package gamestates;

import java.util.ArrayList;

import entities.EnemyManager;
import entities.Player;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import levels.LevelManager;
import logic.GameLogic;
import objects.ObjectManager;
import objects.PineappleAmmo;

public class Playing {
	private Player player;
	private LevelManager levelManager;
	private EnemyManager enemyManager;
	private ObjectManager objectManager;
	
	public Playing(Scene scene) {
		levelManager = new LevelManager();
		player = new Player(0,0, scene);
		enemyManager = new EnemyManager(player);
		objectManager = new ObjectManager();
		player.loadLevelData(levelManager.getLevelData());
	}
	
	public void update(GraphicsContext gc) {
		levelManager.Draw(gc);
		enemyManager.draw(gc);
		objectManager.update(gc);
		player.draw(gc);
		if (enemyManager.levelCleared() && player.isPlayerInClearZone()) {
			GameLogic.getInstance().changeLevel();
		}
	}
	
	public void drawLastFrame(GraphicsContext gc) {
		levelManager.Draw(gc);
		player.render(gc);
		enemyManager.drawEnemies(gc);
		objectManager.draw(gc);
		gc.setFill(Color.rgb(0, 0, 0, 0.5));
		gc.fillRect(0, 0, 1280, 720);
		gc.setFont(Font.font(50));
		gc.setFill(Color.WHITE);
		gc.fillText("PAUSED", 550, 350);
		gc.setFont(Font.font(25));
		gc.fillText("Press Enter to Resume Game", 490, 400);
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public ArrayList<PineappleAmmo> getAmmoFromManager() {
		return objectManager.getCurrentAmmo();
	}
	
	public int[][] getLevelData() {
		return levelManager.getLevelData();
	}
}

