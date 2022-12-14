package entities;

import static utils.Constants.EnemyConstants.GetSpriteAmount;

import utils.Constants.EnemyConstants;
import utils.Constants.UniversalConstants;

public abstract class Enemy extends Entity implements AnimationUpdatable{
    protected int aniIndex, State, Type;
    protected int aniTick, aniSpeed = 10;
    protected int playerAttackRange = 64;
    protected int attackRange = 20;
    protected int attackDamage = 5;
    public int health;

    public Enemy(int x, int y, int Type, int hitboxWidth, int hitboxHeight, int health) {
        super(x, y, hitboxWidth, hitboxHeight);
        this.Type = Type;
        this.health = health;
    }

    public void updateAnimationTick() {
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
        int playerTileY = (int) (player.getHitbox().getY()/UniversalConstants.TILE_SIZE);
        if (playerTileY <= (int) (this.getHitbox().getY()/UniversalConstants.TILE_SIZE + 1) && playerTileY >= (int) (this.getHitbox().getY()/UniversalConstants.TILE_SIZE - 1) ) {
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
        int playerTileY = (int) (player.getHitbox().getY()/UniversalConstants.TILE_SIZE);
        if (playerTileY == (int) (this.getHitbox().getY()/UniversalConstants.TILE_SIZE)) {
            if (isPlayerInAttackRange(player, this.attackRange)) {
                return true;
            }
        }
        return false;
    }
    
    protected boolean isPlayerInAttackRange (Player player, int attackRange) {
        int range = (int) Math.abs(player.getHitbox().getX() - this.getHitbox().getX());
        return range <= attackRange;
    }
    
    public int getHealth() {
        return this.health;
    }

    public void setAniIndex(int aniIndex) {
        this.aniIndex = aniIndex;
    }
    
    
}
