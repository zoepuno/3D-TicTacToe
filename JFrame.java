import java.awt.*;

public class JFrame extends javax.swing.JFrame {
    public JFrame(String Tic_Tac_Toe_Display_File) {
        super(Tic_Tac_Toe_Display_File);
        setResizable(false);
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 1200));
        setLayout(null);
        Tic_Tac_Toe_Display p = new Tic_Tac_Toe_Display();
        add(p);
        pack();
        setVisible(true);
    }
}
