package entities;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import logic.GameLogic;
import utils.Animations;

public class EnemyManager {
	private ArrayList<ArrayList<Image>> tomatoeAni;
	private ArrayList<Tomato> tomatoes;
	private ArrayList<Pineapple> pineapples;
	private ArrayList<ArrayList<Image>> pineappleAni;
	private Player player;
	
	public EnemyManager(Player player) {
		tomatoes = new ArrayList<Tomato>();
		pineapples = new ArrayList<Pineapple>();
		this.player = player;
		loadEnemyAnimations();
		initializeEnemy();
	}
	
	private void initializeEnemy() {
		// TODO Auto-generated method stub
		Image enemyDataImage = new Image(ClassLoader.getSystemResource("level/Map"+ GameLogic.getInstance().getCurrentLevel()%3 + ".png").toString());
		for (int j = 0; j < 23; j++) {
			for (int i = 0; i < 40; i++) {
				Color color= enemyDataImage.getPixelReader().getColor(i, j);
				if ((int) (color.getRed()*255) == 234) {
					tomatoes.add(new Tomato(i*32-13, j*32-21, 0));
				}
				if ((int) (color.getRed()*255) == 123) {
					pineapples.add(new Pineapple(i*32-13, j*32-21, 1));
				}
			}
		}
		
	}

	public boolean levelCleared() {
		return tomatoes.size() == 0 && pineapples.size() == 0;
	}

	public void update(Player player) {
		ArrayList<Tomato> tToBeRemoved = new ArrayList<Tomato>();
		for(Tomato t : tomatoes) {
			t.update(player);
			if (t.getHealth() <= 0) {
				tToBeRemoved.add(t);
			}
		}
		for (Tomato t: tToBeRemoved) {
			tomatoes.remove(t);
		}
		ArrayList<Pineapple> pToBeRemoved = new ArrayList<Pineapple>();
		for(Pineapple p : pineapples) {
			p.update(player);
			if (p.getHealth() <= 0) {
				pToBeRemoved.add(p);
			}
		}
		for (Pineapple p: pToBeRemoved) {
			pineapples.remove(p);
		}
	}
	
	public void draw(GraphicsContext gc) {
		drawEnemies(gc);
		update(player);
	}
	
	public void drawEnemies(GraphicsContext gc) {
		for(Tomato t : tomatoes) {
//			System.out.println(t.getAniIndex() + " " + t.getState());
			gc.drawImage(tomatoeAni.get(t.getState()).get(t.getAniIndex()),  t.getX(), t.getY());
			t.drawHitbox(gc);
		}
		for(Pineapple p : pineapples) {
			gc.drawImage(pineappleAni.get(p.getState()).get(p.getAniIndex()), p.getX(), p.getY());
			p.drawHitbox(gc);
		}
		
	}

	private void loadEnemyAnimations() {
		tomatoeAni = new ArrayList<ArrayList<Image>>();
		tomatoeAni.add(Animations.getTomatoIdle());
		tomatoeAni.add(Animations.getTomatoIdle());
		tomatoeAni.add(Animations.getTomatoIdle());
		tomatoeAni.add(Animations.getTomatoHit());
		pineappleAni = new ArrayList<ArrayList<Image>>();
		pineappleAni.add(Animations.getPineappleIdle());
		pineappleAni.add(Animations.getPineappleIdle());
		pineappleAni.add(Animations.getPineappleIdle());
		pineappleAni.add(Animations.getPineappleHit());
	}
}
