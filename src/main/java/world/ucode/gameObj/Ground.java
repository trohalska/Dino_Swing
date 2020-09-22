package world.ucode.gameObj;

import world.ucode.utils.GetResource;
import static world.ucode.main.GameGeometry.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Ground {

    private class ImageLand {
        int posX;
        BufferedImage img;
    }
    private ArrayList<ImageLand> landList;
    private BufferedImage land1, land2, land3;
    private Random random;

    public Ground() {
        landList = new ArrayList<ImageLand>();
        random = new Random();
        land1 = GetResource.getImage("land1.png");
        land2 = GetResource.getImage("land2.png");
        land3 = GetResource.getImage("land3.png");
        int numLands = SCREEN_WIDTH / land1.getWidth() + 2;

        for (int i = 0; i < numLands; ++i) {
            landList.add(NewLand(i));
        }
    }

    private ImageLand NewLand(int i) {
        ImageLand imgL = new ImageLand();
        imgL.posX = (int) (i * land1.getWidth());
        imgL.img = getRandomGround();

        return imgL;
    }


    public void update() {
        for (ImageLand iL : landList) {
            iL.posX -= LAND_SPEED;
        }
        if (landList.get(0).posX + land1.getWidth() < 0) {
            ImageLand imgL = new ImageLand();
            imgL.posX = landList.get(landList.size() - 1).posX + land1.getWidth();
            imgL.img = getRandomGround();
            landList.add(imgL);

            landList.remove(0);
        }
    }
    public void draw(Graphics g) {
        for (ImageLand iL : landList) {
            g.drawImage(iL.img, iL.posX, (int)LAND_Y, null);
        }
    }
    private BufferedImage getRandomGround() {
        int i = random.nextInt(10);
        return (switch(i) {
           case 0 -> land1;
           case 1,2,3,4,5,6,7,8 -> land2;
           default -> land3;
        });
    }
}
