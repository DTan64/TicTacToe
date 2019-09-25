import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Spot extends JButton {


    public Spot() {

        super();
        this.addActionListener(this::onClick);

    }

    private void onClick(ActionEvent e) {

        BoardController bc = new BoardController();

        JButton tmp = (JButton) e.getSource();
        ImageIcon xIcon = new ImageIcon(GUI.class.getResource("images/" + bc.getCurrentMove().toLowerCase() + ".png"));

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



        bc.makeMove(tmp);





    }


}
