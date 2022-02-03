import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
//Don't push to master make new repository for Elevator
//https://docs.oracle.com/javase/tutorial/uiswing/events/keylistener.html
//https://stackoverflow.com/questions/16728591/add-the-characters-of-word-into-the-jbuttons
public class Tic_Tac_Toe_Display extends JPanel implements MouseListener {
    static ArrayList<RoundRectangle2D.Double> rec = new ArrayList<RoundRectangle2D.Double>();
    static ArrayList<RoundRectangle2D.Double> choice1 = new ArrayList<RoundRectangle2D.Double>();
    static ArrayList<RoundRectangle2D.Double> choice2 = new ArrayList<RoundRectangle2D.Double>();
    static ArrayList<RoundRectangle2D.Double> choice3 = new ArrayList<RoundRectangle2D.Double>();
    static ArrayList<RoundRectangle2D.Double> RandomAi = new ArrayList<RoundRectangle2D.Double>();
    boolean SceneOne;
    boolean SceneTwo;
    boolean SceneThree;
    boolean GameStarted;
    boolean playervsplayer;
    boolean playervsAI;
    boolean playervsRandomAi;
    public Tic_Tac_Toe_Display() {
        rec= new ArrayList<>();
        SceneOne=true;
        addMouseListener(this);
        setSize(800, 1200);
        rec.add(new RoundRectangle2D.Double(250.0, 530.0, 240.0, 100.0, 0, 0));
        choice1.add(new RoundRectangle2D.Double(170, 460, 400,50,0,0));
        choice2.add(new RoundRectangle2D.Double(170, 560, 460,50,0,0));
        choice3.add(new RoundRectangle2D.Double(170, 660, 520,50,0,0));
        RandomAi.add(new RoundRectangle2D.Double(170, 460, 400,50,0,0));
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame("Tic Tac Toe");
    }
    public void paint(Graphics g) {
        Graphics2D p = (Graphics2D) g;
        p.setPaint(new Color(36,37,38));
        p.fillRect(0, 0, 800, 1200);
        if(SceneOne==true) {
    // R 36,  G 37,  B 38
    p.setPaint(new Color(255, 128, 128));
    p.setFont(new Font("Sans Serif", Font.BOLD, 60));
    p.drawString("Welcome To", 206, 200);
    p.drawString("Tic Tac Toe", 206, 300);

    p.setPaint(Color.RED);
    p.setFont(new Font("Sans Serif", Font.BOLD, 60));
    p.drawString("Welcome To", 200, 200);
    p.drawString("Tic Tac Toe", 200, 300);
    p.setPaint(new Color(36,37,38));
            for (int i = 0; i < rec.size(); i++) {
                RoundRectangle2D.Double rectangle = rec.get(i);
                ((Graphics2D) g).fill(rectangle);
            }
    p.setPaint(new Color(255, 128, 128));
    p.drawString("PLAY?", 276, 600);
    p.setFont(new Font("Sans Serif", Font.BOLD, 60));
    p.setPaint(new Color(255, 128, 128));
    p.drawRect(251, 530, 240, 100);
    p.setPaint(Color.RED);
    p.drawString("PLAY?", 270, 600);
    p.drawRect(250, 530, 240, 100);
        }
      else  if(SceneTwo==true) {
            p.setPaint(new Color(255, 128, 128));
            p.setFont(new Font("Sans Serif", Font.BOLD, 60));
            p.drawString("Choose your", 200, 200);
            //128, 140, 255
            p.setPaint(new Color(128, 140, 255));
            p.drawString("Gamemode:", 214, 300);
            p.setFont(new Font("Sans Serif", Font.BOLD, 60));
            p.setPaint(Color.RED);
            p.drawString("Choose your", 206, 200);
            p.setPaint(Color.BLUE);
            p.drawString("Gamemode:", 220, 300);
            p.setPaint(new Color(36,37,38));
            //rec choice
            for (int i = 0; i < rec.size(); i++) {
                RoundRectangle2D.Double rectangle = choice1.get(i);
                ((Graphics2D) g).fill(rectangle);
            }
            for (int i = 0; i < rec.size(); i++) {
                RoundRectangle2D.Double rectangle = choice2.get(i);
                ((Graphics2D) g).fill(rectangle);
            }
            for (int i = 0; i < rec.size(); i++) {
                RoundRectangle2D.Double rectangle = choice3.get(i);
                ((Graphics2D) g).fill(rectangle);
            }
            p.setPaint(new Color(255, 128, 128));
            p.setFont(new Font("Sans Serif", Font.BOLD, 40));
            p.drawString("1. Player vs Player ",186, 500);
            p.setPaint(new Color(128, 140, 255));
            p.drawString("2. Player vs Computer ",186, 600);
            p.setPaint(new Color(255, 128, 128));
            p.drawString("3. Computer vs Computer ",186, 700);
            p.setPaint(Color.RED);
            p.setFont(new Font("Sans Serif", Font.BOLD, 40));
            p.drawRect(170, 460, 400,50);
            p.drawString("1. Player vs Player ",190, 500);
            p.setPaint(Color.BLUE);
            p.drawRect(170, 560, 460,50);
            p.drawString("2. Player vs Computer ",190, 600);
            p.setPaint(Color.RED);
            p.drawRect(170, 660, 520,50);
            p.drawString("3. Computer vs Computer ",190, 700);


        }
       else if(SceneThree==true) {
           if(playervsplayer){

           }
if(playervsAI==true){
    p.setPaint(new Color(255, 128, 128));
    p.setFont(new Font("Sans Serif", Font.BOLD, 60));
    p.drawString("Choose your", 200, 200);
    //128, 140, 255
    p.setPaint(new Color(128, 140, 255));
    p.drawString("AI:", 347, 300);
    p.setFont(new Font("Sans Serif", Font.BOLD, 60));
    p.setPaint(Color.RED);
    p.drawString("Choose your", 206, 200);
    p.setPaint(Color.BLUE);
    p.drawString("AI:", 350, 300);
    //choices
    p.setPaint(new Color(36,37,38));
    for (int i = 0; i < RandomAi.size(); i++) {
        RoundRectangle2D.Double rectangle = RandomAi.get(i);
        ((Graphics2D) g).fill(rectangle);
    }
    p.setPaint(new Color(255, 128, 128));
    p.setFont(new Font("Sans Serif", Font.BOLD, 40));
    p.drawString("1. Random AI ",186, 500);
    p.setPaint(Color.RED);
    p.drawString("1. Random AI ",190, 500);
    p.drawRect(170, 460, 400,50);
}
if(GameStarted==true){
    //Put Bpard Here
}
if(playervsAI==true){
    //Put Code Here!
}
        }
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        e.getButton();
        for (int i = 0; i < rec.size(); i++) {
            RoundRectangle2D.Double rectangle = rec.get(i);
            if (rectangle.contains(e.getPoint())) {
           SceneTwo=true;
           SceneOne=false;
           SceneThree=false;
                }
            }
        for (int i = 0; i < choice1.size(); i++) {
            RoundRectangle2D.Double rectangle = choice1.get(i);
            if (rectangle.contains(e.getPoint())) {
                SceneTwo = false;
                SceneThree = true;
                playervsplayer = true;
                GameStarted=true;
            }
        }
            for (int i = 0; i < choice2.size(); i++) {
                RoundRectangle2D.Double rectangle = choice2.get(i);
                if (rectangle.contains(e.getPoint())) {
                    SceneTwo = false;
                    SceneThree = true;
                    playervsAI=true;
                }
        }
        for (int i = 0; i < RandomAi.size(); i++) {
            RoundRectangle2D.Double rectangle = RandomAi.get(i);
            if (rectangle.contains(e.getPoint())) {
                playervsAI=false;
                playervsRandomAi=true;
                GameStarted=true;
            }
        }

        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public void addNotify(){
        super.addNotify();
        requestFocus();
        repaint();
    }
}

