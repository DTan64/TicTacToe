import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

public class Spot extends JButton {

    private static String move;
    private final Pair<Integer, Integer> position;


    public Spot(int col, int row) {

        super();
        this.addActionListener(this::onClick);
        position = new Pair<>(col, row);
        move = "x";

    }

    private void onClick(ActionEvent e) {

        JButton tmp = (JButton) e.getSource();
        ImageIcon xIcon = new ImageIcon(GUI.class.getResource("images/" + move.toLowerCase() + ".png"));

        BufferedImage resized = new BufferedImage(20, 20, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resized.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(xIcon.getImage(), 0, 0, 20, 20, null);
        g2.dispose();
        xIcon = new ImageIcon(resized);
        tmp.setIcon(xIcon);
        tmp.setBackground(Color.RED);
        tmp.setBorder(BorderFactory.createEmptyBorder());
        tmp.setDisabledIcon(xIcon);
        tmp.setEnabled(false);

        if (move.equals("x")) {
            move = "o";
        } else {
            move = "x";
        }




    }


}
