package utils;

public class Constants {
	
	public static class PlayerConstants{
		public static final int IDLE = 0;
		public static final int ATTACK = 1;
		public static final int JUMP = 2;
		public static final int WALK = 3;
		
		public static int GetSpriteAmount(int playerAction) {
			switch(playerAction){
			case ATTACK: return 8;
			case JUMP: return 8;
			case WALK: return 8;
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
}
