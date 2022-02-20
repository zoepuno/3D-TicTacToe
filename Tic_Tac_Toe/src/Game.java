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
      for (int c = 0; c < 4; c++) {
            int align = 100;
            for (int s = 0; s < 4; s++) {
                for (int r = 0; r < 4; r++) {
                    int xPoints[] = {align + 10 + 50 * r, align + 60 + 50 * r, align + 50 + 50 * r, align + 50 * r};
                    int yPoints[] = {60 + 40 * s + 200 * c, 60 + 40 * s + 200 * c, 100 + 40 * s + 200 * c, 100 + 40 * s + 200 * c};
                    tile[s][r][c] = new Polygon(xPoints, yPoints, 4);

                    board[s][r][c] = '-';
                    winBoard[s][r][c] = '-';
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
                        board[s][r][c] = '-';
                        winBoard[s][r][c] = '-';
                    }
                }
            }
            Thread tt = new Thread(this);
            tt.start();
            repaint();
        }

        else {
            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 4; c++) {
                    for (int s = 0; s < 4; s++) {
                        board[s][r][c] = '-';
                        winBoard[s][r][c] = '-';
                    }
                }
            }
        }

    }
    public boolean isWinner(char player){

      // 2-D vertical wins
        for (int s=0;s<4;s++){
            for(int r=0;r<4;r++){
                if(board[s][r][0] == player && board[s][r][1] == player &&board[s][r][2] == player && board[s][r][3] == player){
                    winBoard[s][r][0] = 'w';
                    winBoard[s][r][1] = 'w';
                    winBoard[s][r][2] = 'w';
                    winBoard[s][r][3] = 'w';
                    return true;
                }
            }
        }
        //|x| -------
        //|x| -------
        //|x| -------
        //|x| -------
        // 3-D vertical wins
        for (int s=0;s<4;s++){
            for(int c=0;c<4;c++){
                if(board[s][0][c] == player && board[s][1][c] == player &&board[s][2][c] == player && board[s][3][c] == player) {
                    winBoard[s][0][c] = 'w';
                    winBoard[s][1][c] = 'w';
                    winBoard[s][2][c] = 'w';
                    winBoard[s][3][c] = 'w';
                    return true;
                }
            }
        }

        //2-D horizontal wins
        for (int r=0;r<4;r++){
            for(int c=0;c<4;c++){
                if(board[0][r][c] == player && board[1][r][c] == player &&board[2][r][c] == player && board[3][r][c] == player) {
                    winBoard[0][r][c] = 'w';
                    winBoard[1][r][c] = 'w';
                    winBoard[2][r][c] = 'w';
                    winBoard[3][r][c] = 'w';
                    return true;
                }
            }
        }

        //3-D sheet diagonal check
        for (int s=0;s<4;s++) {
            if (board[s][0][0] == player && board[s][1][1] == player && board[s][2][2] == player && board[s][3][3] == player) {
                winBoard[s][1][1] = 'w';
                winBoard[s][2][2] = 'w';
                winBoard[s][3][3] = 'w';
                winBoard[s][0][0] = 'w';
                return true;
            }
            else if (board[s][3][0] == player && board[s][2][1] == player && board[s][1][2] == player && board[s][0][3] == player) {
                winBoard[s][2][1] = 'w';
                winBoard[s][1][2] = 'w';
                winBoard[s][0][3] = 'w';
                winBoard[s][3][0] = 'w';
                return true;
            }
        }

        //2_D row diagonal wins
        for(int r=0;r<4;r++){
            if(board[0][r][0] == player && board[1][r][1] == player && board[2][r][2] == player && board[3][r][3] == player) {
                winBoard[0][r][0] = 'w';
                winBoard[1][r][1] = 'w';
                winBoard[2][r][2] = 'w';
                winBoard[3][r][3] = 'w';
                return true;
            }
            else if(board[3][r][0] == player && board[2][r][1] == player && board[1][r][2] == player && board[0][r][3] == player) {
                winBoard[3][r][0] = 'w';
                winBoard[2][r][1] = 'w';
                winBoard[1][r][2] = 'w';
                winBoard[0][r][3] = 'w';
                return true;
            }
        }

        //3-D column diagonal wins
        for(int c=0;c<4;c++){
            if(board[0][0][c] == player && board[1][1][c] == player && board[2][2][c] == player && board[3][3][c] == player) {
                winBoard[0][0][c] = 'w';
                winBoard[1][1][c] = 'w';
                winBoard[2][2][c] = 'w';
                winBoard[3][3][c] = 'w';
                return true;
            }
            else if(board[3][0][c] == player && board[2][1][c] == player && board[1][2][c] == player && board[0][3][c] == player) {
                winBoard[3][0][c] = 'w';
                winBoard[2][1][c] = 'w';
                winBoard[1][2][c] = 'w';
                winBoard[0][3][c] = 'w';
                return true;
            }
        }

        //internal diagonals (r0 top left corner to r3 bottom right corner)
        if(board[0][0][0] == player && board[1][1][1] == player && board[2][2][2] == player && board[3][3][3] == player) {
            winBoard[0][0][0] = 'w';
            winBoard[1][1][1] = 'w';
            winBoard[2][2][2] = 'w';
            winBoard[3][3][3] = 'w';
            return true;
        }
        //internal diagonals (r0 bottom left corner to r3 top right corner)
        else if(board[0][3][0] == player && board[1][2][1] == player && board[2][1][2] == player && board[3][0][3] == player) {
            winBoard[0][3][0] = 'w';
            winBoard[2][2][1] = 'w';
            winBoard[2][1][2] = 'w';
            winBoard[3][0][3] = 'w';
            return true;
        }

        //internal diagonals (r0 bottom right corner to r3 top right corner)
        if(board[0][0][3] == player && board[1][1][2] == player && board[2][2][1] == player && board[3][3][0] == player) {
            winBoard[0][0][3] = 'w';
            winBoard[1][2][2] = 'w';
            winBoard[2][2][1] = 'w';
            winBoard[3][3][0] = 'w';
            return true;
        }
        //internal diagonals (r0 top left corner to r3 bottom right corner)
        else if(board[0][3][3] == player && board[1][2][2] == player && board[2][1][1] == player && board[3][0][0] == player) {
            winBoard[3][0][0] = 'w';
            winBoard[2][1][1] = 'w';
            winBoard[1][2][2] = 'w';
            winBoard[0][3][3] = 'w';
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
                    if(tile[s][r][c].contains(x,y)){
                        System.out.println(player + "(s: " + s +", r: "+ r + ", c : "+ c + ")" + board[s][r][c]);

                        if(board[s][r][c]=='-'){
                            board[s][r][c] = player;
                            System.out.println(player + "(s: " + s +", r: "+ r + ", c : "+ c + ")" + board[s][r][c]);
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
