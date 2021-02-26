package game.world.unit;

import game.world.Unit;
import graphics.DrawObject;
import graphics.Object;
import graphics.Screen;
/**
 * klasa odpowiadająca za bonus spowalniający duchy
 */
public class SlowDown extends Unit {
    public static final Object slowDown = new Object(50, 100, 50, 50, DrawObject.map1);

    public SlowDown(){
        id=8;
        colider=false;

    }

    public void render(Screen s, int x, int y) {
        s.loadImage(x*50,y*50,slowDown);
    }

}
