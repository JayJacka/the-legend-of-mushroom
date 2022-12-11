package utils;

import javafx.scene.shape.Rectangle;

public class HelperMethods {
	
	public static boolean CanMoveHere(float x, float y, int width, int height, int[][] levelData) {
		if (!IsSolid(x,y, levelData)) {
			if (!IsSolid(x+width, y+height, levelData)) {
				if (!IsSolid(x+width,y,levelData)) {
					if (!IsSolid(x,y+height, levelData)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private static boolean IsSolid(float x, float y, int[][] levelData) {
		if (x < 0 || x >= 1280) {
			return true;
		}
		if (y < 0 || y >= 720) {
			return true;
		}
		
		float xIndex = x/32;
		float yIndex = y/32;
		
		int value = levelData[(int) yIndex][(int) xIndex];
		
		if (value > 0 && value != 199 && value != 234 && value != 123) {
			return true;
		}
		return false;
	}
	
	public static boolean InClearZone(float x, float y, int width, int height, int[][] levelData) {
		return ClearLevelZone(x+width,y, levelData);
	}
	
	private static boolean ClearLevelZone(float x, float y, int[][] levelData) {
		float xIndex = x/32;
		float yIndex = y/32;
		
		int value = levelData[(int) yIndex][(int) xIndex];
		
		if (value == 199) {
			return true;
		}
		return false;
	}
	
	public static float GetEntityXPosNextToWall(Rectangle hitbox, float xSpeed) {
		
		int currentTile = (int) (hitbox.getX()/32);
		
		if (xSpeed > 0) {
			//right
			float tileXPos = currentTile * 32;
			float xOffset = (float) ((float)(32) - hitbox.getWidth());
			return tileXPos + xOffset - 1;
			
		} else {
			//left
			return currentTile * 32;
		}
		
	}
	
	public static float GetEntityPosRoofFloor(Rectangle hitbox, float airSpeed) {
		int currentTile = (int) (hitbox.getY()/32);
		if (airSpeed > 0) {
			//fallilng
			float tileYPos = currentTile * 32;
			float yOffset = (float) ((float) (32) - hitbox.getHeight());
			return tileYPos + yOffset;
			
		} else {
			//jumping
			return currentTile * 32;
		}
	}
	
	public static boolean isEntityOnFloor(Rectangle hitbox, int[][] levelData) {
		if(!IsSolid((float) hitbox.getX(), (float) (hitbox.getY()+hitbox.getHeight()+1), levelData)) {
			if(!IsSolid((float) (hitbox.getX()+hitbox.getWidth()), (float) (hitbox.getY()+hitbox.getHeight()+1), levelData)) {
				return false;
			}
		}
		return true;
	}

}
