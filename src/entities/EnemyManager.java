package entities;

import java.util.ArrayList;

import gui.page.Gameplay;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import utils.Animations;

public class EnemyManager {
	private Gameplay gameplay;
	private ArrayList<ArrayList<Image>> TomatoeAni;
	private ArrayList<Tomato> Tomatoes;
	
	public EnemyManager(Gameplay gameplay) {
		Tomatoes = new ArrayList<Tomato>();
		this.gameplay = gameplay;
		loadEnemyAnimations();
		initializeEnemy();
	}
	
	private void initializeEnemy() {
		// TODO Auto-generated method stub
		Image enemyDataImage = new Image(ClassLoader.getSystemResource("level/LevelOneData.png").toString());
		for (int j = 0; j < 23; j++) {
			for (int i = 0; i < 40; i++) {
				Color color= enemyDataImage.getPixelReader().getColor(i, j);
				if (color.getRed()*255 == 255) {
					Tomatoes.add(new Tomato(i*32-13, j*32-21, 0));
				}
			}
		}
		
	}

	public void update() {
		for(Tomato t : Tomatoes) {
			t.update();
		}
	}
	
	public void draw(GraphicsContext gc) {
		drawTomatoes(gc);
		update();
	}
	
	private void drawTomatoes(GraphicsContext gc) {
		for(Tomato t : Tomatoes) {
			gc.drawImage(TomatoeAni.get(t.getState()).get(t.getAniIndex()),  t.getX(), t.getY());
			t.drawHitbox(gc);
		}
	}

	private void loadEnemyAnimations() {
		TomatoeAni = new ArrayList<ArrayList<Image>>();
		TomatoeAni.add(Animations.getTomatoIdle());
		TomatoeAni.add(Animations.getTomatoHit());
	}
}
