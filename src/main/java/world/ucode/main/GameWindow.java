package world.ucode.main;

import world.ucode.utils.JFrame_settings;

public class GameWindow {

    private JFrame_settings frame;
    private GameLoop loop;

    public GameWindow(GameGeometry gg) {
        frame = new JFrame_settings();
        loop = new GameLoop(gg);
        frame.addKeyListener(loop);
        frame.add(loop);
    }

    public void startGame() {
        frame.setVisible(true);
        loop.startGame();
    }
}
