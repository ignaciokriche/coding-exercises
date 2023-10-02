package ar.com.kriche.games.nim.player;

import ar.com.kriche.games.nim.GameBoard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * This guy adds cache, so it will remember previous games knowing if they can or cannot lead to
 * a winning move. By using cache the execution becomes much faster!
 *
 * @author Kriche
 * 
 */
public class MachinePlayerCached extends MachinePlayerTimeLimited {

    private final PositionCache positionCache = new PositionCache();

    public MachinePlayerCached(String name, boolean isReversed, long maxMilliSecs) {
        super(name, isReversed, maxMilliSecs);
    }


    @Override
    protected Boolean isGoodPosittion(GameBoard possition) {

        Boolean isGood;
        if((isGood= positionCache.isGoodPosition(possition)) != null){
            return isGood;
        }

        isGood= super.isGoodPosittion(possition);
        positionCache.putPosition(possition, isGood);
        return isGood;
    }

    @Override
    public Movement makeYourMove(GameBoard theGameBoard) {    
        return super.makeYourMove(theGameBoard);
    }

}

class PositionCache {

    private Map<GameBoard, Boolean> cache = new HashMap<GameBoard, Boolean>();

    Boolean isGoodPosition(GameBoard possition) {
        return cache.get(normalizePosition(possition));
    }

    void putPosition(GameBoard position, Boolean isGood) {
        if(isGood!=null){
            cache.put(normalizePosition(position), isGood);
        }
    }

    private static GameBoard normalizePosition(GameBoard position) {
        GameBoard normalized = position.copy();
        Arrays.sort(normalized.board);
        return normalized;
    }

}
