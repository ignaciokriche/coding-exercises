package ar.com.kriche.games.nim.player;

import ar.com.kriche.games.nim.GameBoard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * This guy asks System.in what to do! It's the human "interface".
 *
 * @author Kriche
 */
public class HumanPlayer implements Player {

    private String name;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public HumanPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public Movement makeYourMove(GameBoard theGameBoard) {

        int row;

        while ((row = readRow(theGameBoard.board.length) - 1) >= 0) {

            if (theGameBoard.board[row] == 0) {
                System.out.println("There are no balls in row: "+ (row+1));
                continue;
            }

            int maxBallsToRemove= theGameBoard.board[row];
            int ballsToRemove = ballsToRemove(maxBallsToRemove);

            if (ballsToRemove < 0) {
                return null; //Giveup
            }
            
            if (ballsToRemove > maxBallsToRemove) {
                System.out.println("Hey! You cannot remove more than " + maxBallsToRemove + " balls from row " + (row+1) );
                continue;
            }
            
            return new Movement(ballsToRemove, row);

        }
        
        return null ; //giveup

    }



     private int readRow(int max) {
        return readPositiveNumber(max, "Write the row number (or -1 to quit) and press enter, please: ");
    }

    private int ballsToRemove(int max) {
        return readPositiveNumber(max, "Write the amount of balls to remove (or -1 to quit) and press enter, please: ");
    }

    private int readPositiveNumber(int max, String msg) {

        String line;
        int num = -1;

        while( (line= readLine(reader, msg))!= null) {

            try {
                num= Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                continue;
            }

            if (num > 0 && num <= max || num == -1) {
                return num;
            }

        }

        throw new Error("End of file reached: " + System.in.toString());

    }

    private String readLine(BufferedReader reader, String msg) {

        String line;

        System.out.print(msg);
        try {
            line= reader.readLine();
        } catch (IOException ex) {
            throw new Error(ex);
        }

        return line;
    }
}
