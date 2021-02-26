package game.world.unit;

import core.gamestates.Score;
import game.world.Map;
import game.world.Unit;
import game.world.unit.Brick;
import graphics.DrawObject;
import graphics.Object;
import graphics.Screen;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * klasa opisujaca bombe
 */
public class Bomb extends Unit{
   public int xBomb;
   public int yBomb;
   public int range;
   public boolean destroyed;
    public static final Object dirt = new Object(100, 0, 50, 50, DrawObject.map1);
   public static final Object bomba = new Object(150, 0, 50, 50, DrawObject.map1);
    public int id=3;

    public Bomb( boolean destroyed){
        this.destroyed=true;
        colider=true;
    }

    public Bomb(int xBomb,int yBomb, int range, boolean destroyed){
        this.xBomb=xBomb;
        this.yBomb=yBomb;
        this.range=range;
        colider=true;
        this.destroyed=false;

    }


    public void update(Map map){

    }
    /**
     * funkcja, odpowiadajaca za wybuch bomby
     */
    public void plantBomb(Map map) {

        int xPosition = xBomb / 50;
        int yPosition = yBomb / 50;


        map.setField(xPosition, yPosition,4);
        checkUnitsL(xPosition,yPosition,map);
        checkUnitsR(xPosition,yPosition,map);
        checkUnitsUp(xPosition,yPosition,map);
        checkUnitsD(xPosition,yPosition,map);
    }

    /**
     * funkcje sprawdzajaca ktore pola moga zostac wysadzone
     */

    public void checkUnitsL(int xPosition,int yPosition,Map map) {

        for (int i = 1; i <= range; i++) {
            if (map.isDestroyalbe(xPosition - i, yPosition) == false) return;
            if(map.isDirt(xPosition-i,yPosition)){
                map.setField(xPosition - i, yPosition,4);
                continue;
            }
            if (map.isDestroyalbe(xPosition - i, yPosition)){

                map.setField(xPosition - i, yPosition,4);
                return;
            }
        }
    }

        public void checkUnitsR(int xPosition,int yPosition,Map map){
            for (int i = 1; i <= range; i++) {

               if (map.isDestroyalbe(xPosition + i, yPosition) == false ) return;
                if(map.isDirt(xPosition+i,yPosition)){
                    map.setField(xPosition + i, yPosition,4);
                    continue;
                }
                if (map.isDestroyalbe(xPosition + i, yPosition)){
                    map.setField(xPosition + i, yPosition,4);

                    return;
                }
            }
        }

    public void checkUnitsD(int xPosition,int yPosition,Map map) {
        for (int i = 1; i <= range; i++) {
          if (map.isDestroyalbe(xPosition, yPosition + i) == false) return;
            if(map.isDirt(xPosition,yPosition+i)){
                map.setField(xPosition, yPosition + i,4);
                continue;
            }
            if (map.isDestroyalbe(xPosition, yPosition + i)){
                map.setField(xPosition, yPosition + i,4);
                return;
                }
            }
        }

    public void checkUnitsUp(int xPosition,int yPosition,Map map){
        for (int i = 1; i <= range ; i++) {
           if (map.isDestroyalbe(xPosition, yPosition-i)==false)return;
            if(map.isDirt(xPosition,yPosition-i)){
                map.setField(xPosition, yPosition-i,4);
                continue;
            }
            if (map.isDestroyalbe(xPosition, yPosition-i)){
                map.setField(xPosition, yPosition-i,4);
                return;
            }
        }

    }


    public void render(Screen s){
      // if(destroyed==false) s.loadImage(xBomb, yBomb,bomba);


    }
}
