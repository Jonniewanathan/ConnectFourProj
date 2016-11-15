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
    private JLabel[][] pieces = new JLabel[6][7];
    private int[][] board = new int[6][7];
    private int player = 1;
    private boolean computer;
    private int numPlayers;
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
        setSize(700,700);
        setLayout(flow);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = 1;
            }
        }
        for (int i = 0; i < colButtons.length; i++) {
                colButtons[i] = new JButton("Column " + (i+1));
                add(colButtons[i]);
        }
        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < 7; j++) {
                pieces[i][j] = new JLabel(empty);
                cFBoard.add(pieces[i][j]);
            }
        }
        cFBoard.setBackground(Color.BLUE);
        add(cFBoard);
        ButtonEventHandler handler = new ButtonEventHandler();

        for (int i = 0;i < colButtons.length;i++)
        {
            colButtons[i].addActionListener(handler);
        }
        numPlayers = JOptionPane.showConfirmDialog(null,"2 Player?");
        if(numPlayers == JOptionPane.YES_OPTION)
        {
            computer = false;
        }
        else
        {
            computer = true;
        }
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    private class ButtonEventHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == colButtons[0])
            {
                if(board[5][0] != 2 && board[5][0] != 3)
                {
                    buttonPressed(0,computer);
                }

            }
            if(e.getSource() == colButtons[1])
            {
                if(board[5][1] != 2 && board[5][1] != 3)
                {
                    buttonPressed(1,computer);
                }

            }
            if(e.getSource() == colButtons[2])
            {
                if(board[5][2] != 2 && board[5][2] != 3)
                {
                    buttonPressed(2,computer);
                }
            }
            if(e.getSource() == colButtons[3])
            {
                if(board[5][3] != 2 && board[5][3] != 3)
                {
                    buttonPressed(3,computer);
                }
            }
            if(e.getSource() == colButtons[4])
            {
                if(board[5][4] != 2 && board[5][4] != 3)
                {
                    buttonPressed(4,computer);
                }
            }
            if(e.getSource() == colButtons[5])
            {
                if(board[5][5] != 2 && board[5][5] != 3)
                {
                    buttonPressed(5,computer);
                }
            }
            if(e.getSource() == colButtons[6])
            {
                if(board[5][6] != 2 && board[5][6] != 3)
                {
                    buttonPressed(6,computer);
                }
            }
        }
    }
    public void setColour(int column, int[][] board,int player)
    {
        boolean valid = false;
        int num = 0;
        int pieceNum = 0;
        ImageIcon playerIcon = empty;
        while(!valid) {
            valid = false;
            if(player == 1)
            {
                pieceNum = 2;
                playerIcon = yellowPiece;
            }
            if(player == 2)
            {
                pieceNum = 3;
                playerIcon = redPiece;
            }
                if(board[num][column] == 1){//checking if a piece exists in the spot
                    board[num][column] = pieceNum;//adding a piece to the connect four board
                    pieces[num][column].setIcon(playerIcon);
                    valid = true;
                }
            num++;
        }

    }
    public void buttonPressed(int col,boolean computer)
    {
        Computer comp = new Computer ("Computer",0);
        if(computer == false)
        {
            setColour(col,board,player);
            switchUsers();
        }
        else
        {
            setColour(col,board,1);
        }
        CheckMethods.checkWinPane(board);
        if(computer ==true)
        {
            setColour(comp.play(),board,2);
        }
        CheckMethods.checkWinPane(board);
    }
    public void switchUsers()
    {
        if(player == 1)
        {
            player = 2;
        }
        else
        {
            player = 1;
        }
    }
}
