package entities;

import java.util.ArrayList;

import gui.page.Gameplay;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import utils.Animations;

public class EnemyManager {
	private Gameplay gameplay;
	private ArrayList<ArrayList<Image>> TomatoeAni;
	private ArrayList<Tomato> Tomatoes;
	
	public EnemyManager(Gameplay gameplay) {
		this.gameplay = gameplay;
		loadEnemyAnimations();
	}
	
	public void update() {
		for(Tomato t : Tomatoes) {
			t.update();
		}
	}
	
	public void draw(GraphicsContext gc) {
		drawTomatoes(gc);
	}
	private void drawTomatoes(GraphicsContext gc) {
		for(Tomato t : Tomatoes) {
			gc.drawImage(TomatoeAni.get(t.getState()).get(t.getAniIndex()),  t.getHitbox().getX(), t.getHitbox().getY());
		}
	}

	private void loadEnemyAnimations() {
		TomatoeAni = new ArrayList<ArrayList<Image>>();
		TomatoeAni.add(Animations.getTomatoIdle());
		TomatoeAni.add(Animations.getTomatoHit());
	}
}
