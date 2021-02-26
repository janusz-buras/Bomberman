package game.world.unit;

import game.world.Unit;
import graphics.DrawObject;
import graphics.Object;
import graphics.Screen;
/**
 * klasa odpowiadająca za bonus przyśpiesznia naszego gracza
 */
public class SpeedUp extends Unit {

    public static final Object speedUp = new Object(0, 100, 50, 50, DrawObject.map1);

    public SpeedUp(){
        id=7;
        colider=false;

    }

    public void render(Screen s, int x, int y) {
      s.loadImage(x*50,y*50,speedUp);
    }


}
