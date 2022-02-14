

public class Random_Ai{

    boolean moved;
    char player;
    char[][][] board;

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
            if (board[RandomAIloc.getCol()][RandomAIloc.getRow()][RandomAIloc.getSheet()] == '-') {
                board[RandomAIloc.getCol()][RandomAIloc.getRow()][RandomAIloc.getSheet()] = player;
                moved = true;
            } else
                RandomAIloc = new Location((int) (Math.random() * 4), (int) (Math.random() * 4), (int) (Math.random() * 4));
        } while (!moved);
    }
}






