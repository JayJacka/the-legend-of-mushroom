package sharedObject;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();

	// Mushroom Image
	public static Image mushRoomIdleLeft0;
	public static Image mushRoomIdleLeft1;
	public static Image mushRoomIdleLeft2;
	public static Image mushRoomIdleLeft3;
	public static Image mushRoomIdleLeft4;
	public static Image mushRoomIdleLeft5;
	public static Image mushRoomIdleLeft6;
	public static Image mushRoomIdleLeft7;
	
	public static Image mushRoomIdleRight0;
	public static Image mushRoomIdleRight1;
	public static Image mushRoomIdleRight2;
	public static Image mushRoomIdleRight3;
	public static Image mushRoomIdleRight4;
	public static Image mushRoomIdleRight5;
	public static Image mushRoomIdleRight6;
	public static Image mushRoomIdleRight7;
	
	public static Image mushRoomAttackLeft0;
	public static Image mushRoomAttackLeft1;
	public static Image mushRoomAttackLeft2;
	public static Image mushRoomAttackLeft3;
	public static Image mushRoomAttackLeft4;
	public static Image mushRoomAttackLeft5;
	public static Image mushRoomAttackLeft6;
	public static Image mushRoomAttackLeft7;
	
	public static Image mushRoomAttackRight0;
	public static Image mushRoomAttackRight1;
	public static Image mushRoomAttackRight2;
	public static Image mushRoomAttackRight3;
	public static Image mushRoomAttackRight4;
	public static Image mushRoomAttackRight5;
	public static Image mushRoomAttackRight6;
	public static Image mushRoomAttackRight7;
	
	public static Image mushRoomWalkLeft0;
	public static Image mushRoomWalkLeft1;
	public static Image mushRoomWalkLeft2;
	public static Image mushRoomWalkLeft3;
	public static Image mushRoomWalkLeft4;
	public static Image mushRoomWalkLeft5;
	public static Image mushRoomWalkLeft6;
	public static Image mushRoomWalkLeft7;
	
	public static Image mushRoomWalkRight0;
	public static Image mushRoomWalkRight1;
	public static Image mushRoomWalkRight2;
	public static Image mushRoomWalkRight3;
	public static Image mushRoomWalkRight4;
	public static Image mushRoomWalkRight5;
	public static Image mushRoomWalkRight6;
	public static Image mushRoomWalkRight7;
	
	public static Image mushRoomJumpLeft0;
	public static Image mushRoomJumpLeft1;
	public static Image mushRoomJumpLeft2;
	public static Image mushRoomJumpLeft3;
	public static Image mushRoomJumpLeft4;
	public static Image mushRoomJumpLeft5;
	public static Image mushRoomJumpLeft6;
	public static Image mushRoomJumpLeft7;
	public static Image mushRoomJumpLeft8;
	
	public static Image mushRoomJumpRight0;
	public static Image mushRoomJumpRight1;
	public static Image mushRoomJumpRight2;
	public static Image mushRoomJumpRight3;
	public static Image mushRoomJumpRight4;
	public static Image mushRoomJumpRight5;
	public static Image mushRoomJumpRight6;
	public static Image mushRoomJumpRight7;
	public static Image mushRoomJumpRight8;
	
	
	//Tomato Image
	public static Image tomatoIdle0;
	public static Image tomatoIdle1;
	public static Image tomatoIdle2;
	public static Image tomatoIdle3;
	public static Image tomatoIdle4;
	public static Image tomatoIdle5;
	
	public static Image tomatoHit0;
	public static Image tomatoHit1;
	public static Image tomatoHit2;
	public static Image tomatoHit3;
	public static Image tomatoHit4;
	public static Image tomatoHit5;
	
	//Pineapple Image
	public static Image pineappleIdle0;
	public static Image pineappleIdle1;
	public static Image pineappleIdle2;

	public static Image pineappleAttack0;
	public static Image pineappleAttack1;
	public static Image pineappleAttack2;
	public static Image pineappleAttack3;
	
	public static Image pineappleHit0;
	public static Image pineappleHit1;
	public static Image pineappleHit2;
	public static Image pineappleHit3;
	public static Image pineappleAmmo;

	//Environment Image
	public static Image gameBackground;
	public static Image bush;
	public static Image palm;
	public static Image pine;
	public static Image plantHouse;
	public static Image strawHouse;
	public static Image rock1;
	public static Image rock2;
	public static Image tree1;
	public static Image tree2;
	public static Image treeHouse;
	public static Image woodenHouse;
	public static Image plant;
	public static Image bigCrate;
	public static Image fence;
	public static Image hpBar;
	public static Image woodenBoard;
	public static Image quit;
	public static Image resume;
	
	//Sounds
	public static AudioClip battleMusic;
	public static AudioClip mainMusic;
	public static AudioClip mushRoomAttack;
	public static AudioClip mushRoomDeath;
	public static AudioClip mushRoomJump;
	public static AudioClip start;
	public static AudioClip mouseEnter;
	public static AudioClip mushRoomWalk;
	public static AnimationTimer battleMusicTimer;
	public static AnimationTimer mainMusicTimer;
	
	//GUI
	public static String myFont;
	public static Image mainBackground;
	public static Image nameLogo;
	public static Image mushroomIdleGIF;
	public static Image startButton;
	public static Image mushroomWalkGIF;
	public static Image helpButton;
	public static Image quitButton;
	public static Image helpPane;
	public static Image xButton;
	public static Image mushroomAttackGIF;
	public static Image soundOn;
	public static Image soundOff;
	public static Image icon;
	public static Image gameover;
	public static Image yes;
	public static Image no;
	
	static {
		loadResource();
	}

	public static void loadResource() {
		String img = "image/";
		String sd = "sounds/";
		// Mushroom Image
		
		//Idle
		mushRoomIdleLeft0 = new Image(ClassLoader.getSystemResource(img + "MushroomIdleLeft0.png").toString());
		mushRoomIdleLeft1 = new Image(ClassLoader.getSystemResource(img + "MushroomIdleLeft1.png").toString());
		mushRoomIdleLeft2 = new Image(ClassLoader.getSystemResource(img + "MushroomIdleLeft2.png").toString());
		mushRoomIdleLeft3 = new Image(ClassLoader.getSystemResource(img + "MushroomIdleLeft3.png").toString());
		mushRoomIdleLeft4 = new Image(ClassLoader.getSystemResource(img + "MushroomIdleLeft4.png").toString());
		mushRoomIdleLeft5 = new Image(ClassLoader.getSystemResource(img + "MushroomIdleLeft5.png").toString());
		mushRoomIdleLeft6 = new Image(ClassLoader.getSystemResource(img + "MushroomIdleLeft6.png").toString());
		mushRoomIdleLeft7 = new Image(ClassLoader.getSystemResource(img + "MushroomIdleLeft7.png").toString());
		
		mushRoomIdleRight0 = new Image(ClassLoader.getSystemResource(img + "MushroomIdleRight0.png").toString());
		mushRoomIdleRight1 = new Image(ClassLoader.getSystemResource(img + "MushroomIdleRight1.png").toString());
		mushRoomIdleRight2 = new Image(ClassLoader.getSystemResource(img + "MushroomIdleRight2.png").toString());
		mushRoomIdleRight3 = new Image(ClassLoader.getSystemResource(img + "MushroomIdleRight3.png").toString());
		mushRoomIdleRight4 = new Image(ClassLoader.getSystemResource(img + "MushroomIdleRight4.png").toString());
		mushRoomIdleRight5 = new Image(ClassLoader.getSystemResource(img + "MushroomIdleRight5.png").toString());
		mushRoomIdleRight6 = new Image(ClassLoader.getSystemResource(img + "MushroomIdleRight6.png").toString());
		mushRoomIdleRight7 = new Image(ClassLoader.getSystemResource(img + "MushroomIdleRight7.png").toString());
		
		//Attack
		mushRoomAttackLeft0 = new Image(ClassLoader.getSystemResource(img + "MushroomAttackLeft0.png").toString());
		mushRoomAttackLeft1 = new Image(ClassLoader.getSystemResource(img + "MushroomAttackLeft1.png").toString());
		mushRoomAttackLeft2 = new Image(ClassLoader.getSystemResource(img + "MushroomAttackLeft2.png").toString());
		mushRoomAttackLeft3 = new Image(ClassLoader.getSystemResource(img + "MushroomAttackLeft3.png").toString());
		mushRoomAttackLeft4 = new Image(ClassLoader.getSystemResource(img + "MushroomAttackLeft4.png").toString());
		mushRoomAttackLeft5 = new Image(ClassLoader.getSystemResource(img + "MushroomAttackLeft5.png").toString());
		mushRoomAttackLeft6 = new Image(ClassLoader.getSystemResource(img + "MushroomAttackLeft6.png").toString());
		mushRoomAttackLeft7 = new Image(ClassLoader.getSystemResource(img + "MushroomAttackLeft7.png").toString());
		
		mushRoomAttackRight0 = new Image(ClassLoader.getSystemResource(img + "MushroomAttackRight0.png").toString());
		mushRoomAttackRight1 = new Image(ClassLoader.getSystemResource(img + "MushroomAttackRight1.png").toString());
		mushRoomAttackRight2 = new Image(ClassLoader.getSystemResource(img + "MushroomAttackRight2.png").toString());
		mushRoomAttackRight3 = new Image(ClassLoader.getSystemResource(img + "MushroomAttackRight3.png").toString());
		mushRoomAttackRight4 = new Image(ClassLoader.getSystemResource(img + "MushroomAttackRight4.png").toString());
		mushRoomAttackRight5 = new Image(ClassLoader.getSystemResource(img + "MushroomAttackRight5.png").toString());
		mushRoomAttackRight6 = new Image(ClassLoader.getSystemResource(img + "MushroomAttackRight6.png").toString());
		mushRoomAttackRight7 = new Image(ClassLoader.getSystemResource(img + "MushroomAttackRight7.png").toString());
		
		//Jump
		mushRoomJumpLeft0 = new Image(ClassLoader.getSystemResource(img + "MushroomJumpLeft2.png").toString());
		mushRoomJumpLeft1 = new Image(ClassLoader.getSystemResource(img + "MushroomJumpLeft2.png").toString());
		mushRoomJumpLeft2 = new Image(ClassLoader.getSystemResource(img + "MushroomJumpLeft2.png").toString());
		mushRoomJumpLeft3 = new Image(ClassLoader.getSystemResource(img + "MushroomJumpLeft3.png").toString());
		mushRoomJumpLeft4 = new Image(ClassLoader.getSystemResource(img + "MushroomJumpLeft4.png").toString());
		mushRoomJumpLeft5 = new Image(ClassLoader.getSystemResource(img + "MushroomJumpLeft5.png").toString());
		mushRoomJumpLeft6 = new Image(ClassLoader.getSystemResource(img + "MushroomJumpLeft6.png").toString());
		mushRoomJumpLeft7 = new Image(ClassLoader.getSystemResource(img + "MushroomJumpLeft7.png").toString());
		
		mushRoomJumpRight0 = new Image(ClassLoader.getSystemResource(img + "MushroomJumpRight2.png").toString());
		mushRoomJumpRight1 = new Image(ClassLoader.getSystemResource(img + "MushroomJumpRight2.png").toString());
		mushRoomJumpRight2 = new Image(ClassLoader.getSystemResource(img + "MushroomJumpRight2.png").toString());
		mushRoomJumpRight3 = new Image(ClassLoader.getSystemResource(img + "MushroomJumpRight3.png").toString());
		mushRoomJumpRight4 = new Image(ClassLoader.getSystemResource(img + "MushroomJumpRight4.png").toString());
		mushRoomJumpRight5 = new Image(ClassLoader.getSystemResource(img + "MushroomJumpRight5.png").toString());
		mushRoomJumpRight6 = new Image(ClassLoader.getSystemResource(img + "MushroomJumpRight6.png").toString());
		mushRoomJumpRight7 = new Image(ClassLoader.getSystemResource(img + "MushroomJumpRight7.png").toString());
		
		//Walk
		mushRoomWalkLeft0 = new Image(ClassLoader.getSystemResource(img + "MushroomWalkLeft0.png").toString());
		mushRoomWalkLeft1 = new Image(ClassLoader.getSystemResource(img + "MushroomWalkLeft1.png").toString());
		mushRoomWalkLeft2 = new Image(ClassLoader.getSystemResource(img + "MushroomWalkLeft2.png").toString());
		mushRoomWalkLeft3 = new Image(ClassLoader.getSystemResource(img + "MushroomWalkLeft3.png").toString());
		mushRoomWalkLeft4 = new Image(ClassLoader.getSystemResource(img + "MushroomWalkLeft4.png").toString());
		mushRoomWalkLeft5 = new Image(ClassLoader.getSystemResource(img + "MushroomWalkLeft5.png").toString());
		mushRoomWalkLeft6 = new Image(ClassLoader.getSystemResource(img + "MushroomWalkLeft6.png").toString());
		mushRoomWalkLeft7 = new Image(ClassLoader.getSystemResource(img + "MushroomWalkLeft2.png").toString());
		
		mushRoomWalkRight0 = new Image(ClassLoader.getSystemResource(img + "MushroomWalkRight0.png").toString());
		mushRoomWalkRight1 = new Image(ClassLoader.getSystemResource(img + "MushroomWalkRight1.png").toString());
		mushRoomWalkRight2 = new Image(ClassLoader.getSystemResource(img + "MushroomWalkRight2.png").toString());
		mushRoomWalkRight3 = new Image(ClassLoader.getSystemResource(img + "MushroomWalkRight3.png").toString());
		mushRoomWalkRight4 = new Image(ClassLoader.getSystemResource(img + "MushroomWalkRight4.png").toString());
		mushRoomWalkRight5 = new Image(ClassLoader.getSystemResource(img + "MushroomWalkRight5.png").toString());
		mushRoomWalkRight6 = new Image(ClassLoader.getSystemResource(img + "MushroomWalkRight6.png").toString());
		mushRoomWalkRight7 = new Image(ClassLoader.getSystemResource(img + "MushroomWalkRight2.png").toString());
		
		
		//Tomato Image
		
		//Idle,Attack,Walk
		tomatoIdle0 = new Image(ClassLoader.getSystemResource(img + "TomatoIdle0.png").toString());
		tomatoIdle1 = new Image(ClassLoader.getSystemResource(img + "TomatoIdle1.png").toString());
		tomatoIdle2 = new Image(ClassLoader.getSystemResource(img + "TomatoIdle2.png").toString());
		tomatoIdle3 = new Image(ClassLoader.getSystemResource(img + "TomatoIdle3.png").toString());
		tomatoIdle4 = new Image(ClassLoader.getSystemResource(img + "TomatoIdle4.png").toString());
		tomatoIdle5 = new Image(ClassLoader.getSystemResource(img + "TomatoIdle5.png").toString());
		
		//Hit
		tomatoHit0 = new Image(ClassLoader.getSystemResource(img + "TomatoHit0.png").toString());
		tomatoHit1 = new Image(ClassLoader.getSystemResource(img + "TomatoHit1.png").toString());
		tomatoHit2 = new Image(ClassLoader.getSystemResource(img + "TomatoHit2.png").toString());
		tomatoHit3 = new Image(ClassLoader.getSystemResource(img + "TomatoHit3.png").toString());
		tomatoHit4 = new Image(ClassLoader.getSystemResource(img + "TomatoHit4.png").toString());
		tomatoHit5 = new Image(ClassLoader.getSystemResource(img + "TomatoHit5.png").toString());
		
		
		//Pineapple Image
		
		//Idle & Walk
		pineappleIdle0 = new Image(ClassLoader.getSystemResource(img + "PineappleIdle0.png").toString());
		pineappleIdle1 = new Image(ClassLoader.getSystemResource(img + "PineappleIdle1.png").toString());
		pineappleIdle2 = new Image(ClassLoader.getSystemResource(img + "PineappleIdle2.png").toString());
		
		//Attack
		pineappleAttack0 = new Image(ClassLoader.getSystemResource(img + "PineappleAttack0.png").toString());
		pineappleAttack1 = new Image(ClassLoader.getSystemResource(img + "PineappleAttack1.png").toString());
		pineappleAttack2 = new Image(ClassLoader.getSystemResource(img + "PineappleAttack2.png").toString());
		pineappleAttack3 = new Image(ClassLoader.getSystemResource(img + "PineappleAttack3.png").toString());
		
		//Hit
		pineappleHit0 = new Image(ClassLoader.getSystemResource(img + "PineappleHit0.png").toString());
		pineappleHit1 = new Image(ClassLoader.getSystemResource(img + "PineappleHit1.png").toString());
		pineappleHit2 = new Image(ClassLoader.getSystemResource(img + "PineappleHit2.png").toString());
		pineappleHit3 = new Image(ClassLoader.getSystemResource(img + "PineappleHit3.png").toString());
		
		//Ball
		pineappleAmmo = new Image(ClassLoader.getSystemResource(img + "PineappleAmmo.png").toString());
		
		//Environment
		gameBackground = new Image(ClassLoader.getSystemResource(img + "back-export.png").toString());
		bush = new Image(ClassLoader.getSystemResource(img + "Bush.png").toString());
		palm = new Image(ClassLoader.getSystemResource(img + "palm.png").toString());
		plantHouse = new Image(ClassLoader.getSystemResource(img + "plant-house.png").toString());
		strawHouse = new Image(ClassLoader.getSystemResource(img + "straw-house.png").toString());
		rock1 = new Image(ClassLoader.getSystemResource(img + "rock-1.png").toString());
		rock2 = new Image(ClassLoader.getSystemResource(img + "rock-2.png").toString());
		tree1 = new Image(ClassLoader.getSystemResource(img + "tree.png").toString());
		tree2 = new Image(ClassLoader.getSystemResource(img + "tree2.png").toString());
		treeHouse = new Image(ClassLoader.getSystemResource(img + "tree-house.png").toString());
		woodenHouse = new Image(ClassLoader.getSystemResource(img + "wooden-house.png").toString());
		pine = new Image(ClassLoader.getSystemResource(img + "pine.png").toString());
		plant = new Image(ClassLoader.getSystemResource(img + "plant1.png").toString());
		bigCrate = new Image(ClassLoader.getSystemResource(img + "big-crate.png").toString());
		fence = new Image(ClassLoader.getSystemResource(img + "fence.png").toString());
		hpBar = new Image(ClassLoader.getSystemResource(img + "HealthBar.png").toString());
		
		//Sounds
		mainMusic = new AudioClip(ClassLoader.getSystemResource(sd+"MainMusic.mp3").toString());
		mushRoomJump = new AudioClip(ClassLoader.getSystemResource(sd+"PlayerJump.mp3").toString());
		mushRoomAttack = new AudioClip(ClassLoader.getSystemResource(sd+"PlayerAttack.mp3").toString());
		mushRoomDeath = new AudioClip(ClassLoader.getSystemResource(sd+"PlayerDeath.mp3").toString());
		start = new AudioClip(ClassLoader.getSystemResource(sd+"StartGame.mp3").toString());
		mouseEnter = new AudioClip(ClassLoader.getSystemResource(sd+"MouseEnter.mp3").toString());
		mushRoomWalk =  new AudioClip(ClassLoader.getSystemResource(sd+"PlayerWalk.mp3").toString());
		battleMusic = new AudioClip(ClassLoader.getSystemResource(sd+"BattleMusic.mp3").toString());
		battleMusicTimer = new AnimationTimer() {
			
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				if(!RenderableHolder.battleMusic.isPlaying()) 
					RenderableHolder.battleMusic.play();
			}
		};
		mainMusicTimer = new AnimationTimer() {
	
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				if(!RenderableHolder.mainMusic.isPlaying()) 
					RenderableHolder.mainMusic.play();
			}
		};
		
		//GUI
		woodenBoard = new Image(ClassLoader.getSystemResource(img + "WoodenBoard.png").toString());
		quit = new Image(ClassLoader.getSystemResource(img + "QuitButton.png").toString());
		resume = new Image(ClassLoader.getSystemResource(img + "ResumeButton.png").toString());
		mainBackground = new Image(ClassLoader.getSystemResource(img + "BackGround.png").toString());
		nameLogo = new Image(ClassLoader.getSystemResource(img + "NameLogo.png").toString());
		mushroomIdleGIF = new Image(ClassLoader.getSystemResource(img + "MushroomIdle.gif").toString());
		startButton = new Image(ClassLoader.getSystemResource(img + "StartButton.png").toString());
		mushroomWalkGIF = new Image(ClassLoader.getSystemResource(img + "MushroomWalking.gif").toString());
		helpButton = new Image(ClassLoader.getSystemResource(img + "HelpButton.png").toString());
		quitButton = new Image(ClassLoader.getSystemResource(img + "QuitButton.png").toString());
		helpPane = new Image(ClassLoader.getSystemResource(img + "HelpPane.png").toString());
		xButton = new Image(ClassLoader.getSystemResource(img + "xButton.png").toString());
		mushroomAttackGIF = new Image(ClassLoader.getSystemResource(img + "MushroomAttack.gif").toString());
		soundOn = new Image(ClassLoader.getSystemResource(img + "SoundOn.png").toString());
		soundOff = new Image(ClassLoader.getSystemResource(img + "SoundOff.png").toString());
		icon = new Image(ClassLoader.getSystemResource(img + "Mushroom.png").toString());
		gameover= new Image(ClassLoader.getSystemResource(img + "GameOver.png").toString());
		yes = new Image(ClassLoader.getSystemResource(img + "YES.png").toString());
		no = new Image(ClassLoader.getSystemResource(img + "No.png").toString());
		
		//Font
		myFont = ClassLoader.getSystemResource("font/font.ttf").toString();
	}

}