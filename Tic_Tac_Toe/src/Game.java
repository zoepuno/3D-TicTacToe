import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;

public class Game implements KeyListener {
    char character;
    public int STATUS = 0;
    public int PLAYING = 1;
    public int PlAYER1_WON = 2;
    public int playerturn =  1;
    public int PlAYER2_WON = 3;
    public int PLAYER1_LOST = 4;
    public int PLAYER2_LOST = 5;
    public int AI1_WON = 6;
    public int AI1_LOST = 7;
    public int AI2_WON = 8;
    public int AI2_LOST = 9;
    public Player player1;
    public Player player2;
    char X;
    char O;


    public char[][][] board= new char[4][4][4];


    public void fillBoard(){
        for (int l = 0; l < 4; l++) {
            for(int c=0; c<4; c++){
                for(int r=0; r<4; r++){
                    board[l][c][r]='-';
                }
            }
        }
    }


    ArrayList playerNames = new ArrayList<String>();

    public void setLetter(){
        X =  player1.getLetter();
        O = player2.getLetter();
    }
    public void setBoard(Location area,char letter){
        board[area.getCol()][area.getRow()][area.getSheet()]=letter;
    }
    public int setSTATUS(int b){
        STATUS=b;
        return STATUS;
    }
    public int getSTATUS() {
        return STATUS;
    }

    public void reset() {
        STATUS = PLAYING;
    }

    public void addNames(String name) {
        playerNames.add(name);

    }
    public String getplayerNames(int x){
        return (String) playerNames.get(x);
    }

    public int getPlayers() {
        return playerNames.size();
    }

    public int getPlayerTurn(){
        return playerturn;
    }

    public void setPlayerturn()
    {
        if (playerturn == 1)
            //switch to second player
            playerturn++;
        else
            //switch to first player
            playerturn--;
    }
    public void displayBoard(char[][][] board) {
        for (int l = 0; l < 4; l++) {
            System.out.println("Level: "+(l+1));
            System.out.println(" " + board[0][0][l] + " | " + board[0][1][l]+ " | " + board[0][2][l] + " | " + board[0][3][l] + " ");
            System.out.println("----------------");
            System.out.println(" " + board[1][0][l] + " | " + board[1][1][l] + " | " + board[1][2][l] + " | " + board[1][3][l] + " ");
            System.out.println("----------------");
            System.out.println(" " + board[2][0][l] + " | " + board[2][1][l] + " | " + board[2][2][l] + " | " + board[2][3][l] + " ");
            System.out.println("----------------");
            System.out.println(" " + board[3][0][l] + " | " + board[3][1][l] + " | " + board[3][2][l] + " | " + board[3][3][l] + " ");

        }
    }



    public boolean count(char[][][] board) {
        int count = 0;
        for (int s = 0; s < 4; s++) {
            for (int r = 0; r < board.length; r++) {
                for (int c = 0; c < board.length; c++) {
                    if (board[r][c][s] != '-') {
                        count++;
                    }
                }
            }
        }
        if (count == 64) {
            return true;
        }
        return false;
    }


    public boolean moveCheck(char[][][] board, int r, int c,int s)
    {
        if (r >= 4 || c >= 4||s >= 4||r < 0 || c < 0||s < 0|| board[r][c][s] != '-')
        {
            return false;
        }
        return true;
    }

    public int isWinner (char[][][] board)
    {
        int win = 0;

        //line wins at each horizantal level
        for (int s = 0; s < 4; s++) {
            //diagonal wins
            if (board[0][0][s] == X && board[1][1][s] == X && board[2][2][s] == X && board[3][3][s] == X)
                win = PlAYER1_WON;
            if (board[0][0][s] == O && board[1][1][s] == O && board[2][2][s] == O && board[3][3][s] == O)
                win = PlAYER2_WON;
            if (board[0][3][s] == X && board[1][2][s] == X && board[2][1][s] == X && board[3][0][s] == X)
                win = PlAYER1_WON;
            if (board[0][3][s] == O && board[1][2][s] == O && board[2][1][s] == O && board[3][0][s] == O)
                win = PlAYER2_WON;

            for (int c = 0; c < 4; c++) {
                //column wins
                if (board[0][c][s] == X && board[1][c][s] == X && board[2][c][s] == X && board[3][c][s] == X)
                    win = PlAYER1_WON;
                if (board[0][c][s] == O && board[1][c][s] == O && board[2][c][s] == O && board[3][c][s] == O)
                    win = PlAYER2_WON;
            }
            for (int r = 0; r < 4; r++) {
                //row wins
                if (board[r][0][s] == X && board[r][1][s] == X && board[r][2][s] == X && board[r][3][s] == X)
                    win = PlAYER1_WON;
                if (board[r][0][s] == O && board[r][1][s] == O && board[r][2][s] == O && board[r][3][s] == O)
                    win = PlAYER2_WON;
            }
        }

        //line wins at each vertical level
        for (int c = 0; c < 4; c++) {
            //diagonal wins
            if (board[0][c][0] == X && board[1][c][1] == X && board[2][c][2] == X && board[3][c][3] == X)
                win = PlAYER1_WON;
            if (board[0][c][0] == O && board[1][c][1] == O && board[2][c][2] == O && board[3][c][3] == O)
                win = PlAYER2_WON;
            if (board[0][c][3] == X && board[1][c][2] == X && board[2][c][1]== X && board[3][c][0]== X)
                win = PlAYER1_WON;
            if (board[0][c][3] == O && board[1][c][2] == O && board[2][c][1]== O && board[3][c][0]== O)
                win = PlAYER2_WON;

            for (int r = 0; r < 4; r++) {
                //vertical row wins
                if (board[r][c][0] == X && board[r][c][1] == X && board[r][c][2] == X && board[r][c][3] == X)
                    win = PlAYER1_WON;
                if (board[r][c][0] == O && board[r][c][1] == O && board[r][c][2] == O && board[r][c][3] == O)
                    win = PlAYER2_WON;
            }
            for (int s = 0; s < 4; s++) {
                //horizantal column wins
                if (board[0][c][s] == X && board[1][c][s] == X && board[2][c][s] == X && board[3][c][s] == X)
                    win = PlAYER1_WON;
                if (board[0][c][s] == O && board[1][c][s] == O && board[2][c][s] == O && board[3][c][s] == O)
                    win = PlAYER2_WON;
            }
        }

        //line wins at each vertical level
        for (int r = 0; r < 4; r++) {
            //diagonal wins
            if (board[r][0][0] == X && board[r][1][1] == X && board[r][2][2] == X && board[r][3][3] == X)
                win = PlAYER1_WON;
            if (board[r][0][0] == O && board[r][1][1] == O && board[r][2][2] == O && board[r][3][3] == O)
                win = PlAYER2_WON;
            if (board[r][3][0] == X && board[r][2][1] == X && board[r][1][2]== X && board[r][0][3]== X)
                win = PlAYER1_WON;
            if (board[r][3][0] == O && board[r][2][1] == O && board[r][1][2]== O && board[r][0][3]== O)
                win = PlAYER2_WON;
        }

        //3-D diagonal wins
        if (board[0][0][0] == X && board[1][1][1] == X && board[2][2][2] == X && board[3][3][3] == X)
            win = PlAYER1_WON;
        if (board[0][0][0] == O && board[1][1][1] == O && board[2][2][2] == O && board[3][3][3] == O)
            win = PlAYER2_WON;
        if (board[0][3][0] == X && board[1][2][1] == X && board[2][1][2]== X && board[3][0][3]== X)
            win = PlAYER1_WON;
        if (board[0][3][0] == O && board[1][2][1] == O && board[2][1][2]== O && board[3][0][3]== O)
            win = PlAYER2_WON;


        return win;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        character =  e.getKeyChar();
        if(character == 'r');
        reset();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
