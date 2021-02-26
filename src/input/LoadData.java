package input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
/**
 *klasa wczytujaca z pliku txt dane potrzebne do utworzenia naszej mapy
 */
public class LoadData {
    private File file;
    private int[][] map = new int[GameConfig.getSize()][GameConfig.getSize()];
    private Scanner scanner;
    private String fileName;

    /**
     * wczytanie naszego pliku i obsługa wyjatkow
     * @param fileName - nazwa pliku
     */
    public LoadData(String fileName){
        this.fileName = fileName;
        this.file = new File(fileName);
        try {
            this.scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * funkcja, ktora odczytuje plik i wstawia poszczegolne wartosci do tabeli dwuwymiarowej intow
     */
public void readDataFromFile() {
    String tempScannerValue;
    int temp;
    int y = 0;
    while (this.scanner.hasNextLine()) {
        tempScannerValue = this.scanner.nextLine();
        for (int x = 0; x < GameConfig.getSize(); x++) {
            temp = Character.getNumericValue(tempScannerValue.charAt(x));
            map[x][y] = temp;
        }
        y++;
    }
}

    /**
     * wyswietlenie calej tabeli dwuwymiarowej
     */
    public void  printBoard(){
        for (int i = 0; i < 15; i++){
            for (int j = 0; j < 15; j++)
                System.out.println(map[j][i]);
            System.out.println("\n");
        }

    }



    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
