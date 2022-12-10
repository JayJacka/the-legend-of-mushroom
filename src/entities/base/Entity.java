package entities.base;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Entity {
	
	private float x,y;
	private Rectangle hitbox;
	
	public Entity(float x, float y) {
		this.x = x;
		this.y = y;
		initializeHitbox();
	}
	
	protected void drawHitbox(GraphicsContext gc) {
		// for debugging the hitbox
		gc.fillRect(hitbox.getX(), hitbox.getY(), hitbox.getWidth(), hitbox.getHeight());
		gc.setStroke(Color.RED);
	}
	
	public void initializeHitbox() {
		hitbox = new Rectangle((int) x,(int) y,80,64);
	}
	
	protected void updateHitbox() {
		hitbox.setX((int) x);
		hitbox.setY((int) y);
	}
}
