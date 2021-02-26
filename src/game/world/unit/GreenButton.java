package game.world.unit;

import game.world.Unit;
import graphics.DrawObject;
import graphics.Object;
import graphics.Screen;
/**
 * klasa odpowiadająca za ukryte przejscie
 */
public class GreenButton extends Unit {

    public static final Object greenbutton = new Object(350, 0, 50, 50, DrawObject.map1);
    public GreenButton(){
        id=6;
        colider=false;
    }
    public void render(Screen s, int x, int y) {
        s.loadImage(x*50,y*50,greenbutton);
    }
}
