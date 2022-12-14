package entities;
import static utils.Constants.EnemyConstants.TOMATO;

import java.util.ArrayList;

import javafx.scene.image.Image;
import utils.Animations;
import utils.Constants.EnemyConstants;
public class Tomato extends Enemy{
	
	private int offSetx = EnemyConstants.TOMATO_X_OFFSET;
	private int offSety = EnemyConstants.TOMATO_Y_OFFSET;
	
	private static int hBoxWidth = EnemyConstants.TOMATO_HITBOX_WIDTH;
	private static int hBoxHeight = EnemyConstants.TOMATO_HITBOX_HEIGHT;
	private ArrayList<ArrayList<Image>> tomatoeAni;
	
	public Tomato(int x, int y, int Type) {
		super(x, y, TOMATO, hBoxWidth, hBoxHeight, EnemyConstants.TOMATO_HEALTH);
		initializeHitbox(x + offSetx, y + offSety);
		loadAnimations();
	}

	@Override
	public void loadAnimations() {
		// TODO Auto-generated method stub
		tomatoeAni = new ArrayList<ArrayList<Image>>();
		tomatoeAni.add(Animations.getTomatoIdle());
		tomatoeAni.add(Animations.getTomatoIdle());
		tomatoeAni.add(Animations.getTomatoIdle());
		tomatoeAni.add(Animations.getTomatoHit());
	}

	public ArrayList<ArrayList<Image>> getTomatoeAni() {
		return tomatoeAni;
	}

	
}
