package game.world.unit;

import game.world.Unit;
import graphics.DrawObject;
import graphics.Object;
import graphics.Screen;

/**
 * klasa wyświetlajaca zabojczy ogien
 */


public class Fire extends Unit {
    public static final Object fire = new Object(250, 50, 50, 50, DrawObject.map1);

    public Fire(){
        id=4;
    }

    public void render(Screen s, int x, int y) {
        s.loadImage(x*50,y*50,fire);
    }
}
