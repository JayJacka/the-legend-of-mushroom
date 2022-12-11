package entities;
import static utils.Constants.EnemyConstant.*;

import javafx.scene.canvas.GraphicsContext;
public class Pineapple extends Enemy{
	
	private int offSetx = 18;
	private int offSety = 10;
	
	public Pineapple(float x, float y, int Type) {
		super(x, y, PINEAPPLE, 29, 46, 100);
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