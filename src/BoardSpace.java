public class BoardSpace
{
    boolean isEmpty;
    String letter;

    public BoardSpace(boolean isEmpty, String letter)
    {
        this.isEmpty = isEmpty;
        this.letter = letter;
    }

    public void setLetter(String letter)
    {
        this.letter = letter;
    }
}
