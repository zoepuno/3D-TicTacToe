public class Blocking_AI implements PlayerInt {
    char[][][] boardCopy = new char[4][4][4];
    Player play = new Player(null, '0');
    Game game = new Game();
    int col=0;
    int row=0;
    boolean done;
    Location boo;
    public Blocking_AI() {
setBoardCopy();
changeBoard();
    }

    public void setBoardCopy() {
        if (play.getLetter() == 'o') {
            for (int l = 0; l < 4; l++) {
                for (int c = 0; c < 4; c++) {
                    for (int r = 0; r < 4; r++) {
                        boardCopy[l][c][r] = 'x';
                    }
                }
            }
        } else {
            for (int l = 0; l < 4; l++) {
                for (int c = 0; c < 4; c++) {
                    for (int r = 0; r < 4; r++) {
                        boardCopy[l][c][r] = 'o';
                    }
                }
            }
        }
    }

    @Override
    public Location getMove(char[][][] board) {

        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void freshCopy() {

    }
    public void changeBoard() {
        if (play.getLetter() == 'o') {
            for (int l = 0; l < 4; l++) {
                for (int c = 0; c < 4; c++) {
                    for (int r = 0; r < 4; r++) {
                        if (game.board.board[l][c][r] == 'x') {
                            boardCopy[l][c][r]='x';
                        }
                    }
                }
            }
        }
     else{
        for (int l = 0; l < 4; l++) {
            for (int c = 0; c < 4; c++) {
                for (int r = 0; r < 4; r++) {
                    if (game.board.board[c][r][l] == 'o') {
                        boardCopy[c][r][l]='o';
                    }
                }
            }
        }
    }
}
public void move(char player){

    for (int l = 0; l < 4; l++) {
        for (int c = 0; c < 4; c++) {
            for (int r = 0; r < 4; r++) {
                //win first, block next
                //Section 1 O's
                //col
                if(boardCopy[c][0][l]=='x' && player=='o') {
                    col++;
                    if(col==2) {
                        for (int v = 0; c < 4; c++) {
                            if(game.board.board[v][0][l]=='-'){
                                boo=  new Location(v,0,l);
                            }
                        }
                    }
                }
                //row
                else if(boardCopy[0][r][l]=='x' && player=='o') {
                    col++;
                    if(col==2) {
                        for (int v = 0; c < 4; c++) {
                            if(game.board.board[0][r][l]=='-'){

                                boo=  new Location(0,r,l);
                            }
                        }
                    }
                }

                //Section for X's
               else if(boardCopy[c][0][l]=='o' && player=='x') {
                    col++;
                    if(col==2) {
                        for (int v = 0; c < 4; c++) {
                            if(game.board.board[v][0][l]=='-'){

                                boo= new Location(v,0,l);
                            }
                        }
                    }
                }
                //row
                else if(boardCopy[0][r][l]=='o' && player == 'x') {
                    col++;
                    if(col==2) {
                        for (int v = 0; c < 4; c++) {
                            if(game.board.board[0][r][l]=='-'){

                                boo=  new Location(0,r,l);
                            }
                        }
                    }
                }
                else{
                    //corner first
                    if(game.board.board[0][0][l]=='-'){
                        System.out.print("PAIN");
                        boo= new Location(c,r,l);
                    }
                    else if(game.board.board[3][3][l]=='-'){
                        System.out.print("PAIN2");
                       boo=  new Location(c,r,l);
                    }
                    else if(game.board.board[0][3][l]=='-'){
                        System.out.print("PAIN3");
                        boo= new Location(c,r,l);
                    }
                    else if(game.board.board[3][0][l]=='-'){
                        System.out.print("PAIN4");
                        boo= new Location(c,r,l);
                    }
                }
            }
            }
        }
    }

}
/**
 * Every two it puts a block between them
 *    ----------------------------
 *   /  o   /   o   /   x   /
 *   -----------------------------
 *                or
 *  -----------------------------
 *   /   o  /     /  x    /  o
 *   ---------------------------
 *
 *   if theres two in a row, col, or sheet
 *   than add a block in that row col or sheet.
 *   Works for straight and diagonal.
 */
