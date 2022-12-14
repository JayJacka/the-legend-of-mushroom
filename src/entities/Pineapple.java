package entities;
import static utils.Constants.EnemyConstants.*;

import logic.GameLogic;
import objects.PineappleAmmo;
import utils.Constants.EnemyConstants;
import utils.Constants.UniversalConstants;
public class Pineapple extends Enemy{
    
    private int offSetx = EnemyConstants.PINEAPPLE_X_OFFSET;
    private int offSety = EnemyConstants.PINEAPPLE_Y_OFFSET;
    private boolean shot = false;
    private boolean reset1 = false;
    private boolean reset2 = false;
    private boolean reset3 = false;
    
    private int rangeAttackRange = 192;
    
    public Pineapple(float x, float y, int Type) {
        super(x, y, PINEAPPLE, PINEAPPLE_HITBOX_WIDTH, PINEAPPLE_HITBOX_WIDTH, PINEAPPLE_HEALTH);
        initializeHitbox(x + offSetx, y + offSety);
    }

    @Override
    public void update(Player player) {
        this.State = EnemyConstants.IDLE;
        if (canSeePlayer(player)) {
            if (player.getPlayerAttack() && player.getAniIndex() >= 6) {
                this.health -= player.getDamage();
                this.State = EnemyConstants.HIT;
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
        if ((int) (player.getHitbox().getY()/UniversalConstants.TILE_SIZE) == (int) (this.getHitbox().getY()/UniversalConstants.TILE_SIZE)) {
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
