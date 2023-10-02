package ar.com.kriche.games.nim;

import ar.com.kriche.games.nim.player.HumanPlayer;
import ar.com.kriche.games.nim.player.MachinePlayerCached;
import ar.com.kriche.games.nim.player.Movement;
import ar.com.kriche.games.nim.player.Player;

/**
 * Represents a game between two players, manage the turns for each player and keep
 * track of the game board and who wins.
 *
 * @author Kriche
 */
public class NimGame {

    private static final long MACHINE_MAX_MOVE_MILLI_SEC = 10000;
    

    /**
     * Prints the games rules.
     */
    public static void printIntro() {
        System.out.println("Welcome to Nim!\n" +
                "Each player takes away any number of balls from any horizontal row.\n" +
                "In \"not reversed\" mode the player that takes the last ball wins the game.\n"+
                "In \"reversed\" mode the player that takes the last ball loses the game.\n\n"+
                "Type \"reversed\" or \"not reversed\" to start playing...");
    }

    /**
     * Plays the game Human Vs Machine
     * @param isReserved
     */
    public void play(boolean isReserved) {

        GameBoard theGameBoard = new GameBoard();
        Player user = new HumanPlayer("Human");
        Player machine = new MachinePlayerCached("Machine", isReserved, MACHINE_MAX_MOVE_MILLI_SEC);
        Movement currentMove;

                
        Player currentPlayer= user;

        while (!gameOver(theGameBoard)) {

            theGameBoard.print();

            System.out.println(currentPlayer.getName() + "'s turn:");
            
            //We pass a copy of the gameboard because we don't trust ours players!
            if ((currentMove= currentPlayer.makeYourMove(theGameBoard.copy()))==null) {
                System.out.println(currentPlayer.getName() + " leaves the game!\n");
                return;
            }
            
            if(!executeMove(theGameBoard, currentMove)){
                System.out.println(currentPlayer.getName() + " loses the game!\n");
                return;
            }


            // It's the turn of the next player!
            if(currentPlayer==user) {
                currentPlayer= machine;
            } else {
                currentPlayer= user;
            }

        }


        theGameBoard.print();


        // if not reversed we need to swap again to left in currentPlayer the winner!
        if (!isReserved) {
            if(currentPlayer==user) {
                currentPlayer= machine;
            } else {
                currentPlayer= user;
            }
        }      
        

        System.out.println(currentPlayer.getName() + " wins the game!\n");


    }


    /**
     * 
     * @param theGameBoard
     * @param currentMove
     * @return true is the move is valid
     */
    private boolean executeMove(GameBoard theGameBoard, Movement currentMove) {

        System.out.println(currentMove);
        
        //Validate if the movement is legal:
        if( currentMove.row<0 || currentMove.row > theGameBoard.board.length-1 ||
            currentMove.ballsToRemove<1 || currentMove.ballsToRemove > theGameBoard.board[currentMove.row] ){
            System.out.println("Invalid movement!!");
            return false;
        }        

        theGameBoard.board[currentMove.row] -= currentMove.ballsToRemove;
        return true;

    }

    /**
     * 
     * @param theGameBoard
     * @return true is the game is over
     */
    private boolean gameOver(GameBoard theGameBoard) {

        for (int balls : theGameBoard.board) {
            if (balls > 0) {
                return false;
            }
        }

        //All the rows have 0 balls so game over!!
        return true;
    }

}


