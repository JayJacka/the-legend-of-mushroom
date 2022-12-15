package objects;

import entities.Entity;
import entities.Player;
import javafx.scene.canvas.GraphicsContext;
import logic.GameLogic;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;
import utils.Constants.UniversalConstants;

public class PineappleAmmo extends Entity implements IRenderable{
	private float x;
	private float y;
	private boolean activated;
	private Player player;
	private int direction;

	public PineappleAmmo(int x, int y, boolean activate, Player player, int direction) {
		super(x, y+25, 16, 16);
		this.x = x;
		this.y = y+25;
		this.activated = activate;
		this.player = player;
		this.direction = direction;
		initializeHitbox(x, y);
	}
	
	public void draw(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.pineappleAmmo, this.x, this.y);
	}
	
	public void update(GraphicsContext gc) {
	
		if (this.activated) {
			updateHitbox(this.x, this.y);
			if ((int) (player.getHitbox().getY() / UniversalConstants.TILE_SIZE) + 1 == (int) (this.getHitbox().getY() / UniversalConstants.TILE_SIZE)) {
				if (this.direction == -1) {
					if (Math.abs(player.getHitbox().getX() + player.getHitbox().getWidth() - this.getHitbox().getX()) <= 1) {
						player.setHealth(player.getHealth() - 10);
						player.knockbackSpeed = -5f;
						this.activated = false;
					}
					if (Math.abs(player.getHitbox().getX() - this.getHitbox().getX()) <= 1) {
						player.setHealth(player.getHealth() - 10);
						player.knockbackSpeed = 5f;
						this.activated = false;
					}	
					
				} else {
					if (Math.abs(player.getHitbox().getX() - this.getHitbox().getX()) <= 1) {
						player.setHealth(player.getHealth() - 10);
						player.knockbackSpeed = 5f;
						this.activated = false;
					}	
					if (Math.abs(player.getHitbox().getX() + player.getHitbox().getWidth() - this.getHitbox().getX()) <= 1) {
						player.setHealth(player.getHealth() - 10);
						player.knockbackSpeed = -5f;
						this.activated = false;
					}
				}
			}
			updatePosition();
			draw(gc);
		}
	}

	private void updatePosition() {
		// TODO Auto-generated method stub
		int[][] levelData = GameLogic.getInstance().getCurrentLevelData();
		int nextTileX = (int) ((this.getHitbox().getX()+direction * 2) / UniversalConstants.TILE_SIZE);
		int currentTileY = (int) (this.getHitbox().getY() / UniversalConstants.TILE_SIZE);
		if (nextTileX < 40) {
			if (levelData[currentTileY][nextTileX] > 0 && levelData[currentTileY][nextTileX] < 11 ) {
				this.activated = false; 
			}
		}
		this.x += direction * 2;			
	}
	
	public float getX() {
		return this.x;
	}
	
	public boolean isActivated() {
		return this.activated;
	}
 
}
