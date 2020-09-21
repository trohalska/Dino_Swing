package world.ucode.gameObj;

import world.ucode.utils.GetResource;
import static world.ucode.main.GameGeometry.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Cacti {

    private ArrayList<Enemy> enemies;
    private BufferedImage cactus1, cactus2;
    private Random random;
    private Character ch;


    public Cacti(Character ch) {
        this.ch = ch;
        enemies = new ArrayList<Enemy>();
        random = new Random();
        cactus1 = GetResource.getImage(imgPath + "cactus1.png");
        cactus2 = GetResource.getImage(imgPath + "cactus2.png");

        enemies.add(getRandomCactus());
    }

    public void update() {
        for (Enemy e : enemies) {
            e.update();
//            if (!ch.getIsAlive()) { //
//
//            }
            if (e.getBound().intersects(ch.getBounds())) {
                ch.setIsAlive(false);
            }
        }
        Enemy first = enemies.get(0);
        if (first.isOutOfScreen()) {
            enemies.remove(first);
            enemies.add(getRandomCactus());
        }
    }

    public void draw(Graphics g) {
        for (Enemy e : enemies) {
            e.draw(g);
        }
    }

    private Cactus getRandomCactus() {
        Cactus cactus = new Cactus(ch);
        cactus.setCactusX(600);
        if (random.nextBoolean()) {
            cactus.setImg(cactus1);
        } else {
            cactus.setImg(cactus2);
        }
        return cactus;
    }
}
