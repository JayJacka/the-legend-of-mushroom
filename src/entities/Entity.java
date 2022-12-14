package entities;

import javafx.scene.shape.Rectangle;

public abstract class Entity{
	
	protected int x,y;
	public Rectangle hitbox;
	protected int hitboxWidth;
	protected int hitboxHeight;
	
	public Entity(int x, int y, int hitboxWidth, int hitboxHeight) {
		this.x = x;
		this.y = y;
		this.hitboxHeight = hitboxHeight;
		this.hitboxWidth = hitboxWidth;
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
