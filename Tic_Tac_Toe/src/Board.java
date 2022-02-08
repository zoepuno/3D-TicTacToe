public class Board {
    public char[][][] board = new char[4][4][4];

    public char[][][] getData() {
        return board;
    }

    public Board() {
        for (int l = 0; l < 4; l++) {
            for (int c = 0; c < 4; c++) {
                for (int r = 0; r < 4; r++) {
                    board[r][c][l] = '-';
                }
            }
        }
    }

    public char getPoint(Location area){
       return board[area.getCol()][area.getRow()][area.getSheet()];
    }
    public void setBoard(Location area,char letter)
    {
        board[area.getCol()][area.getRow()][area.getSheet()] = letter;
    }

    public void displayBoard(char[][][] board) {
        for (int l = 0; l < 4; l++) {
            System.out.println("Level: "+(l+1));
            System.out.println(" " + board[0][0][l] + " | " + board[0][1][l]+ " | " + board[0][2][l] + " | " + board[0][3][l] + " ");
            System.out.println("----------------");
            System.out.println(" " + board[1][0][l] + " | " + board[1][1][l] + " | " + board[1][2][l] + " | " + board[1][3][l] + " ");
            System.out.println("----------------");
            System.out.println(" " + board[2][0][l] + " | " + board[2][1][l] + " | " + board[2][2][l] + " | " + board[2][3][l] + " ");
            System.out.println("----------------");
            System.out.println(" " + board[3][0][l] + " | " + board[3][1][l] + " | " + board[3][2][l] + " | " + board[3][3][l] + " ");

        }
    }

    public boolean count() {
        int count = 0;
        for (int s = 0; s < 4; s++) {
            for (int r = 0; r < board.length; r++) {
                for (int c = 0; c < board.length; c++) {
                    if (board[r][c][s] != '-') {
                        count++;
                    }
                }
            }
        }
        if (count == 64) {
            return true;
        }
        return false;
    }
}