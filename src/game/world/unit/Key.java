package game.world.unit;

import game.world.Unit;
import graphics.DrawObject;
import graphics.Object;
import graphics.Screen;
/**
 * klasa odpowiadająca za bonus odnajdowania ukrytego przejscia
 */
public class Key extends Unit {

    public static final Object key = new Object(200, 100, 50, 50, DrawObject.map1);

    public Key(){
        id=11;
        colider=false;

    }

    public void render(Screen s, int x, int y) {
        s.loadImage(x*50,y*50,key);
    }

}
