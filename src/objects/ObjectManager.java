package objects;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;

public class ObjectManager {
	
	private ArrayList<PineappleAmmo> objects;
	
	public ObjectManager() {
		objects = new ArrayList<PineappleAmmo>();
	}
	
	public void update(GraphicsContext gc) {
		ArrayList<PineappleAmmo> toBeRemoved = new ArrayList<PineappleAmmo>();
		for (PineappleAmmo a : objects) {
			if(a.getX() < 0 || a.getX() > 1280 || !a.isActivated()) {
				toBeRemoved.add(a);
			}
			a.update(gc);
		}
		for (PineappleAmmo a: toBeRemoved) {
			objects.remove(a);
		}
	}
	
	public void draw(GraphicsContext gc) {
		for (PineappleAmmo a: objects) {
			a.draw(gc);
		}
	}
	
	public ArrayList<PineappleAmmo> getCurrentAmmo() {
		return this.objects;
	}
}
