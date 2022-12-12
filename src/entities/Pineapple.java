package entities;
import static utils.Constants.EnemyConstant.*;

import javafx.scene.canvas.GraphicsContext;
import logic.GameLogic;
import objects.PineappleAmmo;
import utils.Constants.EnemyConstant;
public class Pineapple extends Enemy{
	
	private int offSetx = 18;
	private int offSety = 10;
	private boolean shot = false;
	private boolean reset1 = false;
	private boolean reset2 = false;
	private boolean reset3 = false;
	
	private int rangeAttackRange = 192;
	
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
	@Override
	public void update(Player player) {
//		System.out.println(canSeePlayer(player));
		this.State = EnemyConstant.IDLE;
		if (canSeePlayer(player)) {
			if (player.getPlayerAttack() && player.getAniIndex() >= 6) {
				this.health -= player.getDamage();
				this.State = EnemyConstant.HIT;
			}
		}
		if (canAttackPlayer(player)) {
			player.setHealth(player.getHealth() - this.attackDamage);
			if ((int) (player.getHitbox().getX() - this.getHitbox().getX()) < 0 ) {
				player.knockbackSpeed = -10f;
				player.updatePos();
			} else {
				player.knockbackSpeed = 10f;
				player.updatePos();
			}
		}
		if ((int) (player.getHitbox().getY()/32) == (int) (this.getHitbox().getY()/32)) {
			if (isPlayerInAttackRange(player, rangeAttackRange) && !shot) {
				shot = true;
				if (player.getHitbox().getX() - this.getHitbox().getX() <= 0) {
					GameLogic.getInstance().getCurrentAmmo().add(new PineappleAmmo((int) (this.getHitbox().getX() + 5), this.getY(), true, player, -1));
				} else {
					GameLogic.getInstance().getCurrentAmmo().add(new PineappleAmmo((int) (this.getHitbox().getX() + 5), this.getY(), true, player, 1));
				}
			}
		}
		updateAnimationTick();
	}
	@Override
	protected void updateAnimationTick() {
		aniTick++;
		if (aniTick >= aniSpeed) {
			if (aniIndex == 2) {
				if (reset1) {
					if (reset2) {
						if (reset3) {
							shot = false;
							reset3 = false;
						} else {
							reset3 = true;
						}
						reset2 = false;
					} else {
						reset2 = true;
					}
					reset1 = false;
				} else {
					reset1 = true;
				}

	
			}
			aniTick = 0;
			aniIndex++;
			if(aniIndex >= GetSpriteAmount(Type, State)) {
				aniIndex = 0;
			}
		}
	}
}