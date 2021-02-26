package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Klasa obslugujaca klawiature
 */

public class Keyboard implements KeyListener {

    private static final int count = 200;
    private static boolean keys[] = new boolean[count];
    private static boolean keys_prev[] = new boolean[count];

    /**
     * Zabezpieczenie w razie gdyby klawisz byl wcicniety przed uruchomieniem programu
     */
    public Keyboard() {
        for (int i = 0; i < count; i++) {
            keys[i] = false;
            keys_prev[i] = false;
        }
    }


    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        keys[arg0.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        keys[arg0.getKeyCode()] = false;
    }


    public void update() {
        for (int i = 0; i < count; i++) {
            if(!keys[i])
                keys_prev[i]=false;
        }

    }

    public static boolean getKey(int Key){
            return keys[Key];
    }

    /**
     * Funkcja pobierajaca tylko jednorazowe wcisniecie przycisku na klawiaturze
     */
    public static boolean getKeyOnce(int Key){
        if(!keys_prev[Key] && keys[Key]){
          keys_prev[Key]=true;
            return true;
        }

        return false;
}


}
