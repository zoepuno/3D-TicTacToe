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
