
package ar.com.kriche.games.nim.player;

/**
 * Immutable and final class to be used by all the players (including the untrusted ones)!
 * Represents a movement done by a player.
 *
 * @author Kriche
 */
public final class Movement {

    public final int ballsToRemove;
    public final int row;

    public Movement(int ballsToRemove, int row) {
        this.ballsToRemove = ballsToRemove;
        this.row = row;
    }

    @Override
    public String toString() {
        return "Taking " + ballsToRemove + " balls from row: " + (row+1) + ".";
    }    

}
