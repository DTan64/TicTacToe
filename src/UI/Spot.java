package UI;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

class Spot extends JButton {

    // -------------------- Private --------------------

    private final int col;
    private final int row;

    // -------------------- Constructors --------------------

    Spot(int col, int row) {
        super();
        this.addActionListener(this::onClick);
        this.col = col;
        this.row = row;
    }

    // -------------------- Private --------------------

    private void onClick(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();
        System.err.printf("%s\n", buttonClicked.getText());
        buttonClicked.setIcon(getMoveImageIcon());
        buttonClicked.setBorder(BorderFactory.createEmptyBorder());
        buttonClicked.setDisabledIcon(getMoveImageIcon());
        buttonClicked.setEnabled(false);
    }

    private ImageIcon getMoveImageIcon() {
        // TODO: Why do I need ".." working directory maybe?
        ImageIcon moveIcon = new ImageIcon(GUI.class.getResource("../images/x.png"));
        BufferedImage resized = new BufferedImage(20, 20, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resized.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(moveIcon.getImage(), 0, 0, 20, 20, null);
        g2.dispose();
        return new ImageIcon((resized));
    }
}
