package peasant_revolt;

import javax.swing.*;

public class ChessBoardPanelDriver {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Peasant Revolt Chess");
        jf.add(new ChessBoardPanel(new ChessBoard()));
        jf.setSize(600, 600);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}
