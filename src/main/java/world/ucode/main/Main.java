package world.ucode.main;

public class Main {

    public static void main(String[] args) {

//        (new UserMenu()).startMenu();

        (new GameWindow(new GameGeometry())).startGame();
    }
}
