public class Random_Ai{

    boolean moved;
    char player;
    char[][][] board;
    //sheet, row, col

    Random_Ai(char player, char[][][] board, boolean moved) {
        this.player = player;
        this.board = board;
        this.moved = moved;
    }

    //Moves Randomly
    public void RandomAI_Move() {
        Location RandomAIloc = new Location((int) (Math.random() * 4), (int) (Math.random() * 4), (int) (Math.random() * 4));
        moved = false;

        do {
            if (board[RandomAIloc.getSheet()][RandomAIloc.getRow()][RandomAIloc.getCol()] == '-') {
                board[RandomAIloc.getSheet()][RandomAIloc.getRow()][RandomAIloc.getCol()] = player;
                moved = true;
            } else
                RandomAIloc = new Location((int) (Math.random() * 4), (int) (Math.random() * 4), (int) (Math.random() * 4));
        } while (!moved);
    }
}

