package gui.element;

import gamestates.GameState;
import gui.page.Gameplay;
import gui.page.MainMenuPage;
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
		GameOver = new ImageView(RenderableHolder.gameover);
		GameOver.setFitWidth(460);
		GameOver.setFitHeight(480);
	}
	
	public void initializeYesButton() {
		YesButton = new ImageView(RenderableHolder.yes);
		YesButton.setCursor(Cursor.HAND);
		YesButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				YesButton.setFitHeight(55);
				YesButton.setFitWidth(130);
				RenderableHolder.mouseEnter.play();
			}
		});
		
		YesButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				YesButton.setFitHeight(45);
				YesButton.setFitWidth(120);
			}
		});
		YesButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				setVisible(false);
				Gameplay gameplay = new Gameplay(GameLogic.getInstance().getGameplay().getPrimaryStage());
			}
		});
	}
	
	public void initializeNoButton() {
		NoButton = new ImageView(RenderableHolder.no);
		NoButton.setCursor(Cursor.HAND);
		NoButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {

				NoButton.setFitHeight(55);
				NoButton.setFitWidth(130);
				RenderableHolder.mouseEnter.play();
			}
		});
		
		NoButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				NoButton.setFitHeight(45);
				NoButton.setFitWidth(120);
			}
		});
		
		NoButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				setVisible(false);
				MainMenuPage mainMenuPage = new MainMenuPage(GameLogic.getInstance().getGameplay().getPrimaryStage());
				GameState.state = GameState.MENU;
				RenderableHolder.battleMusic.stop();
				RenderableHolder.battleMusicTimer.stop();
			}
		});
	}
	
	public void initializeScore() {
		score = new Text("SCORE : " + GameLogic.getInstance().getCurrentScore());
		score.setFill(Color.web("#502800"));
		score.setFont(Font.loadFont(RenderableHolder.myFont, 18));
	}

	public void setScore(int sc) {
		score.setText("SCORE : " + sc);
	}
}
