/**
 * Created by jonathan on 10/11/2016.
 */
//Import Statements
    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

public class ConnectFour extends JFrame{

    private JButton[] colButtons = new JButton[7];
    private JLabel[][] pieces = new JLabel[7][6];
    ImageIcon redPiece;
    ImageIcon yellowPiece;
    ImageIcon empty;

    public static void main(String[] args) {
        new ConnectFour();
    }
    public ConnectFour()
    {
        redPiece = new ImageIcon("./images/redPiece100.png");
        yellowPiece = new ImageIcon("./images/yellowPiece100.png");
        empty = new ImageIcon("./images/empty100.png");
        FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
        GridLayout boardGrid = new GridLayout(6,7);
        JPanel cFBoard = new JPanel(boardGrid);
        setTitle("Connect Four");
        setSize(770,700);
        setLayout(flow);
        for (int i = 0; i < colButtons.length; i++) {
                colButtons[i] = new JButton("Column " + (i+1));
                add(colButtons[i]);
        }
        for (int i = 6; i >= 0; i--) {
            for (int j = 0; j < 6; j++) {
                pieces[i][j] = new JLabel(empty);
                cFBoard.add(pieces[i][j]);
            }
        }
        add(cFBoard);
        ButtonEventHandler handler = new ButtonEventHandler();
        for (int i = 0;i < 7;i++)
        {
            colButtons[i].addActionListener(handler);
        }
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    private class ButtonEventHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }
}
