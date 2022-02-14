import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

public class TicTacToe_Display extends JPanel implements MouseListener, Runnable, KeyListener {

    Polygon[][][] tile = new Polygon[4][4][4];
    char[][][] board = new char[4][4][4];
    char[][][] winBoard = new char[4][4][4];
    char p1 = 'x', p2 = 'o';
    boolean playerTurn = true;
    static boolean Ai1 = false;
    static boolean Ai2 = false;
    boolean random, blocking, moved;

    int GamePause = 0;
    int millisToSleep = 20;
    int nGames=1;
    boolean playerInput = false;
    int p1Wins = 0;
    int p2Wins = 0;
    int i;
    boolean replay = false;

    public TicTacToe_Display() {
        super();
        addMouseListener(this);
        addKeyListener(this);
        setSize(800, 1200);

        for (int c = 0; c < 4; c++) {
            int align = 100;
            for (int s = 0; s < 4; s++) {
                for (int r = 0; r < 4; r++) {
                    int xPoints[] = {align + 10 + 50 * r, align + 60 + 50 * r, align + 50 + 50 * r, align + 50 * r};
                    int yPoints[] = {60 + 40 * s + 200 * c, 60 + 40 * s + 200 * c, 100 + 40 * s + 200 * c, 100 + 40 * s + 200 * c};
                    tile[r][c][3 - s] = new Polygon(xPoints, yPoints, 4);

                    board[r][c][s] = '-';
                    winBoard[r][c][s] = '-';
                }
                align -= 10;
            }
        }


        System.out.print("Do you want player x to be AI? (type 'y' or 'n'): ");
        if (getStringput().charAt(0) == 'y') {
            Ai1 = true;
            System.out.print("Random AI(r) or Blocking AI(b): ");
            if (getStringput().charAt(0) == 'r') {
                random = true;
            }
            if (getStringput().charAt(0) == 'b') {
                blocking = true;
            }
        }

        System.out.print("Do you want player o to be AI? (type 'y' or 'n'): ");
        if (getStringput().charAt(0) == 'y'){
            Ai2 = true;
        System.out.print("Random AI(r) or Blocking AI(b): ");
        if (getStringput().charAt(0) == 'r') {
            random = true;
        }
        if (getStringput().charAt(0) == 'b') {
            blocking = true;
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
            repaint();
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

    public void paint(Graphics p){

        p.setColor(Color.BLACK);
        p.fillRect(0,0,800,1200);
        p.setColor(new Color(255, 128, 128));
        p.setFont(new Font("Sans Serif", Font.BOLD, 60));

        for(int c=0;c<4;c++){
            for(int r=0;r<4;r++){
                for(int s=0;s<4;s++)
                {
                    p.setColor(Color.WHITE);
                    p.drawPolygon(tile[r][c][s]);
                    if (board[r][c][s] != '-')
                    {
                        if(board[r][c][s]=='x')
                            p.setColor(new Color(255, 128, 128));
                        else if (board[r][c][s]=='o')
                            p.setColor(new Color(163, 185, 224));
                        if (winBoard[r][c][s] =='w')
                            p.setColor(new Color(141, 224, 148));

                        p.fillOval(tile[r][c][s].xpoints[0], tile[r][c][s].ypoints[0]+5, 35,35);
                        p.setColor(Color.WHITE);
                    }
                }
            }
        }

        //displys p1Wins & p2Wins
        if(!Ai1 || !Ai2)
        {
            p.setFont(new Font("Sans Serif", Font.BOLD, 30));
            p.setColor(new Color(255, 128, 128));
            p.drawString("Player 1 wins: " + p1Wins/2, 400,100);
            p.setColor(new Color(163, 185, 224));
            p.drawString("Player 2 wins: " + p2Wins/2, 400,150);
        }
        else{
            p.setFont(new Font("Sans Serif", Font.BOLD, 30));
            p.setColor(new Color(255, 128, 128));
            p.drawString("Player 1 wins: " + p1Wins, 400, 100);
            p.setColor(new Color(163, 185, 224));
            p.drawString("Player 2 wins: " + p2Wins, 400, 150);
        }

        //prints which player wins
        p.setColor(new Color(141, 224, 148));
        if(isWinner(p1)){
            p.drawString("PLAYER 1 WINS" , 400,600);
            if(!replay && !Ai2 || !Ai1)
                p.drawString("Press 'r' to replay" , 400,400);
        }
        else if (isWinner(p2)){
            p.drawString("PLAYER 2 WINS" , 400,600);
            if(!replay && !Ai2 || !Ai1)
                p.drawString("Press 'r' to replay" , 400,400);
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if(!(isWinner(p1) || isWinner(p2))){
            if(playerInput) {
                double mouseX = e.getX();
                double mouseY = e.getY();

                if (playerTurn) {
                    if(!playerMoves(mouseX, mouseY, p1))
                        return;

                } else{
                    if(!playerMoves(mouseX, mouseY, p2))
                        return;
                }
                repaint();
                playerInput = false;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if((isWinner(p1) || isWinner(p2)) && e.getKeyChar() == 'r'){
            System.out.println("r is pressed");
            reset();
            repaint();
        }
    }

    @Override
    public void run() {
        System.out.println("running");
        for (int switched = 0; switched < 2; switched++) {
            //switches player
            if (switched == 1) {
                playerTurn = false;
            }

            for (i = 0; i < nGames; i++) {
                while ((!isWinner(p1) && !isWinner(p2))) {
                    //p1
                    if (playerTurn) {
                        //p1 is AI
                        if (Ai1)
                        {
                            if(random) {
                                Random_Ai random1 = new Random_Ai(p1, board, moved);
                                random1.RandomAI_Move();
                            }
                            if(blocking)

                            try {
                                Thread.sleep(millisToSleep);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        //p1 is a human player
                        else {
                            playerInput = true;
                            while (playerInput) {
                                try {
                                    Thread.sleep(50);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        playerTurn = false;
                        repaint();
                    }
                    //p2
                    else {
                        //p2 is RandomAi
                        if (Ai2) {
                            if(random) {
                                Random_Ai random2 = new Random_Ai(p1, board, moved);
                                random2.RandomAI_Move();
                            }
                            if(blocking)
                            try {
                                Thread.sleep(millisToSleep);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        //p2 is person
                        else {
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
                        repaint();
                    }
                    try {
                        Thread.sleep(GamePause);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
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
        for(int c=0;c<4;c++){
            for(int r=0;r<4;r++){
                for(int s=0;s<4;s++){
                    if(tile[r][c][s].contains(x,y)){
                        System.out.println(player + "(r: " + r +", c: "+ c + ",s : "+ s + ")" + board[r][c][s]);

                        if(board[r][c][s]=='-'){
                            board[r][c][s] = player;
                            System.out.println(player + "(r: " + r +", c: "+ c + ",s : "+ s + ")" + board[r][c][s]);
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
            if(in.hasNext())
                return in.next();
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e) { }

    public void addNotify(){
        super.addNotify();
        requestFocus();
    }
}

