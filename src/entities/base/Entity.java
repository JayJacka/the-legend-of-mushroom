package entities.base;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;
import sharedObject.IRenderable;

public abstract class Entity implements IRenderable{
	
	private float x,y;
	public Rectangle hitbox;
	private int hitboxWidth;
	private int hitboxHeight;
	
	public Entity(float x, float y, int hitboxWidth, int hitboxHeight) {
		this.x = x;
		this.y = y;
		this.hitboxHeight = hitboxHeight;
		this.hitboxWidth = hitboxWidth;
	}
	
	public void drawHitbox(GraphicsContext gc) {
		// for debugging the hitbox
//		gc.strokeRect(hitbox.getX(), hitbox.getY(),hitbox.getWidth(), hitbox.getHeight());
	}
	
	public void initializeHitbox(float x, float y) {
		hitbox = new Rectangle((int) x,(int) y, hitboxWidth, hitboxHeight);
	}
	
	protected void updateHitbox(float x, float y) {
		hitbox.setX((int) x);
		hitbox.setY((int) y);
	}
	
	public Rectangle getHitbox() {
		return this.hitbox;
	}
	
	public float getX() {
		return this.x;
	}
	
	public float getY() {
		return this.y;
	}
}
