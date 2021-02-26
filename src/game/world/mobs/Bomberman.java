package game.world.mobs;

import game.world.Map;
import graphics.DrawObject;
import graphics.Object;
import graphics.Screen;

/**
 * klasa opisująca bohatera naszej gry
 */
public class Bomberman {
    public int direction=0;
    public int xAxis;
    public int yAxis;
    public int life;
    public int speed;
    boolean isAlive;
    public static final Object heror = new Object(0, 50, 36, 36, DrawObject.map1);
    public static final Object heroup = new Object(50, 50, 36, 36, DrawObject.map1);
    public static final Object herod = new Object(100, 50, 36, 36, DrawObject.map1);
    public static final Object herol = new Object(150, 50, 36, 36, DrawObject.map1);
    public static final Object rip = new Object(350, 50, 49, 50, DrawObject.map1); //testowa potem zmienic w renderzer

    /**
     * konstruktor naszego herosa
     * @param xAxis polozenie poczatkowe x
     * @param yAxis polozenie poczatkowe y
     * @param life ilość żyć
     * @param speed prędkość poruszania
     * @param isAlive czy żywy
     */
    public Bomberman(int xAxis, int yAxis, int life, int speed, boolean isAlive) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.life = life;
        this.isAlive = isAlive;
        this.speed = speed;

    }


    public int getxAxis() {
        return xAxis;
    }

    public void setxAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public int getyAxis() {
        return yAxis;
    }

    public void setyAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

   // public void update(GS_Game_LVL1){}

   // public void update(Map m){}

    public void move(){


    }

    public void update(Map map){

    }

    /**
     * rysowanie naszego bohatera w zależności w którą stronę się porusza
     * @param s
     */
    public void render(Screen s){
       if(direction==0) s.loadImage(xAxis, yAxis,heror);
       else if(direction==1) s.loadImage(xAxis, yAxis,herol);
       else if(direction==2) s.loadImage(xAxis, yAxis,heroup);
       else if(direction==3) s.loadImage(xAxis, yAxis,herod);
       else if(direction==4) s.loadImage(xAxis, yAxis,rip);
    }




}