package game.world.unit;

import game.world.Unit;
import graphics.DrawObject;
import graphics.Object;
import graphics.Screen;
/**
 * klasa, która jest blokiem po którym chodzi nasz bohater
 */
public class Dirt extends Unit {

    public static final Object dirt = new Object(100, 0, 50, 50, DrawObject.map1);

    public Dirt(){
        id=0;
        colider=false;
    }


    public void render(Screen s, int x, int y) {
        s.loadImage(x*50,y*50,dirt);
    }
}
