package game.world.unit;

import game.world.Unit;
import graphics.DrawObject;
import graphics.Object;
import graphics.Screen;

/**
 * klasa odpowiadająca za ukryte przejscie
 */
public class RedButton extends Unit {

    public static final Object redbutton = new Object(300, 0, 50, 50, DrawObject.map1);

    public RedButton(){
        id=5;
        colider=false;

    }

    public void render(Screen s, int x, int y) {
        s.loadImage(x*50,y*50,redbutton);
    }
}
