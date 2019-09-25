// maybe and interface?


import javax.swing.*;
import java.util.ArrayList;

public class BoardController {

    private final Board boardInstance;

    public BoardController() {
        boardInstance = Board.getInstance();
    }

    public void makeMove(JButton button) {
        boardInstance.makeMove(button);
    }

    public ArrayList<JButton> getButtonList() {
        return boardInstance.getButtonList();
    }

    public String getCurrentMove() {
        return boardInstance.getMove();
    }




}
