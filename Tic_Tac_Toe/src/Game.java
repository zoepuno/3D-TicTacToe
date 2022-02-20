import java.awt.*;
import java.util.Scanner;

public class Game implements Runnable {
    Polygon[][][] tile = new Polygon[4][4][4];
    char[][][] board = new char[4][4][4];
    char[][][] winBoard = new char[4][4][4];
    char p1 = 'x', p2 = 'o';
    boolean playerTurn = true;
    static boolean  Ai1 , Ai2;
    boolean random, blocking,sl,slb, moved;

    int GamePause = 0;
    int millisToSleep = 20;
    int nGames=1;
    boolean playerInput = false;
    int p1Wins = 0;
    int p2Wins = 0;
    int i;
    boolean replay = false;
    char type;
    Blocking_AI block= new Blocking_AI();

    public Game(){
        for (int s = 0; s < 4; s++) {
            int align = 100;
            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 4; c++) {
                    int xPoints[] = {align + 10 + 50 * c, align + 60 + 50 * c, align + 50 + 50 * c, align + 50 * c};
                    int yPoints[] = {60 + 40 * r + 200 * s, 60 + 40 * r + 200 * s, 100 + 40 * r + 200 * s, 100 + 40 * r + 200 * s};
                    tile[r][c][s] = new Polygon(xPoints, yPoints, 4);

                    board[r][c][s] = '-';
                    winBoard[r][c][s] = '-';
                }
                align -= 10;
            }
        }
        System.out.print("Do you want player x to be AI? (type 'y' or 'n'): ");
        if(getStringput().charAt(0) == 'y') {
            Ai1 = true;
            System.out.print("Random AI(r) or Blocking AI(b) or StraightLine AI(l) or StraightLine-Blocking AI(s): ");
            if (getStringput().charAt(0) == 'r') {
                random = true;
                System.out.println("random is true");
            }
            else if (getStringput().charAt(0) == 'b') {
                block.setBoardCopy();
                blocking = true;
                System.out.println("blocking is true");
            }

            else if (getStringput().charAt(0) == 'l') {
                block.setBoardCopy();
                sl = true;
                System.out.println("sl is true");
            }
            else if (getStringput().charAt(0) == 's') {
                block.setBoardCopy();
                slb = true;
                System.out.println("slb is true");
            }
        }

        System.out.print("Do you want player o to be AI? (type 'y' or 'n'): ");
        if (getStringput().charAt(0) == 'y'){
            Ai2 = true;
            System.out.print("Random AI(r) or Blocking AI(b) or StraightLine AI(l) or StraightLine-Blocking AI(s): ");
            if (getStringput().charAt(0) == 'r') {
                random = true;
                System.out.println("random is true");
            }
            else if (getStringput().charAt(0) == 'b') {
                block.setBoardCopy();
                blocking = true;
                System.out.println("blocking is true");
            }

            else if (getStringput().charAt(0) == 'l') {
                block.setBoardCopy();
                sl = true;
                System.out.println("sl is true");
            }
            else if (getStringput().charAt(0) == 's') {
                block.setBoardCopy();
                slb = true;
                System.out.println("slb is true");
            }
        }

        if(Ai1 && Ai2){
            System.out.print("How many milliseconds between AI moves?: ");
            millisToSleep = getIntput();
            System.out.print("How many games you want the AIs to play?: ");
            nGames = getIntput();
            System.out.print("How many milliseconds between games?: ");
            GamePause = getIntput();
        }

        Thread t = new Thread(this);
        t.start();
    }

    public void reset(){
        System.out.println("reset");

        if(!Ai1 || !Ai2) {
            if (i == nGames) {
            }
            for(int r=0;r<4;r++){
                for(int c=0;c<4;c++){
                    for(int s=0;s<4;s++){
                        board[r][c][s] = '-';
                        winBoard[r][c][s] = '-';
                    }
                }
            }
            Thread tt = new Thread(this);
            tt.start();
        }

        else {
            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 4; c++) {
                    for (int s = 0; s < 4; s++) {
                        board[r][c][s] = '-';
                        winBoard[r][c][s] = '-';
                    }
                }
            }
        }

    }
    public boolean isWinner(char player){

        //linear levels win
        for (int r=0;r<4;r++){
            for(int c=0;c<4;c++){
                if(board[r][c][0] == player && board[r][c][1] == player &&board[r][c][2] == player && board[r][c][3] == player){
                    winBoard[r][c][0] = 'w';
                    winBoard[r][c][1] = 'w';
                    winBoard[r][c][2] = 'w';
                    winBoard[r][c][3] = 'w';
                    return true;
                }
            }
        }

        //linear row check
        for (int r=0;r<4;r++){
            for(int s=0;s<4;s++){
                if(board[r][0][s] == player && board[r][1][s] == player &&board[r][2][s] == player && board[r][3][s] == player) {
                    winBoard[r][0][s] = 'w';
                    winBoard[r][1][s] = 'w';
                    winBoard[r][2][s] = 'w';
                    winBoard[r][3][s] = 'w';
                    return true;
                }
            }
        }
        //linear columns check
        for (int c=0;c<4;c++){
            for(int s=0;s<4;s++){
                if(board[0][c][s] == player && board[1][c][s] == player &&board[2][c][s] == player && board[3][c][s] == player) {
                    winBoard[0][c][s] = 'w';
                    winBoard[1][c][s] = 'w';
                    winBoard[2][c][s] = 'w';
                    winBoard[3][c][s] = 'w';
                    return true;
                }
            }
        }

        //sheet diagonal check
        for (int r=0;r<4;r++) {
            if (board[r][0][0] == player && board[r][1][1] == player && board[r][2][2] == player && board[r][3][3] == player) {
                winBoard[r][1][1] = 'w';
                winBoard[r][2][2] = 'w';
                winBoard[r][3][3] = 'w';
                winBoard[r][0][0] = 'w';
                return true;
            }
            else if (board[r][3][0] == player && board[r][2][1] == player && board[r][1][2] == player && board[r][0][3] == player) {
                winBoard[r][2][1] = 'w';
                winBoard[r][1][2] = 'w';
                winBoard[r][0][3] = 'w';
                winBoard[r][3][0] = 'w';
                return true;
            }
        }

        //diagonal check within each column
        for(int c=0;c<4;c++){
            if(board[0][c][0] == player && board[1][c][1] == player && board[2][c][2] == player && board[3][c][3] == player) {
                winBoard[0][c][0] = 'w';
                winBoard[1][c][1] = 'w';
                winBoard[2][c][2] = 'w';
                winBoard[3][c][3] = 'w';
                return true;
            }
            else if(board[3][c][0] == player && board[2][c][1] == player && board[1][c][2] == player && board[0][c][3] == player) {
                winBoard[3][c][0] = 'w';
                winBoard[2][c][1] = 'w';
                winBoard[1][c][2] = 'w';
                winBoard[0][c][3] = 'w';
                return true;
            }
        }

        //diagonal check within each sheet
        for(int s=0;s<4;s++){
            if(board[0][0][s] == player && board[1][1][s] == player && board[2][2][s] == player && board[3][3][s] == player) {
                winBoard[0][0][s] = 'w';
                winBoard[1][1][s] = 'w';
                winBoard[2][2][s] = 'w';
                winBoard[3][3][s] = 'w';
                return true;
            }
            else if(board[3][0][s] == player && board[2][1][s] == player && board[1][2][s] == player && board[0][3][s] == player) {
                winBoard[3][0][s] = 'w';
                winBoard[2][1][s] = 'w';
                winBoard[1][2][s] = 'w';
                winBoard[0][3][s] = 'w';
                return true;
            }
        }

        //internal diagonal (left to right)
        if(board[0][0][0] == player && board[1][1][1] == player && board[2][2][2] == player && board[3][3][3] == player) {
            winBoard[0][0][0] = 'w';
            winBoard[1][1][1] = 'w';
            winBoard[2][2][2] = 'w';
            winBoard[3][3][3] = 'w';
            return true;
        }
        else if(board[0][3][0] == player && board[1][2][1] == player && board[2][1][2] == player && board[3][0][3] == player) {
            winBoard[0][3][0] = 'w';
            winBoard[1][0][1] = 'w';
            winBoard[2][0][2] = 'w';
            winBoard[3][0][3] = 'w';
            return true;
        }

        //internal diagonal(left to right)
        if(board[0][0][3] == player && board[1][1][2] == player && board[2][2][1] == player && board[3][3][0] == player) {
            winBoard[0][0][3] = 'w';
            winBoard[1][1][2] = 'w';
            winBoard[2][2][1] = 'w';
            winBoard[3][3][0] = 'w';
            return true;
        }
        else if(board[0][3][3] == player && board[1][2][2] == player && board[2][1][1] == player && board[3][0][0] == player) {
            winBoard[0][3][3] = 'w';
            winBoard[0][2][2] = 'w';
            winBoard[0][1][1] = 'w';
            winBoard[0][0][0] = 'w';
            return true;
        }
        return false;
    }

    public void run() {
        System.out.println("running");

        for (i = 0; i < nGames; i++) {
            while ((!isWinner(p1) && !isWinner(p2))) {
                System.out.print(playerTurn);
                if (playerTurn) { //p1
                    if (Ai1)//p1 is AI
                    {
                        if (random) {
                            Random_Ai random1 = new Random_Ai(p1, board, moved);
                            random1.RandomAI_Move();
                        }
                        if (blocking) {
                            moved = block.move(p1, board);
                        }
                        try {
                            Thread.sleep(millisToSleep);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else { //p1 is a human player
                        playerInput = true;
                        while (playerInput) {
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    playerTurn=false;
                } else { //p2
                    if (Ai2) {   //p2 is RandomAi
                        if (random) {
                            Random_Ai random2 = new Random_Ai(p2, board, moved);
                            random2.RandomAI_Move();
                        }
                        if (blocking) {
                            moved = block.move(p2, board);
                        }
                        try {
                            Thread.sleep(millisToSleep);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {  //p2 is person
                        playerInput = true;
                        while (playerInput) {
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    playerTurn = true;
                }
            }
            if (isWinner(p1))
                p1Wins++;
            if (isWinner(p2))
                p2Wins++;
            if (Ai1 && Ai2) {
                if (i != nGames)
                    reset();
            }
            if (Ai1 && Ai2) {
                if (i == nGames)
                    System.out.print("game ends");
                break;
            }
        }
    }

    public boolean playerMoves(double x, double y, char player)
    {

        for(int r=0;r<4;r++){
            for(int c=0;c<4;c++){
                for(int s=0;s<4;s++){
                    if(tile[r][c][s].contains(x,y)){
                        System.out.println(player + "(r: " + r +", c: "+ c + ", s : "+ s + ")" + board[r][c][s]);

                        if(board[r][c][s]=='-'){
                            board[r][c][s] = player;
                            System.out.println(player + "(r: " + r +", c: "+ c + ", s : "+ s + ")" + board[r][c][s]);
                            return true;
                        }
                        else
                            return false;
                    }
                }
            }
        }
        return false;
    }



    public static int getIntput(){
        Scanner in = new Scanner(System.in);
        while(true){
            if(in.hasNextInt())
                return in.nextInt();
            in.next();
        }
    }

    public static String getStringput(){
        Scanner in = new Scanner(System.in);
        while(true){
            if(in.hasNext()) {
                return in.next();
            }
        }
    }


}
