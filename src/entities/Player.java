package entities;

import static utils.Constants.Directions.DOWN;
import static utils.Constants.Directions.LEFT;
import static utils.Constants.Directions.RIGHT;
import static utils.Constants.Directions.UP;
import static utils.Constants.PlayerConstants.GetSpriteAmount;
import static utils.Constants.PlayerConstants.IDLE;
import static utils.Constants.PlayerConstants.WALK;

import java.util.ArrayList;

import entities.base.Entity;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sharedObject.IRenderable;
import utils.Animations;

public class Player extends Entity{
	private int x = 300,y = 300;
	private ArrayList<ArrayList<Image>> animations;
	private int aniTick, aniIndex = 0, aniSpeed = 20;
	private int playerAction = IDLE;
	private int playerDirection = -1;
	private boolean isMoving = false;
	
	public Player(float x, float y, Scene scene) {
		super(x, y);
		addKeyListener(scene);
		loadAnimations();
	}
	
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		update();
		render(gc);
	}
	public void update() {
		updateAnimationTick();
		setAnimation();
		updatePos();
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
		if(isMoving) {
			switch (playerDirection) {
			case LEFT: 
				x-=1;
				break;
			case RIGHT: 
				x+=1;
				break;
			case UP: 
				y-=1;
				break;
			case DOWN: 
				y+=1;
				break;
			}
		}
		
	}

	private void setAnimation() {
		if(isMoving)
			playerAction = WALK;
		else
			playerAction = IDLE;
	}

	private void updateAnimationTick() {
		aniTick++;
		if (aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if(aniIndex >= GetSpriteAmount(playerAction)) {
				aniIndex = 0;
			}
		}
	}
	
	public void setDirection(int direct) {
		this.playerDirection = direct;
		setMoving(true);
	}
	
	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}

	private void addKeyListener(Scene sc) {
		sc.setOnKeyPressed((KeyEvent e) -> {
			if (e.getCode() == KeyCode.LEFT) {
				setDirection(LEFT);
			}
			else if (e.getCode() == KeyCode.RIGHT) {
				setDirection(RIGHT);
			}
			else if (e.getCode() == KeyCode.UP) {
				setDirection(UP);
			}
			else if (e.getCode() == KeyCode.DOWN) {
				setDirection(DOWN);
			}
			else if (e.getCode() == KeyCode.Z) {
				System.out.println("Z");
			}
		});

		sc.setOnKeyReleased((KeyEvent e) -> {
			if (e.getCode() == KeyCode.LEFT) {
				setMoving(false);
			}
			else if (e.getCode() == KeyCode.RIGHT) {
				setMoving(false);
			}
			else if (e.getCode() == KeyCode.UP) {
				setMoving(false);
			}
			else if (e.getCode() == KeyCode.DOWN) {
				setMoving(false);
			}
			else if (e.getCode() == KeyCode.Z) {
				setMoving(false);
			}
		});
	}

}
