package world.ucode.main;

import world.ucode.gameObj.Character;
import world.ucode.gameObj.Ground;
import static world.ucode.main.GameGeometry.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameLoop extends JPanel implements Runnable, KeyListener {
//    private static final float GRAVITY = 0.1f;
//    private static final float GROUND_Y = 300;  // pixels
//
    private Character ch;
    private Thread t;
    private Ground land;

    public GameLoop() {
//        setBackground(Color.RED);
        ch = new Character();
        t = new Thread(this);
        land = new Ground();
    }

    public void startGame() {
        t.start();
    }

    public void run() {
        while(true) {
            try {
                ch.update();
                land.update();
                repaint();
                t.sleep(20);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.decode("#f7f7f7"));
        g.fillRect(0,0,getWidth(),getHeight());
//        g.setColor(Color.red);
//        g.drawLine(0, (int)GROUND_Y, getWidth(), (int)GROUND_Y);
        land.draw(g);
        ch.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        ch.jump();
//        System.out.println("key pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        System.out.println("key released");
    }
}
