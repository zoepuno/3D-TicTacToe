import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Game implements KeyListener {
    char character;
    public int STATUS;
    public boolean playerturn = true;
    public int PLAYING = 1;
    public int PlAYER1 = 1;
    public int PlAYER2 = 2;

    public boolean gameOver;
    public Player player1 = new Player("",'x');
    public Player player2 = new Player("",'o');
    Location p1 = new Location(0,0,0);
    Location p2 = new Location(0,0,0);
    char x = 'x';
    char o = 'o';

    public Board board = new Board();
    public Count count = new Count();
    ArrayList playerNames = new ArrayList<String>();

    public Game()
    {
        playerturn = true;
        this.STATUS = -1;
    }
    public void setLetter(){
        x =  player1.getLetter();
        o = player2.getLetter();
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

    public boolean getPlayerTurn(){
        return playerturn;
    }

    public void setPlayerturn() {
        if (playerturn == true)
            //switch to second player
            playerturn=false;
        else
            //switch to first player
            playerturn = true;
    }

    public boolean moveCheck(char[][][] board, Location a)
    {
        if (a.getRow() >= 4 || a.getCol() >= 4||a.getSheet() >= 4||a.getRow() < 0 || a.getCol()< 0||a.getSheet() < 0|| board[a.getRow()][a.getCol()][a.getSheet()] != '-')
        {
            return false;
        }
        return true;
    }

    public void calculate(Board board, Location location, char player){
        count.calculate(board, location, player);
    }

    public int isWinner (char[][][] board) {
        int win = 0;

        //line wins at each horizantal level
        for (int s = 0; s < 4; s++) {
            //diagonal wins
            if (board[0][0][s] == x && board[1][1][s] == x && board[2][2][s] == x && board[3][3][s] == x)
                win = PlAYER2;
            if (board[0][0][s] == o && board[1][1][s] == o && board[2][2][s] == o && board[3][3][s] == o)
                win = PlAYER1;
            if (board[0][3][s] == x && board[1][2][s] == x && board[2][1][s] == x && board[3][0][s] == x)
                win = PlAYER2;
            if (board[0][3][s] == o && board[1][2][s] == o && board[2][1][s] == o && board[3][0][s] == o)
                win = PlAYER1;

            for (int c = 0; c < 4; c++) {
                //column wins
                if (board[0][c][s] == x && board[1][c][s] == x && board[2][c][s] == x && board[3][c][s] == x)
                    win = PlAYER2;
                if (board[0][c][s] == o && board[1][c][s] == o && board[2][c][s] == o && board[3][c][s] == o)
                    win = PlAYER1;
            }
            for (int r = 0; r < 4; r++) {
                //row wins
                if (board[r][0][s] == x && board[r][1][s] == x && board[r][2][s] == x && board[r][3][s] == x)
                    win = PlAYER2;
                if (board[r][0][s] == o && board[r][1][s] == o && board[r][2][s] == o && board[r][3][s] == o)
                    win = PlAYER1;
            }
        }

        //line wins at each vertical level
        for (int c = 0; c < 4; c++) {
            //diagonal wins
            if (board[0][c][0] == x && board[1][c][1] == x && board[2][c][2] == x && board[3][c][3] == x)
                win = PlAYER2;
            if (board[0][c][0] == o && board[1][c][1] == o && board[2][c][2] == o && board[3][c][3] == o)
                win = PlAYER1;
            if (board[0][c][3] == x && board[1][c][2] == x && board[2][c][1]== x && board[3][c][0]== x)
                win = PlAYER2;
            if (board[0][c][3] == o && board[1][c][2] == o && board[2][c][1]== o && board[3][c][0]== o)
                win = PlAYER1;

            for (int r = 0; r < 4; r++) {
                //vertical row wins
                if (board[r][c][0] == x && board[r][c][1] == x && board[r][c][2] == x && board[r][c][3] == x)
                    win = PlAYER2;
                if (board[r][c][0] == o && board[r][c][1] == o && board[r][c][2] == o && board[r][c][3] == o)
                    win = PlAYER1;
            }
            for (int s = 0; s < 4; s++) {
                //horizantal column wins
                if (board[0][c][s] == x && board[1][c][s] == x && board[2][c][s] == x && board[3][c][s] == x)
                    win = PlAYER2;
                if (board[0][c][s] == o && board[1][c][s] == o && board[2][c][s] == o && board[3][c][s] == o)
                    win = PlAYER1;
            }
        }

        //line wins at each vertical level
        for (int r = 0; r < 4; r++) {
            //diagonal wins
            if (board[r][0][0] == x && board[r][1][1] == x && board[r][2][2] == x && board[r][3][3] == x)
                win = PlAYER2;
            if (board[r][0][0] == o && board[r][1][1] == o && board[r][2][2] == o && board[r][3][3] == o)
                win = PlAYER1;
            if (board[r][3][0] == x && board[r][2][1] == x && board[r][1][2]== x && board[r][0][3]== 'x')
                win = PlAYER2;
            if (board[r][3][0] == o && board[r][2][1] == o && board[r][1][2]== o && board[r][0][3]== o)
                win = PlAYER1;
        }

        //3-D diagonal wins
        if (board[0][0][0] == x && board[1][1][1] == x && board[2][2][2] == x && board[3][3][3] ==x)
            win = PlAYER2;
        if (board[0][0][0] == o && board[1][1][1] == o && board[2][2][2] == o && board[3][3][3] == o)
            win = PlAYER1;
        if (board[0][3][0] == x && board[1][2][1] == x && board[2][1][2]== x && board[3][0][3]== x)
            win = PlAYER2;
        if (board[0][3][0] == o && board[1][2][1] == o && board[2][1][2]== o && board[3][0][3]== o)
            win = PlAYER1;


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

