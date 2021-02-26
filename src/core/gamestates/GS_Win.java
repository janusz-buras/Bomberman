package core.gamestates;

import core.GameState;
import core.GameStateManager;
import graphics.DrawObject;
import graphics.Object;
import graphics.Screen;
import input.Keyboard;
import input.SaveData;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * klasa odpowiadająca za okno po wygranej
 */
public class GS_Win extends GameState{



    public GS_Win(int life,int score) throws IOException {
      score+=life*1000;
        Nickname nick = new Nickname("ranking.txt", score);
        //nick.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nick.setLocationRelativeTo(null);
        nick.setResizable(true);
        nick.setVisible(true);
    }
    public static final Object win = new Object(0, 0, 750, 750, DrawObject.win);

    public void update() throws IOException {
        if (Keyboard.getKeyOnce(KeyEvent.VK_ENTER)) GameStateManager.ChangeGameState(0);
    }

    public void render(Screen s) {
        s.clear(0x00ff00);
        s.loadImage(0, 0, win);


    }
}
