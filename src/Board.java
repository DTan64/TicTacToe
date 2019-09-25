import kotlin.Pair;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Board {

    private static HashMap<JButton, Pair<Integer, Integer>> buttonMap = new HashMap<>(); // button maps to position and value
    private static HashMap<Pair<Integer, Integer>, String> moveMap = new HashMap<>();
    private static ArrayList<JButton> buttonList = new ArrayList<>();
    private static Board board = new Board();


    private static final String xMove = "X";
    private static final String oMove = "O";
    private static String move = xMove;
    private static final int N = 3;

    //private Board() {};




    private Board() {

        int row;
        int col;


        for (int i = 0; i < N*N; i++) {
            JButton buttonToInsert = new Spot();
            //buttonToInsert.addActionListener(this::selectionButtonPressed);
            row = i / N;
            col = i % N;

            buttonMap.put(buttonToInsert, new Pair<>(col, row)); // x y coords from top left. positive y is down
            moveMap.put(new Pair<>(col, row), "");
            buttonList.add(buttonToInsert);
        }


    }


    public static Board getInstance() {
        return board;
    }



    public void makeMove(JButton buttonClicked) {
        System.out.println("making move");

        if (move.equals(xMove)) {

            moveMap.put(buttonMap.get(buttonClicked), xMove);
            move = oMove;
        }
        else {
            moveMap.put(buttonMap.get(buttonClicked), oMove);
            move = xMove;
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
        return move;
    }



    public Pair getPos(JButton button) {
        return buttonMap.get(button);
    }

}
