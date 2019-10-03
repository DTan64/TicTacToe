import kotlin.Pair;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

// implement interface??
// should this be singleton?

// maybe keep Board constant and create new boardState to pass into cpu?
// issue is I need to know which JButton to call onClick...
// I can't recreate buttons so maybe this does need to be singleton?
// Could I store the ArrayList on the GUI class? I'm only keeping track of position and button now.
// That would decouple things more. 

public class Board {

    private static final HashMap<Pair<Integer, Integer>, JButton> buttonMap = new HashMap<>(); // position map to position
    private static HashMap<Pair<Integer, Integer>, String> moveMap = new HashMap<>();
    private static ArrayList<JButton> buttonList = new ArrayList<>();
    private static Board board = new Board();

    private static final String xMove = "X";
    private static final String oMove = "O";
    private static String currentMove = xMove;
    private static final int N = 3;

    private Board() {

        int row;
        int col;


        for (int i = 0; i < N*N; i++) {
            row = i / N;
            col = i % N;
            JButton buttonToInsert = new Spot(col, row);

            buttonMap.put(new Pair<>(col, row), buttonToInsert); // x y coords from top left. positive y is down
            moveMap.put(new Pair<>(col, row), "");
            buttonList.add(buttonToInsert);
        }


    }


    public static Board getInstance() {
        return board;
    }


    public void makeMove(Pair<Integer, Integer> pos, String move) {
        System.out.println("making move");

        if (move.equals(xMove)) {
            moveMap.put(pos, move);
        } else {
            moveMap.put(pos, move);
        }

        if (move.equals(xMove)) {
            currentMove = oMove;
        } else {
            currentMove = xMove;
        }

        printMap();


    }

    public void printMap() {
        moveMap.forEach((pos, m) -> System.out.println(pos + ": " + m));
        System.out.println("\n");
    }

    public ArrayList<JButton> getButtonList() {
        return buttonList;
    }

    public String getMove() {
        return currentMove;
    }

//
//    public Pair getPos(JButton button) {
//        return buttonMap.get(button);
//    }

    public HashMap<Pair<Integer,Integer>, String> getMoveMap() { return moveMap; }

}
