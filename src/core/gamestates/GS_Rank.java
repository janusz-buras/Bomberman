package core.gamestates;

import core.GameState;
import core.GameStateManager;
import graphics.DrawObject;
import graphics.Object;
import graphics.Screen;
import input.Keyboard;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * klasa odpowiadająca za ranking
 */
public class GS_Rank extends GameState{
    private static File file;
    private static Scanner scanner;
    private int []stab=new int[100]; //score tab
    private String []ntab=new String[100]; //nick tab
    public static final Object rank = new Object(0, 0, 750, 750, DrawObject.rank);

    public GS_Rank(String fileName){
        load(fileName);
        readRank();
        sort();
        Ranking ranking=new Ranking(stab,ntab);
        ranking.setLocationRelativeTo(null);
        ranking.setResizable(true);
        ranking.setVisible(true);

    }
    /**
     * funkcja wczytujaca plik
     */
    private static void load(String fileName) {
        file = new File(fileName);
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * funkcja zczytujaca wyniki
     */
    private void readRank() {
        String tempScannerValue;
        int temp=0;
        int k=0;
        int i=0;
        while (this.scanner.hasNextLine()) {
            temp++;
            tempScannerValue = this.scanner.nextLine();
            if(temp % 2 == 1){
                ntab[k]=tempScannerValue;
                k++;
            }
            if(temp % 2 == 0) {
                stab[i] = Integer.parseInt(tempScannerValue);
                i++;
            }
        }
    }
    /**
     * funkcja sortująca wyniki, sortowaniem bąbelkowym
     */
    private void sort(){
            int temp;
            int zmiana = 1;
            String temp_nick;
            while(zmiana > 0){
                zmiana = 0;
                for(int i=0; i<stab.length-1; i++){
                    if(stab[i]<stab[i+1]){
                        temp = stab[i+1];
                        temp_nick=ntab[i+1];
                        stab[i+1] = stab[i];
                        ntab[i+1]=ntab[i];
                        stab[i] = temp;
                        ntab[i]=temp_nick;
                        zmiana++;
                    }
                }
            }

        }


    public void update() throws IOException {
        if (Keyboard.getKeyOnce(KeyEvent.VK_ENTER)) GameStateManager.ChangeGameState(0);
    }

    public void render(Screen s) {
        s.clear(0x00ff00);
        s.loadImage(0, 0, rank);


    }

    }


