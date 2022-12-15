package logic;

import java.util.ArrayList;

import entities.Player;
import gamestates.GameState;
import gamestates.Playing;
import gui.page.Gameplay;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import objects.PineappleAmmo;

public class GameLogic {
	private static GameLogic instance = null;
	private int currentLevel;
	private int score;
	private Player player;
	private Playing playing;
	private Gameplay gameplay;
	private Scene scene;
	private AnimationTimer gameLoop;
	
	public static GameLogic getInstance() {
		if (instance == null) {
			instance = new GameLogic();
		}
		return instance;
	}

	public void newGame(GraphicsContext gc, Scene scene, Gameplay gameplay) {
		this.gameplay = gameplay;
		this.score = 0;
		this.currentLevel = 1;
		this.scene = scene;
		playing = new Playing(scene);
		this.player = playing.getPlayer();
		if (gameLoop != null) {
			gameLoop.stop();
		}
		gameLoop(gc);
		GameState.state = GameState.PLAYING;
	}
	
	public void gameLoop(GraphicsContext gc) {
		this.gameLoop = new AnimationTimer() {
			
			@Override
			public void handle(long arg0) {
				clearScreen(gc);
				
				switch (GameState.state) {
				case PAUSE:
					playing.drawLastFrame(gc);
					break;
				case PLAYING:
					playing.update(gc);
					break;
				case END:
					playing.end(gc);
				default:
					break;
				}
			}
			
		};
		gameLoop.start();
	}
	
	public void changeLevel() {
		this.currentLevel++;
		playing = new Playing(this.scene);
	}
	
	protected void clearScreen(GraphicsContext gc) {
		gc.clearRect(0.0, 0.0, 1280, 720);
	}
	
	public int getCurrentLevel() {
		return this.currentLevel;
	}
	
	public int getCurrentScore() {
		return this.score;
	}
	
	public void setCurrentScore(int score) {
		this.score = score;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public Gameplay getGameplay() {
		return this.gameplay;
	}
	public ArrayList<PineappleAmmo> getCurrentAmmo() {
        return playing.getAmmoFromManager();
    }

    public int[][] getCurrentLevelData() {
        return playing.getLevelData();
    }

	public boolean isGameEnd() {
		return this.player.isDeath();
	}

	public AnimationTimer getGameLoop() {
		return gameLoop;
	}

	
}
