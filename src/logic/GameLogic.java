package logic;

import java.util.ArrayList;

import entities.Player;
import gamestates.GameState;
import gamestates.Menu;
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
	private Menu menu;
	private boolean isGameEnd;
	private boolean isGameWin;
	private Gameplay gameplay;
	private Scene scene;
	
	public static GameLogic getInstance() {
		if (instance == null) {
			instance = new GameLogic();
		}
		return instance;
	}
	
	private GameLogic() {
		
	}

	public void newGame(GraphicsContext gc, Scene scene, Gameplay gameplay) {
		// TODO Auto-generated method stub
		this.gameplay = gameplay;
		this.score = 0;
		this.currentLevel = 1;
		this.scene = scene;
		playing = new Playing(scene);
		menu = new Menu(scene);
		this.player = playing.getPlayer();
		gameLoop(gc);
		//System.out.println(currentLevel);
	}
	
	public void gameLoop(GraphicsContext gc) {
		AnimationTimer gameLoop = new AnimationTimer() {
			
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				clearScreen(gc);
				
				switch (GameState.state) {
				case MENU:
					playing.drawLastFrame(gc);
					break;
				case PLAYING:
					playing.update(gc);
					break;
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
		System.out.println(currentLevel);
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
}
