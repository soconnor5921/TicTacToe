public class Opponent
{
    //Says if the computer can move
    private boolean myTurn;

    //Creates the object
    public Opponent(boolean myTurn)
    {
        this.myTurn = myTurn;
    }

    //Makes the opponent's move
    public void move(BoardSpace[][] board)
    {
        //Finds if a randomly chosen space is empty, if so it moves and ends the turn, if not it repeats the process
        while(myTurn)
        {
            int x = generateNum();
            int y = generateNum();
            if(board[x][y].isEmpty)
            {
                board[x][y].setLetter("O");
                board[x][y].isEmpty = false;
                myTurn = false;
            }
        }
    }

    //Gets a random number from 0-2 for moving
    public int generateNum()
    {
        return (int)(Math.random() * 3);
    }

    //Sets the opponents turn
    public void setMyTurn(boolean myTurn)
    {
        this.myTurn = myTurn;
    }
}
