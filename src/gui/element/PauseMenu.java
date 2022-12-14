package gui.element;

import gamestates.GameState;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import sharedObject.RenderableHolder;

public class PauseMenu extends StackPane{
	private ImageView resumeButton;
	private ImageView quitButton;
	private ImageView soundOffButton;
	private ImageView soundOnButton;
	
	public PauseMenu() {
		setMaxHeight(300);
		setMaxWidth(230);
		VBox button = new VBox();
		initializeResumeButton();
		initializeQuitButton();
		initializeSoundOnButton();
		initializeSoundOffButton();
		StackPane sounds = new StackPane();
		sounds.getChildren().addAll(soundOnButton,soundOffButton);
		button.getChildren().addAll(resumeButton,quitButton,sounds);
		getChildren().add(button);
	}
	
	public void initializeResumeButton() {
		resumeButton = new ImageView(RenderableHolder.resume);
		resumeButton.setCursor(Cursor.HAND);
		resumeButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				resumeButton.setTranslateX(-5);
				resumeButton.setFitHeight(130);
				resumeButton.setFitWidth(240);
				RenderableHolder.mouseEnter.play();
			}
		});
		
		resumeButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				resumeButton.setTranslateX(0);
				resumeButton.setFitHeight(120);
				resumeButton.setFitWidth(230);
			}
		});
		
		resumeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				GameState.state = GameState.PLAYING;
				setVisible(false);
			}
		});
	}
	
	public void initializeQuitButton() {
		quitButton = new ImageView(RenderableHolder.quit);
		quitButton.setCursor(Cursor.HAND);
		quitButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				quitButton.setTranslateX(-5);
				quitButton.setFitHeight(130);
				quitButton.setFitWidth(240);
				RenderableHolder.mouseEnter.play();
			}
		});
		
		quitButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				quitButton.setTranslateX(0);
				quitButton.setFitHeight(120);
				quitButton.setFitWidth(230);
			}
		});
		
		quitButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				Platform.exit();
			}
		});;
	}
	
	public void initializeSoundOnButton() {
		soundOnButton = new ImageView(RenderableHolder.soundOn);
		soundOnButton.setCursor(Cursor.HAND);
		soundOnButton.setFitHeight(64);
		soundOnButton.setFitWidth(64);
		soundOnButton.setVisible(true);
		soundOnButton.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				RenderableHolder.battleMusic.stop();
				RenderableHolder.battleMusicTimer.stop();
				soundOnButton.setVisible(false);
				soundOffButton.setVisible(true);
			}
			
		});
		soundOnButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				soundOnButton.setFitHeight(70);
				soundOnButton.setFitWidth(70);
				RenderableHolder.mouseEnter.play();
			}
		});
		
		soundOnButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				soundOnButton.setFitHeight(64);
				soundOnButton.setFitWidth(64);
			}
		});
	}
	public void initializeSoundOffButton() {
		soundOffButton = new ImageView(RenderableHolder.soundOff);
		soundOffButton.setCursor(Cursor.HAND);
		soundOffButton.setFitHeight(64);
		soundOffButton.setFitWidth(64);
		soundOffButton.setVisible(false);
		soundOffButton.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				RenderableHolder.battleMusicTimer.start();
				soundOnButton.setVisible(true);
				soundOffButton.setVisible(false);
			}
			
		});
		soundOffButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				soundOffButton.setFitHeight(70);
				soundOffButton.setFitWidth(70);
				RenderableHolder.mouseEnter.play();
			}
		});
		
		soundOffButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				soundOffButton.setFitHeight(64);
				soundOffButton.setFitWidth(64);
			}
		});
	}
	
}
