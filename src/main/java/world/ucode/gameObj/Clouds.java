package world.ucode.gameObj;

import world.ucode.utils.GetResource;
import static world.ucode.main.GameGeometry.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Clouds {
    private BufferedImage img;
    private ArrayList<Cloud> clouds;

    public Clouds() {
        img = GetResource.getImage("cloud.png");
        clouds = new ArrayList<Cloud>();

        Cloud cloud = new Cloud();
        cloud.posX = 100;
        cloud.posY = 50;
        clouds.add(cloud);

        Cloud cloud1 = new Cloud();
        cloud1.posX = 210;
        cloud1.posY = 80;
        clouds.add(cloud1);

        Cloud cloud4 = new Cloud();
        cloud4.posX = 350;
        cloud4.posY = 135;
        clouds.add(cloud4);

        Cloud cloud2 = new Cloud();
        cloud2.posX = 450;
        cloud2.posY = 50;
        clouds.add(cloud2);

        Cloud cloud3 = new Cloud();
        cloud3.posX = 550;
        cloud3.posY = 60;
        clouds.add(cloud3);

    }
    public void update() {
        for (Cloud cl : clouds) {
            cl.posX -= CLOUDS_SPEED;
        }
        if (clouds.get(0).posX + img.getWidth() < 0) {
            clouds.get(0).posX = 600;
            clouds.add(clouds.get(0));
            clouds.remove(0);
        }
    }
    public void draw(Graphics g) {
        for (Cloud cl : clouds) {
            g.drawImage(img, (int)cl.posX, (int)cl.posY, null);
        }
    }
    private class Cloud {
        float posX;
        float posY;
    }
}
