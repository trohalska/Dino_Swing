package world.ucode.gameObj;

import world.ucode.main.GameGeometry;
import world.ucode.utils.Animation;
import world.ucode.utils.GetResource;
import static world.ucode.main.GameGeometry.*;

import java.awt.*;

public class Character {
    private float posX;
    private float posY;
    private float speedY;
    private GameGeometry gg;
    private Animation dinoRun;
    private Rectangle rect;
    private boolean isAlive = true;

    public Character(GameGeometry gg) {
        dinoRun = new Animation(SLOW_TIME);
        this.gg = gg;
        rect = new Rectangle();

        switch(gg.getDinoSkin()) {
            case RED -> {
                dinoRun.addFrame(GetResource.getImage(imgPath + "ch1-red.png"));
                dinoRun.addFrame(GetResource.getImage(imgPath + "ch2-red.png"));
            }
            case GREEN -> {
                dinoRun.addFrame(GetResource.getImage(imgPath + "ch1-green.png"));
                dinoRun.addFrame(GetResource.getImage(imgPath + "ch2-green.png"));
            }
            default -> {
                dinoRun.addFrame(GetResource.getImage(imgPath + "ch1.png"));
                dinoRun.addFrame(GetResource.getImage(imgPath + "ch2.png"));
            }
        }
        speedY = 0;
        posX = DINO_GROUND_X;
        posY = DINO_GROUND_Y - dinoRun.getFrame().getHeight();
//        posY = 60;
        // dinoRun.addFrame(GetResource.getImage(imgPath + "ch1.png"));
        // dinoRun.addFrame(GetResource.getImage(imgPath + "ch2.png"));
    }

    public void update() {
        dinoRun.update();
        // for jumping
        if (posY >= DINO_GROUND_Y - dinoRun.getFrame().getHeight()) { // height of figure
            speedY = 0;
            posY = DINO_GROUND_Y - dinoRun.getFrame().getHeight();
        } else {
            speedY += GRAVITY;
            posY += speedY;
        }
        rect.x = (int) posX;
        rect.y = (int) posY;
        rect.width = dinoRun.getFrame().getWidth();
        rect.height = dinoRun.getFrame().getHeight();
    }

    public Rectangle getBounds() {
        return rect;
    }

    public void draw(Graphics g) {
        g.drawImage(dinoRun.getFrame(), (int)posX, (int)posY, null);
    }

    public void drawDead(Graphics g) {
        g.drawImage(GetResource.getImage(imgPath + "ch4.png"), (int)posX, (int)posY, null);
    }

    public void jump() {
        speedY = DINO_JUMP_SPEED;
        posY += speedY;
    }

    // getters and setters
    public void setIsAlive(boolean live) {
        isAlive = live;
    }
    public boolean getIsAlive() {
        return isAlive;
    }

}
