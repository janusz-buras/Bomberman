package core;

import core.gamestates.*;
import graphics.Screen;
import input.GameConfig;

import java.io.IOException;

/**
 * klasa, która pomaga nam w poruszaniu się między etapami gry
 */


public class GameStateManager{

    public static final int GAME_STATE_MENU=0;
    public static final int GAME_STATE_GAME=1;
   public static final int GAME_STATE_RULES=2;
    public static final int GAME_STATE_RANK=3;
    public static final int GAME_STATE_GAMEOVER=4;
    public static final int GAME_STATE_WIN=5;
    private static GameState gs;
    private static int life;
    private static int score;



    /**
     * funkcja zmieniająca etap gry
     * @param id
     */
    public static void ChangeGameState(int id) throws IOException {
        if(id==GAME_STATE_MENU)gs=new GS_Menu();
        if(id==GAME_STATE_GAME){
            life=GameConfig.getLife();
            score=0;

           gs=new GS_Game(1,life,score);


        }
        if(id==GAME_STATE_RULES)gs=new GS_Rules();
        if(id==GAME_STATE_RANK)gs=new GS_Rank("ranking.txt");
        if(id==GAME_STATE_GAMEOVER)gs=new GS_GameOver();

    }

    public static void ChangeGameState(int id, int poziom,int life,int score) throws IOException {
        if(id==GAME_STATE_GAME) gs=new GS_Game(poziom,life,score);
         if(id==GAME_STATE_WIN)gs=new GS_Win(life,score);
    }

    /**
     * konstruktor klasy, przy uruchomieniu gry odpala menu
     */
    public GameStateManager() throws IOException {
        ChangeGameState(GAME_STATE_MENU);

    }

    public void update() throws IOException {
        gs.update();
    }


    public void render(Screen s){
        gs.render(s);
    }

}
