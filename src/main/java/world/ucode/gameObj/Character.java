package world.ucode.gameObj;

import world.ucode.main.GameGeometry;
import world.ucode.utils.Animation;
import world.ucode.utils.GetResource;
import static world.ucode.main.GameGeometry.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Character {
    private float posX;
    private float posY;
    private float speedY;

    private GameGeometry gg;
    private Animation dinoRun;
    private BufferedImage dinoJump;
    private BufferedImage dinoDead;
    private Rectangle rect;
    private boolean isAlive = true;
    private GameGeometry.CharacterState state;

    public Character(GameGeometry gg) {
        dinoRun = new Animation(SLOW_TIME);
        this.gg = gg;
        rect = new Rectangle();
        state = CharacterState.NORMAL;

        switch(gg.getDinoSkin()) {
            case RED -> setCharacterSkin("rch1.png", "rch2.png", "rch3.png", "rch4.png");
            case GREEN -> setCharacterSkin("gch1.png", "gch2.png", "gch3.png", "gch4.png");
            default -> setCharacterSkin("ch1.png", "ch2.png", "ch3.png", "ch4.png");
        }
        speedY = 0;
        posX = DINO_GROUND_X;
        posY = DINO_JUMP_Y;
    }

    private void setCharacterSkin(String s1, String s2, String s3, String s4) {
        dinoRun.addFrame(GetResource.getImage(s1));
        dinoRun.addFrame(GetResource.getImage(s2));
        dinoJump = GetResource.getImage(s3);
        dinoDead = GetResource.getImage(s4);
    }

    public void update() {
        dinoRun.update();
        // for jumping
        if (posY >= DINO_JUMP_Y) {
            posY = DINO_JUMP_Y;
            state = CharacterState.NORMAL;
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
        switch(state) {
            case JUMP -> g.drawImage(dinoJump, (int) posX, (int) posY, null);
            case DEAD -> g.drawImage(dinoDead, (int) posX, (int) posY, null);
            default -> g.drawImage(dinoRun.getFrame(), (int) posX, (int) posY, null);
        }
    }

    public void jump() {
        if (posY >= DINO_JUMP_Y) {
            GetResource.playSound(this.getClass().getClassLoader().getResource("sounds/come-on-1.wav"));
            speedY = DINO_JUMP_SPEED;
            //        speedY = -7. 5f;
            posY += speedY;
            state = CharacterState.JUMP;
        }
    }

    // getters and setters
    public void setIsAlive(boolean live) {
        isAlive = live;
    }
    public boolean getIsAlive() {
        return isAlive;
    }
    public void setCharacterState(GameGeometry.CharacterState state) {
        this.state = state;
    }
}
