package coordinates;

import java.awt.*;

public class Coordinates {
    private float x = 0;
    private float y = 0;
    private float speedY = 0;

    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 400;

    public static final float GRAVITY = 0.1f;
    public static final float GROUND_Y = SCREEN_HEIGHT - 100;




    public void update() {
        // for jumping
        if (y >= GROUND_Y - 100) { // height of figure
            speedY = 0;
            y = GROUND_Y - 100;
        } else {
            speedY += GRAVITY;
            y += speedY;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.drawRect((int)x, (int)y, 100, 100);
    }

    public void jump() {
        speedY = -4;
        y += speedY;
    }


    // getters and setters


}
