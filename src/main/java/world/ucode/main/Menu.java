package world.ucode.main;

import world.ucode.utils.JFrame_settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {

    private JFrame_settings frame;

    private JButton addButton(String text) {
        JButton button = new JButton(text);
//        button.setBounds(50,100,120,30);
//        button.setPreferredSize(new Dimension(500, 300));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMargin(new Insets(10,10,10,10));

        return button;
    }

//    private void addSpacing(Container pane, int height) {
//        pane.add(Box.createRigidArea(new Dimension(0, height)));
//    }

    public Menu() {
        frame = new JFrame_settings();

        Container pane = new Container();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        pane.add(Box.createVerticalGlue());

        JLabel label = new JLabel("Dino's Adventure");
        label.setFont(new Font("Calibri", Font.PLAIN, 20));
//        label.setPreferredSize(new Dimension(500, 300));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(label);

        pane.add(Box.createVerticalGlue());
//        addSpacing(pane, 40); // --------- spacing

        JButton play = addButton("Play");
        play.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                (new GameWindow()).startGame();
                frame.setVisible(false);
            }
        });
        pane.add(play);

        pane.add(Box.createVerticalGlue());
//        addSpacing(pane, 20); // --------- spacing

        JButton exit = addButton("Exit");
        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) { System.exit(0); }
        });
        pane.add(exit);

        pane.add(Box.createVerticalGlue());
        frame.add(pane);
    }

    public void startMenu() {
        frame.setVisible(true);
    }
}
