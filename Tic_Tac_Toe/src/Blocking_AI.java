public class Blocking_AI implements PlayerInt {

    char[][][] boardCopy = new char[4][4][4];

    char letter;
    String name;


    public Blocking_AI(char letter) {
        this.name = "Blocking Ai";
        this.letter = letter;
        setBoardCopy();
        setLetter(letter);
    }

    public void setBoardCopy() {
        if (getLetter()=='x') {
            for (int l = 0; l < 4; l++) {
                for (int c = 0; c < 4; c++) {
                    for (int r = 0; r < 4; r++) {
                        boardCopy[l][r][c] = 'x';

                    }
                }
            }
        }
        if (getLetter()=='o') {
            for (int l = 0; l < 4; l++) {
                for (int c = 0; c < 4; c++) {
                    for (int r = 0; r < 4; r++) {
                        boardCopy[l][r][c] = 'o';
                    }
                }
            }
        }
    }

    public void setLetter(char letter) {
        this.letter=letter;
    }

    @Override
    public char getLetter() {


        return letter;
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

    public void changeBoard(char[][][] b) {
        Board board = new Board(b);
        if (getLetter()=='o') {
            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 4; c++) {
                    for (int s = 0; s < 4; s++) {
                        if ( board.getLocation(c, r, s)== 'x') {
                            boardCopy[s][r][c] = 'x';
                        }
                    }
                }
            }
        }
        if (getLetter()=='x') {
            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 4; c++) {
                    for (int s = 0; s < 4; s++) {
                        if (board.getLocation(c, r, s) == 'o') {
                            boardCopy[s][r][c] = 'o';
                        }
                    }
                }
            }
        }
    }
    @Override
    public Location getMove( char[][][] b) {
        displayBoard(boardCopy);
        Board board = new Board(b);
        Location boo = null;
        int col;
        int row;

        //row check
            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 4; c++) {
                    for (int s = 0; s < 4; s++) {
                        row = 0;
                        if (!(boardCopy[s][r][c] == getLetter())) {
                            row++;
                        }
                        if (row == 3) {
                            for (int m = 0; m < 4; m++) {
                                if (board.getLocation(s, r, m) == '-') {
                                    System.out.println("Row changed because 2");
                                    boo = new Location(c, r, m);
                                    changeBoard(board.getData());
                                    return boo;
                                }

                            }
                        } else if (row == 2) {
                            for (int m = 0; m < 4; m++) {
                                if (board.getLocation(s, r, m) == '-') {
                                    System.out.println("Row changed because 3");
                                    boo = new Location(c, r, m);
                                    changeBoard(board.getData());
                                    return boo;

                                }

                            }
                        }

                    }

                }
            }

            //col check
            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 4; c++) {
                    col = 0;
                    for (int s = 0; s < 4; s++) {

                        if (!(boardCopy[s][r][c] == getLetter())) {
                            col++;
                        }
                        if (col == 3) {
                            for (int m = 0; m < 4; m++) {
                                if (board.getLocation(m, r, s) == '-') {
                                    System.out.println("Col changed because 3");
                                    boo = new Location(m, r, s);
                                    changeBoard(board.getData());
                                    return boo;

                                }

                            }
                        } else if (col == 2) {
                            for (int m = 0; m < 4; m++) {
                                if (board.getLocation(m, r, s) == '-') {

                                    System.out.println("Col changed because 2");
                                    boo = new Location(m, r, s);
                                    changeBoard(board.getData());
                                    return boo;

                                }

                            }
                        }

                    }

                }
            }
            //if there's nothing to block put in corner
        System.out.println("done");
            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 4; c++) {
                    for (int s = 0; s < 4; s++) {

                        if (board.isEmpty(0, r, 0)) {
                            System.out.println("here?");
                            boo = new Location(0, r, 0);
                            changeBoard(board.getData());
                            return boo;

                        } else if (board.isEmpty(3, r, 0)) {
                            System.out.println("why here?");
                            boo = new Location(3, r, 0);
                            changeBoard(board.getData());
                            return boo;

                        } else if (board.isEmpty(0, r, 3)) {
                            System.out.println("why here??");
                            boo = new Location(0, r, 3);
                            changeBoard(board.getData());
                            return boo;

                        } else if (board.isEmpty(3, r, 3)) {
                            System.out.println("why here??");
                            boo = new Location(3, r, 3);
                            changeBoard(board.getData());
                            return boo;

                        }
                    }
                }
            }

                return boo;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void refresh() {
setBoardCopy();
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
