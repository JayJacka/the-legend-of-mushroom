package levels;

import gui.page.Gameplay;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class LevelManager {
	
	private Gameplay gamePlay;
	private Image levelSprite;
	private int[][] levelData;

	public LevelManager(Gameplay gamePlay) {
		this.gamePlay = gamePlay;
		levelSprite = new Image(ClassLoader.getSystemResource("level/ground.png").toString());
		levelData = new int[23][40];
		initializeLevel();
	}
	
	public void initializeLevel() {
		Image dataImage = new Image(ClassLoader.getSystemResource("level/LevelOneData.png").toString());
		for (int j = 0; j < 23; j++) {
			for (int i = 0; i< 40; i++) {
				Color color = dataImage.getPixelReader().getColor(i, j);
				if (color.getRed()*255 == 255) {
					continue;
				} else {
					levelData[j][i] = (int) (color.getRed()*255);
				}
			}
		}
		
	}
	
	public void Draw(GraphicsContext gc) {
		gc.drawImage(new Image(ClassLoader.getSystemResource("back-export.png").toString()),0,0);
		for (int j = 0; j < 23; j++) {
			for (int i = 0; i < 40; i++) {
				gc.drawImage(levelSprite, (levelData[j][i])*32, 0, 31, 31, i*32, j*32, 32, 32);
			}
		}
	}
	
	public int[][] getLevelData() {
		return levelData;
	}
}
