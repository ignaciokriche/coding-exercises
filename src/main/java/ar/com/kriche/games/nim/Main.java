package ar.com.kriche.games.nim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 *
 * Main class for a demo of Nim game.
 *
 * @author Kriche
 * 
 */
public class Main {

    public static void main(String args[]) throws IOException {

        NimGame.printIntro();
        
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        
        String line= reader.readLine();
        
        boolean isReversed;

        if ("Reversed".equalsIgnoreCase(line)) {
            isReversed= true;
        } else if ("Not reversed".equalsIgnoreCase(line)) {
            isReversed= false;
        }else{
            return;
        }

        NimGame theGame = new NimGame();
        theGame.play(isReversed);

    }


}
