package world.ucode.main;

public class GameGeometry {

    public static final String imgPath = "src/main/resources/img/";

    /** SCREEN */
    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 220;

    /** POSITIONS */
    public static final float DINO_GROUND_X = 40;
    public static final float DINO_GROUND_Y = SCREEN_HEIGHT - 40;
    public static final float LAND_Y = SCREEN_HEIGHT - 60;

    /** SPEED */
    public static final int SLOW_TIME = 100;
    public static final float GRAVITY = 0.1f;
    public static final int DINO_JUMP_SPEED = -4;
    public static final int LAND_SPEED = 4;
    public static final int CLOUDS_SPEED = 1;

    /** SKIN COLOR */
    public enum ColorSkin {
        NORMAL,
        RED,
        GREEN
    }
    private ColorSkin dinoSkin = ColorSkin.NORMAL;
    public ColorSkin getDinoSkin() {
        return dinoSkin;
    }
    public void setDinoSkin(ColorSkin newValue) {
        dinoSkin = newValue;
    }

    /** SKIN GAME_STATE */
    public enum GameState {
        NORMAL,
        PLAY,
        GAMEOVER
    }
}
