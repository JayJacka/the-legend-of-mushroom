package entities;

import static utils.Constants.PlayerConstants.*;
import static utils.Constants.Directions.*;
import static utils.HelperMethods.*;
import utils.Animations;

import java.util.ArrayList;
import entities.base.Entity;
import gamestates.GameState;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sharedObject.RenderableHolder;

public class Player extends Entity{
	private int x,y;
	private ArrayList<ArrayList<Image>> animations;
	private int aniTick, aniIndex = 0, aniSpeed = 3;
	private int playerAction = IDLE_RIGHT;
	private int direction = RIGHT;
	private float playerSpeed = 5f;
	private int[][] levelData;
	private boolean isMoving = false, attacking = false;
	private boolean left, up, right, down, jump;
	private static int xDrawOffset = X_DRAW_OFFSET;
	private static int yDrawOffset = Y_DRAW_OFFSET;
	private static int hboxWidth = HITBOXWIDTH;
	private static int hboxHeight = HITBOXHEIGHT;
	private static float airSpeed = AIRSPEED;
	private static float gravity = GRAVITY;
	private static float jumpSpeed = JUMP_SPEED;
	private static float fallSpeedAfterCollision = FALL_SPEED_AFTER_COLLISION;
	private static int damage = DAMAGE;
	private static int health = HEALTH;
	public float xSpeed;
	public float knockbackSpeed = KNOCKBACK_SPEED;
	private boolean inAir = false;
	
	public Player(float x, float y, Scene scene) {
		super(x, y, hboxWidth, hboxHeight);
		initializeHitbox(x+xDrawOffset, y+yDrawOffset);
		addKeyListener(scene);
		loadAnimations();
	}
	
	public void draw(GraphicsContext gc) {
		update();
		render(gc);
	}
	public void update() {
		if (knockbackSpeed != 0)  {
			if (knockbackSpeed < 0) {
				knockbackSpeed += 1f;
			} else {
				knockbackSpeed -= 1f;
			}
		}
		if(!inAir) {
			if (!isEntityOnFloor(hitbox, levelData)) {
				inAir = true;
			}
		}
		updatePos();
		updateAnimationTick();
		setAnimation();
		super.updateHitbox(this.x + xDrawOffset, this.y + yDrawOffset);
	}
	
	public void render(GraphicsContext gc) {
		gc.drawImage(animations.get(playerAction).get(aniIndex), x, y);
		drawHitbox(gc);
	}
	private void loadAnimations() {
		animations = new ArrayList<ArrayList<Image>>();
		animations.add(Animations.getMushroomIdleLeft());
		animations.add(Animations.getMushroomIdleRight());
		animations.add(Animations.getMushroomAttackLeft());
		animations.add(Animations.getMushroomAttackRight());
		animations.add(Animations.getMushroomJumpLeft());
		animations.add(Animations.getMushroomJumpRight());
		animations.add(Animations.getMushroomWalkLeft());
		animations.add(Animations.getMushroomWalkRight());
	}
	
	public void loadLevelData(int[][] levelData) {
		this.levelData = levelData;
	}
	
	public void updatePos() {
		isMoving = false;
		if (jump) {
			jump();
		}
		if (left || right || inAir)
			isMoving = true;
		
		xSpeed = 0f;
		xSpeed += knockbackSpeed;
		
		if(left) {
			direction = LEFT;
			xSpeed -= playerSpeed;
		}
		
		if(right) {
			direction = RIGHT;
			xSpeed += playerSpeed;
		}
		
		if(!inAir) {
			if (!isEntityOnFloor(hitbox, levelData)) {
				inAir = true;
			}
		}
		
		if (inAir) {
			if (CanMoveHere((int) hitbox.getX(),(int) (hitbox.getY() + airSpeed), 32, 44, levelData)) {
				hitbox.setY((hitbox.getY() + airSpeed));
				this.y += (airSpeed);
				airSpeed += gravity;
				updateXPos(xSpeed);
			} else {
				hitbox.setY((GetEntityPosRoofFloor(hitbox, airSpeed)));
				if (airSpeed > 0) {
					resetInAir();
				} else {
					airSpeed = fallSpeedAfterCollision;
				}
				updateXPos(xSpeed);
			}
		} else {
			updateXPos(xSpeed);
		}
	}

	private void jump() {
		// TODO Auto-generated method stub
		if (inAir) {
			return;
		} else {
			inAir = true;
			airSpeed = jumpSpeed;
		}
	}

	private void resetInAir() {
		// TODO Auto-generated method stub
		inAir = false;
		airSpeed = 0;
	}

	private void updateXPos(float xSpeed) {
		// TODO Auto-generated method stub
		if (CanMoveHere((int) (hitbox.getX()+xSpeed), (int) hitbox.getY(), 32, 44, levelData)) {
			hitbox.setX((hitbox.getX()+xSpeed));
			this.x += xSpeed;
		} else {
			hitbox.setX(GetEntityXPosNextToWall(hitbox, xSpeed));
		}
	}

	private void setAnimation() {
		int oldAni = playerAction;
	
		if(isMoving && direction == LEFT) {
			playerAction = WALK_LEFT;
		} else if (isMoving && direction == RIGHT) {
			playerAction = WALK_RIGHT;
		} else {
			if (direction == LEFT) {
				playerAction = IDLE_LEFT;
			} else {
				playerAction = IDLE_RIGHT;
			}
		}
		
		if(attacking) {
			if (direction == LEFT) {
				playerAction = ATTACK_LEFT;				
			} else {
				playerAction = ATTACK_RIGHT;
			}
		}
		
		if(jump) {
			if (direction == LEFT) {
				playerAction = JUMP_LEFT;
			} else {
				playerAction = JUMP_RIGHT;
			}
		}
		if (oldAni != playerAction) {
			aniIndex = 0;
			aniTick = 0;
		}	
	}

	private void updateAnimationTick() {
		aniTick++;
		if (aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if(aniIndex >= GetSpriteAmount(playerAction)) {
				aniIndex = 0;
				attacking = false;
			}
			if(aniIndex == 6 && attacking) {
				if (!RenderableHolder.mushRoomJump.isPlaying()) {
					RenderableHolder.mushRoomAttack.play();
				}
			}
			if(jump) {
				if (!RenderableHolder.mushRoomJump.isPlaying()) {
					RenderableHolder.mushRoomJump.play();
				}
			}
			if(aniIndex == 6 && (playerAction == WALK_LEFT || playerAction == WALK_RIGHT)) {
				if (!RenderableHolder.mushRoomJump.isPlaying()) {
					RenderableHolder.mushRoomWalk.play();
				}
			}
		}
		
	}
	
	public void addKeyListener(Scene sc) {
		sc.setOnKeyPressed((KeyEvent e) -> {
			if (e.getCode() == KeyCode.LEFT) {
				setLeft(true);
			}
			else if (e.getCode() == KeyCode.RIGHT) {
				setRight(true);
			}
			else if (e.getCode() == KeyCode.UP) {
				setJump(true);
			}
			else if (e.getCode() == KeyCode.DOWN) {
				setDown(true);
			}
			else if (e.getCode() == KeyCode.Z) {
				setAttack(true);
			} 
			else if (e.getCode() == KeyCode.ESCAPE) {
				GameState.state = GameState.PAUSE;
			}
		});

		sc.setOnKeyReleased((KeyEvent e) -> {
			if (e.getCode() == KeyCode.LEFT) {
				setLeft(false);
			}
			else if (e.getCode() == KeyCode.RIGHT) {
				setRight(false);
			}
			else if (e.getCode() == KeyCode.UP) {
				setJump(false);
			}
			else if (e.getCode() == KeyCode.DOWN) {
				setDown(false);
			}
			else if (e.getCode() == KeyCode.Z) {
				setAttack(false);
			}
		});
	}

	private void setJump(boolean b) {
		// TODO Auto-generated method stub
		this.jump = b;
	}

	public void setAttack(boolean attacking) {
		this.attacking = attacking;
	}
	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}
	
	public boolean getPlayerAttack() {
		return (playerAction == ATTACK_LEFT || playerAction == ATTACK_RIGHT);
	}
	
	public int getDamage() {
		return Player.damage;
	}
	
	public void setDamage(int damage) {
		Player.damage = damage;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isRemoved() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean isPlayerInClearZone() {
		return InClearZone(this.x, this.y,(int) this.getHitbox().getWidth(),(int) this.getHitbox().getHeight(), levelData);
	}
	
	public int getHealth() {
		return Player.health;
	}
	public void setHealth(int health) {
		Player.health = health;
	}

	public int getAniIndex() {
		return aniIndex;
	}
	
	public boolean isDeath() {
		return getHealth() <= 0;
	}
	
}