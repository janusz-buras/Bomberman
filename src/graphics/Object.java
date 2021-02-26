package graphics;

import graphics.DrawObject;

/**
 * klasa okreslajaca wspolrzedne rozmiary obrazków które będziemy pobierac
 */
public class Object {
    public int x,y,width, height;
    public DrawObject r;

    /**
     * konstruktor określające jakie wymiary mamy wyciąć
     * @param x współrzędna x w naszym jpgu od której będziemy zaczynali nasze wycinanie
     * @param y współrzędna y w naszym jpgu od której będziemy zaczynali nasze wycinanie
     * @param width odległosć jaka będzie wycinana od x
     * @param height odległosć jaka będzie wycinana od y
     * @param r obiekt jaki wycinamy
     */
    public Object(int x, int y, int width, int height, DrawObject r)
    {
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.r=r;
    }

    /**
     * konstruktor taki sam jak poprzedni tylko dla kwadratów
     */
    public Object(int x, int y, int size, DrawObject r)
    {
        this.x=x;
        this.y=y;
        this.width=size;
        this.height=size;
        this.r=r;
    }

}

