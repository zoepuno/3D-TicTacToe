import java.util.Scanner;

public class Random_Ai {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        char player = 'X';
        char[][] board =
                {
                        {' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' '}
                };

        int x = 0;

        boolean error = false;
        int r;
        int c;
        do {
            System.out.print("\n");
            if (isWinner(board, player)) {
                break;
            }

            if (player == 'X') {
                do {
                    displayBoard(board);
                    System.out.println("Entering 4 for the column or row will save the game.");
                    System.out.print("Enter a column from 0 to 4:");
                    c = keyboard.nextInt();
                    System.out.print("Enter a row from 0 to 4:");
                    r = keyboard.nextInt();
                    if (r == 4 || c == 4) {
                        for (int row = 0; row < board.length; row++) {
                            for (int col = 0; col < board[0].length; col++) {
                            }
                        }
                        break;
                    }

                    if (r > 4) {
                        System.out.println("This spot is taken, enter a new move.\n");
                        error = true;
                    } else if (c > 4) {
                        System.out.println("This spot is taken, enter a new move.\n");
                        error = true;
                    } else if (board[r][c] == 'X' || board[r][c] == 'O') {
                        System.out.println("This spot is taken, enter a new move.\n");
                        error = true;
                    } else if (r < 4 && c < 4) {
                        board[r][c] = 'X';
                        error = false;
                        break;
                    }
                } while (error = true);
            } else {
                do {
                    r = (int) (Math.random() * 4);
                    c = (int) (Math.random() * 4);

                } while (board[r][c] == 'X' || board[r][c] == 'O');
                board[r][c] = 'O';
            }
            if (r == 4 || c == 4) {
                break;
            }

            if (player == 'X')
                player = 'O';
            else
                player = 'X';
        } while (isWinner(board, player) != true && count(board) != true);
        displayBoard(board);
        if (player == 'X')
            player = 'O';
        else
            player = 'X';

    }

    public static void displayBoard(char[][] board) {
        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " ");
    }

    public static boolean isWinner(char[][] board, char player) {
        boolean win = false;

        // X wins
        if (board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X')
            win = true;
        if (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X')
            win = true;
        if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X')
            win = true;
        if (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X')
            win = true;
        if (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X')
            win = true;
        if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')
            win = true;

        // O wins
        if (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O')
            win = true;
        if (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O')
            win = true;
        if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O')
            win = true;
        if (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O')
            win = true;
        if (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O')
            win = true;
        if (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')
            win = true;

        return win;
    }


    public static boolean count(char[][] board) {
        int count = 0;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                if (board[r][c] == 'X' || board[r][c] == 'O') {
                    count++;
                }
            }
        }
        if (count == 9) {
            return true;
        } else
            return false;
    }

    //Moves Randomly
    public static void Random_Ai(char[][] board, int r, int c) {
        do {
            r = (int) (Math.random() * 4);
            c = (int) (Math.random() * 4);
            if (r == 4 || c == 4) {
                break;
            }

        } while (board[r][c] == 'X' || board[r][c] == 'O');
    }
}


