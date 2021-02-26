package game.world.mobs;

import graphics.DrawObject;
import graphics.Object;
import graphics.Screen;

/**
 * klasa opisująca naszych przeciwników
 */
public class Ghost {

    public int xG;
    public int yG;
    public int speedG;
    public boolean isAliveG;
    public static final Object ghost = new Object(200, 0, 50, DrawObject.map1);
public static final Object stone = new Object(0, 0, 50, 50, DrawObject.map1);
    public Ghost(int xG, int yG, int speedG){
        this.xG=xG;
        this.yG=yG;
        this.speedG=speedG;
        this.isAliveG=true;
    }


    public void render(Screen s){
        if(isAliveG==true)s.loadImage(xG, yG,ghost);
        if(isAliveG==false)s.loadImage(xG, yG,stone);
    }




}
