package entities.base;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public abstract class Entity {
	
	private float x,y;
	public Rectangle hitbox;
	
	public Entity(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	protected void drawHitbox(GraphicsContext gc) {
		// for debugging the hitbox
//		gc.strokeRect(hitbox.getX(), hitbox.getY(),hitbox.getWidth(), hitbox.getHeight());
	}
	
	public void initializeHitbox(float x, float y) {
		hitbox = new Rectangle((int) x,(int) y, 32, 44);
	}
	
	protected void updateHitbox(float x, float y) {
		hitbox.setX((int) x);
		hitbox.setY((int) y);
	}
}
