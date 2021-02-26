package graphics;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.image.BufferedImage;

/**
 * klasa, która wskazuje na ścieżki jpgów oraz zczytująca dane obiekty
 */
public class DrawObject {

    public static final DrawObject map1 = new DrawObject("/graphics/ikony.png");
    public static final DrawObject background = new DrawObject("/graphics/backgroundmenu.png");
    public static final DrawObject pauza = new DrawObject("/graphics/pauza.jpg");
    public static final DrawObject zasady = new DrawObject("/graphics/zasady.png");
    public static final DrawObject gameover = new DrawObject("/graphics/gameover.png");
    public static final DrawObject win = new DrawObject("/graphics/win.jpg");
    public static final DrawObject rank = new DrawObject("/graphics/rank.jpg");
    public int [] pixels;
    public int width;
    public int height;
// private int[][] position= new int[15][15];

    /**
     * funkcja pobierająca pixele z jpga
     * @param path ścieżka pliku
     */
    public DrawObject(String path){
    try {
        BufferedImage image = ImageIO.read(DrawObject.class.getResource(path));
        width=image.getWidth();
        height=image.getHeight();
        pixels=new int[width*height];
        image.getRGB(0,0,width,height,pixels,0,width);
    } catch (IOException e) {
        e.printStackTrace();
    };
}


}
