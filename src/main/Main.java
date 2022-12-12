package main;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import gui.page.*;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		MainMenuPage mainMenuPage = new MainMenuPage(primaryStage);
		primaryStage.setResizable(false);
		primaryStage.setTitle("The Legend of Mushroom");
		String iconPath = ClassLoader.getSystemResource("Mushroom.png").toString();
		primaryStage.getIcons().add(new Image(iconPath));
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
