package world.ucode.main;

import world.ucode.settings.CharacterSkin;
import world.ucode.utils.JFrame_settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings {
    private JFrame_settings frame;
    private UserMenu menu;

    public Settings(UserMenu usermenu, GameGeometry gg) {
        frame = new JFrame_settings();
        menu = usermenu;

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalGlue());

        JLabel label = new JLabel("Settings");
        label.setFont(new Font("Calibri", Font.PLAIN, 20));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);

        panel.add(Box.createVerticalGlue());

        /** Create and set up the content pane. */
        JPanel settingsPanel = new JPanel();
        settingsPanel.add(new CharacterSkin(gg));
        panel.add(settingsPanel);

        panel.add(Box.createVerticalGlue());

        JButton ret = frame.addButton("Return");
        ret.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                menu.startMenu();
                frame.setVisible(false);
            }
        });
        panel.add(ret);

        panel.add(Box.createVerticalGlue());

        frame.add(panel);
    }

    public void startSettings() {
        frame.setVisible(true);
    }
}
