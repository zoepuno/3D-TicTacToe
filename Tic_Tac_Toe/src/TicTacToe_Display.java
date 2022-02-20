import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

public class Tic_Tac_Toe_Display extends JPanel implements MouseListener, KeyListener {
//y=r, x=c, z=s
    Blocking_AI block= new Blocking_AI();
    Game play = new Game();

    public Tic_Tac_Toe_Display() {
        super();
        addMouseListener(this);
        addKeyListener(this);
        setSize(800, 1200);

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
                    p.drawPolygon(play.tile[r][c][s]);
                    if (play.board[r][c][s] != '-')
                    {
                        if(play.board[r][c][s]=='x')
                            p.setColor(new Color(255, 128, 128));
                        else if (play.board[r][c][s]=='o')
                            p.setColor(new Color(163, 185, 224));
                        else if (play.winBoard[r][c][s] =='w')
                            p.setColor(new Color(141, 224, 148));

                        p.fillOval(play.tile[r][c][s].xpoints[0], play.tile[r][c][s].ypoints[0]+5, 35,35);
                        p.setColor(Color.WHITE);
                    }
                }
            }
        }

        //displys p1Wins & p2Wins
        if(!play.Ai1 || !play.Ai2)
        {
            p.setFont(new Font("Sans Serif", Font.BOLD, 30));
            p.setColor(new Color(255, 128, 128));
            p.drawString("Player 1 wins: " + play.p1Wins/2, 400,100);
            p.setColor(new Color(163, 185, 224));
            p.drawString("Player 2 wins: " + play.p2Wins/2, 400,150);
        }
        else{
            p.setFont(new Font("Sans Serif", Font.BOLD, 30));
            p.setColor(new Color(255, 128, 128));
            p.drawString("Player 1 wins: " + play.p1Wins, 400, 100);
            p.setColor(new Color(163, 185, 224));
            p.drawString("Player 2 wins: " + play.p2Wins, 400, 150);
        }

        //prints which player wins
        p.setColor(new Color(141, 224, 148));
        if(play.isWinner(play.p1)){
            p.drawString("PLAYER 1 WINS" , 400,600);
            if(!play.replay && !play.Ai2 || !play.Ai1)
                p.drawString("Press 'r' to replay" , 400,400);
        }
        else if (play.isWinner(play.p2)){
            p.drawString("PLAYER 2 WINS" , 400,600);
            if(!play.replay && !play.Ai2 || !play.Ai1)
                p.drawString("Press 'r' to replay" , 400,400);
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if(!(play.isWinner(play.p1) || play.isWinner(play.p2))){
            if(play.playerInput) {
                double mouseX = e.getX();
                double mouseY = e.getY();

                if (play.playerTurn) {
                    if(!play.playerMoves(mouseX, mouseY, play.p1))
                        return;

                } else{
                    if(!play.playerMoves(mouseX, mouseY, play.p2))
                        return;
                }
                repaint();
                play.playerInput = false;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if((play.isWinner(play.p1) || play.isWinner(play.p2)) && e.getKeyChar() == 'r'){
            System.out.println("r is pressed");
            play.reset();
            repaint();
        }
    }


    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
