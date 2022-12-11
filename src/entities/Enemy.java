package entities;

import static utils.Constants.EnemyConstant.GetSpriteAmount;

import entities.base.Entity;
import utils.Constants.EnemyConstant;

public abstract class Enemy extends Entity{
	private int aniIndex, State, Type;
	private int aniTick, aniSpeed = 10;
	protected int attackRange = 48;
	public int health;

	public Enemy(float x, float y, int Type, int hitboxWidth, int hitboxHeight, int health) {
		super(x, y, hitboxWidth, hitboxHeight);
		this.Type = Type;
		this.health = health;
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
	
	public void update(Player player) {
//		System.out.println(canSeePlayer(player));
		this.State = EnemyConstant.IDLE;
		if (canSeePlayer(player)) {
			if (player.getPlayerAttack()) {
				this.health -= player.getDamage();
				this.State = EnemyConstant.HIT;
			}
		}
		updateAnimationTick();
	}

	public int getAniIndex(){
		return aniIndex;
	}
	
	public int getState() {
		return State;
	}
	
	public void setState(int state) {
		this.State = state;
	}
	
	protected boolean canSeePlayer(Player player) {
		int playerTileY = (int) (player.getHitbox().getY()/32);
//		System.out.println(playerTileY + " " +(int) (this.getHitbox().getY()/32));
		if (playerTileY == (int) (this.getHitbox().getY()/32)) {
			if (isPlayerInRange(player)) {
				return true;
			}
		}
		return false;
	}

	protected boolean isPlayerInRange(Player player) {
		int range = (int) Math.abs(player.getHitbox().getX() - this.getHitbox().getX());
//		System.out.println(range);
		return range <= attackRange ;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	
}
