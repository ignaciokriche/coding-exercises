package ar.com.kriche.games.nim.player;

import ar.com.kriche.games.nim.GameBoard;

/**
 *
 * This guy does all the work, it knows how to play but has no memory (cache) and
 * it can take too long to make a move!
 * It uses MiniMax algorithm
 * It's the base class for more sophisticated players!
 *
 * @author Kriche
 */
public class MachinePlayer implements Player {

    private String name;
    private final boolean isReserved;
    
    public MachinePlayer(String name, boolean isReserved) {
        this.name= name;
        this.isReserved= isReserved;
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public Movement makeYourMove(GameBoard theGameBoard) {

        Movement move= findGoodMove(theGameBoard);

        if(move==null) {
            //Okay: no good move so what to do? choose the less bad...
            move= findLessBadMove(theGameBoard);
        }

        return move;

    }

    
    protected Movement findGoodMove(GameBoard possition) {

        // a good move can be found if there is a good possition for us

        for (int r = 0; r < possition.board.length; r++) {

            int balls;

            if ((balls = possition.board[r]) > 0) {

                //try leaving the current row with 0 to (balls-1) balls
                for (int n = 0; n < balls; n++) {

                    possition.board[r]= n;                                        
                    if (isGoodPosittion(possition)) {
                        // We restore the board not only because we are not supposed to modify it but also because
                        // we are in a recursive method and if we don't restore it, it will be in a game over state!
                        possition.board[r] = balls;
                        return new Movement(balls-n, r);
                    }
                }

                //No good moves with this row, we leave it as it was and try the next row
                possition.board[r]= balls;

            }
        }

        //Also here we could end with no good moves!!
        return null;

    }

    // Using Boolean instead of boolean to allow extensions to return null, see thread version to understand the reason behind this.
    protected Boolean isGoodPosittion(GameBoard possition) {
        
        for(int balls: possition.board){
            if( balls>0){
                // Not in base case yet! It will be good, if it cannot lead to a good move (because it's opponent turn).
                return findGoodMove(possition)==null;
            }
        }
        
        // Base case: no more balls left, if not reversed then we win since we took the last ball.
        // Otherwise, we lost!
        return !isReserved;

    }

    protected Movement findLessBadMove(GameBoard theGameBoard) {
        //TODO: Not ready yet, just making a silly move
        return findSillyMove(theGameBoard);
    }


    protected Movement findSillyMove(GameBoard theGameBoard) {

        for (int r = theGameBoard.board.length; r-- > 0; ) {
            int balls;
            if ((balls=theGameBoard.board[r]) > 0) {
                return new Movement(balls, r);
            }
        }

        throw new IllegalStateException("unable to perform any movement!! I cannot play when game is over!");
    }


}
