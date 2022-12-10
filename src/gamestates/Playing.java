package gamestates;

import entities.Player;
import gui.page.Gameplay;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import levels.LevelManager;

public class Playing {
	private Player player;
	private LevelManager levelManager;
	
	public Playing(Gameplay gameplay, Scene scene) {
		levelManager = new LevelManager(gameplay);
		player = new Player(64,488,scene);
		player.loadLevelData(levelManager.getLevelData());
		
	}
	
	public void update(GraphicsContext gc) {
		levelManager.Draw(gc);
		player.draw(gc);
	}
	
	public void drawLastFrame(GraphicsContext gc) {
		levelManager.Draw(gc);
		player.render(gc);
	}
}
