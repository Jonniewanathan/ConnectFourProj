/**
 * Created by jonathan on 10/11/2016.
 */
//Import Statements
    import javax.swing.*;
    import java.awt.*;

public class ConnectFour extends JFrame{

    private JButton[] colButtons = new JButton[7];
    private JLabel[][] pieces = new JLabel[7][6];
    GridLayout grid = new GridLayout(7,7);
    public static void main(String[] args) {
        new ConnectFour();
    }
    public ConnectFour()
    {
        setTitle("Connect Four");
        setLayout(grid);
        setSize(700,700);
        for (int i = 0; i < colButtons.length; i++) {
                colButtons[i] = new JButton("Column " + i);
                add(colButtons[i]);

        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                pieces[i][j] = new JLabel(i + " " + j);
                add(pieces[i][j]);
            }
        }
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
