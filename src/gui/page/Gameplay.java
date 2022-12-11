package gui.page;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.GameLogic;

public class Gameplay extends Pane{
	private Stage primaryStage;
	private Canvas canvas;
	private GraphicsContext gc;
	private Scene scene;
	
	public Gameplay(Stage primaryStage) {
		this.primaryStage = primaryStage;
		setStage();
		GameLogic.getInstance().newGame(gc, scene);
		primaryStage.show();
	}

	public void setStage() {
		canvas = new Canvas(1280,720);
		gc = canvas.getGraphicsContext2D();
		getChildren().add(canvas);
		scene = new Scene(this);
		primaryStage.setScene(scene);
	}
}
