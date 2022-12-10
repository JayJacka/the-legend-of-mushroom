package gui.page;

import java.util.ArrayList;

import entities.Player;

import static utils.Constants.PlayerConstants.*;
import static utils.Constants.Directions.*;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import levels.LevelManager;
import utils.Animations;

public class Gameplay extends Pane{
	private Stage primaryStage;
	private Canvas canvas;
	private GraphicsContext gc;
	private Scene scene;
	private int x = 300,y = 300;
	//private Image img;
	private ArrayList<ArrayList<Image>> animations;
	private int aniTick, aniIndex = 0, aniSpeed = 20;
	private int playerAction = IDLE;
	private int playerDirection = -1;
	private boolean isMoving = false;
	private LevelManager levelManager;
	private static int tileWidthCount = 40;
	private static int tileHeightCount = 23;
	private Player player;
	
	
	public Gameplay(Stage primaryStage) {
		this.primaryStage = primaryStage;
		setStage();
		levelManager = new LevelManager(this);
		player = new Player(x,y,scene);
		gameLoop();
		primaryStage.show();
	}

	public void setStage() {
		canvas = new Canvas(1280,720);
		gc = canvas.getGraphicsContext2D();
		getChildren().add(canvas);
		scene = new Scene(this);
		primaryStage.setScene(scene);
	}
	
	public void gameLoop() {
		AnimationTimer gameLoop = new AnimationTimer() {
			
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				clearScreen();
				levelManager.Draw(gc);
				player.draw(gc);
			}
		};
		gameLoop.start();
	}
	
	protected void clearScreen() {
		gc.clearRect(0.0, 0.0, 1280, 720);
		
	}
}
