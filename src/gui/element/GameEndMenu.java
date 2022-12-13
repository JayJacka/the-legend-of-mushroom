package gui.element;

import gui.page.Gameplay;
import gui.page.MainMenuPage;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.GameLogic;
import sharedObject.RenderableHolder;

public class GameEndMenu extends StackPane{
	private ImageView GameOver;
	private ImageView NoButton;
	private ImageView YesButton;
	private AnimationTimer BattleMusic;
	private Text score;
	
	public GameEndMenu() {
		setMaxWidth(460);
		setMaxHeight(480);
		initializeGameOver();
		initializeYesButton();
		initializeNoButton();
		initializeScore();
		HBox button = new HBox();
		button.getChildren().addAll(YesButton, NoButton);
		getChildren().addAll(GameOver,button,score);
		button.setSpacing(20);
		button.setTranslateX(108);
		button.setTranslateY(310);
		score.setTranslateX(0);
		score.setTranslateY(-50);
		
	}
	
	public void initializeGameOver() {
		GameOver = new ImageView(RenderableHolder.Gameover);
		GameOver.setFitWidth(460);
		GameOver.setFitHeight(480);
	}
	
	public void initializeYesButton() {
		YesButton = new ImageView(RenderableHolder.Yes);
		YesButton.setCursor(Cursor.HAND);
		YesButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//NoButton.setTranslateX(-10);
				//NoButton.setTranslateY(10);
				YesButton.setFitHeight(55);
				YesButton.setFitWidth(130);
				RenderableHolder.MouseEnter.play();
			}
		});
		
		YesButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				YesButton.setFitHeight(45);
				YesButton.setFitWidth(120);
			}
		});
		
		YesButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(false);
				Gameplay gameplay = new Gameplay(GameLogic.getInstance().getGameplay().getPrimaryStage());

			}
		});
	}
	
	public void initializeNoButton() {
		NoButton = new ImageView(RenderableHolder.No);
		NoButton.setCursor(Cursor.HAND);
		NoButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//NoButton.setTranslateX(-10);
				//NoButton.setTranslateY(10);
				NoButton.setFitHeight(55);
				NoButton.setFitWidth(130);
				RenderableHolder.MouseEnter.play();
			}
		});
		
		NoButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				NoButton.setFitHeight(45);
				NoButton.setFitWidth(120);
			}
		});
		
		NoButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(false);
				
				MainMenuPage mainMenuPage = new MainMenuPage(GameLogic.getInstance().getGameplay().getPrimaryStage());
			}
		});
	}
	
	public void initializeScore() {
		score = new Text("SCORE : "+GameLogic.getInstance().getCurrentScore());
		score.setFill(Color.web("#502800"));
		score.setFont(Font.loadFont(RenderableHolder.myFont, 18));
	}
}
