package game.world.unit;

import game.world.Unit;
import graphics.DrawObject;
import graphics.Object;
import graphics.Screen;
/**
 * klasa odpowiadająca za bonus dodajacy dodatkowe punkty
 */
public class ExtraMoney extends Unit {
    public static final Object extraMoney = new Object(100, 100, 50, 50, DrawObject.map1);

    public ExtraMoney(){
        id=9;
        colider=false;

    }

    public void render(Screen s, int x, int y) {
        s.loadImage(x*50,y*50,extraMoney);
    }



}
