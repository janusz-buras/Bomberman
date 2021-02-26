package game.world.unit;

import game.world.Unit;
import graphics.DrawObject;
import graphics.Object;
import graphics.Screen;
/**
 * klasa odpowiadająca za bonus dodajacy nowe zycie
 */
public class ExtraLife extends Unit {
    public static final Object extraLife = new Object(150, 100, 50, 50, DrawObject.map1);

    public ExtraLife(){
        id=10;
        colider=false;

    }

    public void render(Screen s, int x, int y) {
        s.loadImage(x*50,y*50,extraLife);
    }
}
