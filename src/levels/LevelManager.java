package levels;

import gui.page.Gameplay;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class LevelManager {
	
	private Gameplay gamePlay;
	private Image levelSprite;
	private int[][] levelOneData;

	public LevelManager(Gameplay gamePlay) {
		this.gamePlay = gamePlay;
		levelSprite = new Image(ClassLoader.getSystemResource("level/ground.png").toString());
		levelOneData = new int[23][40];
		initializeLevel();
	}
	
	public void initializeLevel() {
		Image dataImage = new Image(ClassLoader.getSystemResource("level/LevelOneData.png").toString());
		for (int j = 0; j < 23; j++) {
			for (int i = 0; i< 40; i++) {
				Color color = dataImage.getPixelReader().getColor(i, j);
				levelOneData[j][i] = (int) (color.getRed()*255);
			}
		}
		
	}
	
	public void Draw(GraphicsContext gc) {
		for (int j = 0; j < 23; j++) {
			for (int i = 0; i < 40; i++) {
				gc.drawImage(levelSprite, (levelOneData[j][i])*32, 0, 31, 31, i*32, j*32, 32, 32);
			}
		}
	}
}
