package databaselogin.main;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class SecondFrame extends JFrame{
    
    public SecondFrame(){
        JLabel label = new JLabel("Welcome");
        add(label);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
