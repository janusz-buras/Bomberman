package game.world.unit;

import game.world.Unit;
import graphics.DrawObject;
import graphics.Object;
import graphics.Screen;

/**
 * klasa, która jest blokiem niezniszczalnym i kolidującym(nie da się przez niego przeniknąć
 */
public class Stone extends Unit {

    public static final Object stone = new Object(0, 0, 50, 50, DrawObject.map1);

    public Stone(){
        id=1;
        colider=true;
    }

    public void render(Screen s, int x, int y) {
        s.loadImage(x*50,y*50,stone);
    }

}
