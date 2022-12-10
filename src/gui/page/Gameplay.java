package gui.page;

import java.util.ArrayList;
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
	
	
	public Gameplay(Stage primaryStage) {
		this.primaryStage = primaryStage;
		levelManager = new LevelManager(this);
		setStage();
		gameLoop();
		loadAnimations();
		primaryStage.show();
	}
	
	private void loadAnimations() {
		animations = new ArrayList<ArrayList<Image>>();
		animations.add(Animations.getMushroomIdle());
		animations.add(Animations.getMushroomAttack());
		animations.add(Animations.getMushroomJump());
		animations.add(Animations.getMushroomWalk());
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
				addKeyListener(scene);
				levelManager.Draw(gc);
				draw(gc);
			}
		};
		gameLoop.start();
	}
	
	protected void clearScreen() {
		gc.clearRect(0.0, 0.0, 1280, 720);
		
	}
	
	private void draw(GraphicsContext gc) {
		updateAnimationTick();
		setAnimation();
		updatePos();
		gc.drawImage(animations.get(playerAction).get(aniIndex), x, y);
		
	}
	
	private void updatePos() {
		if(isMoving) {
			switch (playerDirection) {
			case LEFT: 
				x-=1;
				break;
			case RIGHT: 
				x+=1;
				break;
			case UP: 
				y-=1;
				break;
			case DOWN: 
				y+=1;
				break;
			}
		}
		
	}

	private void setAnimation() {
		if(isMoving)
			playerAction = WALK;
		else
			playerAction = IDLE;
	}

	private void updateAnimationTick() {
		aniTick++;
		if (aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if(aniIndex >= GetSpriteAmount(playerAction)) {
				aniIndex = 0;
			}
		}
	}

	private void addKeyListener(Scene sc) {
		sc.setOnKeyPressed((KeyEvent e) -> {
			if (e.getCode() == KeyCode.A) {
				setDirection(LEFT);
			}
			else if (e.getCode() == KeyCode.D) {
				setDirection(RIGHT);
			}
			else if (e.getCode() == KeyCode.W) {
				setDirection(UP);
			}
			else if (e.getCode() == KeyCode.DOWN) {
				setDirection(DOWN);
			}
			else if (e.getCode() == KeyCode.SPACE) {
				System.out.println("Z");
			}
		});

		sc.setOnKeyReleased((KeyEvent e) -> {
			if (e.getCode() == KeyCode.A) {
				setMoving(false);
			}
			else if (e.getCode() == KeyCode.D) {
				setMoving(false);
			}
			else if (e.getCode() == KeyCode.W) {
				setMoving(false);
			}
			else if (e.getCode() == KeyCode.DOWN) {
				setMoving(false);
			}
			else if (e.getCode() == KeyCode.SPACE) {
//				setMoving(false);
			}
		});
	}
	
	public void setDirection(int direct) {
		this.playerDirection = direct;
		setMoving(true);
	}
	
	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}
	/*private Image importImg(String source, int i) {
		String playerURL = ClassLoader.getSystemResource("image/"+ source + i + ".png").toString();
		Image img = new Image(playerURL);
		return img;
	}*/
	
	/*public static Image getSubImage(Image img, int x, int y, int w, int h) {
        PixelReader reader = img.getPixelReader();
        WritableImage image = new WritableImage(reader, , y, w, h);
        return image;
    }*/
}
