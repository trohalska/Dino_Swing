package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameLoop extends JPanel implements Runnable, KeyListener {
//    private static final float GRAVITY = 0.1f;
//    private static final float GROUND_Y = 300;  // pixels
//
    private coordinates.Coordinates ch;
    private Thread t;

    public GameLoop() {
//        setBackground(Color.RED);
        t = new Thread(this);
        ch = new coordinates.Coordinates();
    }

    public void startGame() {
        t.start();
    }

    public void run() {
        while(true) {
            try {
                ch.update();
                repaint();
                t.sleep(20);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.red);
        g.drawLine(0, (int)ch.GROUND_Y, getWidth(), (int)ch.GROUND_Y);
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
