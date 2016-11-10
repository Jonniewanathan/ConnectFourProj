/**
 * Created by jonathan on 10/11/2016.
 */
//Import Statements
    import javax.swing.*;
    import java.awt.*;

public class ConnectFour extends JFrame{

    private JButton[] colButtons = new JButton[7];
    private JLabel[][] pieces = new JLabel[7][6];


    public static void main(String[] args) {
        new ConnectFour();
    }
    public ConnectFour()
    {
        ImageIcon redPiece = new ImageIcon("./images/redPiece100.png");
        GridLayout grid = new GridLayout(7,7);
        setTitle("Connect Four");
        setSize(770,770);
        setLayout(grid);

        for (int i = 0; i < colButtons.length; i++) {
                colButtons[i] = new JButton("Column " + (i+1));
                add(colButtons[i]);
        }
        for (int i = 6; i >= 0; i--) {
            for (int j = 0; j < 6; j++) {
                pieces[i][j] = new JLabel(redPiece);
                add(pieces[i][j]);
            }
        }
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
