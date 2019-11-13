package UI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI {

	private static final Integer N = 3;

		public static void main(String args[]) {
		GUI.startGame();
	}

	private static final void startGame() {
		JFrame rootFrame = new JFrame("TicTacToe");
		rootFrame.setSize(500, 500);
		rootFrame.addWindowListener(getCloseWindowListener());
		JPanel board = new JPanel(new GridLayout(3, 3));

        int row;
        int col;
        for (int i = 0; i < N * N; i++) {
            row = i / N;
            col = i % N;
            JButton buttonToInsert = new Spot(col, row);
            buttonToInsert.setText(Integer.toString(i));
			board.add(buttonToInsert);
        }

		rootFrame.add(board);
		rootFrame.setVisible(true);
	}

	private static final WindowAdapter getCloseWindowListener() {
		return new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		};
	}
}


