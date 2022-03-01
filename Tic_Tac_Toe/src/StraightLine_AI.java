public class StraightLine_AI implements PlayerInt{
    char letter;
    String name;
    int circle;
    int row;
    int col;
    int sheet;
    int diagonals;
    StraightLine_AI(char letter){
        this.name = "Straight Line Ai";
        this.letter = letter;
    }
    @Override
    public char getLetter() {
        return letter;
    }

    @Override
    public Location getMove(char[][][] b) {
        Board board = new Board(b);
        Location sa = null;
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
                                    sa = new Location(co, r, so);
                                    return sa;
                                }
                            }
                        }
                    }
                    if (circle == 0 && diagonals == 3 ) {
                        for (int co = 0; co < 4; co += 1) {
                            for (int so = 0; so < 4; so += 1) {
                                if (so==co && board.getLocation(co, r, so) == '-') {
                                    sa = new Location(co, r, so);
                                    return sa;
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
                                    sa = new Location(co, r, so);
                                    return sa;
                                }
                            }
                        }
                    }
                    if (circle == 0 && diagonals == 3) {
                        for (int co = 3; co >=0; co --) {
                            for (int so = 3; so >= 0; so --) {
                                if ((s==3 && c==0)&& (s==2 && c==1) && (s==1 && c==2)&& (s==0 && c==3)  && board.getLocation(co, r, so) == '-') {
                                    sa = new Location(co, r, so);
                                    return sa;
                                }
                            }
                        }
                    }
                    if (circle == 3 && diagonals == 0 ) {
                        for (int co = 0; co < 4; co += 1) {
                            for (int so = 0; so < 4; so += 1) {
                                if (so==co && board.getLocation(co, r, so) == '-') {
                                    sa = new Location(co, r, so);
                                    return sa;
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
                                        sa = new Location(co, ro, so);
                                        return sa;
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
                                        sa = new Location(co, ro, so);
                                        return sa;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        //sheet check
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                sheet=0;
                circle=0;
                for (int s = 0; s < 4; s++) {
                    if (board.getLocation(c, r, s) == getLetter()) {
                        sheet++;
                    }
                    if (!(board.getLocation(c, r, s) == getLetter()) && !(board.getLocation(c, r, s) == '-')) {
                        circle++;
                    }
                    if (circle==0 && sheet==3) {
                        for (int so = 0; so < 4; so++) {
                            if (board.getLocation(c, r, so) == '-') {
                                sa = new Location(c, r, so);
                                return sa;
                            }
                        }
                    }
                    if (circle==3 && sheet==0) {
                        for (int so = 0; so < 4; so++) {
                            if (board.getLocation(c, r, so) == '-') {
                                sa = new Location(c, r, so);
                                return sa;
                            }
                        }
                    }
                }

            }
        }
//col
        for (int r = 0; r < 4; r++) {
            for (int s = 0; s < 4; s++) {
                circle=0;
                col = 0;
                for (int c = 0; c < 4; c++) {
                    if (board.getLocation(c, r, s) == getLetter()) {
                        col++;
                    }
                    if (!(board.getLocation(c, r, s) == getLetter()) && !(board.getLocation(c, r, s) == '-')) {
                        circle++;
                    }
                    if (circle==0 && col==3) {
                        for (int co = 0; co < 4; co++) {
                            if (board.getLocation(co, r, s) == '-'){
                                sa = new Location(co, r, s);
                                return sa;

                            }
                        }
                    }
                    if (circle==3 && col==0) {
                        for (int co = 0; co < 4; co++) {
                            if (board.getLocation(co, r, s) == '-'){
                                sa = new Location(co, r, s);
                                return sa;

                            }
                        }
                    }
                }
            }
        }
        //row check
        for (int s = 0; s < 4; s++) {
            for (int c = 0; c < 4; c++) {
                circle=0;
                row = 0;
                for (int r = 0; r < 4; r++) {
                    if (board.getLocation(c, r, s) == getLetter()) {
                        row++;
                    }
                    if (!(board.getLocation(c, r, s) == getLetter()) && !(board.getLocation(c, r, s) == '-')) {
                        circle++;
                    }
                    if (circle==0 && row==3) {
                        for (int ro = 0; ro < 4; ro++) {
                            if (board.getLocation(c, ro, s) == '-' ) {
                                sa = new Location(c, ro, s);
                                return sa;

                            }
                        }
                    }
                    if (circle==3 && row==0) {
                        for (int ro = 0; ro < 4; ro++) {
                            if (board.getLocation(c, ro, s) == '-' ) {
                                sa = new Location(c, ro, s);
                                return sa;

                            }
                        }
                    }

                }

            }
        }
        for (int s = 0; s < 4; s++) {
            for (int r = 0; r < 4; r++) {
                if (board.getLocation(0, r, s) == '-' && board.getLocation(0, r, s) == '-' && board.getLocation(0, r, s) == '-' && board.getLocation(0, r, s) == '-') {
                    sa = new Location(0, r, s);
                    return sa;
                }
            }
        }
        // 3-D vertical wins
        for (int s = 0; s < 4; s++) {
            for (int c = 0; c < 4; c++) {
                if (board.getLocation(c, 0, s) == '-' && board.getLocation(c, 0, s) == '-' && board.getLocation(c, 0, s) == '-' && board.getLocation(c, 0, s) == '-') {
                    sa = new Location(c, 0, s);
                    return sa;
                }
            }
        }

        //2-D horizontal wins
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                if (board.getLocation(c, r, 0) == '-' && board.getLocation(c, r, 0) == '-' && board.getLocation(c, r, 0) == '-' && board.getLocation(c, r, 0) == '-') {
                    sa = new Location(c, r, 0);
                    return sa;
                }
            }
        }

            return sa;

        }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getStudentName() {
        return null;
    }

    @Override
    public void refresh() {

    }
}
