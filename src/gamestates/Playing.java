package gamestates;

import java.util.ArrayList;

import entities.EnemyManager;
import entities.Player;
import gui.element.GameEndMenu;
import gui.element.PauseMenu;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import levels.LevelManager;
import logic.GameLogic;
import objects.ObjectManager;
import objects.PineappleAmmo;
import sharedObject.RenderableHolder;

public class Playing {
    private Player player;
    private LevelManager levelManager;
    private EnemyManager enemyManager;
    private ObjectManager objectManager;
	private PauseMenu pausePane;
	private GameEndMenu gameEndPane;
    
    public Playing(Scene scene) {
        levelManager = new LevelManager();
        player = new Player(0,0, scene);
        enemyManager = new EnemyManager(player);
        objectManager = new ObjectManager();
        player.loadLevelData(levelManager.getLevelData());
        RenderableHolder.battleMusicTimer.start();
        pausePane = new PauseMenu();
		pausePane.setVisible(false);
		gameEndPane = new GameEndMenu();
		gameEndPane.setVisible(false);
		GameLogic.getInstance().getGameplay().getChildren().addAll(pausePane,gameEndPane);
    }
    
    public void update(GraphicsContext gc) {
    	levelManager.draw(gc);
		enemyManager.draw(gc);
		objectManager.update(gc);
		player.draw(gc);
		drawGameStatus(gc);
		if (enemyManager.levelCleared() && player.isPlayerInClearZone()) {
			GameLogic.getInstance().changeLevel();
		}
		if (player.isDeath()) {
			GameState.state = GameState.END;
			gameEndPane.setScore(GameLogic.getInstance().getCurrentScore());
		}
    }
    
    public void drawLastFrame(GraphicsContext gc) {
    	levelManager.draw(gc);
		player.render(gc);
		enemyManager.drawEnemies(gc);
		objectManager.draw(gc);
		gc.setFill(Color.rgb(0, 0, 0, 0.5));
		gc.fillRect(0, 0, 1280, 720);
		pausePane.setVisible(true);
    }
    
    public void end(GraphicsContext gc) {
    	levelManager.draw(gc);
		player.render(gc);
		enemyManager.drawEnemies(gc);
		objectManager.draw(gc);
		gc.setFill(Color.rgb(0, 0, 0, 0.5));
		gc.fillRect(0, 0, 1280, 720);
		gameEndPane.setVisible(true);
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
	
	public void drawGameStatus(GraphicsContext gc) {
		drawHpBar(gc, player.getHealth());
		drawScore(gc);
		drawLevel(gc);
	}
	
	public void drawHpBar(GraphicsContext gc,double hp) {
		gc.drawImage(RenderableHolder.hpBar,0,0,400,64);
		gc.setFill(Color.web("#3af237"));
		gc.fillRect(66.5, 26.5, 287*hp/100, 9);
	}
	
	public void drawScore(GraphicsContext gc) {
		gc.setFont(Font.loadFont(RenderableHolder.myFont, 20));
		gc.setFill(Color.web("#502800"));
		gc.fillText("Score : " + GameLogic.getInstance().getCurrentScore(), 1050, 40);
	}
	
	public void drawLevel(GraphicsContext gc) {
		gc.setFont(Font.loadFont(RenderableHolder.myFont, 20));
		gc.setFill(Color.web("#502800"));
		gc.fillText("Level : " + GameLogic.getInstance().getCurrentLevel(), 570, 40);
	}
}

