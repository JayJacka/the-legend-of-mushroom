package gamestates;

import entities.EnemyManager;
import entities.Player;
import gui.page.Gameplay;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import levels.LevelManager;

public class Playing {
	private Player player;
	private LevelManager levelManager;
	private EnemyManager enemyManager;
	
	public Playing(Gameplay gameplay, Scene scene) {
		levelManager = new LevelManager(gameplay);
		enemyManager = new EnemyManager(gameplay);
		player = new Player(64,488,scene);
		player.loadLevelData(levelManager.getLevelData());
		
	}
	
	public void update(GraphicsContext gc) {
		levelManager.Draw(gc);
		enemyManager.draw(gc);
		player.draw(gc);
	}
	
	public void drawLastFrame(GraphicsContext gc) {
		levelManager.Draw(gc);
		player.render(gc);
		gc.setFill(Color.rgb(0, 0, 0, 0.5));
		gc.fillRect(0, 0, 1280, 720);
		gc.setFont(Font.font(50));
		gc.setFill(Color.WHITE);
		gc.fillText("PAUSED", 550, 350);
		gc.setFont(Font.font(25));
		gc.fillText("Press Enter to Resume Game", 490, 400);
	}
}
