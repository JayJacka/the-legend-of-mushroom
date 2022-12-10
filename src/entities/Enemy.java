package entities;

import static utils.Constants.EnemyConstant.GetSpriteAmount;

import entities.base.Entity;

public abstract class Enemy extends Entity{
	private int aniIndex, State, Type;
	private int aniTick, aniSpeed = 20;

	public Enemy(float x, float y, int Type) {
		super(x, y);
		this.Type = Type;
	}

	private void updateAnimationTick() {
		aniTick++;
		if (aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if(aniIndex >= GetSpriteAmount(Type, State)) {
				aniIndex = 0;
			}
		}
	}
	
	public void update() {
		updateAnimationTick();
	}

	public int getAniIndex(){
		return aniIndex;
	}
	
	public int getState() {
		return State;
	}
	
	
}
