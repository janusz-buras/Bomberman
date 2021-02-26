package core.gamestates;

import input.SaveData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
/**
 * klasa odpowiadająca za tworzenie nowego okna aby wyświetlić wyniki
 */
public class Ranking extends JFrame implements ActionListener {

    JLabel nazwa,nr1,nr2,nr3,nr4,nr5;
    JButton bConfirm;
    private int fontSize=24;
    public Font font=new Font("Calibri", Font.BOLD, fontSize);

    public Ranking(int stab[], String ntab[]){
        setSize(260,280);
        setTitle("RANKING");
        setLayout(null);

        nazwa = new JLabel("   WYNIK NICK");
        nazwa.setBounds(40,10,250,30);
        nazwa.setFont(font);
        add(nazwa);

        nr1 = new JLabel("1. "+stab[0] + " "+ ntab[0]);
        nr1.setBounds(40,40,250,30);
        nr1.setFont(font);
        add(nr1);

        nr2 = new JLabel("2. "+stab[1] + " "+ ntab[1]);
        nr2.setBounds(40,70,250,30);
        nr2.setFont(font);
        add(nr2);

        nr3 = new JLabel("3. "+stab[2] + " "+ ntab[2]);
        nr3.setBounds(40,100,250,30);
        nr3.setFont(font);
        add(nr3);

        nr4 = new JLabel("4. "+stab[3] + " "+ ntab[3]);
        nr4.setBounds(40,130,250,30);
        nr4.setFont(font);
        add(nr4);

        nr5 = new JLabel("5. "+stab[4] + " "+ ntab[4]);
        nr5.setBounds(40,160,250,30);
        nr5.setFont(font);
        add(nr5);




        bConfirm = new JButton("Okej");
        bConfirm.setBounds(70,200,100,20);
        add(bConfirm);
        bConfirm.addActionListener(this);


    }

    public void actionPerformed(ActionEvent e) {
        dispose();
    }
    }


