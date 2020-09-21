package world.ucode.main;

import world.ucode.gameObj.Character;
import world.ucode.gameObj.Clouds;
import world.ucode.gameObj.Ground;
import world.ucode.gameObj.Cacti;
import world.ucode.utils.GetResource;
import static world.ucode.main.GameGeometry.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class GameLoop extends JPanel implements Runnable, KeyListener {

    private Character ch;
    private Thread t;
    private Ground land;
    private Clouds cloud;
    private Cacti cacti;
    private int score;
    private long prevTime;

    private GameGeometry.GameState gameState;
    private BufferedImage gameOverPic;

    public GameLoop(GameGeometry gg) {
        ch = new Character(gg);
        t = new Thread(this);
        land = new Ground();
        cloud = new Clouds();
        cacti = new Cacti(ch);
        gameState = GameGeometry.GameState.NORMAL;
        gameOverPic = GetResource.getImage(imgPath + "gameover_text.png");
    }

    public void startGame() {
        t.start();
    }

    public void run() {
        while(true) {
            try {
                update();
                repaint();
                t.sleep(20);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        if (gameState == GameState.PLAY) {
            cloud.update();
            land.update();
            cacti.update();
            ch.update();
            if (!ch.getIsAlive()) {
                gameState = GameGeometry.GameState.GAMEOVER;
            }
        }
    }

//    public void handleScore(int score) {
//        this.score += score;
//    }

    public void paint(Graphics g) {
        g.setColor(Color.decode("#f7f7f7"));
        g.fillRect(0,0,getWidth(),getHeight());

//        g.drawLine(0, (int)GROUND_Y, getWidth(), (int)GROUND_Y);
        switch(gameState) {
            case PLAY -> {
                cloud.draw(g);
                land.draw(g);
                cacti.draw(g);
                ch.draw(g);
                drawScore(g);
            }
            case GAMEOVER -> {
                cloud.draw(g);
                land.draw(g);
                cacti.draw(g);
                ch.drawDead(g);
                g.drawImage(gameOverPic, SCREEN_WIDTH/2 - gameOverPic.getWidth()/2,
                        SCREEN_HEIGHT/4 - gameOverPic.getHeight()/2, null);
            }
            default -> { // normal
                ch.draw(g);
            }
        }
    }

    private void drawScore(Graphics g) {
        g.setColor(Color.black);
        g.setFont(new Font("Calibri", Font.PLAIN, 15));

        if (System.currentTimeMillis() - prevTime > SLOW_TIME) {
            score++;
            prevTime = System.currentTimeMillis();
        }
        g.drawString("HI " + String.valueOf(score), 500, 20);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println("key pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (gameState == GameState.NORMAL) {
                gameState = GameState.PLAY;
            } else if (gameState == GameState.PLAY) {
                ch.jump();
            }
        }
//        System.out.println("key released");
    }
}
