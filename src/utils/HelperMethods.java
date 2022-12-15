package utils;

import javafx.scene.shape.Rectangle;
import utils.Constants.EnemyConstants;
import utils.Constants.UniversalConstants;

public class HelperMethods {
	
	public static boolean CanMoveHere(float x, float y, int width, int height, int[][] levelData) {
		if (!IsSolid(x,y, levelData)) {
			if (!IsSolid(x + width, y + height, levelData)) {
				if (!IsSolid(x + width,y,levelData)) {
					if (!IsSolid(x,y + height, levelData)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private static boolean IsSolid(float x, float y, int[][] levelData) {
		if (x < 0 || x >= UniversalConstants.X_DIMENSION) {
			return true;
		}
		if (y < 0 || y >= UniversalConstants.Y_DIMENSION) {
			return true;
		}
		
		float xIndex = x / UniversalConstants.TILE_SIZE;
		float yIndex = y / UniversalConstants.TILE_SIZE;
		
		int value = levelData[(int) yIndex][(int) xIndex];
		
		if (value > 0 && value != 199 && value != EnemyConstants.TOMATO_R_VALUE && value != EnemyConstants.PINEAPPLE_R_VALUE) {
			return true;
		}
		return false;
	}
	
	public static boolean InClearZone(float x, float y, int width, int height, int[][] levelData) {
		return ClearLevelZone(x+width,y, levelData);
	}
	
	private static boolean ClearLevelZone(float x, float y, int[][] levelData) {
		float xIndex = x / UniversalConstants.TILE_SIZE;
		float yIndex = y / UniversalConstants.TILE_SIZE;
		
		int value = levelData[(int) yIndex][(int) xIndex];
		
		if (value == 199) {
			return true;
		}
		return false;
	}
	
	public static float GetEntityXPosNextToWall(Rectangle hitbox, float xSpeed) {
		
		int currentTile = (int) (hitbox.getX() / UniversalConstants.TILE_SIZE);
		
		if (xSpeed > 0) {
			//right
			float tileXPos = currentTile * UniversalConstants.TILE_SIZE;
			float xOffset = (float) ((float)(UniversalConstants.TILE_SIZE) - hitbox.getWidth());
			return tileXPos + xOffset - 1;
			
		} else {
			//left
			return currentTile * UniversalConstants.TILE_SIZE;
		}
		
	}
	
	public static float GetEntityPosRoofFloor(Rectangle hitbox, float airSpeed) {
		int currentTile = (int) (hitbox.getY() / UniversalConstants.TILE_SIZE);
		if (airSpeed > 0) {
			//fallilng
			float tileYPos = currentTile * UniversalConstants.TILE_SIZE;
			float yOffset = (float) ((float) (UniversalConstants.TILE_SIZE) - hitbox.getHeight());
			return tileYPos + yOffset;
			
		} else {
			//jumping
			return currentTile * UniversalConstants.TILE_SIZE;
		}
	}
	
	public static boolean isEntityOnFloor(Rectangle hitbox, int[][] levelData) {
		if(!IsSolid((float) hitbox.getX(), (float) (hitbox.getY() + hitbox.getHeight() + 1), levelData)) {
			if(!IsSolid((float) (hitbox.getX() + hitbox.getWidth()), (float) (hitbox.getY() + hitbox.getHeight() + 1), levelData)) {
				return false;
			}
		}
		return true;
	}

}
