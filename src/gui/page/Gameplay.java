package gui.page;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.GameLogic;

public class Gameplay extends StackPane{
	private Stage primaryStage;
	private Canvas canvas;
	private GraphicsContext gc;
	private Scene scene;

	public Gameplay(Stage primaryStage) {
		this.primaryStage = primaryStage;
		setStage();
		GameLogic.getInstance().newGame(gc, scene, this);
		primaryStage.show();
	}

	public void setStage() {
		canvas = new Canvas(1280,720);
		gc = canvas.getGraphicsContext2D();
		getChildren().add(canvas);
		scene = new Scene(this);
		primaryStage.setScene(scene);
	}

	public StackPane getGameplayPane() {
		return this;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

}
