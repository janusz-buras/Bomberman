package game.world.unit;

import game.world.Unit;
import graphics.DrawObject;
import graphics.Object;
import graphics.Screen;
/**
 * klasa, która jest blokiem zniszczalnym i kolidującym(nie da się przez niego przeniknąć
 */
public class Brick extends Unit {

    public static final Object brick = new Object(50, 0, 50, 50, DrawObject.map1);

    public Brick(){
        id=2;
        colider=true;
    }

    public void render(Screen s, int x, int y) {
        s.loadImage(x*50,y*50,brick);
    }

}
