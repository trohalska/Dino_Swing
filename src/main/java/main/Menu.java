package main;

import coordinates.Coordinates;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends JFrame {

    private coordinates.Coordinates coo = new Coordinates();

    private JButton addButton(String text) {
        JButton button = new JButton(text);
        button.setBounds(50,100,120,30);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMargin(new Insets(10,10,10,10));

        return button;
    }

    public Menu() {
        super("Java T-Rex game");
        setSize(coo.SCREEN_WIDTH, coo.SCREEN_HEIGHT);
        setLocationRelativeTo(null);

        Container pane = new Container();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Dino's Adventure");
        label.setFont(new Font("Calibri", Font.PLAIN, 14));;
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(label);

//        final JTextField tf = new JTextField();
//        tf.setBounds(50,50, 150,20);

        JButton play = addButton("Play");
        play.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                (new game.GameWindow()).startGame();
                setVisible(false);
            }
        });
        pane.add(play);

        JButton exit = addButton("Exit");
        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) { System.exit(0); }
        });
        pane.add(exit);

        add(pane);
    }

    public void startMenu() {
        setVisible(true);
    }
}
