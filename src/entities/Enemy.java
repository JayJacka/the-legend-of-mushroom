package entities;

import static utils.Constants.EnemyConstants.GetSpriteAmount;

import utils.Constants.EnemyConstants;
import utils.Constants.PlayerConstants;
import utils.Constants.UniversalConstants;

public abstract class Enemy extends Entity implements AnimationUpdatable{
    protected int aniIndex, state, type;
    protected int aniTick, aniSpeed = 10;
    protected int playerAttackRange = PlayerConstants.PLAYER_ATTACK_RANGE;
    protected int attackRange = EnemyConstants.ATTACK_RANGE;
    protected int attackDamage = EnemyConstants.ATTACK_DAMAGE;
    public int health;

    public Enemy(int x, int y, int type, int hitboxWidth, int hitboxHeight, int health) {
        super(x, y, hitboxWidth, hitboxHeight);
        this.type = type;
        this.health = health;
    }

    public void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if(aniIndex >= GetSpriteAmount(type, state)) {
                aniIndex = 0;
            }
        }
    }
    
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
        updateAnimationTick();
    }

    public int getAniIndex(){
        return aniIndex;
    }
    
    public int getState() {
        return state;
    }
    
    public void setState(int state) {
        this.state = state;
    }
    
    protected boolean canSeePlayer(Player player) {
        int playerTileY = (int) (player.getHitbox().getY() / UniversalConstants.TILE_SIZE);
        if (playerTileY <= (int) (this.getHitbox().getY() / UniversalConstants.TILE_SIZE + 1) && playerTileY >= (int) (this.getHitbox().getY()/UniversalConstants.TILE_SIZE - 1) ) {
            if (isPlayerInRange(player)) {
                return true;
            }
        }
        return false;
    }

    protected boolean isPlayerInRange(Player player) {
        int range = (int) Math.abs(player.getHitbox().getX() - this.getHitbox().getX());
        return range <= playerAttackRange ;
    }
    
    protected boolean canAttackPlayer(Player player) {
        int playerTileY = (int) (player.getHitbox().getY() / UniversalConstants.TILE_SIZE);
        if (playerTileY == (int) (this.getHitbox().getY() / UniversalConstants.TILE_SIZE)) {
            if (isPlayerInAttackRangeX(player, this.attackRange)) {
                return true;
            }
        }
        return false;
    }
    
    protected boolean isPlayerInAttackRangeX (Player player, int attackRange) {
        int range = (int) Math.abs(player.getHitbox().getX() - this.getHitbox().getX());
        return range <= attackRange;
    }
    
    public int getHealth() {
        return this.health;
    }
    
}
