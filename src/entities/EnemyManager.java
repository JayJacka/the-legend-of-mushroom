package entities;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import logic.GameLogic;
import sharedObject.IRenderable;
import utils.Constants.EnemyConstants;
import utils.Constants.UniversalConstants;

public class EnemyManager implements IRenderable{
	private ArrayList<ArrayList<Image>> tomatoeAni;
	private ArrayList<Enemy> enemies;
	private ArrayList<ArrayList<Image>> pineappleAni;
	private Player player;
	
	public EnemyManager(Player player) {
		this.player = player;
		enemies = new ArrayList<Enemy>();
		initializeEnemy();
	}
	
	private void initializeEnemy() {
		Image enemyDataImage = new Image(ClassLoader.getSystemResource("level/Map"+ GameLogic.getInstance().getCurrentLevel()%3 + ".png").toString());
		for (int j = 0; j < 23; j++) {
			for (int i = 0; i < 40; i++) {
				Color color= enemyDataImage.getPixelReader().getColor(i, j);
				if ((int) (color.getRed() * 255) == EnemyConstants.TOMATO_R_VALUE) {
					enemies.add(new Tomato(i * UniversalConstants.TILE_SIZE-EnemyConstants.X_OFFSET, j * UniversalConstants.TILE_SIZE-EnemyConstants.Y_OFFSET, 0));
				}
				if ((int) (color.getRed() * 255) == EnemyConstants.PINEAPPLE_R_VALUE) {
					enemies.add(new Pineapple(i * UniversalConstants.TILE_SIZE-EnemyConstants.X_OFFSET, j * UniversalConstants.TILE_SIZE-EnemyConstants.Y_OFFSET, 1));
				}
			}
		}
		
	}

	public boolean levelCleared() {
		return enemies.size() == 0;
	}

	public void update(Player player) {
		ArrayList<Enemy> ToBeRemoved = new ArrayList<Enemy>();
		for(Enemy e : enemies) {
			e.update(player);
			if (e.getHealth() <= 0) {
				ToBeRemoved.add(e);
			}
		}
		for (Enemy e: ToBeRemoved) {
			enemies.remove(e);
			int nowScore = GameLogic.getInstance().getCurrentScore();
			int nowLevel = GameLogic.getInstance().getCurrentLevel();
			GameLogic.getInstance().setCurrentScore(nowScore+10*nowLevel);
		}
	}
	
	public void draw(GraphicsContext gc) {
		drawEnemies(gc);
		update(player);
	}
	
	public void drawEnemies(GraphicsContext gc) {
		for(Enemy e : enemies) {
			if (e instanceof Tomato) {
				tomatoeAni = ((Tomato) e).getTomatoeAni();
				gc.drawImage(tomatoeAni.get(e.getState()).get(e.getAniIndex()),  e.getX(), e.getY());
			} else if (e instanceof Pineapple) {
				pineappleAni = ((Pineapple) e).getPineappleAni();
				gc.drawImage(pineappleAni.get(e.getState()).get(e.getAniIndex()),  e.getX(), e.getY());
			}
		}
	}

}
