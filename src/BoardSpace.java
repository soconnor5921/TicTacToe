public class BoardSpace
{
    //Variables for if the space is empty and what it's letter is
    boolean isEmpty;
    String letter;

    //Creates the object
    public BoardSpace(boolean isEmpty, String letter)
    {
        this.isEmpty = isEmpty;
        this.letter = letter;
    }

    //Sets the letter
    public void setLetter(String letter)
    {
        this.letter = letter;
    }
}
