package entities;
import static utils.Constants.EnemyConstants.*;

import javafx.scene.canvas.GraphicsContext;
import utils.Constants.EnemyConstants;
public class Tomato extends Enemy{
	
	private int offSetx = EnemyConstants.TOMATO_X_OFFSET;
	private int offSety = EnemyConstants.TOMATO_Y_OFFSET;
	
	private static int hBoxWidth = EnemyConstants.TOMATO_HITBOX_WIDTH;
	private static int hBoxHeight = EnemyConstants.TOMATO_HITBOX_HEIGHT;
	
	public Tomato(float x, float y, int Type) {
		super(x, y, TOMATO, hBoxWidth, hBoxHeight, EnemyConstants.TOMATO_HEALTH);
		initializeHitbox(x + offSetx, y + offSety);
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}

}
