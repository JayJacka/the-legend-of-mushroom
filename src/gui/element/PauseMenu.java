package gui.element;

import gamestates.GameState;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import logic.GameLogic;
import sharedObject.RenderableHolder;

public class PauseMenu extends StackPane{
	private ImageView resumeButton;
	private ImageView quitButton;
	private ImageView soundOffButton;
	private ImageView soundOnButton;
	private AnimationTimer BattleMusic;
	
	public PauseMenu() {
		setMaxHeight(300);
		setMaxWidth(230);
		
		VBox button = new VBox();
		initializeBackgroundMusic();
		BattleMusic.start();
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
		resumeButton = new ImageView(RenderableHolder.Resume);
		resumeButton.setCursor(Cursor.HAND);
		resumeButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				resumeButton.setTranslateX(-5);
				resumeButton.setFitHeight(130);
				resumeButton.setFitWidth(240);
				RenderableHolder.MouseEnter.play();
			}
		});
		
		resumeButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				resumeButton.setTranslateX(0);
				resumeButton.setFitHeight(120);
				resumeButton.setFitWidth(230);
			}
		});
		
		resumeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				GameState.state = GameState.PLAYING;
				setVisible(false);
			}
		});;
	}
	
	public void initializeQuitButton() {
		quitButton = new ImageView(RenderableHolder.Quit);
		quitButton.setCursor(Cursor.HAND);
		quitButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				quitButton.setTranslateX(-5);
				quitButton.setFitHeight(130);
				quitButton.setFitWidth(240);
				RenderableHolder.MouseEnter.play();
			}
		});
		
		quitButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				quitButton.setTranslateX(0);
				quitButton.setFitHeight(120);
				quitButton.setFitWidth(230);
			}
		});
		
		quitButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Platform.exit();
			}
		});;
	}
	
	public void initializeSoundOnButton() {
		String soundOnButtonPath = ClassLoader.getSystemResource("SoundOn.png").toString();
		soundOnButton = new ImageView(soundOnButtonPath);
		soundOnButton.setCursor(Cursor.HAND);
		soundOnButton.setFitHeight(64);
		soundOnButton.setFitWidth(64);
		soundOnButton.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				RenderableHolder.BattleMusic.stop();
				BattleMusic.stop();
				soundOnButton.setVisible(false);
				soundOffButton.setVisible(true);
			}
			
		});
		soundOnButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				soundOnButton.setFitHeight(70);
				soundOnButton.setFitWidth(70);
				RenderableHolder.MouseEnter.play();
			}
		});
		
		soundOnButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				soundOnButton.setFitHeight(64);
				soundOnButton.setFitWidth(64);
			}
		});
	}
	public void initializeSoundOffButton() {
		String soundOffButtonPath = ClassLoader.getSystemResource("SoundOff.png").toString();
		soundOffButton = new ImageView(soundOffButtonPath);
		soundOffButton.setCursor(Cursor.HAND);
		soundOffButton.setFitHeight(64);
		soundOffButton.setFitWidth(64);
		soundOffButton.setVisible(false);
		soundOffButton.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				BattleMusic.start();
				soundOnButton.setVisible(true);
				soundOffButton.setVisible(false);
			}
			
		});
		soundOffButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				soundOffButton.setFitHeight(70);
				soundOffButton.setFitWidth(70);
				RenderableHolder.MouseEnter.play();
			}
		});
		
		soundOffButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				soundOffButton.setFitHeight(64);
				soundOffButton.setFitWidth(64);
			}
		});
	}
	public void initializeBackgroundMusic() {
		BattleMusic = new AnimationTimer() {
			
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				if(!RenderableHolder.BattleMusic.isPlaying()) 
					RenderableHolder.BattleMusic.play();
			}
		};
	}
	
}
