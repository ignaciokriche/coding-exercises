
package ar.com.kriche.games.nim.player;

import ar.com.kriche.games.nim.GameBoard;

/**
 * Represents what a class needs to know to be a player
 *
 * @author Kriche
 * 
 */
public interface Player {

    /**
     * 
     * @param theGameBoard
     * @return a valid movement according to theGameBoard or null to leave the game.
     */
    Movement makeYourMove(GameBoard theGameBoard);

    String getName();

}
