import java.util.ArrayList;

public class Game implements PlayerInt {
    public int STATUS=0;
    public int PLAYING=1;
    public int PlAYER1_WON=2;
    public int PLAYER1_LOST=3;
    public int PlAYER2_WON=2;
    public int PLAYER2_LOST=3;
    public int AI1_WON=2;
    public int AI1_LOST=3;
    public int AI2_WON=2;
    public int AI2_LOST=3;
    ArrayList playerNames= new ArrayList<String>();

    public int getSTATUS(){
        return STATUS;
    }
    public void reset(){
        STATUS=PLAYING;
    }


    @Override
    public char getLetter() {
        return 0;
    }

    @Override
    public Location getMove(char[][][] board) {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public PlayerInt freshCopy(char letter) {
        return null;
    }
}
