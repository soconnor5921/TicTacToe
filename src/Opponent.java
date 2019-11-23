public class Opponent
{
    boolean myTurn;

    public Opponent(boolean myTurn)
    {
        this.myTurn = myTurn;
    }

    public void move(BoardSpace[][] board)
    {
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

    public int generateNum()
    {
        return (int)(Math.random() * 3);
    }

    public void setMyTurn(boolean myTurn)
    {
        this.myTurn = myTurn;
    }
}
