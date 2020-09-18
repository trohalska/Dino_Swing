package game;

import coordinates.Coordinates;
import javax.swing.*;

public class GameWindow extends JFrame {

    private coordinates.Coordinates coo = new Coordinates();
    private GameLoop loop;

    public GameWindow() {
        super("Java T-Rex game");
        setSize(coo.SCREEN_WIDTH, coo.SCREEN_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // deletable
//        String iconPath = "/src/main/resources/main-character1.png";
//        ImageIcon img = new ImageIcon(iconPath);
//        setIconImage(img.getImage());

        loop = new GameLoop();
        addKeyListener(loop);
        add(loop);
    }

    public void startGame() {
        setVisible(true);
        loop.startGame();
    }
}
