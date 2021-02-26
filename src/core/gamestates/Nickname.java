package core.gamestates;

import input.SaveData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
/**
 * klasa odpowiadająca za wpisywanie nicku po wygranej w nowym oknie
 */
public class Nickname extends JFrame implements ActionListener {

    JLabel lnick;
    JLabel lscore;
    JTextField tnick;
    JButton bConfirm;
    private static String tempNick;
    private static String nick;
    private static int score;
    public SaveData saveData;


    public Nickname(String fileName,int score) throws IOException {

        setSize(400,150);
        setTitle("Wpis do rankingu");
        setLayout(null);

        lscore = new JLabel("Twój wynik:  "+score);
        lscore.setBounds(40,20,150,20);
        add(lscore);

        lnick = new JLabel("Wprowadź swój nick:");
        lnick.setBounds(40,40,150,20);
        add(lnick);

        tnick = new JTextField("Anonim");
        tnick.setBounds(190,40,150,20);
        add(tnick);


        bConfirm = new JButton("Okej");
        bConfirm.setBounds(250,70,100,20);
        add(bConfirm);
        bConfirm.addActionListener(this);

        this.score=score;
    }


    public void actionPerformed(ActionEvent e) {
        tempNick = tnick.getText();
        System.out.println(tempNick);
        nick=tempNick;
        try {
            saveData=new SaveData(score, nick);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
            dispose();
    }
}
