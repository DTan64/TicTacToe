import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class GUI {

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JPanel boardPanel;

    public static final Integer N = 3;
    private static final ArrayList<JButton> buttonList = new ArrayList<>();
    private static final HashMap<Pair<Integer, Integer>, JButton> buttonMap = new HashMap<>(); // position map to button


    private GUI() {
        prepare();
    }

    public static void main(String args[]) {
        GUI game = new GUI();
        game.startGame();
    }

    private void prepare() {
        mainFrame = new JFrame("TicTacToe");
        //mainFrame.setSize(500,500);
        mainFrame.setLayout(new GridLayout(3, 1));

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);


    }

    private void startGame() {

        boardPanel = new JPanel();
        boardPanel.setSize(300, 300);
        GridLayout layout = new GridLayout(0, 3);
        layout.setHgap(10);
        layout.setVgap(10);
        boardPanel.setLayout(layout);

        int row;
        int col;


        for (int i = 0; i < N * N; i++) {
            row = i / N;
            col = i % N;
            JButton buttonToInsert = new Spot(col, row);
            buttonList.add(buttonToInsert);
            buttonMap.put(new Pair<>(col, row), buttonToInsert); // x y coords from top left. positive y is down
        }

        for (JButton jButton : buttonList) {
            boardPanel.add(jButton);
        }


        controlPanel.add(boardPanel);

        mainFrame.setSize(400, 400);
        mainFrame.setVisible(true);


    }

    public static JButton getButton(int col, int row) {
        return buttonMap.get(new Pair<>(col, row));
    }


}


