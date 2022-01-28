public class Player<E extends Location> implements PlayerInt<E>
{

   char letter;
   String name;

   public Player( String name, char letter )
   {
       this.name = name;
       this.letter = letter;
   }
    public void setLetter(char letter) {
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    @Override
    public Location getMove(char[][][] board) {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public PlayerInt<Location> freshCopy(char letter) {
        return null;
    }
}
