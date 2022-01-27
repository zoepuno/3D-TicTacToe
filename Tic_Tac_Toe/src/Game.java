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

    public void displayBoard(char[][][] board) {
        for (int l = 0; l < 4; l++) {
            System.out.println(" " + board[0][0][l] + " | " + board[0][1][l]+ " | " + board[0][2][l] + " " + board[0][3][l] + " ");
            System.out.println("-------------");
            System.out.println(" " + board[1][0][l] + " | " + board[1][1][l] + " | " + board[1][2][l] + " " + board[1][3][l] + " ");
            System.out.println("-------------");
            System.out.println(" " + board[2][0][l] + " | " + board[2][1][l] + " | " + board[2][2][l] + " " + board[2][3][l] + " ");
            System.out.println("-------------");
            System.out.println(" " + board[3][0][l] + " | " + board[3][1][l] + " | " + board[3][2][l] + " " + board[3][3][l] + " ");
            System.out.println("Level: "+l);
        }
    }
        public boolean count(char[][][] board) {
        int count = 0;
        for (int l = 0; l < 4; l++) {
            for (int r = 0; r < board.length; r++) {
                for (int c = 0; c < board.length; c++) {
                    if (board[r][c][l] != ' ') {
                        count++;
                    }
                }
            }
            if (count == 64) {
                return true;
            } else
                return false;
        }
    }
    }
