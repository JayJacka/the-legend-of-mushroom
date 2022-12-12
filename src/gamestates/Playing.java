package gamestates;

import java.util.ArrayList;

import entities.EnemyManager;
import entities.Player;
import gui.element.PauseMenu;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import levels.LevelManager;
import logic.GameLogic;
<<<<<<< HEAD
import sharedObject.RenderableHolder;
||||||| 1923d2b
=======
import objects.ObjectManager;
import objects.PineappleAmmo;
>>>>>>> d6c29962cc6c4e00c5d6f5a873b5dc36400b2ad0

public class Playing {
	private Player player;
	private LevelManager levelManager;
	private EnemyManager enemyManager;
<<<<<<< HEAD
	private AnimationTimer BattleMusic;
	private PauseMenu pausePane;
||||||| 1923d2b
=======
	private ObjectManager objectManager;
>>>>>>> d6c29962cc6c4e00c5d6f5a873b5dc36400b2ad0
	
	public Playing(Scene scene) {
		levelManager = new LevelManager();
		player = new Player(0,0, scene);
		enemyManager = new EnemyManager(player);
		objectManager = new ObjectManager();
		player.loadLevelData(levelManager.getLevelData());
		pausePane = new PauseMenu();
		pausePane.setVisible(false);
		GameLogic.getInstance().getGameplay().getChildren().add(pausePane);
	}

	public void update(GraphicsContext gc) {
		levelManager.Draw(gc);
		enemyManager.draw(gc);
		objectManager.update(gc);
		player.draw(gc);
		drawGameStatus(gc);
		System.out.println(GameLogic.getInstance().getCurrentScore());
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
		pausePane.setVisible(true);
		/*
		gc.setFont(Font.font(50));
		gc.setFill(Color.WHITE);
		gc.fillText("PAUSED", 550, 350);
		gc.setFont(Font.font(25));
		gc.fillText("Press Enter to Resume Game", 490, 400);*/
	}
	
	public Player getPlayer() {
		return this.player;
	}
<<<<<<< HEAD

	public void playBattleMusic() {
		BattleMusic = new AnimationTimer() {
			
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				if (!RenderableHolder.BattleMusic.isPlaying()) {
					RenderableHolder.BattleMusic.play();
				}
			}
		};
		BattleMusic.start();
	}
	
	public void drawGameStatus(GraphicsContext gc) {
		drawHpBar(gc, player.getHealth());
		drawScore(gc);
		drawLevel(gc);
	}
	
	public void drawHpBar(GraphicsContext gc,double hp) {
		gc.drawImage(RenderableHolder.hpBar,0,0,400,64);
		gc.setFill(Color.LIMEGREEN);
		gc.fillRect(66.5, 26.5, 287*hp/100, 9);
	}
	
	public void drawScore(GraphicsContext gc) {
		gc.setFont(Font.loadFont(RenderableHolder.myFont, 20));
		gc.setFill(Color.SANDYBROWN);
		gc.fillText("Score : " + GameLogic.getInstance().getCurrentScore(), 1050, 40);
	}
	
	public void drawLevel(GraphicsContext gc) {
		gc.setFont(Font.loadFont(RenderableHolder.myFont, 20));
		gc.setFill(Color.SANDYBROWN);
		gc.fillText("Level : " + GameLogic.getInstance().getCurrentLevel(), 570, 40);
	}

||||||| 1923d2b
=======
	
	public ArrayList<PineappleAmmo> getAmmoFromManager() {
		return objectManager.getCurrentAmmo();
	}
	
	public int[][] getLevelData() {
		return levelManager.getLevelData();
	}
>>>>>>> d6c29962cc6c4e00c5d6f5a873b5dc36400b2ad0
}

