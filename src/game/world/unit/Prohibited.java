package game.world.unit;

import game.world.Unit;
import graphics.DrawObject;
import graphics.Object;
import graphics.Screen;

public class Prohibited extends Unit {

    public static final Object prohibited = new Object(300, 50, 50, 50, DrawObject.map1);

    public Prohibited(){
        colider=false;
        id=3;
    }

    public void render(Screen s, int x, int y) {
        s.loadImage(x*50,y*50,prohibited);
    }
}
