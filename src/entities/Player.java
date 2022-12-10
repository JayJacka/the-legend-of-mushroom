package entities;

import static utils.Constants.PlayerConstants.*;

import java.util.ArrayList;
import java.util.concurrent.Delayed;

import entities.base.Entity;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import utils.Animations;

public class Player extends Entity{
	private int x = 300,y = 300;
	private ArrayList<ArrayList<Image>> animations;
	private int aniTick, aniIndex = 0, aniSpeed = 20;
	private int playerAction = IDLE;
	private boolean isMoving = false, attacking = false;
	private boolean left, up, right, down;
	private float playerSpeed = 2;
	
	public Player(float x, float y, Scene scene) {
		super(x, y);
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
	}
	
	public void render(GraphicsContext gc) {
		gc.drawImage(animations.get(playerAction).get(aniIndex), x, y);
	}
	private void loadAnimations() {
		animations = new ArrayList<ArrayList<Image>>();
		animations.add(Animations.getMushroomIdle());
		animations.add(Animations.getMushroomAttack());
		animations.add(Animations.getMushroomJump());
		animations.add(Animations.getMushroomWalk());
	}
	
	private void updatePos() {
		isMoving = false;
		if(left && !right) {
			x -= playerSpeed;
			isMoving = true;
		}
		else if(right && !left) {
			x += playerSpeed;
			isMoving = true;
		}
		
		if (up && !down) {
			y -= playerSpeed;
			isMoving = true;
		}
		else if (down && !up) {
			y += playerSpeed;
			isMoving = true;
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
				setUp(true);
			}
			else if (e.getCode() == KeyCode.DOWN) {
				setDown(true);
			}
			else if (e.getCode() == KeyCode.Z) {
				setAttack(true);
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
				setUp(false);
			}
			else if (e.getCode() == KeyCode.DOWN) {
				setDown(false);
			}
			else if (e.getCode() == KeyCode.Z) {
				setAttack(false);
			}
		});
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
