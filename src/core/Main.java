package core;

import graphics.Screen;
import input.GameConfig;
import input.Keyboard;
import input.SaveData;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Main extends Canvas implements Runnable {

    public static final String title = "Dyna Blaster";
    public static int width = 750, height = 750;
    private static final int framerate = 60;
    private boolean running = false;
    private JFrame frame;
    private Keyboard keyboard = new Keyboard();
    private GameStateManager gsm;
    private Screen screen;
   // int x=50,y=50;

    /**
     * klasa odpowiadająca za działanie całej naszej gry
     */

    public Main() throws IOException {
        setPreferredSize(new Dimension(width, height));

        frame = new JFrame();
        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this, new BorderLayout().CENTER);

      addKeyListener(new Keyboard());

      frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);

        screen =new Screen(750,750);
        gsm=new GameStateManager();

    }

    /**
     * funkcja odpowiadająca za wystartowanie naszej aplikacji
     */
    protected void start() {
        if (running) return;
        running = true;
        new Thread(this, "Game " + title).start();
    }
    /**
     * funkcja odpowiadająca za zakończenie działania naszej apki
     */
    private void stop() {
        if (!running) return;
        running = false;
        frame.dispose();
        System.exit(0);
    }

    private double timer = System.currentTimeMillis();
    private int fps = 0;
    private int ups = 0;
    private double delta;
    private double frametime = 1000000000 / framerate;
    private long timeNow = System.nanoTime();
    private long timeLast = System.nanoTime();

   // public static final Object stone= new Object(0,0,50,50, DrawObject.map1);
   // public static final Object brick= new Object(50,0,50,50, DrawObject.map1);
   // public static final Object dirt= new Object(100,0,50,50, DrawObject.map1);

    /**
     * funkcja odpowiadająca za płynne funkcjonowanie naszej gry
     */
    @Override
    public void run() {

        while (running) {
            timeNow = System.nanoTime();
            delta += (timeNow - timeLast) / frametime;
            timeLast = timeNow;

            while (delta >= 1) {
                try {
                    update();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                delta -= 1;
                ups++;
            }
            render();
            fps++;

            if (System.currentTimeMillis() - timer >= 1000) {
                timer = System.currentTimeMillis();
                // System.out.println("FPS=" + fps + "  UPS=" +ups);
                fps = 0;
                ups = 0;
            }
        }
        stop();
    }

    /**
     * funkcja odpowiadająca za odświeżanie stanu gry
     */
    private void update() throws IOException {
        keyboard.update();
    gsm.update();
    }

    /**
     * funkcja renderująca świat gry oraz umożliwiąjąca skalowanie obrazu
     */
    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        screen.clear(0x000000);

        gsm.render(screen);

        //skalowanie
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform saveTransform = g2d.getTransform();
        AffineTransform scaleMatrix = new AffineTransform();
        float sx =(1f+(getSize().width-width)/(float)width);
        float sy =(1f+(getSize().height-height)/(float)height);
        scaleMatrix.scale(sx, sy);
        g2d.setTransform(scaleMatrix);
        g=g2d;

        g.drawImage(screen.getImage(),0,0,width,height,null);
        g.dispose();
        bs.show();
    }


    /**
     * funkcja, która rozpoczyna naszą grę
     */
    public static void main(String[] args) throws IOException {

        new Main().start();
        GameConfig gameConfig= new GameConfig("src/config.txt");
       // new SaveData(6000,"Kris");
       // System.out.println();

    }
}
