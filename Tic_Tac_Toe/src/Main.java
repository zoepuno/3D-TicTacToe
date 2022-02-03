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


public class Main{

    static Game maingame = new Game();
static int playing;
static int choice;
static int randomAI;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        PlayervsPlayer Fight = new PlayervsPlayer();
        String player1;
        String player2;
        int ChosentoPlay;
        int AiAmount;
        int gamemode;
        int play=0;
       ChosentoPlay=playing;
       
        while (ChosentoPlay== 1) {
            gamemode=choice;
            if(gamemode==1){
                //Player Input: Player vs PLayer
                System.out.print("Player One Name: ");
                in.next();
              player1= in.nextLine();
                maingame.addNames(player1);
                System.out.print("Player Two Name: ");
                in.next();
                player2= in.nextLine();
                maingame.addNames(player2);
                Fight.theMainPlayerGame();

            }
            if(gamemode==2) {
                // Player vs Computer
                System.out.print("Choose your name: ");
                in.next();
                player1 = in.nextLine();
                AiAmount=randomAI;
                if(AiAmount==1){
                    
                }


            }
            //Computer vs Computer
            if(gamemode==3){

            }
        }
    }

}

