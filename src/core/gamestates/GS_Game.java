package core.gamestates;

import core.GameState;
import core.GameStateManager;
import game.world.mobs.Bomberman;
import game.world.Map;
import game.world.mobs.Ghost;
import game.world.unit.Bomb;
import graphics.DrawObject;
import graphics.Object;
import graphics.Screen;
import input.GameConfig;
import input.Keyboard;
import input.LoadData;


import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;

/**
 * klasa odpowiadająca za obsługę levela
 */


public class GS_Game extends GameState {
    public static final Object lifes = new Object(250, 0, 50, 50, DrawObject.map1);
    public static final Object pauza = new Object(0, 0, 250, 149, DrawObject.pauza);
    public Map map;
    private Bomberman bomberman;
    public Bomb bomb;
    public Ghost ghost1;
    public Ghost ghost2;
    public Time time;
    private boolean bombFlag=true;


    /**
     * konstruktor, który wczytuję mapę do odpowiedniego levela, wczytuje bohatera, duchy itp
     * @param lvl
     */
private int lvl;
private int life;
    private int score;

    public GS_Game(int lvl,int life,int score){

        if(lvl==1) {
            LoadData loadData = new LoadData("src/level1.txt");
            loadData.readDataFromFile();
            map = new Map();
            map.transferMap(loadData);
            ghost2 = new Ghost(GameConfig.getxG2(), GameConfig.getyG2(), GameConfig.getSpeedG2());
            ghost1 = new Ghost(GameConfig.getxG1(), GameConfig.getyG1(), GameConfig.getSpeedG1());
            this.lvl=lvl;
            this.life=life;
            this.score=score;
        }

            if(lvl==2) {

            LoadData loadData = new LoadData("src/level2.txt");
            loadData.readDataFromFile();
            map=new Map();
            map.transferMap(loadData);
            ghost2= new Ghost(GameConfig.getxG3(),GameConfig.getyG3(),GameConfig.getSpeedG3());
            ghost1= new Ghost(GameConfig.getxG4(),GameConfig.getyG4(),GameConfig.getSpeedG4());
            this.lvl=lvl;
            this.life=life;
            this.score=score;
        }
        if(lvl==3) {

            LoadData loadData = new LoadData("src/level3.txt");
            loadData.readDataFromFile();
            map=new Map();
            map.transferMap(loadData);
            ghost2= new Ghost(GameConfig.getxG5(),GameConfig.getyG5(),GameConfig.getSpeedG5());
            ghost1= new Ghost(GameConfig.getxG6(),GameConfig.getyG6(),GameConfig.getSpeedG6());
            this.lvl=lvl;
            this.life=life;
            this.score=score;
        }
        time = new Time();
        time.start();
        bomb=new Bomb(true);
        bomberman=new Bomberman(GameConfig.getxAxisHero(),GameConfig.getyAxisHero(),life,GameConfig.getSpeedHero(),GameConfig.isIsAliveHero());
    }


    int kill=0;
    int direction2=2;
    int direction=4;
    int temp,tempt,tempr,temptt;
    int bombCount=0;
    int bombCountAllow=1;
    int tempx,tempy;
    int block=0;
    boolean ifPause=false;
    boolean pause=false;
    boolean used1=false,used2=false,used3=false,used4=false,used5=false;
    /**
     * funkcja odpowiadająca za poruszanie naszym bohaterem, poruszaniem ducha, podkładania bomb itp.
     */
    public void update() throws IOException {


        if (ifPause == false) {

            if (Keyboard.getKeyOnce(KeyEvent.VK_P)) {
                ifPause = true;
                pause = true;
                temptt = time.secondsPassed;
            }

            //podkładanie bomby
            if (time.secondsPassed == temp + 3 && bombFlag == false) {
                bomb.plantBomb(map);
                tempt = time.getSecondsPassed();
                bombCount = 0;
                bombFlag = true;

            }
//respawn bohatera
            if (time.secondsPassed == tempr + 2 && block == 1) {
                bomberman.xAxis = 50;
                bomberman.yAxis = 50;
                block = 0;
                bomberman.direction = 0;
            }
//śmierć bohatera poprzez wybuch
            if (map.checkUnit(((bomberman.xAxis + 16) / 50), ((bomberman.yAxis + 16) / 50)) == 4) {
                if (bomberman.direction != 4) bomberman.life -= 1;
                bomberman.direction = 4;
                block = 1;
                tempr = time.secondsPassed;
            }
//śmierć ducha poprzez wybuch
            if (map.checkUnit(((ghost1.xG + 16) / 50), ((ghost1.yG + 16) / 50)) == 4) {
                ghost1.xG = 0;
                ghost1.yG = 0;
                ghost1.isAliveG = false;
                direction = 0;
                kill++;
                score += 500;

            }
            if (map.checkUnit(((ghost2.xG + 16) / 50), ((ghost2.yG + 16) / 50)) == 4) {
                ghost2.xG = 0;
                ghost2.yG = 0;
                ghost2.isAliveG = false;
                direction2 = 0;
                kill++;
                score += 500;
            }
//śmierć bohatera poprzez zawał, gdy napotkał ducha
            if ((bomberman.xAxis + 16) / 50 == (ghost1.xG + 16) / 50 && (bomberman.yAxis + 16) / 50 == (ghost1.yG + 16) / 50 && block == 0) {
                if (bomberman.direction != 4) bomberman.life -= 1;
                bomberman.direction = 4;
                block = 1;
                tempr = time.secondsPassed;

            }
            if ((bomberman.xAxis + 16) / 50 == (ghost2.xG + 16) / 50 && (bomberman.yAxis + 16) / 50 == (ghost2.yG + 16) / 50) {
                if (bomberman.direction != 4) bomberman.life -= 1;
                bomberman.direction = 4;
                block = 1;
                tempr = time.secondsPassed;
            }


//uzupełnianie pól po wybuchu
            if (time.secondsPassed == tempt + 1) {
                for (int i = 0; i < 15; i++) {
                    for (int k = 0; k < 15; k++) {
                        if (map.checkUnit(i, k) == 4) map.setField(i, k, 0);

                    }
                }
            }

//poruszanie się ducha1
            if (direction == 0) ghost1.speedG = 0;
            if (direction == 1) ghost1.xG += ghost1.speedG;
            if (direction == 2) ghost1.xG -= ghost1.speedG;
            if (direction == 3) ghost1.yG += ghost1.speedG;
            if (direction == 4) ghost1.yG -= ghost1.speedG;

            if (direction == 1) {
                if (map.BoxColision(ghost1.xG + ghost1.speedG, ghost1.yG, 45, 45)) {
                    ghost1.xG -= ghost1.speedG;
                    direction = randomBeetwen(1, 5);
                }
            }
            if (direction == 2) {
                if (map.BoxColision(ghost1.xG - ghost1.speedG, ghost1.yG, 45, 45)) {
                    ghost1.xG += ghost1.speedG;
                    direction = randomBeetwen(1, 5);
                }
            }
            if (direction == 3) {
                if (map.BoxColision(ghost1.xG, ghost1.yG + ghost1.speedG, 45, 45)) {
                    ghost1.yG -= ghost1.speedG;
                    direction = randomBeetwen(1, 5);
                }
            }
            if (direction == 4) {
                if (map.BoxColision(ghost1.xG, ghost1.yG - ghost1.speedG, 45, 45)) {
                    ghost1.yG += ghost1.speedG;
                    direction = randomBeetwen(1, 5);
                }
            }
//poruszanie się ducha 2
            if (direction2 == 0) ghost2.speedG = 0;
            if (direction2 == 1) ghost2.xG += ghost2.speedG;
            if (direction2 == 2) ghost2.xG -= ghost2.speedG;
            if (direction2 == 3) ghost2.yG += ghost2.speedG;
            if (direction2 == 4) ghost2.yG -= ghost2.speedG;

            if (direction2 == 1) {
                if (map.BoxColision(ghost2.xG + ghost2.speedG, ghost2.yG, 45, 45)) {
                    ghost2.xG -= ghost2.speedG;
                    direction2 = randomBeetwen(1, 5);
                }
            }
            if (direction2 == 2) {
                if (map.BoxColision(ghost2.xG - ghost2.speedG, ghost2.yG, 45, 45)) {
                    ghost2.xG += ghost2.speedG;
                    direction2 = randomBeetwen(1, 5);
                }
            }
            if (direction2 == 3) {
                if (map.BoxColision(ghost2.xG, ghost2.yG + ghost2.speedG, 45, 45)) {
                    ghost2.yG -= ghost2.speedG;
                    direction2 = randomBeetwen(1, 5);
                }
            }
            if (direction2 == 4) {
                if (map.BoxColision(ghost2.xG, ghost2.yG - ghost2.speedG, 45, 45)) {
                    ghost2.yG += ghost2.speedG;
                    direction2 = randomBeetwen(1, 5);
                }
            }

//poruszanie się bohatera
            if (Keyboard.getKey(KeyEvent.VK_UP) && block == 0) {
                if (map.BoxColision(bomberman.xAxis, bomberman.yAxis - bomberman.speed, 35, 35)) {
                    return;
                } else {
                    bomberman.yAxis -= bomberman.speed;
                    bomberman.direction = 2;
                }
            }


            if (Keyboard.getKey(KeyEvent.VK_DOWN) && block == 0) {
                if (map.BoxColision(bomberman.xAxis, bomberman.yAxis + bomberman.speed, 35, 35)) return;
                else {
                    bomberman.yAxis += bomberman.speed;
                    bomberman.direction = 3;
                }


            }
            if (Keyboard.getKey(KeyEvent.VK_RIGHT) && block == 0) {
                if (map.BoxColision(bomberman.xAxis + bomberman.speed, bomberman.yAxis, 35, 35)) {
                    return;
                } else {
                    bomberman.xAxis += bomberman.speed;
                    bomberman.direction = 0;
                }

            }
            if (Keyboard.getKey(KeyEvent.VK_LEFT) && block == 0) {
                if (map.BoxColision(bomberman.xAxis - bomberman.speed, bomberman.yAxis, 35, 35)) return;
                else {
                    bomberman.xAxis -= bomberman.speed;
                    bomberman.direction = 1;
                }
            }

//podkładanie bomby
            if (Keyboard.getKeyOnce(KeyEvent.VK_SPACE) && block == 0) {
                if (bombCount < bombCountAllow) {
                    bomb = new Bomb(((bomberman.xAxis + 16) / 50) * 50, ((bomberman.yAxis + 16) / 50) * 50, 2, false);
                    temp = time.getSecondsPassed();
                    bombCount++;
                    // System.out.println("lb bomb " + bombCount);
                    bombFlag = false;
                    tempx = (bomberman.xAxis + 16) / 50;
                    tempy = (bomberman.yAxis + 16) / 50;
                    map.setField(tempx, tempy, 3);
                }
            }

//konfiguracja mapy zależna od lvlu
            if (lvl == 1) {

                if (map.checkUnit(GameConfig.getBonus1x1() / 50, GameConfig.getBonus1y1() / 50) != 2 && used1 == false)
                    map.setField(GameConfig.getBonus1x1() / 50, GameConfig.getBonus1y1() / 50, 7);
                if (map.checkUnit(GameConfig.getBonus2x1() / 50, GameConfig.getBonus2y1() / 50) != 2 && used2 == false)
                    map.setField(GameConfig.getBonus2x1() / 50, GameConfig.getBonus2y1() / 50, 8);
                if (map.checkUnit(GameConfig.getBonus3x1() / 50, GameConfig.getBonus3y1() / 50) != 2 && used3 == false)
                    map.setField(GameConfig.getBonus3x1() / 50, GameConfig.getBonus3y1() / 50, 9);
                if (map.checkUnit(GameConfig.getButton1x() / 50, GameConfig.getButton1y() / 50) != 2) {
                    if (kill < 2) map.setField(GameConfig.getButton1x() / 50, GameConfig.getButton1y() / 50, 5);
                    if (kill == 2) map.setField(GameConfig.getButton1x() / 50, GameConfig.getButton1y() / 50, 6);
                }
            }


            if (lvl == 2) {
                if (map.checkUnit(GameConfig.getBonus1x2() / 50, GameConfig.getBonus1y2() / 50) != 2 && used4 == false)
                    map.setField(GameConfig.getBonus1x2() / 50, GameConfig.getBonus1y2() / 50, 10);
                if (map.checkUnit(GameConfig.getBonus2x2() / 50, GameConfig.getBonus2y2() / 50) != 2 && used3 == false)
                    map.setField(GameConfig.getBonus2x2() / 50, GameConfig.getBonus2y2() / 50, 9);
                if (map.checkUnit(GameConfig.getBonus3x2() / 50, GameConfig.getBonus3y2() / 50) != 2 && used2 == false)
                    map.setField(GameConfig.getBonus3x2() / 50, GameConfig.getBonus3y2() / 50, 8);
                if (map.checkUnit(GameConfig.getButton2x() / 50, GameConfig.getButton2y() / 50) != 2) {
                    if (kill < 2) map.setField(GameConfig.getButton2x() / 50, GameConfig.getButton2y() / 50, 5);
                    if (kill == 2) map.setField(GameConfig.getButton2x() / 50, GameConfig.getButton2y() / 50, 6);
                }
            }


            if (lvl == 3) {
                if (map.checkUnit(GameConfig.getBonus1x3() / 50, GameConfig.getBonus1y3() / 50) != 2 && used2 == false)
                    map.setField(GameConfig.getBonus1x3() / 50, GameConfig.getBonus1y3() / 50, 8);
                if (map.checkUnit(GameConfig.getBonus2x3() / 50, GameConfig.getBonus2y3() / 50) != 2 && used3 == false)
                    map.setField(GameConfig.getBonus2x3() / 50, GameConfig.getBonus2y3() / 50, 9);
                if (map.checkUnit(GameConfig.getBonus3x3() / 50, GameConfig.getBonus3y3() / 50) != 2 && used5 == false)
                    map.setField(GameConfig.getBonus3x3() / 50, GameConfig.getBonus3y3() / 50, 11);

                if (map.checkUnit(GameConfig.getButton3x() / 50, GameConfig.getButton3y() / 50) != 2) {
                    if (kill < 2) map.setField(GameConfig.getButton3x() / 50, GameConfig.getButton3y() / 50, 5);
                    if (kill == 2) map.setField(GameConfig.getButton3x() / 50, GameConfig.getButton3y() / 50, 6);
                }
            }
        }


        if(map.checkUnit(bomberman.xAxis/50,bomberman.yAxis/50)==8){
            if(direction!=0)ghost1.speedG--;
            if(direction2!=0)ghost2.speedG--;
            map.setField(bomberman.xAxis/50,bomberman.yAxis/50,0);
            used2=true;
        }


        if(map.checkUnit(bomberman.xAxis/50,bomberman.yAxis/50)==7 &&bomberman.speed<3){
            bomberman.speed++;
            map.setField(bomberman.xAxis/50,bomberman.yAxis/50,0);
            used1=true;
        }

        if(map.checkUnit(bomberman.xAxis/50,bomberman.yAxis/50)==9){
            score+=1500;
            map.setField(bomberman.xAxis/50,bomberman.yAxis/50,0);
            used3=true;
        }

        if(map.checkUnit(bomberman.xAxis/50,bomberman.yAxis/50)==10){
            bomberman.life++;
            map.setField(bomberman.xAxis/50,bomberman.yAxis/50,0);
            used4=true;
        }


        if(map.checkUnit(bomberman.xAxis/50,bomberman.yAxis/50)==11){
            if (kill < 2) map.setField(GameConfig.getButton3x() / 50, GameConfig.getButton3y() / 50, 5);
            if (kill == 2) map.setField(GameConfig.getButton3x() / 50, GameConfig.getButton3y() / 50, 6);
            map.setField(bomberman.xAxis/50,bomberman.yAxis/50,0);
            used5=true;
        }

        //zmiana levela na następny
        if(map.checkUnit(bomberman.xAxis/50,bomberman.yAxis/50)==6){
            lvl++;
            score+=2000;
           if(lvl<4) GameStateManager.ChangeGameState(GameStateManager.GAME_STATE_GAME, lvl,bomberman.life,score);
           if(lvl==4)GameStateManager.ChangeGameState(GameStateManager.GAME_STATE_WIN, lvl,bomberman.life,score);
        }





        if(Keyboard.getKeyOnce(KeyEvent.VK_P)){
            ifPause=false;
            pause=false;
            time.secondsPassed=temptt;
        }

        if(bomberman.life<1){GameStateManager.ChangeGameState(GameStateManager.GAME_STATE_GAMEOVER);}


    }

    


    public void render(Screen s){


        s.clear(0x000000);
        map.render(s);
        bomberman.render(s);
      //  bomb.render(s);
        ghost1.render(s);
        ghost2.render(s);
     if(pause==true) s.loadImage(250,125,pauza);
        if(bomberman.life>=5) s.loadImage(450,0,lifes);
        if(bomberman.life>=4) s.loadImage(500,0,lifes);
        if(bomberman.life>=3) s.loadImage(550,0,lifes);
        if(bomberman.life>=2) s.loadImage(600,0,lifes);
        if(bomberman.life>=1) s.loadImage(650,0,lifes);
    }

    /**
     * funkcja losująca cyfrę z danego przedizału
     */
static int randomBeetwen(int start, int end){
    Random random=new Random();
    int a1=random.nextInt(end-start);
    int a2=a1+start;
return a2;
}
}