import kotlin.Pair;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public interface BoardControllerInterface {

    void makeMove(Pair<Integer,Integer> pos, String move);

    ArrayList<JButton> getButtonList();

    String getCurrentMove();

    HashMap<Pair<Integer, Integer>, String> getMoveMap();


}
