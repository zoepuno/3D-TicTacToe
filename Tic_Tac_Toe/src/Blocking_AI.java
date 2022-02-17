public class Blocking_AI implements PlayerInt {
    char[][][] boardCopy = new char[4][4][4];
    Player play = new Player(null, '0');
    int col = 0;
    int row = 0;
    boolean done;
    Location boo;
    char board[][][];
    boolean moved;

    public Blocking_AI( ) {

    }

    public void setBoardCopy() {
        if (Tic_Tac_Toe_Display.Ai1 == true) {
            for (int l = 0; l < 4; l++) {
                for (int c = 0; c < 4; c++) {
                    for (int r = 0; r < 4; r++) {
                        boardCopy[l][r][c] = 'x';

                    }
                }
            }
        }
        if (Tic_Tac_Toe_Display.Ai2 == true) {
            for (int l = 0; l < 4; l++) {
                for (int c = 0; c < 4; c++) {
                    for (int r = 0; r < 4; r++) {
                        boardCopy[l][r][c] = 'o';
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
    public void displayBoard(char[][][] boardCopy) {
        for (int l = 0; l < 4; l++) {
            System.out.println("Level: " + (l + 1));
            System.out.println(" " + boardCopy[0][0][l] + " | " + boardCopy[0][1][l] + " | " + boardCopy[0][2][l] + " | " + boardCopy[0][3][l] + " ");
            System.out.println("----------------");
            System.out.println(" " + boardCopy[1][0][l] + " | " + boardCopy[1][1][l] + " | " + boardCopy[1][2][l] + " | " + boardCopy[1][3][l] + " ");
            System.out.println("----------------");
            System.out.println(" " + boardCopy[2][0][l] + " | " + boardCopy[2][1][l] + " | " + boardCopy[2][2][l] + " | " + boardCopy[2][3][l] + " ");
            System.out.println("----------------");
            System.out.println(" " + boardCopy[3][0][l] + " | " + boardCopy[3][1][l] + " | " + boardCopy[3][2][l] + " | " + boardCopy[3][3][l] + " ");
        }
        }
    public void changeBoard() {
        if (Tic_Tac_Toe_Display.Ai2 == true) {
            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 4; c++) {
                    for (int s = 0; s < 4; s++) {
                        if (board[r][c][s] == 'x') {
                            boardCopy[r][c][s] = 'x';
                        }
                    }
                }
            }
        }
        if (Tic_Tac_Toe_Display.Ai2 == false) {
            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 4; c++) {
                    for (int s = 0; s < 4; s++) {
                        if (board[r][c][s] == 'o') {
                            boardCopy[r][c][s] = 'o';
                        }
                    }
                }
            }
        }
    }

    public boolean move(char player, char board[][][]) {
        int col=0;
        int row=0;
        int sheet=0;
        this.board=board;
moved=false;
        while(!moved) {
            //row check
            for (int s = 0; s < 4; s++) {
                for (int r = 0; r < 4; r++) {
                    row = 0;
                    for (int c = 0; c < 4; c++) {
                        if (!(boardCopy[r][c][s] == player)) {
                            row++;
                        }
                        if (row == 3) {
                            for (int m = 0; m < 4; m++) {
                                if (board[m][c][s] == '-') {
                                    boo = new Location(c, r, s);
                                    moved=true;
                                }

                            }
                        }
                      else if (row == 2) {
                            for (int m = 0; m < 4; m++) {
                                if (board[m][c][s] == '-') {
                                    boo = new Location(c, r, s);
                                    moved=true;
                                }

                            }
                        }

                    }

                }
            }
            //col check
            for (int s = 0; s < 4; s++) {
                    for (int c = 0; c < 4; c++) {
                        col=0;
                        for (int r = 0; r < 4; r++) {
                        if (!(boardCopy[r][c][s] == player)) {
                            col++;
                        }
                        if (col == 3) {
                            for (int m = 0; m < 4; m++) {
                                if (board[m][c][s] == '-') {
                                    boo = new Location(c, r, s);
                                    moved=true;
                                }

                            }
                        }
                        else if (col == 2) {
                            for (int m = 0; m < 4; m++) {
                                if (board[m][c][s] == '-') {
                                    boo = new Location(c, r, s);
                                    moved=true;
                                }

                            }
                        }

                    }

                }
            }
            //row down
                    for (int r = 0; r < 4; r++) {
                    row = 0;
                    for (int c = 0; c < 4; c++) {
                        for (int s = 0; s < 4; s++) {
                        if (!(boardCopy[r][c][s] == player)) {
                            row++;
                        }
                        if (row == 3) {
                            for (int m = 0; m < 4; m++) {
                                if (board[m][c][s] == '-') {
                                    boo = new Location(c, r, s);
                                    moved=true;
                                }

                            }
                        }
                        else if (row == 2) {
                            for (int m = 0; m < 4; m++) {
                                if (board[m][c][s] == '-') {
                                    boo = new Location(c, r, s);
                                    moved=true;
                                }

                            }
                        }

                    }

                }
            }
            //col check
                for (int c = 0; c < 4; c++) {
                    col=0;
                    for (int r = 0; r < 4; r++) {
                        for (int s = 0; s < 4; s++) {
                        if (!(boardCopy[r][c][s] == player)) {
                            col++;
                        }
                        if (col == 3) {
                            for (int m = 0; m < 4; m++) {
                                if (board[m][c][s] == '-') {
                                    boo = new Location(c, r, s);
                                    moved=true;
                                }

                            }
                        }
                        else if (col == 2) {
                            for (int m = 0; m < 4; m++) {
                                if (board[m][c][s] == '-') {
                                    boo = new Location(c, r, s);
                                    moved=true;
                                }

                            }
                        }

                    }

                }
            }
            //if there's nothing to block put in corner
            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 4; c++) {
                    for (int s = 0; s < 4; s++) {

                        //corner first
                        if (board[0][0][s] == '-') {
                            boo = new Location(c, r, s);
                            moved=true;
                        } else if (board[3][3][s] == '-') {
                            boo = new Location(c, r, s);
                            moved=true;
                        } else if (board[0][3][s] == '-') {
                            boo = new Location(c, r, s);
                            moved=true;
                        } else if (board[3][0][s] == '-') {
                            boo = new Location(c, r, s);
                          moved=true;

                        }
                    }
                }
            }
        }

            board[boo.getRow()][boo.getCol()][boo.getSheet()] = player;
            System.out.print("\n"+ board + " "+boardCopy);
            changeBoard();
            displayBoard(boardCopy);
            return moved;
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
 *
 *
 *
 *   old Code:
 *      //Section 1 O's
 *                     //win first, block next
 *                     //col
 *                     if (boardCopy[c][0][l] == 'x' && Tic_Tac_Toe_Display.Ai2 == true) {
 *                         col++;
 *                         if (col == 2) {
 *                             for (int v = 0; c < 4; c++) {
 *                                 if (game.board.board[v][0][l] == '-') {
 *                                     boo = new Location(v, 0, l);
 *                                 }
 *                             }
 *                         }
 *                     }
 *                     //row
 *                     else if (boardCopy[0][r][l] =='x' && Tic_Tac_Toe_Display.Ai2 == true) {
 *                         col++;
 *                         if (col == 2) {
 *                             for (int v = 0; c < 4; c++) {
 *                                 if (game.board.board[0][r][l] == '-') {
 *
 *                                     boo = new Location(0, r, l);
 *                                 }
 *                             }
 *                         }
 *                     }
 *
 *                     //Section for X's
 *                     else if (boardCopy[c][0][l] == 'o' && Tic_Tac_Toe_Display.Ai1 == true) {
 *                         col++;
 *                         if (col == 2) {
 *                             for (int v = 0; c < 4; c++) {
 *                                 if (game.board.board[v][0][l] == '-') {
 *
 *                                     boo = new Location(v, 0, l);
 *                                 }
 *                             }
 *                         }
 *                     }
 *                     //row
 *                     else if (boardCopy[0][r][l] == 'o' && Tic_Tac_Toe_Display.Ai1 == true) {
 *                         col++;
 *                         if (col == 2) {
 *                             for (int v = 0; c < 4; c++) {
 *                                 if (game.board.board[0][r][l] == '-') {
 *
 *                                     boo = new Location(0, r, l);
 *                                 }
 *                             }
 *                         }
 *                     } else {
 *                         //corner first
 *                         if (game.board.board[0][0][l] == '-') {
 *                             boo = new Location(c, r, l);
 *                         } else if (game.board.board[3][3][l] == '-') {
 *                             boo = new Location(c, r, l);
 *                         } else if (game.board.board[0][3][l] == '-') {
 *                             boo = new Location(c, r, l);
 *                         } else if (game.board.board[3][0][l] == '-') {
 *                             boo = new Location(c, r, l);
 *
 *                             // Location loc = p1.getMove(board);
 *                         }
 *                     }
 */
