/*
              |         |         |
              |         |         |
              |         |         |
    ----------------------------------------
              |         |         |
              |         |         |
              |         |         |
    ----------------------------------------
              |         |         |
              |         |         |
              |         |         |
     ---------------------------------------
              |         |         |
              |         |         |
              |         |         |
 */

import java.awt.*;
import java.util.Scanner;


public class Main {

    static Game mg = new Game();

    public static void main(String args[]) {

        new TTTFrame("Tic_Tac_Toe with Ai");
        Scanner in = new Scanner(System.in);
        PlayervsPlayer Fight = new PlayervsPlayer();
        //and its coordinates
        int c = 0;
        int r = 0;
        int s = 0;

        boolean play = false;
        int AiType;
        int gamemode;
        if(mg.STATUS == mg.PLAYING)
        {
            //Game mode Selection
            System.out.println("1. Player vs Player ");
            System.out.println("2. Player vs Computer ");
            System.out.println("3. Computer vs Computer ");
            System.out.println("Choose your gamemode: ");
            gamemode = in.nextInt();


            if (gamemode == 1) {
                //Player Input: Player vs PLayer
                System.out.print("Player One Name: ");
                mg.player1.name = in.next();
                mg.addNames(mg.player1.name );
                System.out.print("Player Two Name: ");
                mg.player2.name = in.next();
                mg.addNames(mg.player2.name );

                Fight.theMainPlayerGame();

            }
            if (gamemode == 2) {
                // Player vs Computer
                System.out.print("Choose your name: ");
                mg.player1.name = in.next();
                //AI Choices
                System.out.println("Which AI to Play?");
                System.out.println("1. Random AI");
                System.out.println("2. Straight Line AI");
                System.out.println("3. Blocking AI");
                System.out.println("4. Straight Line Blocking AI");
                AiType = in.nextInt();

            //random AI
                if (AiType == 1) {
                    Random_Ai random = new Random_Ai("Random", 'x');
                    mg.player2.name = random.getName();

                    do {
                        mg.board.displayBoard(mg.board.board);
                    //p1
                        if (mg.getPlayerTurn() == 1) {
                            System.out.println(mg.player1.name  + "'s turn!\n\n");
                            mg.calculate(mg.board, setLocation(c,r,s), mg.player1.letter);
                        }
                   //p2
                        if(mg.playerturn == 2 && !mg.gameOver){  // Let the computer take a turn
                           random.random_move(mg.board.board);
                            Location p2 = new Location(random.getC(), random.getR(),random.getS());
                            if(mg.moveCheck(mg.board.board, p2))  // make sure it's valid move
                                mg.board.setBoard(p2,mg.player2.letter);
                            else
                                System.out.println("Computer chose invalid move. Lose turn.");
                            Main.mg.setPlayerturn();


                            if(Main.mg.board.count()){
                                System.out.println("Game ends in a draw.");
                                Main.mg.gameOver = true;
                            }

                            else if(Main.mg.isWinner(Main.mg.board.board) == Main.mg.PlAYER2){
                                System.out.println("P2 wins!");
                                Main.mg.gameOver = true;
                            }
                        }
                        if(mg.isWinner(mg.board.board) != 0)
                            break;


                        mg.board.count();
                        mg.setPlayerturn();
                        System.out.print(mg.isWinner(mg.board.board));
                    } while (mg.isWinner(mg.board.board) == 0 || !mg.board.count());

                    winner(mg.player1.name, mg.player2.name);

                }
            /*
                if (AiType == 2) {

                }
                if (AiType == 3) {

                }
                if (AiType == 3) {

                }*/

                //Computer vs Computer
                if (gamemode == 3) {

                }
            }
        }
    }

        public static Location setLocation(int c, int r, int s) {
        Scanner in = new Scanner(System.in);
        System.out.println("");

        System.out.print("Enter a column from 0 to 3: ");
        c = in.nextInt();
        System.out.print("Enter a row from 0 to 3: ");
        r = in.nextInt();
        System.out.print("Enter the board from 0 to 3: ");
        s = in.nextInt();
        Location area = new Location(c, r, s);

        if(mg.moveCheck(mg.board.board, area) == false)
        {
            System.out.println("invalid location");
            setLocation(c,r,s);
        }
        return area;
    }

    public static void winner(String player1, String player2)
    {   if(mg.isWinner(mg.board.board) == mg.PlAYER1)
        System.out.println(player1 + " won!");
        if(mg.isWinner(mg.board.board) == mg.PlAYER2)
            System.out.println(player2 + " won!");
    }

}


