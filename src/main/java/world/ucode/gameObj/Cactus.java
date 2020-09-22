package world.ucode.gameObj;

import world.ucode.utils.GetResource;
import static world.ucode.main.GameGeometry.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Cactus extends Enemy {

    private BufferedImage img;
    private int posX, posY;
    private Rectangle rect;
    private Character ch;

    public Cactus(Character ch) {
        this.ch = ch;
        img = GetResource.getImage("cactus1.png");
        rect = new Rectangle();
    }
    public void setCactusX(int x) {
        posX = x;
    }
    public void setImg(BufferedImage img) {
        posY = (int)DINO_GROUND_Y - img.getHeight();
        this.img = img;
    }

    @Override
    public Rectangle getBound() {
        return rect;
    }
    @Override
    public void update() {
        posX -= LAND_SPEED;
        rect.x = posX;
        rect.y = posY;
        rect.width = img.getWidth();
        rect.height = img.getHeight();
    }
    @Override
    public void draw(Graphics g) {
        g.drawImage(img, posX, posY, null);
    }

    @Override
    public boolean isOutOfScreen() { return (posX + img.getWidth() < 0); }
}
