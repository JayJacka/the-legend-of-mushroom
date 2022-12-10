package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javafx.scene.image.Image;

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
		//mushRoomIdle8 = new Image(ClassLoader.getSystemResource(img + "MushroomIdle8.png").toString());
		//mushRoomIdle9 = new Image(ClassLoader.getSystemResource(img + "MushroomIdle9.png").toString());
		
		//Attack
		mushRoomAttack0 = new Image(ClassLoader.getSystemResource(img + "MushroomAttack0.png").toString());
		mushRoomAttack1 = new Image(ClassLoader.getSystemResource(img + "MushroomAttack1.png").toString());
		mushRoomAttack2 = new Image(ClassLoader.getSystemResource(img + "MushroomAttack2.png").toString());
		mushRoomAttack3 = new Image(ClassLoader.getSystemResource(img + "MushroomAttack3.png").toString());
		mushRoomAttack4 = new Image(ClassLoader.getSystemResource(img + "MushroomAttack4.png").toString());
		mushRoomAttack5 = new Image(ClassLoader.getSystemResource(img + "MushroomAttack5.png").toString());
		mushRoomAttack6 = new Image(ClassLoader.getSystemResource(img + "MushroomAttack6.png").toString());
		mushRoomAttack7 = new Image(ClassLoader.getSystemResource(img + "MushroomAttack7.png").toString());
		//mushRoomAttack8 = new Image(ClassLoader.getSystemResource(img + "MushroomAttack7.png").toString());
		//mushRoomAttack9 = new Image(ClassLoader.getSystemResource(img + "MushroomAttack7.png").toString());
		
		//Jump
		mushRoomJump0 = new Image(ClassLoader.getSystemResource(img + "MushroomJump0.png").toString());
		mushRoomJump1 = new Image(ClassLoader.getSystemResource(img + "MushroomJump1.png").toString());
		mushRoomJump2 = new Image(ClassLoader.getSystemResource(img + "MushroomJump2.png").toString());
		mushRoomJump3 = new Image(ClassLoader.getSystemResource(img + "MushroomJump3.png").toString());
		mushRoomJump4 = new Image(ClassLoader.getSystemResource(img + "MushroomJump4.png").toString());
		mushRoomJump5 = new Image(ClassLoader.getSystemResource(img + "MushroomJump5.png").toString());
		mushRoomJump6 = new Image(ClassLoader.getSystemResource(img + "MushroomJump6.png").toString());
		mushRoomJump7 = new Image(ClassLoader.getSystemResource(img + "MushroomJump7.png").toString());
		//mushRoomJump8 = new Image(ClassLoader.getSystemResource(img + "MushroomJump8.png").toString());
		
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
		//Idle
		TomatoIdle0 = new Image(ClassLoader.getSystemResource(img + "TomatoIdle0.png").toString());
		TomatoIdle1 = new Image(ClassLoader.getSystemResource(img + "TomatoIdle1.png").toString());
		TomatoIdle2 = new Image(ClassLoader.getSystemResource(img + "TomatoIdle2.png").toString());
		TomatoIdle3 = new Image(ClassLoader.getSystemResource(img + "TomatoIdle3.png").toString());
		TomatoIdle4 = new Image(ClassLoader.getSystemResource(img + "TomatoIdle4.png").toString());
		TomatoIdle5 = new Image(ClassLoader.getSystemResource(img + "TomatoIdle5.png").toString());
		
		TomatoHit0 = new Image(ClassLoader.getSystemResource(img + "TomatoHit0.png").toString());
		TomatoHit1 = new Image(ClassLoader.getSystemResource(img + "TomatoHit1.png").toString());
		TomatoHit2 = new Image(ClassLoader.getSystemResource(img + "TomatoHit2.png").toString());
		TomatoHit3 = new Image(ClassLoader.getSystemResource(img + "TomatoHit3.png").toString());
		TomatoHit4 = new Image(ClassLoader.getSystemResource(img + "TomatoHit4.png").toString());
		TomatoHit5 = new Image(ClassLoader.getSystemResource(img + "TomatoHit5.png").toString());
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