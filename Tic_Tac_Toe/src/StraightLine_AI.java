public class StraightLine_AI implements PlayerInt{
    char letter;
    String name;
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

                     for (int r = 0; r < 4; r++) {
                         for (int s = 0; s < 4; s++) {
                             for (int c = 0; c < 4; c++) {
                                 //col straight
                                 while (board.getLocation(c, r, s) == '-') {
                                     sa = new Location(c, r, s);
                                     return sa;
                                 }
                             }
                         }
                     }
                    //sheet straight
                for (int r = 0; r < 4; r++) {
                    for (int c = 0; c < 4; c++) {
                    for (int s = 0; s < 4; s++) {
                    while (board.getLocation(c, r, s) == '-') {
                        sa = new Location(c, r, s);
                        return sa;
                    }

                }
            }

        }
                    //row straight
        for (int s = 0; s < 4; s++) {
            for (int c = 0; c < 4; c++) {
                for (int r = 0; r < 4; r++) {
                    while (board.getLocation(c, r, s) == '-') {
                        sa = new Location(c, r, s);
                        return sa;
                    }

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
    public void refresh() {

    }
}
