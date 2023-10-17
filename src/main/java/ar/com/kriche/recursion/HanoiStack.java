/**
 * A solution to the classic problem of the towers of Hanoi removing recursion calls.
 * There are other ways to solve this (see tail recursion).
 *
 * @author Kriche
 */

package ar.com.kriche.recursion;

import java.io.IOException;
import java.io.Writer;
import java.util.Stack;

public class HanoiStack {

    private final Writer out;

    public HanoiStack(Writer out) {
        this.out = out;
    }

    public void hanoi(int n, String ini, String temp, String finish) throws IOException {

        Stack<Frame> stack = new Stack<>();
        String auxi;

        RETURN_ADDRESS returnAddress = RETURN_ADDRESS.BEGINNING;

        while (true) {

            switch (returnAddress) {

                case BEGINNING:

                    if (n > 0) {
                        stack.push(new Frame(n, ini, temp, finish, RETURN_ADDRESS.FIRST_CALL));
                        n--;
                        auxi = temp;
                        temp = finish;
                        finish = auxi;

                        returnAddress = RETURN_ADDRESS.BEGINNING;
                    } else {
                        returnAddress = RETURN_ADDRESS.SECOND_CALL;
                    }
                    break;

                case FIRST_CALL:

                    out.write("move disk: " + n + " from " + ini + " to " + finish + ".\n");

                    stack.push(new Frame(n, ini, temp, finish, RETURN_ADDRESS.SECOND_CALL));

                    n--;
                    auxi = temp;
                    temp = ini;
                    ini = auxi;

                    returnAddress = RETURN_ADDRESS.BEGINNING;

                    break;

                case SECOND_CALL:

                    if (!stack.isEmpty()) {
                        Frame frame = stack.pop();
                        n = frame.n;
                        ini = frame.ini;
                        temp = frame.temp;
                        finish = frame.fin;
                        returnAddress = frame.returnAddress;
                    } else {
                        return;
                    }
                    break;
            }
        }

    }

    private enum RETURN_ADDRESS {BEGINNING, FIRST_CALL, SECOND_CALL}

    private class Frame {

        public final int n;
        public final String ini;
        public final String temp;
        public final String fin;
        public final RETURN_ADDRESS returnAddress;

        public Frame(int n, String ini, String temp, String fin, RETURN_ADDRESS returnAddress) {
            this.n = n;
            this.ini = ini;
            this.temp = temp;
            this.fin = fin;
            this.returnAddress = returnAddress;
        }
    }
}
