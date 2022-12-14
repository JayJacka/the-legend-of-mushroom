package main;

import gui.page.MainMenuPage;
import javafx.application.Application;
import javafx.stage.Stage;
import sharedObject.RenderableHolder;

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
