package entities;

import static utils.Constants.PlayerConstants.*;
import static utils.HelperMethods.*;

import java.util.ArrayList;
import java.util.concurrent.Delayed;

import entities.base.Entity;
import gamestates.GameState;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import utils.Animations;
import utils.HelperMethods;

public class Player extends Entity{
	private int x = 64,y = 488;
	private ArrayList<ArrayList<Image>> animations;
	private int aniTick, aniIndex = 0, aniSpeed = 3;
	private int playerAction = IDLE;
	private float playerSpeed = 2;
	private int playerDirection = -1;
	private int[][] levelData;
	private boolean isMoving = false, attacking = false;
	private boolean left, up, right, down, jump;
	private int xDrawOffset = 16;
	private int yDrawOffset = 10;
	
	private double airSpeed = 0;
	private double gravity = 0.3;
	private double jumpSpeed = -10;
	private double fallSpeedAfterCollision = 1;
	private boolean inAir = false;
	
	public Player(float x, float y, Scene scene) {
		super(x, y);
		initializeHitbox(x+xDrawOffset, y+yDrawOffset);
		addKeyListener(scene);
		loadAnimations();
	}
	
	public void draw(GraphicsContext gc) {
		update();
		render(gc);
	}
	public void update() {
		updatePos();
		updateAnimationTick();
		setAnimation();
		updatePos();
		super.updateHitbox(this.x + xDrawOffset, this.y + yDrawOffset);
	}
	
	public void render(GraphicsContext gc) {
		gc.drawImage(animations.get(playerAction).get(aniIndex), x, y);
		drawHitbox(gc);
	}
	private void loadAnimations() {
		animations = new ArrayList<ArrayList<Image>>();
		animations.add(Animations.getMushroomIdle());
		animations.add(Animations.getMushroomAttack());
		animations.add(Animations.getMushroomJump());
		animations.add(Animations.getMushroomWalk());
	}
	
	public void loadLevelData(int[][] levelData) {
		this.levelData = levelData;
	}
	
	private void updatePos() {
		isMoving = false;
		if (jump) {
			jump();
		}
		if (!left && !right && !inAir)
			return;
		
		float xSpeed = 0;
		
		if(left) {
			xSpeed -= playerSpeed;
		}
		
		if(right) {
			xSpeed += playerSpeed;
		}
		
		if(!inAir) {
			if (!isEntityOnFloor(hitbox, levelData)) {
				inAir = true;
			}
		}
		
		if (inAir) {
			if (CanMoveHere((int) hitbox.getX(),(int) (hitbox.getY() + airSpeed), 32, 44, levelData)) {
				hitbox.setY((int) (hitbox.getY() + airSpeed));
				this.y += (int) (airSpeed);
				airSpeed += gravity;
				updateXPos(xSpeed);
			} else {
				hitbox.setY((int) (GetEntityPosRoofFloor(hitbox, (int) airSpeed)));
//				this.y += (int) GetEntityPosRoofFloor(hitbox, airSpeed);
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
		isMoving = true;
		
		
//		if (CanMoveHere((int) hitbox.getX()+xSpeed, (int) hitbox.getY()+ySpeed, 32, 44, levelData)) {
//			hitbox.setX(hitbox.getX()+xSpeed);
//			hitbox.setY(hitbox.getY()+ySpeed);
//			this.x += xSpeed;
//			this.y += ySpeed;
//			isMoving = true;
//		}
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
		if (CanMoveHere((int) hitbox.getX()+xSpeed, (int) hitbox.getY(), 32, 44, levelData)) {
			hitbox.setX((int) (hitbox.getX()+xSpeed));
			this.x += xSpeed;
		} else {
			hitbox.setX((int) GetEntityXPosNextToWall(hitbox, xSpeed));
//			this.x += GetEntityXPosNextToWall(hitbox, xSpeed);
		}
	}

	private void setAnimation() {
		if(isMoving) {
			playerAction = WALK;
		}
		else {
			playerAction = IDLE;
		}
		
		if(attacking) {
			playerAction = ATTACK;
		}
		
		if(jump) {
			playerAction = JUMP;
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
				GameState.state = GameState.MENU;
			}
			else if (e.getCode() == KeyCode.ENTER) {
				GameState.state = GameState.PLAYING;
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
	
}
