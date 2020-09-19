package world.ucode.utils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Animation {
    private List<BufferedImage> frames;
    private int currentFrame = 0;
    private int slowTime;
    private long prevTime;

    public Animation(int slowTime) {
        this.slowTime = slowTime;
        frames = new ArrayList<BufferedImage>();
    }

    public void update() {
        if (System.currentTimeMillis() - prevTime > slowTime) {
            currentFrame++;
            if (currentFrame >= frames.size()) {
                currentFrame = 0;
            }
            prevTime = System.currentTimeMillis();
        }
    }

    public void addFrame(BufferedImage frame) {
        frames.add(frame);
    }

    public BufferedImage getFrame() {
        if (frames.size() > 0) {
            return frames.get(currentFrame);
        }
        return null;
    }

}
