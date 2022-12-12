package main;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sharedObject.RenderableHolder;
import gui.element.*;
import gui.page.*;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		MainMenuPage mainMenuPage = new MainMenuPage(primaryStage);
		primaryStage.setResizable(false);
		primaryStage.setTitle("The Legend of Mushroom");
		primaryStage.getIcons().add(RenderableHolder.icon);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
