import kotlin.Pair;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;

// implement interface??
// should this be singleton?

// maybe keep Board constant and create new boardState to pass into cpu?
// issue is I need to know which JButton to call onClick...
// I can't recreate buttons so maybe this does need to be singleton?
// Could I store the ArrayList on the GUI class? I'm only keeping track of position and button now.
// That would decouple things more.

public class Board {

    private final HashMap<Pair<Integer, Integer>, String> moveMap;
    private static final String xMove = "X";
    private static final String oMove = "O";
    private String currentMove = xMove;
    private static final int N = GUI.N;
    private Integer utility;
    private static final Object lock = new Object();

    private Board() {

        int row;
        int col;
        moveMap = new HashMap<>();

        for (int i = 0; i < N*N; i++) {
            row = i / N;
            col = i % N;

            moveMap.put(new Pair<>(col, row), "");

        }


    }

    private Board(Board initialState) {
        this.moveMap = initialState.getMoveMap();
    }


    /* X = 1; O = -1; 0 for now win
    */

    public static void main(String[] args) {
        Board b = new Board();


        for (int i = 0; i < GUI.N; i++) {
            b.computeUtility(new Pair<>(i,i), b);

        }



        System.err.println(b.getUtility());

    }


    public Board computeUtility(Pair<Integer, Integer> move, Board state) {

        Board newState = new Board(state);


        newState.makeMove(move);
        HashMap<Pair<Integer, Integer>, String> moves = newState.getMoveMap();
        ArrayList<Pair<Integer, Integer>> xMoveList = new ArrayList<>();
        ArrayList<Pair<Integer, Integer>> oMoveList = new ArrayList<>();

        moves.forEach((k,v) -> {
            System.err.println(k + v);



            // O(N) to get all x moves
            if (v.equals(xMove)) {
                xMoveList.add(k);
            } else {
                oMoveList.add(k);
            }
        });


        // nlogn to sort

        xMoveList.sort((c1, c2) -> c2.getSecond().compareTo(c1.getSecond()));
        oMoveList.sort((c1, c2) -> c2.getSecond().compareTo(c1.getSecond()));


        for (Pair<Integer, Integer> p : xMoveList) {
            state.makeMove(new Pair<>(p.getFirst(), p.getSecond()));
            state.printMap();
        }


        return state;

        // O(N) to search column
//        int currentColum = -1;
//        int currentRow = -1;
//        int colSequence;


        // second needs to remain constant









//            for (Pair<Integer, Integer> pos : xMoveList) {
//                currentRow = pos.getSecond();
//                currentColum = pos.getFirst();
//                if (pos)
//
//                System.out.println(pos);
//
//
//
//            }
//






    }

    public Integer getUtility() { return this.utility;}




    public void makeMove(Pair<Integer, Integer> move) {
        System.out.println("making move");

//        if (move.equals(xMove)) {
//            moveMap.put(pos, move);
//        } else {
//            moveMap.put(pos, move);
//        }
//
//        if (move.equals(xMove)) {
//            currentMove = oMove;
//        } else {
//            currentMove = xMove;
//        }


        synchronized (lock) {
            moveMap.put(move, currentMove);
            currentMove = currentMove.equals(xMove) ? oMove : xMove;

        }





        //printMap();


    }

    public void printMap() {
        synchronized (lock) {
            this.moveMap.forEach((pos, m) -> System.out.println(pos + ": " + m));
            System.out.println("\n");
        }

    }

    public String getMove() {
        return currentMove;
    }

    public HashMap<Pair<Integer,Integer>, String> getMoveMap() { return moveMap; }

}
