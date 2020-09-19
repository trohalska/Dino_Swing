package world.ucode.gameObj;

import world.ucode.utils.Animation;
import world.ucode.utils.GetResource;
import static world.ucode.main.GameGeometry.*;

import java.awt.*;

public class Character {
    private float x = 40;
    private float y = SCREEN_HEIGHT - 40;
    private float speedY = 0;

    private Animation dinoRun;

    public Character() {
        dinoRun = new Animation(100);
        dinoRun.addFrame(GetResource.getImage(imgPath + "main-character1.png"));
        dinoRun.addFrame(GetResource.getImage(imgPath + "main-character2.png"));
    }

    public void update() {
        dinoRun.update();
        // for jumping
        if (y >= DINO_GROUND_Y - dinoRun.getFrame().getHeight()) { // height of figure
            speedY = 0;
            y = DINO_GROUND_Y - dinoRun.getFrame().getHeight();
        } else {
            speedY += GRAVITY;
            y += speedY;
        }
    }

    public void draw(Graphics g) {
//        g.setColor(Color.black);
//        g.drawRect((int)x, (int)y, image.getWidth(), image.getHeight());
        g.drawImage(dinoRun.getFrame(), (int)x, (int)y, null);
    }

    public void jump() {
        speedY = DINO_JUMP_SPEED;
        y += speedY;
    }


    // getters and setters


}
