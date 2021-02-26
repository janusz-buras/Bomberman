package game.world;

import game.world.unit.*;
import graphics.Screen;

/**
 * klasa matka odpowiadająca za nasze bloczki na mapie
 */
public class Unit {
    public int id;
    public boolean colider;

    /**
     * klasa pozyskująca dany kolcek
     * @param id oznakowanie klocka 0 1 lub 2
     * @return zwraca i rysuje dany klocek na mapie
     */
    public static  Unit getUnit(int id){

        if(id==1)return new Stone();
        if(id==2)return new Brick();
        if(id==3)return new Prohibited();
        if(id==4)return new Fire();
        if(id==5)return new RedButton();
        if(id==6)return new GreenButton();
        if(id==7)return new SpeedUp();
        if(id==8)return new SlowDown();
        if(id==9)return new ExtraMoney();
        if(id==10)return new ExtraLife();
        if(id==11)return new Key();
        return new Dirt();
    }



    public void update(){};

    public void render(Screen s,int x, int y){};


}
