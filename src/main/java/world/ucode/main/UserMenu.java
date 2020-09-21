package world.ucode.main;

import world.ucode.utils.JFrame_settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMenu {

    private JFrame_settings frame;
    private Settings set;
    private GameGeometry gg;
//    private JFrame_settings settings;
    JLabel picture;

    public UserMenu() {
        frame = new JFrame_settings();
        gg = new GameGeometry();
        set = new Settings(this, gg);
//        settings = new JFrame_settings();

        ImageIcon pic = new ImageIcon(GameGeometry.imgPath + "rsz_t-rex.png");
        picture = new JLabel(pic);
        picture.setPreferredSize(new Dimension(200, 200));

        JPanel pane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        pane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        pane.add(Box.createVerticalGlue());

        JLabel label = new JLabel("Dino's Adventure");
        label.setFont(new Font("Calibri", Font.PLAIN, 20));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(label);

        pane.add(Box.createVerticalGlue());
        pane.add(buttonPanel());
        pane.add(Box.createVerticalGlue());

        frame.add(pane, BorderLayout.CENTER);
        frame.add(picture, BorderLayout.LINE_START);
    }
    /** Create button panel. */
    private JPanel buttonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
//        buttonPanel.setLayout(new GridLayout(0, 1));
//        buttonPanel.setPreferredSize(new Dimension(80, 80));

        JButton play = frame.addButton("Play");
        play.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                (new GameWindow(gg)).startGame();
                frame.setVisible(false);
            }
        });
        buttonPanel.add(play);

        JButton settings = frame.addButton("Settings");
        settings.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                set.startSettings();
                frame.setVisible(false);
            }
        });
        buttonPanel.add(settings);

        JButton exit = frame.addButton("Exit");
        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) { System.exit(0); }
        });
        buttonPanel.add(exit);

        return buttonPanel;
    }

    public void startMenu() {
        frame.setVisible(true);
    }
}
