package core.gamestates;

import core.GameState;
import core.GameStateManager;
import graphics.Screen;
import graphics.Object;
import graphics.DrawObject;
import input.Keyboard;

import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * klasa odpowiadająca za nasze menu
 */
public class GS_Menu extends GameState {
    public static final Object background = new Object(0, 0, 750, 800, DrawObject.background);
    public static final Object pointer = new Object(200, 50, 50, 50, DrawObject.map1);
    private int chose = 0;
    private int pointerPosition = 0;


    public GS_Menu() {
    }

    /**
     * funkcja która umożliwia wybieraniu różnych opcji w menu
     */
    public void update() throws IOException {
        if (chose==0 && Keyboard.getKeyOnce(KeyEvent.VK_ENTER)) {
            GameStateManager.ChangeGameState(GameStateManager.GAME_STATE_GAME);
        }
        if (chose==1 && Keyboard.getKeyOnce(KeyEvent.VK_ENTER)) {
            GameStateManager.ChangeGameState(GameStateManager.GAME_STATE_RULES);
        }
        if (chose==2 && Keyboard.getKeyOnce(KeyEvent.VK_ENTER)) {
            GameStateManager.ChangeGameState(GameStateManager.GAME_STATE_RANK);
        }
        else if(chose==3 && Keyboard.getKeyOnce(KeyEvent.VK_ENTER)){
            System.exit(0);
        }



        if(Keyboard.getKeyOnce(KeyEvent.VK_DOWN)) chose++;
        if(Keyboard.getKeyOnce(KeyEvent.VK_UP)) chose--;
        if(chose<0) chose=0;
        if(chose>3) chose=3;

        if (chose == 0) pointerPosition = 160;
        if (chose == 1) pointerPosition = 230;
        if (chose == 2) pointerPosition = 310;
        if (chose == 3) pointerPosition = 385;

    }


    public void render(Screen s) {
        s.clear(0x00ff00);
        s.loadImage(0, 0, background);
        s.loadImage(0, pointerPosition, pointer);

    }
}