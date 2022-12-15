package levels;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import logic.GameLogic;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class LevelManager implements IRenderable{
	
	private Image levelSprite;
	private int[][] levelData;

	public LevelManager() {
		levelSprite = new Image(ClassLoader.getSystemResource("level/ground.png").toString());
		levelData = new int[23][40];
		initializeLevel();
	}
	
	public void initializeLevel() {
		Image dataImage = new Image(ClassLoader.getSystemResource("level/Map" + (GameLogic.getInstance().getCurrentLevel()) % 3 + ".png").toString());
		for (int j = 0; j < 23; j++) {
			for (int i = 0; i< 40; i++) {
				Color color = dataImage.getPixelReader().getColor(i, j);
				if ((int) (color.getRed() * 255) != 234 && (int) (color.getRed() * 255) != 123) {
					levelData[j][i] = (int) (color.getRed()*255);
				}
			}
		}
		
	}
	
	public void draw(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.gameBackground,0,0);
		MapManager.drawElement(GameLogic.getInstance().getCurrentLevel() % 3,gc);
		for (int j = 0; j < 23; j++) {
			for (int i = 0; i < 40; i++) {
				if (levelData[j][i] == 199) {
					gc.drawImage(levelSprite, 0, 0, 31, 31, i * 32, j * 32, 32, 32);
				} else {
					gc.drawImage(levelSprite, (levelData[j][i])*32, 0, 31, 31, i * 32, j * 32, 32, 32);
				}
			}
		}
	}
	
	public int[][] getLevelData() {
		return levelData;
	}

}
