import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.Scanner;
//Don't push to master make new repository for Elevator
//https://docs.oracle.com/javase/tutorial/uiswing/events/keylistener.html
//https://stackoverflow.com/questions/16728591/add-the-characters-of-word-into-the-jbuttons


public class Tic_Tac_Toe_Display extends JPanel implements MouseListener,Runnable{
    static ArrayList<RoundRectangle2D.Double> play = new ArrayList<RoundRectangle2D.Double>();
    static ArrayList<RoundRectangle2D.Double> choice1 = new ArrayList<RoundRectangle2D.Double>();
    static ArrayList<RoundRectangle2D.Double> choice2 = new ArrayList<RoundRectangle2D.Double>();
    static ArrayList<RoundRectangle2D.Double> choice3 = new ArrayList<RoundRectangle2D.Double>();
    static ArrayList<RoundRectangle2D.Double> RandomAi = new ArrayList<RoundRectangle2D.Double>();
    boolean SceneOne;
    boolean SceneTwo;
    boolean SceneThree;
    private Thread t;

    boolean playervsplayer = false;
    boolean playervsAI = false;
    boolean playervsRandomAi = false;
    int m;
    static Game mg = new Game();
    Scanner in = new Scanner(System.in);

    public Tic_Tac_Toe_Display() {

        // Sets it's size
        setSize(800, 1200);
        setVisible(true);

        addMouseListener(this);
        play = new ArrayList<>();
        SceneOne=true;
        play.add(new RoundRectangle2D.Double(250.0, 330.0, 240.0, 100.0, 10, 10));
        choice1.add(new RoundRectangle2D.Double(170, 460, 400,50,10,10));
        choice2.add(new RoundRectangle2D.Double(170, 560, 460,50,10,10));
        choice3.add(new RoundRectangle2D.Double(170, 660, 520,50,10,10));
        RandomAi.add(new RoundRectangle2D.Double(170, 460, 400,50,10,10));
        repaint();

    }

    public void paint(Graphics g) {
        addNotify();
        Graphics2D p = (Graphics2D) g;

        p.setPaint(new Color(36, 37, 38));
        p.fillRect(0, 0, 800, 1200);

        //intro to play
        if (SceneOne == true) {
            // R 36,  G 37,  B 38
            p.setPaint(new Color(255, 128, 128));
            p.setFont(new Font("Sans Serif", Font.BOLD, 60));
            p.drawString("Welcome To", 206, 200);
            p.drawString("Tic Tac Toe", 206, 300);

            p.setPaint(Color.RED);
            p.setFont(new Font("Sans Serif", Font.BOLD, 60));
            p.drawString("Welcome To", 200, 200);
            p.drawString("Tic Tac Toe", 200, 300);


            p.setPaint(new Color(36, 37, 38));
            for (int i = 0; i < play.size(); i++) {
                RoundRectangle2D.Double rectangle = play.get(i);
                ((Graphics2D) g).fill(rectangle);
            }
            p.setPaint(new Color(255, 128, 128));
            p.drawString("PLAY?", 276, 400);
            p.setFont(new Font("Sans Serif", Font.BOLD, 60));
            p.setPaint(new Color(163, 185, 224));
            p.drawRect(250, 330, 240, 100);
            p.setPaint(Color.RED);
            p.drawString("PLAY?", 270, 400);
            p.drawRect(250, 330, 240, 100);
        }

        //choose gamemode
        else if (SceneTwo == true) {
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
            p.setPaint(new Color(36, 37, 38));

            //rec choice
            for (int i = 0; i < play.size(); i++) {
                RoundRectangle2D.Double rectangle = choice1.get(i);
                ((Graphics2D) g).fill(rectangle);
            }
            for (int i = 0; i < play.size(); i++) {
                RoundRectangle2D.Double rectangle = choice2.get(i);
                ((Graphics2D) g).fill(rectangle);
            }
            for (int i = 0; i < play.size(); i++) {
                RoundRectangle2D.Double rectangle = choice3.get(i);
                ((Graphics2D) g).fill(rectangle);
            }
            p.setPaint(new Color(255, 128, 128));
            p.setFont(new Font("Sans Serif", Font.BOLD, 40));
            p.drawString("1. Player vs Player ", 186, 500);
            p.setPaint(new Color(128, 140, 255));
            p.drawString("2. Player vs Computer ", 186, 600);
            p.setPaint(new Color(255, 128, 128));
            p.drawString("3. Computer vs Computer ", 186, 700);
            p.setPaint(Color.RED);
            p.setFont(new Font("Sans Serif", Font.BOLD, 40));
            p.drawRect(170, 460, 400, 50);
            p.drawString("1. Player vs Player ", 190, 500);
            p.setPaint(Color.BLUE);
            p.drawRect(170, 560, 460, 50);
            p.drawString("2. Player vs Computer ", 190, 600);
            p.setPaint(Color.RED);
            p.drawRect(170, 660, 520, 50);
            p.drawString("3. Computer vs Computer ", 190, 700);
        }

        //game type begins
        else if (SceneThree == true) {
            if (playervsplayer) {

            }
            if (playervsAI == true) {
                p.setPaint(new Color(255, 128, 128));
                p.setFont(new Font("Sans Serif", Font.BOLD, 60));
                p.drawString("Choose your", 200, 200);
                p.setPaint(new Color(128, 140, 255));
                p.drawString("AI:", 347, 300);
                p.setFont(new Font("Sans Serif", Font.BOLD, 60));
                p.setPaint(Color.RED);
                p.drawString("Choose your", 206, 200);
                p.setPaint(Color.BLUE);
                p.drawString("AI:", 350, 300);
                //choices
                p.setPaint(new Color(36, 37, 38));
                for (int i = 0; i < RandomAi.size(); i++) {
                    RoundRectangle2D.Double rectangle = RandomAi.get(i);
                    ((Graphics2D) g).fill(rectangle);
                }
                p.setPaint(new Color(255, 128, 128));
                p.setFont(new Font("Sans Serif", Font.BOLD, 40));
                p.drawString("1. Random AI ", 186, 500);
                p.setPaint(Color.RED);
                p.drawString("1. Random AI ", 190, 500);
                p.drawRect(170, 460, 400, 50);
            }
        }

        if(mg.STATUS == mg.PLAYING) {
            //Prints Board
            int[] a = {100, 200, 225, 125, 100};
            int[] b = {550, 550, 525, 525, 550};
            for (int s = 0; s < 4; s++) {
                for (int r = 0; r < 4; r++) {
                    for (int c = 0; c < 4; c++) {
                        p.setPaint(Color.WHITE);
                        p.drawPolygon(a, b, 5);

                        Location area = new Location(c, r, s);
                        char type = Main.mg.board.getPoint(area);

                        if (type == 'x') {
                            p.setPaint(new Color(255, 128, 128));
                            p.fillPolygon(a, b, 5);
                        }

                        if (type == 'o') {
                            p.setPaint(new Color(128, 140, 255));
                            p.fillPolygon(a, b, 5);
                        }
                        for (m = 0; m < 5; m++)
                            a[m] += 100;
                    }
                    for (m = 0; m < 5; m++) {
                        a[m] -= 375;
                        b[m] -= 25;
                    }
                }
                for (m = 0; m < 5; m++) {
                    a[m] -= 100;
                    b[m] -= 25;
                }
            }

            //prints player turn
            p.setPaint(new Color(226, 225, 187));
            p.setFont(new Font("Sans Serif", Font.BOLD, 30));
            p.drawString("Player Turn: ", 100, 600);
            if (mg.playerturn)//p1
            {
                p.setPaint(new Color(234, 153, 150));
                p.setFont(new Font("Sans Serif", Font.BOLD, 30));
                p.drawString(Main.mg.player1.getName(), 300, 600);
            }
            //p2
            if (!mg.playerturn) {
                p.setPaint(new Color(163, 185, 224));
                p.setFont(new Font("Sans Serif", Font.BOLD, 30));
                p.drawString(Main.mg.player2.getName(), 300, 600);
            }
            play();
        }
        repaint();
    }

    public void play(){
        SceneThree = false;
        mg.STATUS = mg.PLAYING;
            if(playervsplayer)
            {

            }
            else if(playervsRandomAi)
            {
                //sets up person as first player
                System.out.print("Player One Name: ");
               // mg.player1.name = in.next();
                mg.addNames(mg.player1.name );

                //sets up AI as second player
                Random_Ai random = new Random_Ai("Random", 'x');
                mg.player2.name = random.getName();

                System.out.println("Hello" + mg.player1.name);
                System.out.println("Player Two is " + random.getName());

                // Let player 1 take a turn
                if (mg.playerturn) {
                    if (mg.moveCheck(mg.board.board, mg.p1)) {  // make sure it's a valid move
                        mg.board.setBoard(mg.p1, mg.player1.getLetter());

                        if (Main.mg.board.count()) {
                            System.out.println("Game ends in a draw.");
                            mg.gameOver = true;
                        } else if (mg.isWinner(mg.board.board) == mg.PlAYER1) {
                            System.out.println("P1 wins!");
                            mg.gameOver = true;
                        }
                    }
                }
                //p2 - Ai's turn
                if (!mg.playerturn && !mg.gameOver) {
                    random.random_move(mg.board.board);
                    mg.p2 = new Location(random.getC(), random.getR(), random.getS());
                    if (mg.moveCheck(mg.board.board, mg.p2))  // make sure it's valid move
                        mg.board.setBoard(mg.p2, mg.player2.letter);

                    if (mg.board.count()) {
                        System.out.println("Game ends in a draw.");
                        mg.gameOver = true;
                    } else if (mg.isWinner(mg.board.board) == mg.PlAYER2) {
                        System.out.println("P2 wins!");
                        mg.gameOver = true;
                    }
                }
                mg.setPlayerturn();
            }

        }

    @Override
    public void run() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }
    @Override
    public void mouseClicked (MouseEvent e) {
        e.getButton();

        //pressed [Play]
        for (int i = 0; i < play.size(); i++) {
            RoundRectangle2D.Double rectangle = play.get(i);
            if (rectangle.contains(e.getPoint())) {
                SceneTwo = true;
                SceneOne = false;
                SceneThree = false;
                System.out.println("Pressed Play");
            }
        }
        //pressed [PvsP]
        for (int i = 0; i < choice1.size(); i++) {
            RoundRectangle2D.Double rectangle = choice1.get(i);
            if (rectangle.contains(e.getPoint())) {
                SceneTwo = false;
                SceneThree = true;
                playervsplayer = true;
                System.out.println("Pressed PvP");
            }
        }

        //pressed [PvsAi]
        for (int i = 0; i < choice2.size(); i++) {

            RoundRectangle2D.Double rectangle = choice2.get(i);
            if (rectangle.contains(e.getPoint())) {
                SceneTwo = false;
                SceneThree = true;
                playervsAI = true;
                System.out.println("Pressed PvsAi");
            }
        }
        //pressed [PvsRAi]
        for (int i = 0; i < RandomAi.size(); i++) {

            RoundRectangle2D.Double rectangle = RandomAi.get(i);
            if (rectangle.contains(e.getPoint())) {
                playervsAI = false;
                playervsRandomAi = true;
                mg.STATUS = mg.PLAYING;
                System.out.println("Pressed PvsRandom");
            }

            //click on grid
            if (mg.STATUS == mg.PLAYING)
                System.out.println("Pressed Board");{
                int x = e.getX(), y = e.getY();
                System.out.println(x + "," + y);
                if (mg.playerturn)
                    Main.mg.p1 = Location(x, y);
                if (mg.playerturn)
                    Main.mg.p2 = Location(x, y);

                if (!mg.playerturn)//player 1 spot
                    Main.mg.p1 = Location(x, y);

                if (Main.mg.gameOver)
                    System.out.println("Press REPLAY button to play again.");
                repaint();
            }

        }
    }

    public Location Location(int x, int y)
    {
        int c = 0;
        int r = 0;
        int s = 0;
        int row = 0;
        int col = 0;

        //sheet 0
        if(y>=75 && y<175){
            s=0;
            //row
            row = 0;
            for(int yrow = 75; yrow<= 150; yrow+=25)
            {
                if (y >= yrow && y < yrow+25)
                {
                    r = row;
                }
                row++;
            }
        }

        //sheet 1
        if(y>=200 && y<300){
            s = 1;
            row=0;
            for(int yrow = 200; yrow<= 275; yrow+=25)
            {
                if (y  >= yrow && y < yrow+25)
                {
                    r = row;
                }
                row++;
            }
        }
        //sheet 2
        if(y>=325 && y<425){
            s = 2;
            //row
            row = 0;
            for(int yrow = 325; yrow <= 400; yrow+=25)
            {
                if (y  >= yrow && y < yrow+25)
                {
                    r = row;
                }
                row++;
            }
        }

        //sheet 3
        if(y>=450 && y<550){
            s = 3;
            row = 0;
            for(int yrow = 450; yrow<=525; yrow+=25)
            {
                if (y  >= yrow && y < yrow+25)
                {
                    r = row;
                }
                row++;
            }
        }

        //determine column
        if(r==0) {
            for (int xcol = 200; xcol <= 500; xcol += 100) {
                if (x >= xcol && x < xcol + 100) {
                    c = col;
                }
                col++;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.Scanner;
//Don't push to master make new repository for Elevator
//https://docs.oracle.com/javase/tutorial/uiswing/events/keylistener.html
//https://stackoverflow.com/questions/16728591/add-the-characters-of-word-into-the-jbuttons


public class Tic_Tac_Toe_Display extends JPanel implements MouseListener,Runnable{
    static ArrayList<RoundRectangle2D.Double> play = new ArrayList<RoundRectangle2D.Double>();
    static ArrayList<RoundRectangle2D.Double> choice1 = new ArrayList<RoundRectangle2D.Double>();
    static ArrayList<RoundRectangle2D.Double> choice2 = new ArrayList<RoundRectangle2D.Double>();
    static ArrayList<RoundRectangle2D.Double> choice3 = new ArrayList<RoundRectangle2D.Double>();
    static ArrayList<RoundRectangle2D.Double> RandomAi = new ArrayList<RoundRectangle2D.Double>();
    boolean SceneOne;
    boolean SceneTwo;
    boolean SceneThree;
    private Thread t;

    boolean playervsplayer = false;
    boolean playervsAI = false;
    boolean playervsRandomAi = false;
    int m;
    static Game mg = new Game();
    Scanner in = new Scanner(System.in);

    public Tic_Tac_Toe_Display() {

        // Sets it's size
        setSize(800, 1200);
        setVisible(true);

        addMouseListener(this);
        play = new ArrayList<>();
        SceneOne=true;
        play.add(new RoundRectangle2D.Double(250.0, 330.0, 240.0, 100.0, 10, 10));
        choice1.add(new RoundRectangle2D.Double(170, 460, 400,50,10,10));
        choice2.add(new RoundRectangle2D.Double(170, 560, 460,50,10,10));
        choice3.add(new RoundRectangle2D.Double(170, 660, 520,50,10,10));
        RandomAi.add(new RoundRectangle2D.Double(170, 460, 400,50,10,10));
        repaint();

    }

    public void paint(Graphics g) {
        addNotify();
        Graphics2D p = (Graphics2D) g;

        p.setPaint(new Color(36, 37, 38));
        p.fillRect(0, 0, 800, 1200);

        //intro to play
        if (SceneOne == true) {
            // R 36,  G 37,  B 38
            p.setPaint(new Color(255, 128, 128));
            p.setFont(new Font("Sans Serif", Font.BOLD, 60));
            p.drawString("Welcome To", 206, 200);
            p.drawString("Tic Tac Toe", 206, 300);

            p.setPaint(Color.RED);
            p.setFont(new Font("Sans Serif", Font.BOLD, 60));
            p.drawString("Welcome To", 200, 200);
            p.drawString("Tic Tac Toe", 200, 300);


            p.setPaint(new Color(36, 37, 38));
            for (int i = 0; i < play.size(); i++) {
                RoundRectangle2D.Double rectangle = play.get(i);
                ((Graphics2D) g).fill(rectangle);
            }
            p.setPaint(new Color(255, 128, 128));
            p.drawString("PLAY?", 276, 400);
            p.setFont(new Font("Sans Serif", Font.BOLD, 60));
            p.setPaint(new Color(163, 185, 224));
            p.drawRect(250, 330, 240, 100);
            p.setPaint(Color.RED);
            p.drawString("PLAY?", 270, 400);
            p.drawRect(250, 330, 240, 100);
        }

        //choose gamemode
        else if (SceneTwo == true) {
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
            p.setPaint(new Color(36, 37, 38));

            //rec choice
            for (int i = 0; i < play.size(); i++) {
                RoundRectangle2D.Double rectangle = choice1.get(i);
                ((Graphics2D) g).fill(rectangle);
            }
            for (int i = 0; i < play.size(); i++) {
                RoundRectangle2D.Double rectangle = choice2.get(i);
                ((Graphics2D) g).fill(rectangle);
            }
            for (int i = 0; i < play.size(); i++) {
                RoundRectangle2D.Double rectangle = choice3.get(i);
                ((Graphics2D) g).fill(rectangle);
            }
            p.setPaint(new Color(255, 128, 128));
            p.setFont(new Font("Sans Serif", Font.BOLD, 40));
            p.drawString("1. Player vs Player ", 186, 500);
            p.setPaint(new Color(128, 140, 255));
            p.drawString("2. Player vs Computer ", 186, 600);
            p.setPaint(new Color(255, 128, 128));
            p.drawString("3. Computer vs Computer ", 186, 700);
            p.setPaint(Color.RED);
            p.setFont(new Font("Sans Serif", Font.BOLD, 40));
            p.drawRect(170, 460, 400, 50);
            p.drawString("1. Player vs Player ", 190, 500);
            p.setPaint(Color.BLUE);
            p.drawRect(170, 560, 460, 50);
            p.drawString("2. Player vs Computer ", 190, 600);
            p.setPaint(Color.RED);
            p.drawRect(170, 660, 520, 50);
            p.drawString("3. Computer vs Computer ", 190, 700);
        }

        //game type begins
        else if (SceneThree == true) {
            if (playervsplayer) {

            }
            if (playervsAI == true) {
                p.setPaint(new Color(255, 128, 128));
                p.setFont(new Font("Sans Serif", Font.BOLD, 60));
                p.drawString("Choose your", 200, 200);
                p.setPaint(new Color(128, 140, 255));
                p.drawString("AI:", 347, 300);
                p.setFont(new Font("Sans Serif", Font.BOLD, 60));
                p.setPaint(Color.RED);
                p.drawString("Choose your", 206, 200);
                p.setPaint(Color.BLUE);
                p.drawString("AI:", 350, 300);
                //choices
                p.setPaint(new Color(36, 37, 38));
                for (int i = 0; i < RandomAi.size(); i++) {
                    RoundRectangle2D.Double rectangle = RandomAi.get(i);
                    ((Graphics2D) g).fill(rectangle);
                }
                p.setPaint(new Color(255, 128, 128));
                p.setFont(new Font("Sans Serif", Font.BOLD, 40));
                p.drawString("1. Random AI ", 186, 500);
                p.setPaint(Color.RED);
                p.drawString("1. Random AI ", 190, 500);
                p.drawRect(170, 460, 400, 50);
            }
        }

        if(mg.STATUS == mg.PLAYING) {
            //Prints Board
            int[] a = {100, 200, 225, 125, 100};
            int[] b = {550, 550, 525, 525, 550};
            for (int s = 0; s < 4; s++) {
                for (int r = 0; r < 4; r++) {
                    for (int c = 0; c < 4; c++) {
                        p.setPaint(Color.WHITE);
                        p.drawPolygon(a, b, 5);

                        Location area = new Location(c, r, s);
                        char type = Main.mg.board.getPoint(area);

                        if (type == 'x') {
                            p.setPaint(new Color(255, 128, 128));
                            p.fillPolygon(a, b, 5);
                        }

                        if (type == 'o') {
                            p.setPaint(new Color(128, 140, 255));
                            p.fillPolygon(a, b, 5);
                        }
                        for (m = 0; m < 5; m++)
                            a[m] += 100;
                    }
                    for (m = 0; m < 5; m++) {
                        a[m] -= 375;
                        b[m] -= 25;
                    }
                }
                for (m = 0; m < 5; m++) {
                    a[m] -= 100;
                    b[m] -= 25;
                }
            }

            //prints player turn
            p.setPaint(new Color(226, 225, 187));
            p.setFont(new Font("Sans Serif", Font.BOLD, 30));
            p.drawString("Player Turn: ", 100, 600);
            if (mg.playerturn)//p1
            {
                p.setPaint(new Color(234, 153, 150));
                p.setFont(new Font("Sans Serif", Font.BOLD, 30));
                p.drawString(Main.mg.player1.getName(), 300, 600);
            }
            //p2
            if (!mg.playerturn) {
                p.setPaint(new Color(163, 185, 224));
                p.setFont(new Font("Sans Serif", Font.BOLD, 30));
                p.drawString(Main.mg.player2.getName(), 300, 600);
            }
            play();
        }
        repaint();
    }

    public void play(){
        SceneThree = false;
        mg.STATUS = mg.PLAYING;
            if(playervsplayer)
            {
                // insert Player vs. Player Game Here
            }
            else if(playervsRandomAi)
            {
                //sets up person as first player
                System.out.print("Player One Name: ");
               // mg.player1.name = in.next();
                mg.addNames(mg.player1.name );

                //sets up AI as second player
                Random_Ai random = new Random_Ai("Random", 'x');
                mg.player2.name = random.getName();

                System.out.println("Hello" + mg.player1.name);
                System.out.println("Player Two is " + random.getName());

                // Let player 1 take a turn
                if (mg.playerturn) {
                    if (mg.moveCheck(mg.board.board, mg.p1)) {  // make sure it's a valid move
                        mg.board.setBoard(mg.p1, mg.player1.getLetter());

                        if (Main.mg.board.count()) {
                            System.out.println("Game ends in a draw.");
                            mg.gameOver = true;
                        } else if (mg.isWinner(mg.board.board) == mg.PlAYER1) {
                            System.out.println("P1 wins!");
                            mg.gameOver = true;
                        }
                    }
                }
                //p2 - Ai's turn
                if (!mg.playerturn && !mg.gameOver) {
                    random.random_move(mg.board.board);
                    mg.p2 = new Location(random.getC(), random.getR(), random.getS());
                    if (mg.moveCheck(mg.board.board, mg.p2))  // make sure it's valid move
                        mg.board.setBoard(mg.p2, mg.player2.letter);

                    if (mg.board.count()) {
                        System.out.println("Game ends in a draw.");
                        mg.gameOver = true;
                    } else if (mg.isWinner(mg.board.board) == mg.PlAYER2) {
                        System.out.println("P2 wins!");
                        mg.gameOver = true;
                    }
                }
                mg.setPlayerturn();
            }

        }

    @Override
    public void run() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }
    @Override
    public void mouseClicked (MouseEvent e) {
        e.getButton();

        //pressed [Play]
        for (int i = 0; i < play.size(); i++) {
            RoundRectangle2D.Double rectangle = play.get(i);
            if (rectangle.contains(e.getPoint())) {
                SceneTwo = true;
                SceneOne = false;
                SceneThree = false;
                System.out.println("Pressed Play");
            }
        }
        //pressed [PvsP]
        for (int i = 0; i < choice1.size(); i++) {
            RoundRectangle2D.Double rectangle = choice1.get(i);
            if (rectangle.contains(e.getPoint())) {
                SceneTwo = false;
                SceneThree = true;
                playervsplayer = true;
                System.out.println("Pressed PvP");
            }
        }

        //pressed [PvsAi]
        for (int i = 0; i < choice2.size(); i++) {

            RoundRectangle2D.Double rectangle = choice2.get(i);
            if (rectangle.contains(e.getPoint())) {
                SceneTwo = false;
                SceneThree = true;
                playervsAI = true;
                System.out.println("Pressed PvsAi");
            }
        }
        //pressed [PvsRAi]
        for (int i = 0; i < RandomAi.size(); i++) {

            RoundRectangle2D.Double rectangle = RandomAi.get(i);
            if (rectangle.contains(e.getPoint())) {
                playervsAI = false;
                playervsRandomAi = true;
                mg.STATUS = mg.PLAYING;
                System.out.println("Pressed PvsRandom");
            }

            //click on grid
            if (mg.STATUS == mg.PLAYING)
                System.out.println("Pressed Board");{
                int x = e.getX(), y = e.getY();
                System.out.println(x + "," + y);
                if (mg.playerturn)
                    Main.mg.p1 = Location(x, y);
                if (mg.playerturn)
                    Main.mg.p2 = Location(x, y);

                if (!mg.playerturn)//player 1 spot
                    Main.mg.p1 = Location(x, y);

                if (Main.mg.gameOver)
                    System.out.println("Press REPLAY button to play again.");
                repaint();
            }

        }
    }

    public Location Location(int x, int y)
    {
        int c = 0;
        int r = 0;
        int s = 0;
        int row = 0;
        int col = 0;

        //sheet 0
        if(y>=75 && y<175){
            s=0;
            //row
            row = 0;
            for(int yrow = 75; yrow<= 150; yrow+=25)
            {
                if (y >= yrow && y < yrow+25)
                {
                    r = row;
                }
                row++;
            }
        }

        //sheet 1
        if(y>=200 && y<300){
            s = 1;
            row=0;
            for(int yrow = 200; yrow<= 275; yrow+=25)
            {
                if (y  >= yrow && y < yrow+25)
                {
                    r = row;
                }
                row++;
            }
        }
        //sheet 2
        if(y>=325 && y<425){
            s = 2;
            //row
            row = 0;
            for(int yrow = 325; yrow <= 400; yrow+=25)
            {
                if (y  >= yrow && y < yrow+25)
                {
                    r = row;
                }
                row++;
            }
        }

        //sheet 3
        if(y>=450 && y<550){
            s = 3;
            row = 0;
            for(int yrow = 450; yrow<=525; yrow+=25)
            {
                if (y  >= yrow && y < yrow+25)
                {
                    r = row;
                }
                row++;
            }
        }

        //determine column
        if(r==0) {
            for (int xcol = 200; xcol <= 500; xcol += 100) {
                if (x >= xcol && x < xcol + 100) {
                    c = col;
                }
                col++;
            }
        }
        if(r==1) {
            for (int xcol = 175; xcol <= 475; xcol += 100) {
                if (x >= xcol && x < xcol + 100) {
                    c = col;
                }
                col++;
            }
        }
        if(r==2) {
            for (int xcol = 150; xcol <= 450; xcol += 100) {
                if (x >= xcol && x < xcol + 100) {
                    c = col;
                }
                col++;
            }
        }
        if(r==3) {
            for (int xcol = 125; xcol <= 425; xcol += 100) {
                if (x >= xcol && x < xcol + 100) {
                    c = col;
                }
                col++;
            }
        }

        Location area = new Location(c, r, s);
        System.out.println(area.toString());
        return area;
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




