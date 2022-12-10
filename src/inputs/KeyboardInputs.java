package inputs;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;

public class KeyboardInputs {
	private static ArrayList<KeyCode> keys = new ArrayList<KeyCode>();
	
	public static void setKeyPressed(KeyCode key, boolean pressed) {
		if(pressed) {
			if(!keys.contains(key)) {
				keys.add(key);
			} else {
				keys.remove(key);
			}
		}
	}
	
	public static ArrayList<KeyCode> getKeys() {
		return keys;
	}
	
}