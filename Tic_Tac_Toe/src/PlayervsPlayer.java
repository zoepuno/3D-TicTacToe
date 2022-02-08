import java.lang.Math;
import java.util.Scanner;
public class PlayervsPlayer {
    Game gamepull = new Game();
    Location area = new Location(0, 0, 0);
    char player;


    char player2;
    int col;
    int row;
    int sheet;

    public void XorO() {
        if (Math.random() * 1 == 0) {
            player = 'x';
            player2 = 'o';
            gamepull.playerturn = true;
        } else {
            player2 = 'x';
            player = 'o';
            gamepull.playerturn = false;
        }
    }

    public void theMainPlayerGame() {
        Scanner in = new Scanner(System.in);
        gamepull.setSTATUS(1);
        XorO();


    }
}
