package graphics;

import graphics.Object;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * Klasa odpowiedzialna za nasze okno
 */
public class Screen {


    public int width=750;
    public int height=750;
    private BufferedImage image;
    private int[] pixels;

    /**
     * konstruktor wypelniajacy nasze okno kolorem
     * @param w  szerokosc
     * @param h  dlugosc
     */
    public Screen(int w, int h) {
        width = w;
        height = h;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
    }

    /**
     * wypełnianie okno danym kolorem
     * @param color
     */
    public void clear(int color){
        for(int i=0; i<width*height; i++){
            pixels[i]=color;
        }
    }

    public BufferedImage getImage(){
        return image;
    }

    public void frect(int px, int py, int w, int h,int color){
        for(int y=0; y<h;y++)
            for(int x=0; x<w;x++){
                pixel(px+x,py+y, color);
            }
    }

    /**
     * Funkcja, która rysuje w nasyzm oknie obiekt
     * @param px określa położenie x
     * @param py określa położenie y
     * @param o obiekt jaki podajemy do narysowania
     */
    public void loadImage(int px, int py, Object o) {
        for (int y = 0; y < o.height; y++)
            for (int x = 0; x < o.width; x++) {
                pixel(px+x,py+y, o.r.pixels[o.x+x+(o.y+y)*o.r.width]);
            }
    }

//    public void loadImage(int px, int py,int sx,int sy,int size, Object o) {
//        for (int y = 0; y < o.height; y++)
//            for (int x = 0; x < o.width; x++) {
//                pixel(px+x, py+y, o.pixels[sx+x+(sy+y*o.width)]);
//            }
//    }

    /**
     * Filtrowanie kolorów i ustawienie aby nasze grafiki nie zostały narysowane poza ekranem
     * @param x położenie x
     * @param y położenie y
     * @param color kolor danego pixela
     */
private void pixel(int x,int y,int color){
   if(x<0 || x>=width || y<0 || y>=height || color==0xffff00ff || color == 0xffff10ff) return;
    pixels[x+y*width]=color;
}
}