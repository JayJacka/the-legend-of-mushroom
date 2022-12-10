package utils;

import java.util.ArrayList;

import javafx.scene.image.Image;
import sharedObject.RenderableHolder;

public class Animations {
	public static ArrayList<Image> getMushroomIdle() {
		ArrayList x = new ArrayList<Image>();
		x.add(RenderableHolder.mushRoomIdle0);x.add(RenderableHolder.mushRoomIdle1);
		x.add(RenderableHolder.mushRoomIdle2);x.add(RenderableHolder.mushRoomIdle3);
		x.add(RenderableHolder.mushRoomIdle4);x.add(RenderableHolder.mushRoomIdle5);
		x.add(RenderableHolder.mushRoomIdle6);x.add(RenderableHolder.mushRoomIdle7);
		//x.add(RenderableHolder.mushRoomIdle8);x.add(RenderableHolder.mushRoomIdle9);
		return x;
	}
	
	public static ArrayList<Image> getMushroomAttack(){
		ArrayList x = new ArrayList<Image>();
		x.add(RenderableHolder.mushRoomAttack0);x.add(RenderableHolder.mushRoomAttack1);
		x.add(RenderableHolder.mushRoomAttack2);x.add(RenderableHolder.mushRoomAttack3);
		x.add(RenderableHolder.mushRoomAttack4);x.add(RenderableHolder.mushRoomAttack5);
		x.add(RenderableHolder.mushRoomAttack6);x.add(RenderableHolder.mushRoomAttack7);
		return x;
	}
	
	public static ArrayList<Image> getMushroomJump(){
		ArrayList x = new ArrayList<Image>();
		x.add(RenderableHolder.mushRoomJump0);x.add(RenderableHolder.mushRoomJump1);
		x.add(RenderableHolder.mushRoomJump2);x.add(RenderableHolder.mushRoomJump3);
		x.add(RenderableHolder.mushRoomJump4);x.add(RenderableHolder.mushRoomJump5);
		x.add(RenderableHolder.mushRoomJump6);x.add(RenderableHolder.mushRoomJump7);
		//x.add(RenderableHolder.mushRoomJump8);
		return x;
	}
	
	public static ArrayList<Image> getMushroomWalk(){
		ArrayList x = new ArrayList<Image>();
		x.add(RenderableHolder.mushRoomWalk0);x.add(RenderableHolder.mushRoomWalk1);
		x.add(RenderableHolder.mushRoomWalk2);x.add(RenderableHolder.mushRoomWalk3);
		x.add(RenderableHolder.mushRoomWalk4);x.add(RenderableHolder.mushRoomWalk5);
		x.add(RenderableHolder.mushRoomWalk6);x.add(RenderableHolder.mushRoomWalk7);
		//x.add(RenderableHolder.mushRoomWalk8);x.add(RenderableHolder.mushRoomWalk9);
		return x;
	}
}
