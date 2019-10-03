import kotlin.Pair;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class BoardController implements BoardControllerInterface {

    private final Board boardInstance;

    public BoardController() {
        boardInstance = Board.getInstance();
    }

    public void makeMove(Pair<Integer,Integer> pos, String move) {
        boardInstance.makeMove(pos, move);
    }

    public ArrayList<JButton> getButtonList() {
        return boardInstance.getButtonList();
    }

    public String getCurrentMove() {
        return boardInstance.getMove();
    }

    public HashMap<Pair<Integer, Integer>, String> getMoveMap() {
        return boardInstance.getMoveMap();
    }


}
