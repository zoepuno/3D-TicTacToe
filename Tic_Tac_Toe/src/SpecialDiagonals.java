public class SpecialDiagonals implements PlayerInt {

    char letter;
    String name;
    String studentName;


    public SpecialDiagonals(char letter) {
        this.name = "Special Diagonals";
        this.letter = letter;
        this.studentName= "Zoe Puno & Jessica Sollars";
        setLetter(letter);
    }
    @Override
    public String getStudentName(){
        return studentName;
    }

    public void setLetter(char letter) {
        this.letter=letter;
    }

    @Override
    public char getLetter() {


        return letter;
    }

    @Override
    public Location getMove( char[][][] b) {
        Board board = new Board(b);
        Location boo = null;
        int col;
        int row;
        int sheet;
        int circle;
        int diagonals;
//time to win
        //Blocking Moves works \/

        //diagonal left to right on boards
        for (int r = 0; r < 4; r++) {
            circle = 0;
            diagonals = 0;
            for (int s = 0; s < 4; s ++) {
                for (int c = 0; c < 4; c ++) {

                    if (s==c && board.getLocation(c, r, s) == getLetter()) {
                        diagonals++;
                        System.out.println(s+" , "+c);
                    }
                    if (s==c && !(board.getLocation(c, r, s) == getLetter()) && !(board.getLocation(c, r, s) == '-')) {
                        System.out.println(s+" , "+c);
                        circle++;
                        System.out.println(circle);
                    }
                    if (circle == 3 && diagonals == 0 ) {
                        for (int co = 0; co < 4; co += 1) {
                            for (int so = 0; so < 4; so += 1) {
                                if (so==co && board.getLocation(co, r, so) == '-') {
                                    boo = new Location(co, r, so);
                                    return boo;
                                }
                            }
                        }
                    }
                    if (circle == 0 && diagonals == 3 ) {
                        for (int co = 0; co < 4; co += 1) {
                            for (int so = 0; so < 4; so += 1) {
                                if (so==co && board.getLocation(co, r, so) == '-') {
                                    boo = new Location(co, r, so);
                                    return boo;
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int r = 3; r >=0; r--) {
            circle = 0;
            diagonals = 0;
            for (int s = 3; s >=0; s--) {
                for (int c = 3; c >=0; c --) {
                    if ((s==3 && c==0)&& (s==2 && c==1) && (s==1 && c==2)&& (s==0 && c==3) && board.getLocation(c, r, s) == getLetter()) {
                        diagonals++;
                    }
                    if ((s==3 && c==0)&& (s==2 && c==1) && (s==1 && c==2)&& (s==0 && c==3) && !(board.getLocation(c, r, s) == getLetter()) && !(board.getLocation(c, r, s) == '-')) {
                        circle++;
                    }
                    if (circle == 3 && diagonals == 0) {
                        for (int co = 3; co >=0; co --) {
                            for (int so = 3; so >= 0; so --) {
                                if ((s==3 && c==0)&& (s==2 && c==1) && (s==1 && c==2)&& (s==0 && c==3)  && board.getLocation(co, r, so) == '-') {
                                    boo = new Location(co, r, so);
                                    return boo;
                                }
                            }
                        }
                    }
                    if (circle == 0 && diagonals == 3) {
                        for (int co = 3; co >=0; co --) {
                            for (int so = 3; so >= 0; so --) {
                                if ((s==3 && c==0)&& (s==2 && c==1) && (s==1 && c==2)&& (s==0 && c==3)  && board.getLocation(co, r, so) == '-') {
                                    boo = new Location(co, r, so);
                                    return boo;
                                }
                            }
                        }
                    }
                    if (circle == 3 && diagonals == 0 ) {
                        for (int co = 0; co < 4; co += 1) {
                            for (int so = 0; so < 4; so += 1) {
                                if (so==co && board.getLocation(co, r, so) == '-') {
                                    boo = new Location(co, r, so);
                                    return boo;
                                }
                            }
                        }
                    }
                }
            }
        }
        //3D Block
        //left to right
        circle = 0;
        diagonals = 0;
        for (int r = 0; r < 4; r++) {
            for (int s = 0; s < 4; s++) {
                for (int c = 0; c < 4; c++) {
                    if (r == s && r == c && s == c && board.getLocation(c, r, s) == getLetter()) {
                        diagonals++;
                    }
                    if (r == s && r == c && s == c && !(board.getLocation(c, r, s) == getLetter()) && !(board.getLocation(c, r, s) == '-')) {
                        circle++;
                        System.out.println(circle);
                    }
                    if (circle == 3 && diagonals == 0) {
                        for (int ro = 0; ro < 4; ro++) {
                            for (int co = 0; co < 4; co += 1) {
                                for (int so = 0; so < 4; so += 1) {
                                    if (ro == so && ro == co && so == co && board.getLocation(co, ro, so) == '-') {
                                        boo = new Location(co, ro, so);
                                        return boo;
                                    }
                                }
                            }
                        }
                    }
                    if (circle == 0 && diagonals == 3) {
                        for (int ro = 0; ro < 4; ro++) {
                            for (int co = 0; co < 4; co += 1) {
                                for (int so = 0; so < 4; so += 1) {
                                    if (ro == so && ro == co && so == co && board.getLocation(co, ro, so) == '-') {
                                        boo = new Location(co, ro, so);
                                        return boo;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        //right to left
        for (int r = 3; r >=0; r--) {
            circle = 0;
            diagonals = 0;
            for (int s = 3; s >= 0; s--) {
                for (int c = 3; c >= 0; c--) {
                    if ((r == 0 && s == 3 && c == 0) && (r == 1 && s == 2 && c == 1) && (r == 2 && s == 1 && c == 2) && (r == 3 && s == 0 && c == 3) && board.getLocation(c, r, s) == getLetter()) {
                        diagonals++;
                    }
                    if ((r == 0 && s == 3 && c == 0) && (r == 1 && s == 2 && c == 1) && (r == 2 && s == 1 && c == 2) && (r == 3 && s == 0 && c == 3) && !(board.getLocation(c, r, s) == getLetter()) && !(board.getLocation(c, r, s) == '-')) {
                        circle++;
                    }
                    if (circle == 3 && diagonals == 0) {
                        for (int ro = 3; ro >= 0; ro--) {
                            for (int co = 3; co >= 0; co--) {
                                for (int so = 3; so >= 0; so--) {
                                    if ((ro == 0 && so == 3 && co == 0) && (ro == 1 && so == 2 && co == 1) && (ro == 2 && so == 1 && co == 2) && (ro == 3 && so == 0 && co == 3) && board.getLocation(co, ro, so) == '-') {
                                        boo = new Location(co, ro, so);
                                        return boo;
                                    }
                                }
                            }
                        }
                    }
                    if (circle == 0 && diagonals == 3) {
                        for (int ro = 3; ro >= 0; ro--) {
                            for (int co = 3; co >= 0; co--) {
                                for (int so = 3; so >= 0; so--) {
                                    if ((ro == 0 && so == 3 && co == 0) && (ro == 1 && so == 2 && co == 1) && (ro == 2 && so == 1 && co == 2) && (ro == 3 && so == 0 && co == 3) && board.getLocation(co, r, so) == '-') {
                                        boo = new Location(co, ro, so);
                                        return boo;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int ro = 3; ro >= 0; ro--) {
            for (int co = 3; co >= 0; co--) {
                for (int so = 3; so >= 0; so--) {
                    if (((ro == 0 && so == 3 && co == 0) || (ro == 1 && so == 2 && co == 1) || (ro == 2 && so == 1 && co == 2) || (ro == 3 && so == 0 && co == 3) )&& board.getLocation(co, ro, so) == '-') {
                        boo = new Location(co, ro, so);
                        return boo;
                    }
                }
            }
        }
        //Diagonals

            return boo;
        }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void refresh() {
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