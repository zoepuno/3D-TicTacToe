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
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class Main extends JPanel implements KeyListener {
    char character;
    Game maingame = new Game();


    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Game staticMainGame = new Game();
        PlayervsPlayer Fight = new PlayervsPlayer();
        String player1;
        String player2;
        String ChosentoPlay;
        int AiAmount;
        int gamemode;
        int play=0;

        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Type: \"PLAY\" to begin");
       ChosentoPlay =  in.nextLine();
        if(ChosentoPlay.equals("Play")||ChosentoPlay.equals("PLAY") ) {
            play=1;
        }
        while (play == 1) {
            //Game mode Selection
            System.out.println("1. Player vs Player ");
            System.out.println("2. Player vs Computer ");
            System.out.println("3. Computer vs Computer ");
            System.out.println("Choose your gamemode: ");
            gamemode=in.nextInt();
            if(gamemode==1){
                //Player Input: Player vs PLayer
                System.out.print("Player One Name: ");
                in.next();
              player1= in.nextLine();
              staticMainGame.addNames(player1);
                System.out.print("Player Two Name: ");
                in.next();
                player2= in.nextLine();
                staticMainGame.addNames(player2);
                Fight.theMainPlayerGame();

            }
            if(gamemode==2) {
                // Player vs Computer
                System.out.print("Choose your name: ");
                in.next();
                player1 = in.nextLine();
                //AI Choices
                System.out.println("How many Ais do you want?");
               AiAmount=in.nextInt();


            }
            //Computer vs Computer
            if(gamemode==3){

            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        character =  e.getKeyChar();
        if(character == 'r');
        maingame.reset();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
