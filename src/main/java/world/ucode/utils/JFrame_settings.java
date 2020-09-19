package world.ucode.utils;

import static world.ucode.main.GameGeometry.*;

import javax.swing.*;

public class JFrame_settings extends JFrame {

    public JFrame_settings() {
        super("Java T-Rex game");
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
}
