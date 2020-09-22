package world.ucode.utils;

import static world.ucode.main.GameGeometry.*;

import javax.swing.*;
import java.awt.*;

public class JFrame_settings extends JFrame {

    public JFrame_settings() {
        super("Java T-Rex game");
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    /** Create one button. */
    public JButton addButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMargin(new Insets(5,10,5,10));

        return button;
    }
}
