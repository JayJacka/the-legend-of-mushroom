package entities;
import static utils.Constants.EnemyConstant.*;
public class Tomato extends Enemy{
	
	private int offSetx = 13;
	private int offSety = 11;
	
	public Tomato(float x, float y, int Type) {
		super(x, y, TOMATO, 38, 48);
		initializeHitbox(x + offSetx, y + offSety);
	}
	
}
