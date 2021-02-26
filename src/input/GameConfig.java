package input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 Klasa zczytujaca cala konfiguracje naszej gry zaczynajac od zyc naszego bohatera, jego polozenia poczatkowego, prędkości itp
 */

public class GameConfig {

    private static File file;

    private static int life;


    private static int xAxisHero;
    private static int yAxisHero;
    private static int speedHero;
    private static boolean isAliveHero;
    private static int size;
    private static int xG1,yG1,speedG1,xG2,yG2,speedG2,xG3,yG3,speedG3,xG4,yG4,speedG4,xG5,yG5,speedG5,xG6,yG6,speedG6;
    private static int button1x;
    private static int button2x;
    private static int button2y;
    private static int button3x;



    private static int button3y;
    private static int button1y;
    private static int bonus1x1;
    private static int bonus2x1;
    private static int bonus1x3;
    private static int bonus1y3;
    private static int bonus2x3;
    private static int bonus2y3;



    private static int bonus3x3;
    private static int bonus3y3;
    private static int bonus1y1;
    private static int bonus2y1;
    private static int bonus3x1;
    private static int bonus3y1;
    private static int bonus1x2;
    private static int bonus1y2;
    private static int bonus2x2;
    private static int bonus2y2;


    private static int bonus3x2;
    private static int bonus3y2;
    private static Scanner scanner;
    private static String fileName;

    /**
     * Konstruktor wczytujacy nasz plik i parsujacy go
     */
    public GameConfig(String fileName) {
        fileName = fileName;
        loadConfig(fileName);
        parseConfig();
    }

    /**
     * Funkcja, ktora wczytuje nasz plik
     * @param fileName - nazwa pliku
     */
    public static void loadConfig(String fileName) {

        file = new File(fileName);
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Funkcja, ktora odpowiedmio zmienia nasze wczytane dane na inty, booleany, chary itd
     */

    public static void parseConfig() {
        String temp = scanner.nextLine();
        life = Integer.parseInt(temp);
        temp = scanner.nextLine();
        xAxisHero = Integer.parseInt(temp);
        temp = scanner.nextLine();
        yAxisHero = Integer.parseInt(temp);
        temp = scanner.nextLine();
        speedHero = Integer.parseInt(temp);
        temp = scanner.nextLine();
        isAliveHero = Boolean.parseBoolean(temp);
        temp = scanner.nextLine();
        size = Integer.parseInt(temp);
        temp = scanner.nextLine();
        xG1 = Integer.parseInt(temp);
        temp = scanner.nextLine();
        yG1 = Integer.parseInt(temp);
        temp = scanner.nextLine();
        speedG1 = Integer.parseInt(temp);
        temp = scanner.nextLine();
        xG2 = Integer.parseInt(temp);
        temp = scanner.nextLine();
        yG2 = Integer.parseInt(temp);
        temp = scanner.nextLine();
        speedG2 = Integer.parseInt(temp);
        temp = scanner.nextLine();
        button1x= Integer.parseInt(temp);
        temp = scanner.nextLine();
        button1y= Integer.parseInt(temp);
        temp = scanner.nextLine();
        bonus1x1= Integer.parseInt(temp);
        temp = scanner.nextLine();
        bonus1y1= Integer.parseInt(temp);
        temp = scanner.nextLine();
        bonus2x1= Integer.parseInt(temp);
        temp = scanner.nextLine();
        bonus2y1= Integer.parseInt(temp);
        temp = scanner.nextLine();
        bonus3x1= Integer.parseInt(temp);
        temp = scanner.nextLine();
        bonus3y1= Integer.parseInt(temp);
        temp = scanner.nextLine();
        xG3 = Integer.parseInt(temp);
        temp = scanner.nextLine();
        yG3 = Integer.parseInt(temp);
        temp = scanner.nextLine();
        speedG3 = Integer.parseInt(temp);
        temp = scanner.nextLine();
        xG4 = Integer.parseInt(temp);
        temp = scanner.nextLine();
        yG4 = Integer.parseInt(temp);
        temp = scanner.nextLine();
        speedG4 = Integer.parseInt(temp);
        temp = scanner.nextLine();
        button2x= Integer.parseInt(temp);
        temp = scanner.nextLine();
        button2y= Integer.parseInt(temp);
        temp = scanner.nextLine();
        bonus1x2= Integer.parseInt(temp);
        temp = scanner.nextLine();
        bonus1y2= Integer.parseInt(temp);
        temp = scanner.nextLine();
        bonus2x2= Integer.parseInt(temp);
        temp = scanner.nextLine();
        bonus2y2= Integer.parseInt(temp);
        temp = scanner.nextLine();
        bonus3x2= Integer.parseInt(temp);
        temp = scanner.nextLine();
        bonus3y2= Integer.parseInt(temp);
        temp = scanner.nextLine();
        xG5 = Integer.parseInt(temp);
        temp = scanner.nextLine();
        yG5 = Integer.parseInt(temp);
        temp = scanner.nextLine();
        speedG5 = Integer.parseInt(temp);
        temp = scanner.nextLine();
        xG6 = Integer.parseInt(temp);
        temp = scanner.nextLine();
        yG6 = Integer.parseInt(temp);
        temp = scanner.nextLine();
        speedG6 = Integer.parseInt(temp);
        temp = scanner.nextLine();
        button3x= Integer.parseInt(temp);
        temp = scanner.nextLine();
        button3y= Integer.parseInt(temp);
        temp = scanner.nextLine();
        bonus1x3= Integer.parseInt(temp);
        temp = scanner.nextLine();
        bonus1y3= Integer.parseInt(temp);
        temp = scanner.nextLine();
        bonus2x3= Integer.parseInt(temp);
        temp = scanner.nextLine();
        bonus2y3= Integer.parseInt(temp);
        temp = scanner.nextLine();
        bonus3x3= Integer.parseInt(temp);
        temp = scanner.nextLine();
        bonus3y3= Integer.parseInt(temp);
    }


    public static int getLife() {
        return life;
    }

    public static int getxAxisHero() {
        return xAxisHero;
    }

    public static int getyAxisHero() {
        return yAxisHero;
    }

    public static boolean isIsAliveHero() {
        return isAliveHero;
    }

    public static int getSpeedHero() {
        return speedHero;
    }

    public static int getSize() { return size; }

    public static int getxG1() { return xG1; }

    public static int getyG1() { return yG1; }

    public static int getSpeedG1() { return speedG1; }

    public static int getxG2() { return xG2; }

    public static int getyG2() { return yG2; }

    public static int getSpeedG2() { return speedG2; }

    public static int getButton1x() { return button1x; }

    public static int getButton1y() { return button1y; }

    public static int getBonus1x1() { return bonus1x1; }

    public static int getBonus1y1() { return bonus1y1; }

    public static int getBonus2x1() { return bonus2x1; }

    public static int getBonus2y1() { return bonus2y1; }

    public static int getBonus3x1() { return bonus3x1; }

    public static int getBonus3y1() { return bonus3y1; }

    public static int getxG3() {
        return xG3;
    }

    public static int getyG3() {
        return yG3;
    }

    public static int getSpeedG3() {
        return speedG3;
    }

    public static int getxG4() {
        return xG4;
    }

    public static int getyG4() {
        return yG4;
    }

    public static int getSpeedG4() {
        return speedG4;
    }

    public static int getButton2x() {
        return button2x;
    }

    public static int getButton2y() {
        return button2y;
    }

    public static int getBonus1x2() {
        return bonus1x2;
    }

    public static int getBonus1y2() {
        return bonus1y2;
    }

    public static int getBonus2x2() {
        return bonus2x2;
    }

    public static int getBonus2y2() {
        return bonus2y2;
    }

    public static int getBonus3x2() {
        return bonus3x2;
    }

    public static int getBonus3y2() {
        return bonus3y2;
    }

    public static int getxG5() {
        return xG5;
    }

    public static int getyG5() {
        return yG5;
    }

    public static int getSpeedG5() {
        return speedG5;
    }

    public static int getxG6() {
        return xG6;
    }

    public static int getyG6() {
        return yG6;
    }

    public static int getSpeedG6() {
        return speedG6;
    }

    public static int getButton3x() {
        return button3x;
    }

    public static int getButton3y() {
        return button3y;
    }

    public static int getBonus1x3() {
        return bonus1x3;
    }

    public static int getBonus1y3() {
        return bonus1y3;
    }

    public static int getBonus2x3() {
        return bonus2x3;
    }

    public static int getBonus2y3() {
        return bonus2y3;
    }

    public static int getBonus3x3() {
        return bonus3x3;
    }

    public static int getBonus3y3() {
        return bonus3y3;
    }

}