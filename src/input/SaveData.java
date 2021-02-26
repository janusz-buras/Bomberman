package input;

import java.io.*;
/**
 * klasa odpowiadająca za zapisywanie wyniku do pliku
 */
public class SaveData {


    public SaveData(int score, String nick) throws IOException {
        Writer output= new BufferedWriter(new FileWriter("ranking.txt",true));

        output.append(nick + "\n" + score+"\n");
        output.close();
    }


}
