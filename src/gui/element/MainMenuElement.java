package gui.element;

import gui.page.Gameplay;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import sharedObject.RenderableHolder;

public class MainMenuElement extends StackPane {
	
	private Stage primaryStage;
	private ImageView startButton;
	private ImageView quitButton;
	private ImageView helpButton;
	private ImageView background;
	private Rectangle rectangle;
	private StackPane helpPane;
	private ImageView character;
	private ImageView soundOnButton;
	private ImageView soundOffButton;
	
	private AnimationTimer MainMusic;

	public MainMenuElement(Stage primaryStage) {
		this.primaryStage = primaryStage;
		setPrefWidth(1280);
		setPrefHeight(720);
		setMinWidth(1280);
		setMinHeight(700);
		background = new ImageView(RenderableHolder.MainBackground);
		background.setFitHeight(720);
		background.setFitWidth(1280);
		initializeBackgroundMusic();
		MainMusic.start();
		initializeHelpPane();
		initializeStartButton();
		initializeHelpButton();
		initializeQuitButton();
		initializeSoundOnButton();
		initializeSoundOffButton();
		VBox buttonContainer = new VBox();
		StackPane soundButton = new StackPane();
		soundButton.getChildren().addAll(soundOffButton,soundOnButton);
		buttonContainer.getChildren().addAll(startButton, helpButton, quitButton,soundButton);
		buttonContainer.setTranslateX(450);
		buttonContainer.setTranslateY(100);
		buttonContainer.setAlignment(Pos.CENTER);
		buttonContainer.setSpacing(5);
		ImageView nameLogo = new ImageView(RenderableHolder.NameLogo);
		nameLogo.setFitWidth(860);
		nameLogo.setFitHeight(140);
		nameLogo.setTranslateX(-200);
		nameLogo.setTranslateY(-280);
		character = new ImageView(RenderableHolder.MushroomIdleGIF);
		character.setFitHeight(192);
		character.setFitWidth(240);
		character.setTranslateY(190);
		this.getChildren().addAll(background, nameLogo, character, buttonContainer, rectangle, helpPane);
	}
	
	public void initializeStartButton() {
		startButton = new ImageView(RenderableHolder.StartButton);
		startButton.setCursor(Cursor.HAND);
		startButton.setFitHeight(80);
		startButton.setFitWidth(200);
		startButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				startButton.setFitHeight(88);
				startButton.setFitWidth(220);
				RenderableHolder.MouseEnter.play();
			}
		});
		
		startButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				startButton.setFitHeight(80);
				startButton.setFitWidth(200);
				startButton.setTranslateY(0);
			}
		});
		
		startButton.setOnMousePressed(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				startButton.setTranslateY(2);
			}
		});
		
		startButton.setOnMouseReleased(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				startButton.setTranslateY(0);
			}
		});
		
		startButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				startButtonHandler();
				RenderableHolder.Start.play();
			}
		});;
	}
	
	public void startButtonHandler() {
		startButton.setDisable(true);
		helpButton.setDisable(true);
		quitButton.setDisable(true);
		System.out.println("Start the Game");
		character.setImage(RenderableHolder.MushroomWalkGIF);
		Path path = new Path();
		path.getElements().add(new MoveTo(120, 285));
		path.getElements().add(new HLineTo(860));
		PathTransition pathTransition = new PathTransition();
		pathTransition.setDuration(Duration.millis(2500));
		pathTransition.setPath(path);
		pathTransition.setNode(character);
		pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		FadeTransition start = new FadeTransition(Duration.millis(1500));
		start.setNode(rectangle);
		start.setFromValue(0);
		start.setToValue(1);
		pathTransition.setOnFinished(e -> {
			start.play();
			rectangle.setVisible(true);
		});
		pathTransition.play();
		start.setOnFinished(e -> {
			if (RenderableHolder.MainMusic.isPlaying()) {
				RenderableHolder.MainMusic.stop();
				MainMusic.stop();
			}
			Gameplay gamePlay = new Gameplay(this.primaryStage);
		});
	}
	public void initializeHelpButton() {
		helpButton = new ImageView(RenderableHolder.HelpButton);
		helpButton.setCursor(Cursor.HAND);
		helpButton.setFitHeight(80);
		helpButton.setFitWidth(200);
		helpButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				helpButton.setFitHeight(88);
				helpButton.setFitWidth(220);
				RenderableHolder.MouseEnter.play();
			}
		});
		
		helpButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				helpButton.setFitHeight(80);
				helpButton.setFitWidth(200);
				helpButton.setTranslateY(0);
			}
		});
		
		helpButton.setOnMousePressed(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				helpButton.setTranslateY(2);
			}
		});
		
		helpButton.setOnMouseReleased(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				helpButton.setTranslateY(0);
			}
		});
		
		helpButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				helpButtonHandler();
			}
		});;
	}
	
	public void helpButtonHandler() {
		FadeTransition ft1 = new FadeTransition(Duration.millis(300));
		ft1.setNode(helpPane);
		ft1.setFromValue(0.00);
		ft1.setToValue(1);
		ft1.play();
		FadeTransition ft2 = new FadeTransition(Duration.millis(300));
		ft2.setNode(rectangle);
		ft2.setFromValue(0.00);
		ft2.setToValue(0.5);
		ft2.play();
		helpPane.setVisible(true);
		rectangle.setVisible(true);
	}
	
	public void initializeQuitButton() {
		quitButton = new ImageView(RenderableHolder.QuitButton);
		quitButton.setCursor(Cursor.HAND);
		quitButton.setFitHeight(80);
		quitButton.setFitWidth(200);
		quitButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				quitButton.setFitHeight(88);
				quitButton.setFitWidth(220);
				RenderableHolder.MouseEnter.play();
			}
		});
		
		quitButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				quitButton.setFitHeight(80);
				quitButton.setFitWidth(200);
				quitButton.setTranslateY(0);
			}
		});
		
		quitButton.setOnMousePressed(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				quitButton.setTranslateY(2);
			}
		});
		
		quitButton.setOnMouseReleased(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				quitButton.setTranslateY(0);
			}
		});
		
		quitButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				quitButtonHandler();
			}
		});;
	}
	
	public void quitButtonHandler() {
		Platform.exit();
	}
	
	public void initializeHelpPane() {
		rectangle = new Rectangle(1280,720);
		rectangle.setOpacity(0.5);
		rectangle.setVisible(false);
		helpPane = new StackPane();
		ImageView helpPaneImg = new ImageView(RenderableHolder.HelpPane);
		helpPaneImg.setFitHeight(540);
		helpPaneImg.setFitWidth(960);
		helpPane.getChildren().add(helpPaneImg);
		ImageView xButton = new ImageView(RenderableHolder.xButton);
		xButton.setFitHeight(35);
		xButton.setFitWidth(35);
		xButton.setCursor(Cursor.HAND);
		xButton.setTranslateX(425);
		xButton.setTranslateY(-225);
		xButton.setOnMousePressed(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				xButton.setTranslateY(-223);
			}
		});
		
		xButton.setOnMouseReleased(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				xButton.setTranslateY(-225);
			}
		});
		xButton.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				FadeTransition ft1 = new FadeTransition(Duration.millis(300));
				ft1.setNode(helpPane);
				ft1.setFromValue(1.00);
				ft1.setToValue(0);
				ft1.play();
				FadeTransition ft2 = new FadeTransition(Duration.millis(300));
				ft2.setNode(rectangle);
				ft2.setFromValue(0.50);
				ft2.setToValue(0.0);
				ft2.play();
				ft1.setOnFinished(e -> helpPane.setVisible(false));
				ft2.setOnFinished(e -> rectangle.setVisible(false));
			}
			
		});
		Text titleText = new Text("How to Play");
		titleText.setFont(Font.font(35));
		titleText.setTranslateX(-350);
		titleText.setTranslateY(-220);
		Text storyText = new Text();
		storyText.setText("In this game you play as Spoc, "
				+ "a Mushroom Warrior. You’re one of the strongest warrior of Mushroomkind. "
				+ "You’re tasked to help rescue Princess Funga who got captured by the great devil name Fruton. "
				+ "There are 100 levels to reach the Princess. For level after level, the enemies become stronger and stronger."
				+ "You must utilize your strength and save the Princess.");
		storyText.setWrappingWidth(800);
		storyText.setFont(Font.font(20));
		storyText.setTranslateY(-135);
		Text controlText = new Text();
		controlText.setText("These are the controls for Spoc");
		controlText.setFont(Font.font(25));
		controlText.setTranslateX(-280);
		controlText.setTranslateY(-50);
		ImageView characterIdle = new ImageView(RenderableHolder.MushroomIdleGIF);
		characterIdle.setFitHeight(160);
		characterIdle.setFitWidth(200);
		characterIdle.setTranslateY(150);
		characterIdle.setTranslateX(-200);
		ImageView characterAttack = new ImageView(RenderableHolder.MushroomAttackGIF);
		characterAttack.setFitHeight(160);
		characterAttack.setFitWidth(200);
		characterAttack.setTranslateY(150);
		characterAttack.setTranslateX(300);
		Text jump = new Text();
		jump.setText("use W to jump");
		jump.setFont(Font.font(20));
		jump.setTranslateX(-220);
		jump.setTranslateY(50);
		Text left = new Text();
		left.setText("use A to move left");
		left.setFont(Font.font(20));
		left.setTranslateX(-380);
		left.setTranslateY(150);
		Text right = new Text();
		right.setText("use ➜ to move right");
		right.setFont(Font.font(20));
		right.setTranslateY(150);
		right.setTranslateX(-40);
		Text attack = new Text();
		attack.setText("press Space to attack");
		attack.setFont(Font.font(20));
		attack.setTranslateX(280);
		attack.setTranslateY(50);
		Text specialAttack = new Text();
		specialAttack.setText("hold Space for special attack");
		specialAttack.setFont(Font.font(20));
		specialAttack.setTranslateX(280);
		specialAttack.setTranslateY(230);
		helpPane.getChildren().addAll(xButton, titleText, storyText, controlText, characterIdle, characterAttack, jump, left, right, attack, specialAttack);
		helpPane.setVisible(false);
	}
	
	public void initializeSoundOnButton() {
		soundOnButton = new ImageView(RenderableHolder.SoundOn);
		soundOnButton.setCursor(Cursor.HAND);
		soundOnButton.setFitHeight(64);
		soundOnButton.setFitWidth(64);
		soundOnButton.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				RenderableHolder.MainMusic.stop();
				MainMusic.stop();
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
		soundOffButton = new ImageView(RenderableHolder.SoundOff);
		soundOffButton.setCursor(Cursor.HAND);
		soundOffButton.setFitHeight(64);
		soundOffButton.setFitWidth(64);
		soundOffButton.setVisible(false);
		soundOffButton.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				MainMusic.start();
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
		MainMusic = new AnimationTimer() {
			
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				if(!RenderableHolder.MainMusic.isPlaying()) 
					RenderableHolder.MainMusic.play();
			}
		};
	}
	
	
}
