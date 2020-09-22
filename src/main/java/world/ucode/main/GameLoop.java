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
    private BufferedImage gameoverPic;
    private BufferedImage restartPic;

    public GameLoop(GameGeometry gg) {
        ch = new Character(gg);
        t = new Thread(this);
        land = new Ground();
        cloud = new Clouds();
        cacti = new Cacti(ch);
        gameState = GameState.PLAY;
        gameoverPic = GetResource.getImage("gameover.png");
        restartPic = GetResource.getImage("restart.png");
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
            if (!ch.getIsAlive() && gameState != GameGeometry.GameState.GAMEOVER) {
                gameState = GameGeometry.GameState.GAMEOVER;
                ch.setCharacterState(CharacterState.DEAD);
                GetResource.playSound(this.getClass().getClassLoader().getResource("sounds/no-1.wav"));
            }
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.decode("#f7f7f7"));
        g.fillRect(0,0,getWidth(),getHeight());

        cloud.draw(g);
        land.draw(g);
        cacti.draw(g);
        ch.draw(g);
        drawScore(g);
        if (gameState == GameState.GAMEOVER) {
            g.drawImage(gameoverPic, SCREEN_WIDTH/2 - gameoverPic.getWidth()/2,
                    SCREEN_HEIGHT/4 - gameoverPic.getHeight()/2, null);
            g.drawImage(restartPic, SCREEN_WIDTH/2 - restartPic.getWidth()/2,
                    SCREEN_HEIGHT/4 + gameoverPic.getHeight(), null);
        }
    }

    private void drawScore(Graphics g) {
        g.setColor(Color.black);
        g.setFont(new Font("Calibri", Font.PLAIN, 15));

        if (System.currentTimeMillis() - prevTime > SLOW_TIME) {
            if (gameState == GameState.PLAY) {
                score++;
            }
            if (score % 100 == 0) {
                GetResource.playSound(this.getClass().getClassLoader().getResource("sounds/nice-work.wav"));
            }
            prevTime = System.currentTimeMillis();
        }
        g.drawString("HI " + String.valueOf(score), 500, 20);
    }

    private void resetGame() {
    	ch.setIsAlive(true);
    	// ch.setX setY
    	cacti.reset();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (gameState == GameState.PLAY) {
                ch.jump();
            } else if (gameState == GameState.GAMEOVER) {
                gameState = GameState.PLAY;
                resetGame();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
