package peasant_revolt;

import javax.swing.*;
import java.awt.*;

public class ChessBoardPanel extends JPanel {
    private ChessBoard board;

    public ChessBoardPanel(ChessBoard c) {
        board = c;

        setLayout(new GridLayout(8,8));

        for(int i = 0; i < 64; i++) {
            /*
            // Here's an example of how I can get multiple elements in the same
            // square - by putting them on the same JPanel and then adding the JPanel
            // to the ChessBoardPanel
            JPanel jp = new JPanel();
            jp.add(new JLabel("" + i));
            jp.add(new JLabel("" + (i * 20)));
            add(jp);
             */
            add(new ChessBoardSquarePanel(i));
        }
    }

    private class ChessBoardSquarePanel extends JPanel {
        private Piece piece;
        private Integer row, column;

        public ChessBoardSquarePanel(Integer i) {

            /*if((((i/8) % 2 == 0) && ((i%8) % 2 == 1)) ||
                ((i/8) % 2 == 1) && ((i%8) % 2) == 0) { */

            row = i/8;
            column = i%8;

            /*if((evenRow(i) && !evenColumn(i)) ||
               (!evenRow(i) && evenColumn(i))) { */

            if((even(row) && odd(column)) ||
               (odd(row) && even(column))) {
                setBackground(getBackground().darker());
            }
        }

        private Boolean even(Integer i) {
            return i % 2 == 0;
        }

        private Boolean odd(Integer i) {
            return !even(i);//i % 2 == 1;
        }
        private Boolean evenRow(Integer i) {
            return (i/8) % 2 == 0;
        }

        private Boolean evenColumn(Integer i) {
            return (i%8) % 2 == 0;
        }
    }

}
