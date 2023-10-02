package ar.com.kriche.games.nim;

import java.util.Arrays;

/**
 * Not much roles for this class only to keep the state of the game board, clone it, compare it
 * to another one and print it.
 *
 * @author Kriche
 *
 */
public class GameBoard {

    public int[] board = new int[]{1,3,8,12,15,18,21,};
    private int maxRowLength= 21;
    
    /**
     * 
     * @return a another instance with the same state.
     */
    public GameBoard copy() {
        GameBoard aCloneOfMine= new GameBoard();
        aCloneOfMine.maxRowLength= maxRowLength;
        aCloneOfMine.board= board.clone();        
        return aCloneOfMine;
    }

    public void print() {

        System.out.println();
        for(int row=0; row< board.length; row++){
            System.out.print("row: "+(row+1)+"     ");
            print(board[row]);
        }
        System.out.println("\n");

    }

    private void print(int row) {

        int spaces= maxRowLength - row ;

        for(int i=0; i<spaces/2; i++){
            System.out.print(" ");
        }

        int balls= row;
        while(row-->0){
            System.out.print("*");
        }

        for(int i=spaces/2; i<spaces; i++){
            System.out.print(" ");
        }

        System.out.print("     Balls: "+ balls);

        System.out.println();

    }


    @Override
    public boolean equals(Object obj) {

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        return Arrays.equals(board, ((GameBoard) obj).board);
    }

    @Override
    public int hashCode() {        
        return  Arrays.hashCode(board);
    }
    

}
