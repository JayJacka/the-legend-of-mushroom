package entities;
import static utils.Constants.EnemyConstant.*;

import javafx.scene.canvas.GraphicsContext;
public class Tomato extends Enemy{
	
	private int offSetx = 13;
	private int offSety = 11;
	
	public Tomato(float x, float y, int Type) {
		super(x, y, TOMATO, 38, 48, 100);
		initializeHitbox(x + offSetx, y + offSety);
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isRemoved() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
