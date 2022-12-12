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
	public static Image mushRoomIdle0;
	public static Image mushRoomIdle1;
	public static Image mushRoomIdle2;
	public static Image mushRoomIdle3;
	public static Image mushRoomIdle4;
	public static Image mushRoomIdle5;
	public static Image mushRoomIdle6;
	public static Image mushRoomIdle7;
	public static Image mushRoomIdle8;
	public static Image mushRoomIdle9;
	
	public static Image mushRoomAttack0;
	public static Image mushRoomAttack1;
	public static Image mushRoomAttack2;
	public static Image mushRoomAttack3;
	public static Image mushRoomAttack4;
	public static Image mushRoomAttack5;
	public static Image mushRoomAttack6;
	public static Image mushRoomAttack7;
	
	public static Image mushRoomWalk0;
	public static Image mushRoomWalk1;
	public static Image mushRoomWalk2;
	public static Image mushRoomWalk3;
	public static Image mushRoomWalk4;
	public static Image mushRoomWalk5;
	public static Image mushRoomWalk6;
	public static Image mushRoomWalk7;
	public static Image mushRoomWalk8;
	public static Image mushRoomWalk9;
	
	public static Image mushRoomJump0;
	public static Image mushRoomJump1;
	public static Image mushRoomJump2;
	public static Image mushRoomJump3;
	public static Image mushRoomJump4;
	public static Image mushRoomJump5;
	public static Image mushRoomJump6;
	public static Image mushRoomJump7;
	public static Image mushRoomJump8;
	
	
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
	
	public static AudioClip BackgroundMusic;
	public static AudioClip mushRoomAttack;
	public static AudioClip mushRoomDeath;
	public static AudioClip mushRoomJump;
	public static AudioClip Start;
	public static AudioClip MouseEnter;
	public static AudioClip mushRoomWalk;
	
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
		mushRoomIdle0 = new Image(ClassLoader.getSystemResource(img + "MushroomIdle0.png").toString());
		mushRoomIdle1 = new Image(ClassLoader.getSystemResource(img + "MushroomIdle1.png").toString());
		mushRoomIdle2 = new Image(ClassLoader.getSystemResource(img + "MushroomIdle2.png").toString());
		mushRoomIdle3 = new Image(ClassLoader.getSystemResource(img + "MushroomIdle3.png").toString());
		mushRoomIdle4 = new Image(ClassLoader.getSystemResource(img + "MushroomIdle4.png").toString());
		mushRoomIdle5 = new Image(ClassLoader.getSystemResource(img + "MushroomIdle5.png").toString());
		mushRoomIdle6 = new Image(ClassLoader.getSystemResource(img + "MushroomIdle6.png").toString());
		mushRoomIdle7 = new Image(ClassLoader.getSystemResource(img + "MushroomIdle7.png").toString());
		
		//Attack
		mushRoomAttack0 = new Image(ClassLoader.getSystemResource(img + "MushroomAttack0.png").toString());
		mushRoomAttack1 = new Image(ClassLoader.getSystemResource(img + "MushroomAttack1.png").toString());
		mushRoomAttack2 = new Image(ClassLoader.getSystemResource(img + "MushroomAttack2.png").toString());
		mushRoomAttack3 = new Image(ClassLoader.getSystemResource(img + "MushroomAttack3.png").toString());
		mushRoomAttack4 = new Image(ClassLoader.getSystemResource(img + "MushroomAttack4.png").toString());
		mushRoomAttack5 = new Image(ClassLoader.getSystemResource(img + "MushroomAttack5.png").toString());
		mushRoomAttack6 = new Image(ClassLoader.getSystemResource(img + "MushroomAttack6.png").toString());
		mushRoomAttack7 = new Image(ClassLoader.getSystemResource(img + "MushroomAttack7.png").toString());
		
		//Jump
		mushRoomJump0 = new Image(ClassLoader.getSystemResource(img + "MushroomJump2.png").toString());
		mushRoomJump1 = new Image(ClassLoader.getSystemResource(img + "MushroomJump2.png").toString());
		mushRoomJump2 = new Image(ClassLoader.getSystemResource(img + "MushroomJump2.png").toString());
		mushRoomJump3 = new Image(ClassLoader.getSystemResource(img + "MushroomJump3.png").toString());
		mushRoomJump4 = new Image(ClassLoader.getSystemResource(img + "MushroomJump4.png").toString());
		mushRoomJump5 = new Image(ClassLoader.getSystemResource(img + "MushroomJump5.png").toString());
		mushRoomJump6 = new Image(ClassLoader.getSystemResource(img + "MushroomJump6.png").toString());
		mushRoomJump7 = new Image(ClassLoader.getSystemResource(img + "MushroomJump7.png").toString());
		
		//Walk
		mushRoomWalk0 = new Image(ClassLoader.getSystemResource(img + "MushroomWalk0.png").toString());
		mushRoomWalk1 = new Image(ClassLoader.getSystemResource(img + "MushroomWalk1.png").toString());
		mushRoomWalk2 = new Image(ClassLoader.getSystemResource(img + "MushroomWalk2.png").toString());
		mushRoomWalk3 = new Image(ClassLoader.getSystemResource(img + "MushroomWalk3.png").toString());
		mushRoomWalk4 = new Image(ClassLoader.getSystemResource(img + "MushroomWalk4.png").toString());
		mushRoomWalk5 = new Image(ClassLoader.getSystemResource(img + "MushroomWalk5.png").toString());
		mushRoomWalk6 = new Image(ClassLoader.getSystemResource(img + "MushroomWalk6.png").toString());
		mushRoomWalk7 = new Image(ClassLoader.getSystemResource(img + "MushroomWalk2.png").toString());
		
		
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
		
		
		//Environment
		GameBackground = new Image(ClassLoader.getSystemResource("back-export.png").toString());
		Bush = new Image(ClassLoader.getSystemResource("Bush.png").toString());
		palm = new Image(ClassLoader.getSystemResource("palm.png").toString());
		plantHouse = new Image(ClassLoader.getSystemResource("plant-house.png").toString());
		strawHouse = new Image(ClassLoader.getSystemResource("straw-house.png").toString());
		rock1 = new Image(ClassLoader.getSystemResource("rock-1.png").toString());
		rock2 = new Image(ClassLoader.getSystemResource("rock-2.png").toString());
		tree1 = new Image(ClassLoader.getSystemResource("tree.png").toString());
		tree2 = new Image(ClassLoader.getSystemResource("tree2.png").toString());
		treeHouse = new Image(ClassLoader.getSystemResource("tree-house.png").toString());
		woodenHouse = new Image(ClassLoader.getSystemResource("wooden-house.png").toString());
		pine = new Image(ClassLoader.getSystemResource("pine.png").toString());
		plant = new Image(ClassLoader.getSystemResource("plant1.png").toString());
		bigCrate = new Image(ClassLoader.getSystemResource("big-crate.png").toString());
		fence = new Image(ClassLoader.getSystemResource("fence.png").toString());
		hpBar = new Image(ClassLoader.getSystemResource("HealthBar.png").toString());
		
		//Sounds
		BackgroundMusic = new AudioClip(ClassLoader.getSystemResource(sd+"BackgroundMusic.mp3").toString());
		mushRoomJump = new AudioClip(ClassLoader.getSystemResource(sd+"PlayerJump.mp3").toString());
		mushRoomAttack = new AudioClip(ClassLoader.getSystemResource(sd+"PlayerAttack.mp3").toString());
		mushRoomDeath = new AudioClip(ClassLoader.getSystemResource(sd+"PlayerDeath.mp3").toString());
		Start = new AudioClip(ClassLoader.getSystemResource(sd+"StartGame.mp3").toString());
		MouseEnter = new AudioClip(ClassLoader.getSystemResource(sd+"MouseEnter.mp3").toString());
		mushRoomWalk =  new AudioClip(ClassLoader.getSystemResource(sd+"PlayerWalk.mp3").toString());
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