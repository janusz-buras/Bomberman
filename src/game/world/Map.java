package game.world;

import graphics.Screen;
import input.LoadData;

/**
 * klasa odpowiedzialna za rysowanie naszej mapy oraz obsługę zdarzeń na tej mapie
 */
public class Map {

    public final int width, height;
    public Unit[][] units;

/**
 * konstruktor tworzący mapę 15 na 15
 */
    public Map() {
        width = 15;
        height = 15;
        units = new Unit[width][height];
        //fill(1);
    }



    /**
     *  funkcja wykrywajaca kolizje
     */


    public boolean BoxColision(int px, int py, int w, int h) {
        int unitX = px / 50;
        int unitY = py / 50;
        boolean result = false;
        if(BoxColisionAt(unitX,unitY,px,py,w,h)) result=true;
        if (BoxColisionAt(unitX, unitY + 1, px, py, w, h)) result = true;
        if (BoxColisionAt(unitX + 1, unitY, px, py, w, h)) result = true;
        if (BoxColisionAt(unitX + 1, unitY + 1, px, py, w, h)) result = true;

        return result;
    }



    public boolean BoxColisionAt(int tx, int ty, int px, int py, int w, int h) {

        int pixelX = tx * 50;
        int pixelY = ty * 50;
        if (tx < 0 || ty < 0)
            return false;

        if (px + w > pixelX && px < pixelX + 50 && py + h > pixelY && py < pixelY + 50)
            return units[tx][ty].colider;
        return false;

    }

    /**
     * funkcja zczytująca do tablicy dwuwymiarowe cyfry, które będą oznaczały dane bloki
     * @param ld
     */
    public void transferMap(LoadData ld) {
        int[][] map = ld.getMap();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                units[x][y] = Unit.getUnit(map[x][y]);
            }

        }
    }


    public void fill(int id) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                units[x][y] = Unit.getUnit(id);

            }
        }
    }

    /**
     * rysowanie naszej mapy
     * @param s
     */
    public void render(Screen s) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                units[x][y].render(s, x, y);
            }
        }
    }

    public void setField(int x, int y, int fieldId){
        units[x][y]=Unit.getUnit(fieldId);
    }


    public boolean isDirt(int x, int y){
        if(units[x][y].id==0 || units[x][y].id==5 || units[x][y].id==6 || units[x][y].id==7 || units[x][y].id==8 || units[x][y].id==9 || units[x][y].id==10||units[x][y].id==11){
            return true;
        }
        return false;
}

public int checkUnit(int x, int y){
        return units[x][y].id;
}


    public boolean isDestroyalbe(int x, int y){
        if(units[x][y].id==1) {

            return false;
        }
        return true;
    }

    public void update() {

    }
}
