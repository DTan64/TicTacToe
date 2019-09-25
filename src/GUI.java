import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.*;

public class GUI {

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JPanel boardPanel;
    private BoardController bc = new BoardController();

    public GUI() {
        prepare();
    }

    public static void main(String args[]) {
        GUI game = new GUI();
        game.startGame();
    }

    private void prepare() {
        mainFrame = new JFrame("TicTacToe");
        //mainFrame.setSize(500,500);
        mainFrame.setLayout(new GridLayout(3,1));

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("",JLabel.CENTER);
        statusLabel.setSize(350,100);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);




    }

    private void startGame() {

        boardPanel = new JPanel();
        boardPanel.setSize(300,300);
        GridLayout layout = new GridLayout(0, 3);
        layout.setHgap(10);
        layout.setVgap(10);
        boardPanel.setLayout(layout);

        ArrayList<JButton> buttonList = bc.getButtonList();


        for(int i = 0; i < buttonList.size(); i++) {
            boardPanel.add(buttonList.get(i));
        }

        controlPanel.add(boardPanel);

        mainFrame.setSize(400,400);
        mainFrame.setVisible(true);


    }




}


