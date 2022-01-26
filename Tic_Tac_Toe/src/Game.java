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
    public char[][][] board= new char[4][4][4];
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

 public static void displayBoard(char[][][] board) {
    for(int l = 0; l <4; l++){
        System.out.println(" " + board[l][0][0] + " | " + board[l][0][1] + " | " + board[l][0][2] + " "+ board[l][0][3] + " ");
        System.out.println("-------------");
        System.out.println(" " + board[l][1][0] + " | " + board[l][1][1] + " | " + board[l][1][2] + " "+ board[l][1][3] + " ");
        System.out.println("-------------");
        System.out.println(" " + board[l][2][0] + " | " + board[l][2][1] + " | " + board[l][2][2] + " "+ board[l][2][3] + " ");
        System.out.println("-------------");
        System.out.println(" " + board[l][3][0] + " | " + board[l][3][1] + " | " + board[l][3][2] + " "+ board[l][3][3] + " ");
    }
    }
