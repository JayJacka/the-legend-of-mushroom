package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();

	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;

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
	public static Image TomatoIdle0;
	public static Image TomatoIdle1;
	public static Image TomatoIdle2;
	public static Image TomatoIdle3;
	public static Image TomatoIdle4;
	public static Image TomatoIdle5;
	
	public static Image TomatoHit0;
	public static Image TomatoHit1;
	public static Image TomatoHit2;
	public static Image TomatoHit3;
	public static Image TomatoHit4;
	public static Image TomatoHit5;
	
	//Pineapple Image
	public static Image PineappleIdle0;
	public static Image PineappleIdle1;
	public static Image PineappleIdle2;
	
	public static Image PineappleAttack0;
	public static Image PineappleAttack1;
	public static Image PineappleAttack2;
	public static Image PineappleAttack3;
	
	public static Image PineappleHit0;
	public static Image PineappleHit1;
	public static Image PineappleHit2;
	public static Image PineappleHit3;
	public static Image PineappleAmmo;

	//Environment Image
	public static Image GameBackground;
	public static Image Bush;
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
	public static Image WoodenBoard;
	public static Image Quit;
	public static Image Resume;
	
	//Sounds
	public static AudioClip BattleMusic;
	public static AudioClip MainMusic;
	public static AudioClip mushRoomAttack;
	public static AudioClip mushRoomDeath;
	public static AudioClip mushRoomJump;
	public static AudioClip Start;
	public static AudioClip MouseEnter;
	public static AudioClip mushRoomWalk;
	
	//GUI
	public static String myFont;
	public static Image MainBackground;
	public static Image NameLogo;
	public static Image MushroomIdleGIF;
	public static Image StartButton;
	public static Image MushroomWalkGIF;
	public static Image HelpButton;
	public static Image QuitButton;
	public static Image HelpPane;
	public static Image xButton;
	public static Image MushroomAttackGIF;
	public static Image SoundOn;
	public static Image SoundOff;
	public static Image icon;
	public static Image Gameover;
	public static Image Yes;
	public static Image No;
	
	static {
		loadResource();
	}

	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}

	public static RenderableHolder getInstance() {
		return instance;
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
		TomatoIdle0 = new Image(ClassLoader.getSystemResource(img + "TomatoIdle0.png").toString());
		TomatoIdle1 = new Image(ClassLoader.getSystemResource(img + "TomatoIdle1.png").toString());
		TomatoIdle2 = new Image(ClassLoader.getSystemResource(img + "TomatoIdle2.png").toString());
		TomatoIdle3 = new Image(ClassLoader.getSystemResource(img + "TomatoIdle3.png").toString());
		TomatoIdle4 = new Image(ClassLoader.getSystemResource(img + "TomatoIdle4.png").toString());
		TomatoIdle5 = new Image(ClassLoader.getSystemResource(img + "TomatoIdle5.png").toString());
		
		//Hit
		TomatoHit0 = new Image(ClassLoader.getSystemResource(img + "TomatoHit0.png").toString());
		TomatoHit1 = new Image(ClassLoader.getSystemResource(img + "TomatoHit1.png").toString());
		TomatoHit2 = new Image(ClassLoader.getSystemResource(img + "TomatoHit2.png").toString());
		TomatoHit3 = new Image(ClassLoader.getSystemResource(img + "TomatoHit3.png").toString());
		TomatoHit4 = new Image(ClassLoader.getSystemResource(img + "TomatoHit4.png").toString());
		TomatoHit5 = new Image(ClassLoader.getSystemResource(img + "TomatoHit5.png").toString());
		
		
		//Pineapple Image
		
		//Idle & Walk
		PineappleIdle0 = new Image(ClassLoader.getSystemResource(img + "PineappleIdle0.png").toString());
		PineappleIdle1 = new Image(ClassLoader.getSystemResource(img + "PineappleIdle1.png").toString());
		PineappleIdle2 = new Image(ClassLoader.getSystemResource(img + "PineappleIdle2.png").toString());
		
		//Attack
		PineappleAttack0 = new Image(ClassLoader.getSystemResource(img + "PineappleAttack0.png").toString());
		PineappleAttack1 = new Image(ClassLoader.getSystemResource(img + "PineappleAttack1.png").toString());
		PineappleAttack2 = new Image(ClassLoader.getSystemResource(img + "PineappleAttack2.png").toString());
		PineappleAttack3 = new Image(ClassLoader.getSystemResource(img + "PineappleAttack3.png").toString());
		
		//Hit
		PineappleHit0 = new Image(ClassLoader.getSystemResource(img + "PineappleHit0.png").toString());
		PineappleHit1 = new Image(ClassLoader.getSystemResource(img + "PineappleHit1.png").toString());
		PineappleHit2 = new Image(ClassLoader.getSystemResource(img + "PineappleHit2.png").toString());
		PineappleHit3 = new Image(ClassLoader.getSystemResource(img + "PineappleHit3.png").toString());
		
		//Ball
		PineappleAmmo = new Image(ClassLoader.getSystemResource(img + "PineappleAmmo.png").toString());
		
		//Environment
		GameBackground = new Image(ClassLoader.getSystemResource(img + "back-export.png").toString());
		Bush = new Image(ClassLoader.getSystemResource(img + "Bush.png").toString());
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
		MainMusic = new AudioClip(ClassLoader.getSystemResource(sd+"MainMusic.mp3").toString());
		mushRoomJump = new AudioClip(ClassLoader.getSystemResource(sd+"PlayerJump.mp3").toString());
		mushRoomAttack = new AudioClip(ClassLoader.getSystemResource(sd+"PlayerAttack.mp3").toString());
		mushRoomDeath = new AudioClip(ClassLoader.getSystemResource(sd+"PlayerDeath.mp3").toString());
		Start = new AudioClip(ClassLoader.getSystemResource(sd+"StartGame.mp3").toString());
		MouseEnter = new AudioClip(ClassLoader.getSystemResource(sd+"MouseEnter.mp3").toString());
		mushRoomWalk =  new AudioClip(ClassLoader.getSystemResource(sd+"PlayerWalk.mp3").toString());
		BattleMusic = new AudioClip(ClassLoader.getSystemResource(sd+"BattleMusic.mp3").toString());
		
		//GUI
		WoodenBoard = new Image(ClassLoader.getSystemResource(img + "WoodenBoard.png").toString());
		Quit = new Image(ClassLoader.getSystemResource(img + "QuitButton.png").toString());
		Resume = new Image(ClassLoader.getSystemResource(img + "ResumeButton.png").toString());
		MainBackground = new Image(ClassLoader.getSystemResource(img + "BackGround.png").toString());
		NameLogo = new Image(ClassLoader.getSystemResource(img + "NameLogo.png").toString());
		MushroomIdleGIF = new Image(ClassLoader.getSystemResource(img + "MushroomIdle.gif").toString());
		StartButton = new Image(ClassLoader.getSystemResource(img + "StartButton.png").toString());
		MushroomWalkGIF = new Image(ClassLoader.getSystemResource(img + "MushroomWalking.gif").toString());
		HelpButton = new Image(ClassLoader.getSystemResource(img + "HelpButton.png").toString());
		QuitButton = new Image(ClassLoader.getSystemResource(img + "QuitButton.png").toString());
		HelpPane = new Image(ClassLoader.getSystemResource(img + "HelpPane.png").toString());
		xButton = new Image(ClassLoader.getSystemResource(img + "xButton.png").toString());
		MushroomAttackGIF = new Image(ClassLoader.getSystemResource(img + "MushroomAttack.gif").toString());
		SoundOn = new Image(ClassLoader.getSystemResource(img + "SoundOn.png").toString());
		SoundOff = new Image(ClassLoader.getSystemResource(img + "SoundOff.png").toString());
		icon = new Image(ClassLoader.getSystemResource(img + "Mushroom.png").toString());
		Gameover= new Image(ClassLoader.getSystemResource(img + "GameOver.png").toString());
		Yes = new Image(ClassLoader.getSystemResource(img + "YES.png").toString());
		No = new Image(ClassLoader.getSystemResource(img + "No.png").toString());
		//Font
		//InputStream fontStream = CustomFontTest.class.getResourceAsStream("font/8-BIT WONDER.ttf");
		myFont = ClassLoader.getSystemResource("font/font.ttf").toString();
	}
	
	public void add(IRenderable entity) {
		entities.add(entity);
		Collections.sort(entities, comparator);
	}

	public void update() {
		for (int i = entities.size() - 1; i >= 0; i--) {
			if (entities.get(i).isRemoved())
				entities.remove(i);
		}
	}

	public List<IRenderable> getEntities() {
		return entities;
	}
}