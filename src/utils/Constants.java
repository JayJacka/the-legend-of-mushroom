package utils;

public class Constants {
	
	public static class UniversalConstants{
		public static final int TILE_SIZE = 32;
		public static final int X_DIMENSION = 1280;
		public static final int Y_DIMENSION = 720;
	}
	
	public static class PlayerConstants{
		public static final int IDLE_LEFT = 0;
		public static final int IDLE_RIGHT = 1;
		public static final int ATTACK_LEFT = 2;
		public static final int ATTACK_RIGHT = 3;
		public static final int JUMP_LEFT = 4;
		public static final int JUMP_RIGHT = 5;
		public static final int WALK_LEFT = 6;
		public static final int WALK_RIGHT = 7;
		public static final int DEATH = 8;
		
		public static final int PLAYER_ATTACK_RANGE = 64;
		
		public static final int X_DRAW_OFFSET = 16;
		public static final int Y_DRAW_OFFSET = 10;
		
		public static final int HITBOXWIDTH = 32;
		public static final int HITBOXHEIGHT = 44;
		
		public static final float AIRSPEED = 0f;
		public static final float GRAVITY = 0.8f;
		public static final float JUMP_SPEED = -15f;
		public static final float FALL_SPEED_AFTER_COLLISION = 2f;
		public static final float KNOCKBACK_SPEED = 0f;
		
		public static final int DAMAGE = 10;
		public static final int HEALTH = 100;
		
		public static int GetSpriteAmount(int playerAction) {
			switch(playerAction){
			case ATTACK_LEFT: return 8;
			case JUMP_LEFT: return 8;
			case WALK_LEFT: return 8;
			case ATTACK_RIGHT: return 8;
			case JUMP_RIGHT: return 8;
			case WALK_RIGHT: return 8;
			default : return 8;
			}
		}
	}
	
	public static class Directions{
		public static final int RIGHT = 0;
		public static final int LEFT = 1;
	}
	
	public static class EnemyConstants{
		public static final int TOMATO = 0;
		public static final int PINEAPPLE = 1;
		
		public static final int ATTACK_RANGE = 20;
		public static final int ATTACK_DAMAGE = 5;
		
		public static final int X_OFFSET = 13;
		public static final int Y_OFFSET = 21;
		
		public static final int TOMATO_X_OFFSET = 13;
		public static final int TOMATO_Y_OFFSET = 11;
		
		public static final int PINEAPPLE_X_OFFSET = 18;
		public static final int PINEAPPLE_Y_OFFSET = 10;
		
		public static final int TOMATO_HITBOX_WIDTH = 38;
		public static final int TOMATO_HITBOX_HEIGHT = 48;
		
		public static final int PINEAPPLE_HITBOX_WIDTH = 29;
		public static final int PINEAPPLE_HITBOX_HEIGHT = 46;
		
		public static final int TOMATO_R_VALUE = 234;
		public static final int PINEAPPLE_R_VALUE = 123;
		
		public static final int TOMATO_HEALTH = 200;
		public static final int PINEAPPLE_HEALTH = 100;
		
		public static final int IDLE = 0;
		public static final int ATTACK = 1;
		public static final int WALK = 2;
		public static final int HIT = 3;
		
		public static int GetSpriteAmount(int Type, int State) {
			switch(Type) {
				case TOMATO:
					switch(State) {
					case IDLE : return 6;
					case WALK : return 6;
					case ATTACK : return 6;
					case HIT : return 6;
					}
				case PINEAPPLE:
					switch(State) {
					case IDLE: return 3;
					case WALK: return 3;
					case ATTACK: return 3;
					case HIT : return 3;
					}
			}
			return 0;
		}
	}
}
