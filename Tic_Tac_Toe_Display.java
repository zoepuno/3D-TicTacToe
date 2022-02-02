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
    boolean SceneOne=true;
    boolean SceneTwo;
    boolean SceneThree;
    public Tic_Tac_Toe_Display() {

        addMouseListener(this);
        setSize(800, 1200);
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame("Tic Tac Toe");

    }
    public void paint(Graphics g) {
        Graphics2D p = (Graphics2D) g;
        p.setPaint(new Color(36,37,38));
        if(SceneOne==true) {
    // R 36,  G 37,  B 38
    p.fillRect(0, 0, 800, 1200);
    p.setPaint(new Color(255, 128, 128));
    p.setFont(new Font("Sans Serif", Font.BOLD, 60));
    p.drawString("Welcome To", 206, 200);
    p.drawString("Tic Tac Toe", 206, 300);

    p.setPaint(Color.RED);
    p.setFont(new Font("Sans Serif", Font.BOLD, 60));
    p.drawString("Welcome To", 200, 200);
    p.drawString("Tic Tac Toe", 200, 300);

    p.setPaint(new Color(255, 128, 128));
    p.drawString("PLAY?", 276, 600);
    p.setFont(new Font("Sans Serif", Font.BOLD, 60));
    p.setPaint(Color.RED);
    p.drawString("PLAY?", 270, 600);
        }
        if(SceneTwo==true) {
        }
        if(SceneThree==true) {
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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

