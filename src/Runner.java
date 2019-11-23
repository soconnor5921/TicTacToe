import java.util.Scanner;

public class Runner
{
    private static boolean gameOn = true;

    public static void main(String[] args)
    {
        //Creates the board and fills it with empty spaces
        BoardSpace[][] board = new BoardSpace[3][3];
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                //"-" is a placeholder to avoid errors
                board[i][j] = new BoardSpace(true, "-");
            }
        }

        //Sets up the scanner and gets the user's name
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = in.nextLine();

        //Sets up the player and computer
        Player player = new Player(name);
        Opponent cpu =  new Opponent(false);

        while(gameOn)
        {
            //Prints the board at the start of every turn
            printBoard(board);

            //Takes player input
            System.out.println(player.name.toUpperCase() + "'S TURN");
            System.out.println("Use the number pad to indicate your move");
            String move = in.nextLine();

            if(validMove(move, board))
            {
                //If the input is valid it shows the board updated with your move
                System.out.println("THIS IS YOUR MOVE:");
                printBoard(board);

                //If this move is a winning move the game ends
                if(checkWin(board))
                {
                    System.out.println(player.name.toUpperCase() + " HAS WON!");
                    gameOff();
                }
                //If this move has filled up the last space the game ends in a draw
                else if(!validMovesExist(board))
                {
                    System.out.println("NO VALID MOVES EXIST, THE GAME IS A DRAW!");
                    gameOff();
                }
                //Computer's turn
                else
                {
                    //Makes the computer's random move and tells the player
                    cpu.setMyTurn(true);
                    cpu.move(board);
                    System.out.println("COMPUTER'S HAS MOVED");

                    //If this move is a winning move the board is shown and the game ends
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
                //If the input is NOT valid the player will be told to make a valid move
                System.out.println("PLEASE MAKE A VALID MOVE");
            }
        }
    }

    //Checks to make sure the player's move is possible
    public static boolean validMove(String move, BoardSpace[][] board)
    {
        //Handles all of the number inputs and updates the board accordingly
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

    //Sees if there are any possible moves
    public static boolean validMovesExist(BoardSpace[][] board)
    {
        //If there are any empty spaces left it returns true, otherwise it's false
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

    //Ends the game
    public static void gameOff()
    {
        gameOn = false;
    }

    //Prints the board
    public static void printBoard(BoardSpace[][] board)
    {
        //Goes through every space and prints it with it's corresponding letter
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

    //Checks if there is a win from either player
    public static boolean checkWin(BoardSpace[][] board)
    {
        //Top left - bottom right diagonal
        if(board[0][0].letter.equals(board[1][1].letter) && board[0][0].letter.equals(board[2][2].letter))
        {
            //Makes sure the letter is not the placeholder
            if(!board[0][0].letter.equals("-"))
            {
                return true;
            }
        }
        //Top right - bottom left diagonal
        else if(board[0][2].letter.equals(board[1][1].letter) && board[0][2].letter.equals(board[2][0].letter))
        {
            if(!board[0][2].letter.equals("-"))
            {
                return true;
            }
        }
        else
        {
            //Rows
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

            //Columns
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
