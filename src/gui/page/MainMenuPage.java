package gui.page;

import gui.element.MainMenuElement;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainMenuPage extends StackPane {
	
	public MainMenuPage(Stage primaryStage) {
		MainMenuElement mainMenuElement = new MainMenuElement(primaryStage);
		Scene scene = new Scene(mainMenuElement, 1280,720);
		primaryStage.setScene(scene);
	}
}
