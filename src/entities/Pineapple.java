package entities;
import static utils.Constants.EnemyConstants.GetSpriteAmount;
import static utils.Constants.EnemyConstants.PINEAPPLE;
import static utils.Constants.EnemyConstants.PINEAPPLE_HEALTH;
import static utils.Constants.EnemyConstants.PINEAPPLE_HITBOX_WIDTH;

import java.util.ArrayList;

import javafx.scene.image.Image;
import logic.GameLogic;
import objects.PineappleAmmo;
import utils.Animations;
import utils.Constants.EnemyConstants;
import utils.Constants.UniversalConstants;
public class Pineapple extends Enemy{
    
    private int offSetx = EnemyConstants.PINEAPPLE_X_OFFSET;
    private int offSety = EnemyConstants.PINEAPPLE_Y_OFFSET;
    private boolean shot = false;
    private boolean reset1 = false;
    private boolean reset2 = false;
    private boolean reset3 = false;
    private ArrayList<ArrayList<Image>> pineappleAni;
    private int rangeAttackRange = 192;
    
    public Pineapple(int x, int y, int Type) {
        super(x, y, PINEAPPLE, PINEAPPLE_HITBOX_WIDTH, PINEAPPLE_HITBOX_WIDTH, PINEAPPLE_HEALTH);
        initializeHitbox(x + offSetx, y + offSety);
        loadAnimations();
    }

    @Override
    public void update(Player player) {
        this.state = EnemyConstants.IDLE;
        if (canSeePlayer(player)) {
            if (player.isAttacking() && player.getAniIndex() >= 6) {
                this.health -= player.getDamage();
                this.state = EnemyConstants.HIT;
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
        if ((int) (player.getHitbox().getY() / UniversalConstants.TILE_SIZE) == (int) (this.getHitbox().getY()/UniversalConstants.TILE_SIZE)) {
            if (isPlayerInAttackRangeX(player, rangeAttackRange) && !shot) {
                shot = true;
                if (player.getHitbox().getX() - this.getHitbox().getX() <= 0) {
                    GameLogic.getInstance().getCurrentAmmo().add(new PineappleAmmo((int) (this.getHitbox().getX() + 5), (int) this.getY(), true, player, -1));
                } else {
                    GameLogic.getInstance().getCurrentAmmo().add(new PineappleAmmo((int) (this.getHitbox().getX() + 5), (int) this.getY(), true, player, 1));
                }
            }
        }
        updateAnimationTick();
    }
    @Override
	public void updateAnimationTick() {
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
            if(aniIndex >= GetSpriteAmount(type, state)) {
                aniIndex = 0;
            }
        }
    }

	@Override
	public void loadAnimations() {
		// TODO Auto-generated method stub
		pineappleAni = new ArrayList<ArrayList<Image>>();
		pineappleAni.add(Animations.getPineappleIdle());
		pineappleAni.add(Animations.getPineappleIdle());
		pineappleAni.add(Animations.getPineappleIdle());
		pineappleAni.add(Animations.getPineappleHit());
	}

	public ArrayList<ArrayList<Image>> getPineappleAni() {
		return pineappleAni;
	}
	
	
}
