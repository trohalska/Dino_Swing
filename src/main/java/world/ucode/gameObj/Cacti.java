package world.ucode.gameObj;

import world.ucode.utils.GetResource;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Cacti {

    private ArrayList<Enemy> enemies;
    private BufferedImage cactus1, cactus2, cactus3, cactus4, cactus5;
    private Random random;
    private Character ch;


    public Cacti(Character ch) {
        this.ch = ch;
        enemies = new ArrayList<Enemy>();
        random = new Random();
        cactus1 = GetResource.getImage("cactus1.png");
        cactus2 = GetResource.getImage("cactus2.png");
//        cactus3 = GetResource.getImage("cactus3.png");
//        cactus4 = GetResource.getImage("cactus4.png");
//        cactus5 = GetResource.getImage("cactus5.png");

        enemies.add(getRandomCactus());
    }

    public void update() {
        for (Enemy e : enemies) {
            e.update();
            if (e.getBound().intersects(ch.getBounds())) {
                ch.setIsAlive(false);
            }
        }
        Enemy first = enemies.get(0);  /// mdannik знайшов краш )))
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

    public void reset() {
        enemies.clear();
        enemies.add(getRandomCactus());
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

//    private BufferedImage resize(BufferedImage img) {
//        int newW = 0, newH = 0;
//        if (img == cactus1 || img == cactus3 || img == cactus5) {
//            newW = 49;
//            newH = 33;
//        } else {
//            newW = 23;
//            newH = 46;
//        }
//
//        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
//        return dimg;
//    }
}
