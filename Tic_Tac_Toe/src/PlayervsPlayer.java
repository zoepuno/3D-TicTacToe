import java.lang.Math;
import java.util.Scanner;
public class PlayervsPlayer{
    Game gamepull = new Game();
    char player;
    boolean playerTurn;
    boolean player2Turn;

    char player2;
    int col;
    int row;
    int sheet;

    public void XorO() {
        if (Math.random() * 1 == 0) {
            player = 'x';
            player2 = 'o';
            playerTurn=true;
        } else {
            player2 = 'x';
            player = 'o';
            player2Turn=true;
        }
    }
    public void theMainPlayerGame(){
        Scanner in = new Scanner(System.in);
        System.out.println(gamepull.getPlayers());
        gamepull.setSTATUS(1);
        XorO();
        gamepull.fillBoard();
        while (gamepull.getSTATUS() == gamepull.PLAYING) {
            if( playerTurn==true && player2Turn==false){
                gamepull.displayBoard(gamepull.board);
            //   System.out.println(gamepull.getplayerNames(0));
                System.out.println("Enter a column from 0 to 3: ");
                col = in.nextInt();
                System.out.println("Enter a row from 0 to 3: ");
                row = in.nextInt();
                System.out.println("Enter the board from 0 to 3");
                sheet = in.nextInt();
                Location area = new Location(col, row, sheet);
                if (gamepull.board[col][row][sheet] == '-') {

                    if (player == 'x') {
                        gamepull.setBoard(col,row,sheet,'x');
                    } else {
                        gamepull.setBoard(col,row,sheet, 'o');
                    }
                    player2Turn = true;
                    playerTurn = false;
                }
                else{
                    System.out.println("Invalid Move!");
                    player2Turn = true;
                    playerTurn = false;
                }
            }
            else{
                gamepull.displayBoard(gamepull.board);
              //  System.out.println(gamepull.getplayerNames(1));
                System.out.println("Enter a column from 0 to 3: ");
                col = in.nextInt();
                System.out.println("Enter a row from 0 to 3: ");
                row = in.nextInt();
                System.out.println("Enter the board from 0 to 3");
                sheet = in.nextInt();
                Location area = new Location(col, row, sheet);
                if (gamepull.board[col][row][sheet] == '-') {

                    if (player2 == 'x') {
                        gamepull.setBoard(col,row,sheet,'x');
                    } else {
                        gamepull.setBoard(col,row,sheet, 'o');
                    }
                    player2Turn = false;
                    playerTurn = true;
                }

                else{
                    System.out.println("Invalid Move!");
                    player2Turn = false;
                    playerTurn = true;
                }
            }
            gamepull.isWinner(gamepull.board);
            gamepull.count(gamepull.board);
        }
        }
}


