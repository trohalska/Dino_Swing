package world.ucode.utils;

import static world.ucode.main.GameGeometry.*;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class GetResource {

    public static BufferedImage getImage(String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(imgPath + path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    public static void playSound(URL url) {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        }
        catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

}
