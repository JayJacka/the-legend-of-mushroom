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
		gc.drawImage(RenderableHolder.tree2,800,410,210,200);
		gc.drawImage(RenderableHolder.tree2,530,440,210,200);
		gc.drawImage(RenderableHolder.tree2,940,384,210,200);
		gc.drawImage(RenderableHolder.strawHouse,400,-10,200,170);
		gc.drawImage(RenderableHolder.pine, 1000,0,150,230);
		gc.drawImage(RenderableHolder.pine, 1080,0,150,230);
		gc.drawImage(RenderableHolder.pine, 1160,0,150,230);
		gc.drawImage(RenderableHolder.pine, 1240,0,150,230);
		gc.drawImage(RenderableHolder.pine, 920,0,150,230);
		gc.drawImage(RenderableHolder.rock1, 600,590);
		gc.drawImage(RenderableHolder.rock2, 640,590);
		gc.drawImage(RenderableHolder.Bush,520,325,100,60);
		gc.drawImage(RenderableHolder.Bush,560,325,100,60);
		gc.drawImage(RenderableHolder.Bush,600,325,100,60);
		gc.drawImage(RenderableHolder.Bush,640,325,100,60);
		gc.drawImage(RenderableHolder.Bush,680,325,100,60);
		gc.drawImage(RenderableHolder.Bush,720,325,100,60);
	}

	private static void drawElementMap2Second(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.Bush,-20,500,120,80);
		gc.drawImage(RenderableHolder.Bush,55,500,120,80);
		gc.drawImage(RenderableHolder.Bush,130,500,120,80);
		gc.drawImage(RenderableHolder.Bush,-20,560,120,80);
		gc.drawImage(RenderableHolder.Bush,55,560,120,80);
		gc.drawImage(RenderableHolder.Bush,130,560,120,80);
		gc.drawImage(RenderableHolder.Bush,190,500,120,80);
		gc.drawImage(RenderableHolder.Bush,190,560,120,80);
		gc.drawImage(RenderableHolder.plant,300,130,30,30);
		gc.drawImage(RenderableHolder.bigCrate,350,97,64,64);
		gc.drawImage(RenderableHolder.bigCrate,400,113,48,48);
	}

	private static void drawElementMap2First(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.tree1,250,-30,210,200);
		gc.drawImage(RenderableHolder.tree2,600,-30,210,200);
		gc.drawImage(RenderableHolder.pine, 550,-60,150,230);
		gc.drawImage(RenderableHolder.fence,250,120,48,48);
		gc.drawImage(RenderableHolder.fence,283,120,48,48);
		gc.drawImage(RenderableHolder.fence,316,120,48,48);
		gc.drawImage(RenderableHolder.fence,349,120,48,48);
		gc.drawImage(RenderableHolder.fence,550,120,48,48);
		gc.drawImage(RenderableHolder.fence,583,120,48,48);
		gc.drawImage(RenderableHolder.fence,616,120,48,48);
		gc.drawImage(RenderableHolder.fence,649,120,48,48);
	}
	
	public static void drawElementMap3(GraphicsContext gc) {
		drawElementMap3First(gc);
		drawElementMap3Second(gc);
		drawElementMap3Third(gc);
		drawElementMap3Fourth(gc);
		drawElementMap3Fifth(gc);
	}
	
	public static void drawElementMap3First(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.Bush,640,452);
		gc.drawImage(RenderableHolder.Bush,660,452);
		gc.drawImage(RenderableHolder.Bush,680,452);
		gc.drawImage(RenderableHolder.Bush,700,452);
		gc.drawImage(RenderableHolder.Bush,720,452);
		gc.drawImage(RenderableHolder.Bush,740,452);
		gc.drawImage(RenderableHolder.Bush,760,452);
		gc.drawImage(RenderableHolder.Bush,780,452);
		gc.drawImage(RenderableHolder.Bush,800,452);
		gc.drawImage(RenderableHolder.fence,700,440,48,48);
		gc.drawImage(RenderableHolder.fence,733,440,48,48);
		gc.drawImage(RenderableHolder.fence,766,440,48,48);
		gc.drawImage(RenderableHolder.tree1,1000,60,210,200);
	}
	public static void drawElementMap3Second(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.Bush,200,355,100,60);
		gc.drawImage(RenderableHolder.rock1,200,365);
		gc.drawImage(RenderableHolder.bigCrate,1100,370,48,48);
		gc.drawImage(RenderableHolder.fence,700,440,48,48);
		gc.drawImage(RenderableHolder.fence,733,440,48,48);
		gc.drawImage(RenderableHolder.fence,766,440,48,48);
		gc.drawImage(RenderableHolder.tree2,980,475,210,200);
		gc.drawImage(RenderableHolder.tree2,880,475,210,200);
		gc.drawImage(RenderableHolder.tree2,780,475,210,200);
		gc.drawImage(RenderableHolder.tree2,680,475,210,200);
		gc.drawImage(RenderableHolder.tree2,580,475,210,200);
	}
	
	public static void drawElementMap3Third(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.Bush,0,132);
		gc.drawImage(RenderableHolder.Bush,40,132);
		gc.drawImage(RenderableHolder.Bush,200,200,100,60);
		gc.drawImage(RenderableHolder.Bush,240,200,100,60);
		gc.drawImage(RenderableHolder.pine,200,30,150,230);
		gc.drawImage(RenderableHolder.pine,650,95,150,230);
		gc.drawImage(RenderableHolder.rock2,660,280);
		gc.drawImage(RenderableHolder.fence,570,281,48,48);
		gc.drawImage(RenderableHolder.fence,603,281,48,48);
		gc.drawImage(RenderableHolder.fence,636,281,48,48);
	}
	
	public static void drawElementMap3Fourth(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.Bush,640,644);
		gc.drawImage(RenderableHolder.Bush,660,644);
		gc.drawImage(RenderableHolder.Bush,680,644);
		gc.drawImage(RenderableHolder.Bush,700,644);
		gc.drawImage(RenderableHolder.Bush,720,644);
		gc.drawImage(RenderableHolder.Bush,740,644);
		gc.drawImage(RenderableHolder.Bush,760,644);
		gc.drawImage(RenderableHolder.Bush,780,644);
		gc.drawImage(RenderableHolder.Bush,800,644);
		gc.drawImage(RenderableHolder.Bush,840,644);
		gc.drawImage(RenderableHolder.Bush,860,644);
		gc.drawImage(RenderableHolder.Bush,880,644);
		gc.drawImage(RenderableHolder.Bush,900,644);
		gc.drawImage(RenderableHolder.Bush,920,644);
		gc.drawImage(RenderableHolder.Bush,940,644);
		gc.drawImage(RenderableHolder.Bush,960,644);
		gc.drawImage(RenderableHolder.Bush,980,644);
		gc.drawImage(RenderableHolder.Bush,1000,644);
		
	}
	
	public static void drawElementMap3Fifth(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.Bush,1020,644);
		gc.drawImage(RenderableHolder.Bush,1040,644);
		gc.drawImage(RenderableHolder.Bush,1060,644);
		gc.drawImage(RenderableHolder.Bush,1080,644);
		gc.drawImage(RenderableHolder.Bush,1100,644);
		gc.drawImage(RenderableHolder.rock2,280,529);
		
	}
}
