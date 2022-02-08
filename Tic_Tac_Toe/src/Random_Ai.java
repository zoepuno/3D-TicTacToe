import java.util.Scanner;

public class Random_Ai extends Player{

    Scanner keyboard = new Scanner(System.in);

    Player RAi = new Player("Random",'x');

    int x = 0;
    boolean error = false;
    int r;
    int c;
    int s;

    Random_Ai(String name, char letter) {
        super(name, letter);
    }


    public void setR(int r)
    {
        this.r = r;
    }
    public void setC(int c)
    {
        this.c = c;
    }
    public void setS(int s)
    {
        this.s = s;
    }

    public int getR()
    {
        return r;
    }
    public int getC()
    {
        return c;
    }
    public int getS()
    {
        return c;
    }
    //Moves Randomly
    public void random_move(char[][][] board) {

            r = (int) (Math.random() * 4);
            c = (int) (Math.random() * 4);
            s = (int) (Math.random() * 4);

                if (r >= 4 || c >= 4||s >= 4||r < 0 || c < 0||s < 0|| board[r][c][s] != '-')
                {
                    random_move(board);
                }
        }
    }






