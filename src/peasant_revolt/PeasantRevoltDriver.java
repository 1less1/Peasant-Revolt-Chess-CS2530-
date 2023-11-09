package peasant_revolt;

import javax.swing.*;

public class PeasantRevoltDriver {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Peasant Revolt Chess");
        PeasantRevolt pr = new PeasantRevolt();

        jf.add(new ChessBoardPanel(pr.getChessBoard()));
        jf.setSize(600, 600);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}
