package levels;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sharedObject.RenderableHolder;

public class MapManager {
	public static void drawElementMap1(GraphicsContext gc) {
		drawElementMap1First(gc);
		drawElementMap1Second(gc);
		drawElementMap1Third(gc);
	}
	
	public static void drawElementMap1First(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.pine,-50,300,200,250);
		gc.drawImage(RenderableHolder.Bush,0,495,120,80);
		gc.drawImage(RenderableHolder.tree2,80,336,250,240);
		gc.drawImage(RenderableHolder.plantHouse,30,400,200,177);
		gc.drawImage(RenderableHolder.Bush,165,535,69,42);
		gc.drawImage(RenderableHolder.Bush,190,535,69,42);
		gc.drawImage(RenderableHolder.rock2,370,470);
		gc.drawImage(RenderableHolder.Bush,410,470,69,42);
		gc.drawImage(RenderableHolder.Bush,1200,500,120,80);
		gc.drawImage(RenderableHolder.Bush,1110,500,120,80);
	}
	
	public static void drawElementMap1Second(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.Bush,1110,500,120,80);
		gc.drawImage(RenderableHolder.Bush,1010,500,120,80);
		gc.drawImage(RenderableHolder.Bush,1200,560,120,80);
		gc.drawImage(RenderableHolder.Bush,1110,560,120,80);
		gc.drawImage(RenderableHolder.Bush,1010,560,120,80);
		gc.drawImage(RenderableHolder.treeHouse,1150,-30, 238,288);
		gc.drawImage(RenderableHolder.Bush,1120,215,69,42);
		gc.drawImage(RenderableHolder.tree2,0,-40,210,200);
		gc.drawImage(RenderableHolder.tree2,160,-40,210,200);
		gc.drawImage(RenderableHolder.tree2,80,-40,210,200);
		gc.drawImage(RenderableHolder.tree1,240,-40,210,200);
	}
	public static void drawElementMap1Third(GraphicsContext gc) {
		gc.drawImage(new Image(ClassLoader.getSystemResource("tree.png").toString()),-60,-40,210,200);
		gc.drawImage(RenderableHolder.Bush,0,100,100,60);
		gc.drawImage(RenderableHolder.Bush,50,100,100,60);
		gc.drawImage(RenderableHolder.Bush,100,100,100,60);
		gc.drawImage(RenderableHolder.Bush,150,100,100,60);
		gc.drawImage(RenderableHolder.Bush,200,100,100,60);
		gc.drawImage(RenderableHolder.Bush,250,100,100,60);
		gc.drawImage(RenderableHolder.Bush,300,100,100,60);
	}
	
	public static void drawElementMap2(GraphicsContext gc) {
		drawElementMap2First(gc);
		drawElementMap2Second(gc);
		drawElementMap2Third(gc);
	}

	private static void drawElementMap2Third(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}

	private static void drawElementMap2Second(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}

	private static void drawElementMap2First(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}
}
