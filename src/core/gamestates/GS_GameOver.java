package core.gamestates;

import core.GameState;
import core.GameStateManager;
import graphics.DrawObject;
import graphics.Object;
import graphics.Screen;
import input.Keyboard;

import java.awt.event.KeyEvent;
import java.io.IOException;
/**
 * klasa odpowiadająca za przegraną
 */
public class GS_GameOver extends GameState {

    public GS_GameOver(){}
    public static final Object gameover = new Object(0, 0, 750, 750, DrawObject.gameover);
    public void update() throws IOException {
        if (Keyboard.getKeyOnce(KeyEvent.VK_ENTER)) GameStateManager.ChangeGameState(0);
    }

    public void render(Screen s) {
        s.clear(0x00ff00);
        s.loadImage(0, 0, gameover);


    }
}
