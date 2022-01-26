import java.util.ArrayList;

public class Game{
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
public void addNames(String name){
        playerNames.add(name);

}
    public int getPlayers() {
        return playerNames.size();
    }

