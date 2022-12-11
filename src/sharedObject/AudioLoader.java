package utils;

import javafx.scene.media.AudioClip;

public class AudioLoader {
	public static AudioClip PlayerAttack = new AudioClip(ClassLoader.getSystemResource("/sounds/PlayerAttack.wav").toString());
}
