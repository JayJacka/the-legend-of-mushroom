package utils;

public class Constants {
	
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
		public static final int UP = 2;
		public static final int DOWN = 3;
	}
	
	public static class EnemyConstant{
		public static final int TOMATO = 0;
		public static final int PINEAPPLE = 1;
		
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
