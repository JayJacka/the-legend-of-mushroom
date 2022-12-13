package objects;

import entities.Player;
import entities.base.Entity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.GameLogic;
import sharedObject.RenderableHolder;
import utils.Constants.UniversalConstants;
import utils.HelperMethods.*;

public class PineappleAmmo extends Entity {
	private float x;
	private float y;
	private boolean activated;
	private Player player;
	private int direction;
	private int offsetX;
	private int offsetY;

	public PineappleAmmo(float x, float y, boolean activate, Player player, int direction) {
		super(x, y+25, 16, 16);
		this.x = x;
		this.y = y+25;
		this.activated = activate;
		this.player = player;
		this.direction = direction;
		initializeHitbox(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(RenderableHolder.PineappleAmmo, this.x, this.y);
		this.drawHitbox(gc);
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
	
	public void update(GraphicsContext gc) {
	
		if (this.activated) {
			updateHitbox(this.x, this.y);
//			System.out.println((int) (player.getHitbox().getY()/UniversalConstants.TILE_SIZE) + " " + (int) (this.getHitbox().getY()/UniversalConstants.TILE_SIZE));
			if ((int) (player.getHitbox().getY()/UniversalConstants.TILE_SIZE) + 1 == (int) (this.getHitbox().getY()/UniversalConstants.TILE_SIZE)) {
				if (this.direction == -1) {
					if (Math.abs(player.getHitbox().getX() + player.getHitbox().getWidth() - this.getHitbox().getX()) <= 1) {
						player.setHealth(player.getHealth() - 10);
						player.knockbackSpeed = -5f;
						this.activated = false;
					}
				} else {
					if (Math.abs(player.getHitbox().getX() - this.getHitbox().getX()) <= 1) {
						player.setHealth(player.getHealth() - 10);
						player.knockbackSpeed = 5f;
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
		int nextTileX = (int) ((this.getHitbox().getX()+direction*2)/UniversalConstants.TILE_SIZE);
		int currentTileY = (int) (this.getHitbox().getY()/UniversalConstants.TILE_SIZE);
		if (nextTileX < 40) {
			if (levelData[currentTileY][nextTileX] > 0 && levelData[currentTileY][nextTileX] < 11 ) {
				this.activated = false; 
			}
		}
		this.x += direction*2;			
	}
	
	public float getX() {
		return this.x;
	}
	
	public boolean isActivated() {
		return this.activated;
	}
 
}
