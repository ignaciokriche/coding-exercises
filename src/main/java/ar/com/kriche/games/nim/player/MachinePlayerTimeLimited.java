package ar.com.kriche.games.nim.player;

import ar.com.kriche.games.nim.GameBoard;

/**
 *
 * This guy guarantee to give a move in no more than a given amount of time!
 * Not always that movement will be a good one, but it will try!!
 *
 * @author Kriche
 * 
 */
public class MachinePlayerTimeLimited extends MachinePlayer {
        
    private long maxMilliSecs;
    private volatile Movement bestMove;
    private volatile boolean bestMoveFinderDone;
    
    public MachinePlayerTimeLimited(String name, boolean isReversed,long maxMilliSecs) {
        super(name, isReversed);
        this.maxMilliSecs = maxMilliSecs;
    }

    @Override
    public Movement makeYourMove(final GameBoard theGameBoard) {

        Runnable bestMoveFinder = new Runnable() {
            public void run() {

                // We use a copy of the game board since if interrupted the original game board
                // would be changed in an "incomplete" way
                GameBoard tempGameBoard = theGameBoard.copy();                
                Movement move= MachinePlayerTimeLimited.super.makeYourMove(tempGameBoard);

                synchronized (MachinePlayerTimeLimited.this) {
                    if (!Thread.currentThread().isInterrupted()) {
                        theGameBoard.board= tempGameBoard.board;
                        bestMove= move;
                        bestMoveFinderDone= true;
                        MachinePlayerTimeLimited.this.notify(); //By the way this is done only one thread will be waiting.
                    }
                }
            }
        };

        Thread bestMoveFinderThread = new Thread(bestMoveFinder,"bestMoveFinder");
        bestMoveFinderThread.setDaemon(true);
        bestMoveFinderDone= false;
        bestMoveFinderThread.start();

        Movement theMovement;

        synchronized (this) {

            try {

                // wait until bestMoveFinderThread completes or timeout:

                long waitTime = maxMilliSecs;
                long elapsedTime = 0;
                long iniTime = System.currentTimeMillis();

                while (waitTime > 0 && !bestMoveFinderDone) {

                    System.out.println("Thinking, please wait...");
                    wait(waitTime);

                    elapsedTime = System.currentTimeMillis() - iniTime;
                    waitTime -= elapsedTime;
                }

                if (!bestMoveFinderDone) {
                    bestMoveFinderThread.interrupt();                    
                    theMovement= findFastMove(theGameBoard);
                }else{
                    theMovement= bestMove;
                }

            } catch (InterruptedException ex) {
                throw new Error(ex);
            }

        }
        
        return theMovement;

    }



    @Override
    protected Movement findGoodMove(GameBoard possition) {

        Movement move;

        try{
            move= super.findGoodMove(possition);
        }catch(NullPointerException npe){
            //Timeout and not able to find a goodmove!
            move= null;
        }

        return move;
    }


    @Override
    protected Boolean isGoodPosittion(GameBoard possition) {

        if (Thread.currentThread().isInterrupted()) {
            /*
             * Stop since it was interrupted!
             * We don't know if it is good or bad so we return null (so it will
             * not be cached or used). This will cause a null pointer exception
             * in the executing thread but it will be cached and anyway it
             * wont affect the program execution.
             */
            return null; 
        }

        return super.isGoodPosittion(possition);
    }

    @Override
    protected Movement findLessBadMove(GameBoard theGameBoard) {

        if (Thread.currentThread().isInterrupted()) {
            // stop since it was interrupted
            return null; //Here the important thing is to return, not the movement returned.
        }        
        
        return super.findLessBadMove(theGameBoard);

    }

    protected Movement findFastMove(GameBoard theGameBoard) {
        return findSillyMove(theGameBoard);
    }

}
