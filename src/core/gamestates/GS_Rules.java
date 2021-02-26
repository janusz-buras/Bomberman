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
 * klasa odpowiadająca za zasady gry
 */
public class GS_Rules extends GameState {

    public GS_Rules(){}
    public static final Object zasady = new Object(0, 0, 750, 750, DrawObject.zasady);

    public void update() throws IOException {
        if (Keyboard.getKeyOnce(KeyEvent.VK_ENTER)) GameStateManager.ChangeGameState(0);
    }

    public void render(Screen s) {
        s.clear(0x00ff00);
        s.loadImage(0, 0, zasady);


    }
}
