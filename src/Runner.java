import java.util.Scanner;

public class Runner
{
    private static boolean gameOn = true;

    public static void main(String[] args)
    {
        BoardSpace[][] board = new BoardSpace[3][3];

        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                board[i][j] = new BoardSpace(true, "-");
            }
        }

        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = in.nextLine();

        Player player = new Player(name);
        Opponent cpu =  new Opponent(false);

        while(gameOn)
        {
            printBoard(board);

            System.out.println(player.name.toUpperCase() + "'S TURN");
            System.out.println("Use the number pad to indicate your move");
            String move = in.nextLine();
            if(validMove(move, board))
            {
                System.out.println("THIS IS YOUR MOVE:");
                printBoard(board);
                if(checkWin(board))
                {
                    System.out.println(player.name.toUpperCase() + " HAS WON!");
                    gameOff();
                }
                else if(!validMovesExist(board))
                {
                    System.out.println("NO VALID MOVES EXIST, THE GAME IS A DRAW!");
                    gameOff();
                }
                else
                {
                    cpu.setMyTurn(true);
                    cpu.move(board);
                    System.out.println("COMPUTER'S HAS MOVED");
                    if(checkWin(board))
                    {
                        printBoard(board);
                        System.out.println("THE COMPUTER HAS WON!");
                        gameOff();
                    }
                }
            }
            else
            {
                System.out.println("PLEASE MAKE A VALID MOVE");
            }
        }
    }

    public static boolean validMove(String move, BoardSpace[][] board)
    {
        switch(move)
        {
            case "7":
                if(board[0][0].isEmpty)
                {
                    board[0][0].isEmpty = false;
                    board[0][0].setLetter("X");
                    return true;
                }
                else
                {
                    return false;
                }
            case "8":
                if(board[0][1].isEmpty)
                {
                    board[0][1].isEmpty = false;
                    board[0][1].setLetter("X");
                    return true;
                }
                else
                {
                    return false;
                }
            case "9":
                if(board[0][2].isEmpty)
                {
                    board[0][2].isEmpty = false;
                    board[0][2].setLetter("X");
                    return true;
                }
                else
                {
                    return false;
                }
            case "4":
                if(board[1][0].isEmpty)
                {
                    board[1][0].isEmpty = false;
                    board[1][0].setLetter("X");
                    return true;
                }
                else
                {
                    return false;
                }
            case "5":
                if(board[1][1].isEmpty)
                {
                    board[1][1].isEmpty = false;
                    board[1][1].setLetter("X");
                    return true;
                }
                else
                {
                    return false;
                }
            case "6":
                if(board[1][2].isEmpty)
                {
                    board[1][2].isEmpty = false;
                    board[1][2].setLetter("X");
                    return true;
                }
                else
                {
                    return false;
                }
            case "1":
                if(board[2][0].isEmpty)
                {
                    board[2][0].isEmpty = false;
                    board[2][0].setLetter("X");
                    return true;
                }
                else
                {
                    return false;
                }
            case "2":
                if(board[2][1].isEmpty)
                {
                    board[2][1].isEmpty = false;
                    board[2][1].setLetter("X");
                    return true;
                }
                else
                {
                    return false;
                }
            case "3":
                if(board[2][2].isEmpty)
                {
                    board[2][2].isEmpty = false;
                    board[2][2].setLetter("X");
                    return true;
                }
                else
                {
                    return false;
                }
            default: break;
        }
        return false;
    }

    public static boolean validMovesExist(BoardSpace[][] board)
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                if(board[i][j].isEmpty)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static void gameOff()
    {
        gameOn = false;
    }

    public static void printBoard(BoardSpace[][] board)
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                if(board[i][j].isEmpty)
                {
                    System.out.print("[ ]");
                }
                else
                {
                    System.out.print("[" + board[i][j].letter + "]");
                }
            }
            System.out.println();
        }
    }

    public static boolean checkWin(BoardSpace[][] board)
    {
        if(board[0][0].letter.equals(board[1][1].letter) && board[0][0].letter.equals(board[2][2].letter))
        {
            if(!board[0][0].letter.equals("-"))
            {
                return true;
            }
        }
        else if(board[0][2].letter.equals(board[1][1].letter) && board[0][2].letter.equals(board[2][0].letter))
        {
            if(!board[0][2].letter.equals("-"))
            {
                return true;
            }
        }
        else
        {
            for(int i = 0; i < board.length; i++)
            {
                if(board[i][0].letter.equals(board[i][1].letter) && board[i][0].letter.equals(board[i][2].letter))
                {
                    if(!board[i][0].letter.equals("-"))
                    {
                        return true;
                    }
                }
            }

            for(int j = 0; j < board.length; j++)
            {
                if(board[0][j].letter.equals(board[1][j].letter) && board[0][j].letter.equals(board[2][j].letter))
                {
                    if(!board[0][j].letter.equals("-"))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
