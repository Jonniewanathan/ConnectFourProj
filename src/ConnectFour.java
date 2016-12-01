/**
 * Created by jonathan on 10/11/2016.
 */
//Import Statements
    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.util.*;
    import java.io.*;
    import sun.audio.*;

public class ConnectFour extends JFrame{

    //Creating the column buttons
    private JButton[] colButtons = new JButton[7];

    //Creating the playBoard on the gui
    private JLabel[][] pieces = new JLabel[6][7];

    //Declaring the code for the 2d array
    private int[][] board;

    //Player number either player one or two
    private int player = 1;

    //new game button count
    private int newGameclick = 0;

    //Boolean to tell the program if it's against computer or not
    private boolean computer = false;
    private int numPlayers;

    //Boolean to display the computer scores in the highscores
    boolean compInList = false;

    //Making a player Arraylist
    private ArrayList<Player> players;

    private String p1Name;

    //Menu Buttons
    private JButton newGame;
    private JButton newPlayer;
    private JButton highScore;

    //Menu Bar
    private JMenuBar menuBar;
    private JMenu menu;
    //private JMenuItem menuItem;
    private JMenuItem history;
    private JMenuItem howToPlay;

    //Image icons for my pieces
    private ImageIcon redPiece;
    private ImageIcon yellowPiece;
    private ImageIcon empty;

    //JLabels to print the Name, Wins and Loses to the gui;
    private JLabel pName;
    private JLabel pl2Name;
    private JLabel pWin;
    private JLabel p2Win;
    private JLabel pLoses;
    private JLabel p2Loses;

    //JPanel to place Components on the JFrame
    private JPanel cFBoard;
    private JPanel colButton;
    private JPanel score;
    private JPanel menuButtons;

    //Grid Layouts
    private GridLayout boardGrid;
    private GridLayout scoreGrid;
    private GridLayout menuGrid;

    //Border Layouts
    private BorderLayout border;

    //Flow Layout
    private FlowLayout flow;

    //Dimension sizes
    private Dimension score_size;

    //Player Object
    private Player p1;
    private Player p2;
    private Computer comp;
    private Player temp;

    //Player list Number select
    private int pNumber;
    private int p2Number;


    //Creating the ButtonHandler
    private ButtonEventHandler handler;

    //Main
    public static void main(String[] args) {
        new ConnectFour();
    }
    //GUI Constructor
    public ConnectFour()
    {
        //ImageIcons
        redPiece = new ImageIcon("./images/redPiece100.png");
        //redPiece = new ImageIcon("./images/gerRed100.png");
        yellowPiece = new ImageIcon("./images/yellowPiece100.png");
        //yellowPiece = new ImageIcon("./images/gerYellow100.png");
        empty = new ImageIcon("./images/empty100.png");

        //Dimension
        score_size = new  Dimension(100,700);

        //Creating the board for use in calculations
        Board boardObj = new Board(6,7);

        //FlowLayout
        flow = new FlowLayout();

        //BorderLayout
        border = new BorderLayout();

        //Menu Bar
        menuBar = new JMenuBar();
        menu = new JMenu("Info");
        //menuItem = new JMenuItem("Menu Item");
        history = new JMenuItem("History");
        howToPlay = new JMenuItem("How To Play!");

        //Grid Layouts
        boardGrid = new GridLayout(6,7);
        scoreGrid = new GridLayout(6,1);
        menuGrid = new GridLayout(4,1);

        //JPanels
        cFBoard = new JPanel(boardGrid);
        colButton = new JPanel(flow);
        score = new JPanel(scoreGrid);
        menuButtons = new JPanel(menuGrid);

        //JLabels
        pName = new JLabel();
        pWin = new JLabel();
        pLoses = new JLabel();
        pl2Name = new JLabel();
        p2Win = new JLabel();
        p2Loses = new JLabel();

        //Setting the size of the score panel
        score.setPreferredSize(score_size);

        //setting up the JFrame
        setTitle("Connect Four");
        setSize(900,700);
        setLayout(border);

        //Adding menu bar
        menuBar.add(menu);
        //menu.add(menuItem);
        menu.add(history);
        menu.add(howToPlay);
        setJMenuBar(menuBar);


        //Creates the board
        board = boardObj.getBoard();

        //Creates the Computer Object
        comp = new Computer();

        //Creates the Array list
        players = new ArrayList<>();

        //Adds comp object to the players ArrayList
        players.add(comp);

        //Adding the column buttons to the JPanel colButton
        for (int i = 0; i < colButtons.length; i++)
        {
                colButtons[i] = new JButton("Column " + (i+1));
                colButton.add(colButtons[i]);
        }


        //sets the background of the board
        cFBoard.setBackground(Color.BLUE);

        //Sets the board up for play
        emptyBoard();

        //Adding the scoreboard panel
        addScoreBoard();

        //Adding the menu buttons
        addMenuButtons();

        //adding the panels to the the JFrame
        add(colButton,BorderLayout.NORTH);
        add(cFBoard,BorderLayout.CENTER);

        //creating the button event handler
        handler = new ButtonEventHandler();

        //adding the action listener to the menu buttons
        newGame.addActionListener(handler);
        newPlayer.addActionListener(handler);
        highScore.addActionListener(handler);

        //Adding action listener to menu items
        history.addActionListener(handler);
        howToPlay.addActionListener(handler);


        //forces the window to not be resizeable
        setResizable(false);

        //makes the gui visible
        setVisible(true);

        //Setting the close operation
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    private class ButtonEventHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == newGame)
            {
                playSound("boxMovement.wav");
                open();
                numPlayers = JOptionPane.showConfirmDialog(null,"2 Player?");
                resetBoard();
                printPlayerlist();
                if(numPlayers == JOptionPane.YES_OPTION)
                {
                    computer = false;
                    if(newGameclick < 1)
                    {
                        colButtonsListener();
                        p1 = players.get(pNumber);
                        p2 = players.get(p2Number);
                    }
                }
                else if(numPlayers == JOptionPane.NO_OPTION)
                {
                    computer = true;
                    if(newGameclick < 1)
                    {
                        colButtonsListener();
                        p1 = players.get(pNumber);
                        temp = players.get(0);
                        int compWin = temp.getWin();
                        int compLose = temp.getLoses();
                        comp.setExactWin(compWin);
                        comp.setExactLose(compLose);
                    }
                }
                getScores();
                newGameclick++;
            }
            else if(e.getSource() == newPlayer)
            {
                addPlayer();
                save();
            }
            else if(e.getSource() == highScore)
            {
                open();
                compInList = true;
                printPlayerlist();

            }
            else if(e.getSource() == history)
            {
                String stringHistory = "Connect Four (also known as Captain's Mistress, Four Up, Plot Four, Find Four, Fourplay, Four in a Row,\n" +
                        "Four in a Line and Gravitrips (in Soviet Union) ) is a two-player connection game in which the players first choose a \n" +
                        "color and then take turns dropping colored discs from the top into a seven-column, six-row vertically suspended grid. \n" +
                        "The pieces fall straight down, occupying the next available space within the column. The objective of the game is to be \n" +
                        "the first to form a horizontal, vertical, or diagonal line of four of one's own discs. Connect Four is a solved game. \n" +
                        "The first player can always win by playing the right moves.\n" +
                        "\n" +
                        "The game was first sold under the famous Connect Four trademark by Milton Bradley in February 1974.";
                JOptionPane.showMessageDialog(null,stringHistory,"History",JOptionPane.PLAIN_MESSAGE);
            }
            else if(e.getSource() == howToPlay)
            {
                String stringHowToPlay = "The Player starts by placing their first piece onto the board.\n" +
                        "Player 2/Computer places their piece next.\n" +
                        "This goes back and forth until one player gets four pieces in a row horizontally,Vertically or Diagonally eg.\n" +
                        "X X X X X X X    X X X X X X X\n" +
                        "X X X X X X X    X X X X X X X\n" +
                        "X X X X X X X    X X X X O X X\n" +
                        "X X X X X X X    X X X O X X X\n" +
                        "X X X X X X X    X X O X X X X\n" +
                        "X O O O O X X   X O X X X X X\n\n" +
                        "X X X X X X X    X X X X X X X\n" +
                        "X X X X X X X    X X X X X X X\n" +
                        "X X X O X X X    X O X X X X X\n" +
                        "X X X O X X X    X X O X X X X\n" +
                        "X X X O X X X    X X X O X X X\n" +
                        "X X X O X X X    X X X X O X X\n";






                JOptionPane.showMessageDialog(null,stringHowToPlay,"How to Play!",JOptionPane.PLAIN_MESSAGE);
            }
            else if(e.getSource() == colButtons[0])
            {
                if(board[5][0] != 2 && board[5][0] != 3)
                {
                    buttonPressed(0);
                }

            }
            else if(e.getSource() == colButtons[1])
            {
                if(board[5][1] != 2 && board[5][1] != 3)
                {
                    buttonPressed(1);
                }

            }
            else if(e.getSource() == colButtons[2])
            {
                if(board[5][2] != 2 && board[5][2] != 3)
                {
                    buttonPressed(2);
                }
            }
            else if(e.getSource() == colButtons[3])
            {
                if(board[5][3] != 2 && board[5][3] != 3)
                {
                    buttonPressed(3);
                }
            }
            else if(e.getSource() == colButtons[4])
            {
                if(board[5][4] != 2 && board[5][4] != 3)
                {
                    buttonPressed(4);
                }
            }
            else if(e.getSource() == colButtons[5])
            {
                if(board[5][5] != 2 && board[5][5] != 3)
                {
                    buttonPressed(5);
                }
            }
            else if(e.getSource() == colButtons[6])
            {
                if(board[5][6] != 2 && board[5][6] != 3)
                {
                    buttonPressed(6);
                }
            }
        }
    }
    public void playSound(String soundFile)
    {
        try
        {
            // open the sound file as a Java input stream
            InputStream in = new FileInputStream(soundFile);

            // create an audiostream from the inputstream
            AudioStream audioStream = new AudioStream(in);

            // play the audio clip with the audioplayer class
            AudioPlayer.player.start(audioStream);
        }catch(IOException e)
        {

        }
    }
    public void addMenuButtons()
    {
        newGame = new JButton("New Game");
        newPlayer = new JButton("New Player");
        highScore = new JButton("High Score");
        menuButtons.add(newGame);
        menuButtons.add(newPlayer);
        menuButtons.add(highScore);
        menuButtons.setPreferredSize(score_size);
        add(menuButtons,BorderLayout.WEST);
    }
    //Displays the list of players stored in the Arraylist
    public void printPlayerlist()
    {
        int num = 1;
        JTextArea playerList = new JTextArea(20,20);
        if(compInList)
        {
            num = 0;
        }
        else
        {
            playerList.append("Enter the number of the player you would like to play as\n");
        }
        for (int i = num; i < players.size() ; i++)//Starts at one so as not to display the computer in the player select
        {
            playerList.append( " " + i + ": " + players.get(i).toString() + "\n");
        }
        if(!compInList)
        {
            pNumber = Integer.parseInt(JOptionPane.showInputDialog(playerList));
            if(numPlayers == JOptionPane.YES_OPTION)
            {
                p2Number = Integer.parseInt(JOptionPane.showInputDialog(playerList));
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,playerList,"High Scores",JOptionPane.PLAIN_MESSAGE);
            compInList = false;
        }

    }
    //Adds players to the game
    public void addPlayer()
    {
        p1Name = JOptionPane.showInputDialog("Please enter your name");
        p1 = new Player(p1Name);
        players.add(p1);
    }
    //saves to the .dat file
    public void save()
    {
        try{
            ObjectOutputStream os;
            os = new ObjectOutputStream(new FileOutputStream ("Player.dat"));
            os.writeObject(players);
            os.close();
        }catch(IOException e)
        {
            JOptionPane.showMessageDialog(null,"You done Goofed!");
            e.printStackTrace();
        }

    }
    //loads from the .dat file
    public void open() {
        try{
            ObjectInputStream is;
            is = new ObjectInputStream(new FileInputStream ("Player.dat"));
            players  = (ArrayList<Player>) is.readObject();
            is.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"open didn't work");
            e.printStackTrace();
        }

    }
    //Adds the column button listteners
    public void colButtonsListener()
    {
        for (int i = 0;i < colButtons.length;i++)
        {
            colButtons[i].addActionListener(handler);
        }
    }
    //empties the board of pieces
    public void emptyBoard()
    {
        for (int i = 5; i >= 0; i--)
        {
            for (int j = 0; j < 7; j++)
            {
                pieces[i][j] = new JLabel(empty);
                cFBoard.add(pieces[i][j]);
            }
        }
    }
    //Resets the underlying 2-d array of ints back to 1
    public void resetBoard()
    {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if(board[i][j] != 1)
                {
                    board[i][j] = 1;
                    pieces[i][j].setIcon(empty);
                }
            }
        }
    }
    //removes action listeners from the column select buttons
    public void removeColListener()
    {
        for (int i = 0;i < colButtons.length;i++)
        {
            colButtons[i].removeActionListener(handler);
        }
    }
    //adds the stat board to the right side
    public void addScoreBoard()
    {
        score.add(pName);
        score.add(pWin);
        score.add(pLoses);
        score.add(pl2Name);
        score.add(p2Win);
        score.add(p2Loses);
        add(score,BorderLayout.EAST);
    }
    //Gets the scores for the particular player
    public void getScores()
    {
        pName.setText("Name: " + p1.getName());
        pWin.setText("Win: " + Integer.toString(p1.getWin()));
        pLoses.setText("Loses: " + Integer.toString(p1.getLoses()));
        pWin.repaint();
        pLoses.repaint();

        if(numPlayers == JOptionPane.YES_OPTION)
        {
            pl2Name.setText("Name: " + p2.getName());
            p2Win.setText("Win: " + Integer.toString(p2.getWin()));
            p2Loses.setText("Loses: " + Integer.toString(p2.getLoses()));
            p2Win.repaint();
            p2Loses.repaint();
        }
        else if(numPlayers == JOptionPane.NO_OPTION)
        {
            players.remove(0);
            players.add(0,comp);
            pl2Name.setText("Name: " + comp.getName());
            p2Win.setText("Win: " + Integer.toString(comp.getWin()));
            p2Loses.setText("Loses: " + Integer.toString(comp.getLoses()));
            p2Win.repaint();
            p2Loses.repaint();
        }
    }
    //Sets the colour of the piece on the board
    public void setColour(int column, int[][] board,int player)
    {
        boolean valid = false;
        int num = 0;
        int pieceNum = 0;
        ImageIcon playerIcon = empty;
        while(!valid) {
            valid = false;
            //Changing the Piece Colour depending on player
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

            //checking if a piece exists in the spot
            if(board[num][column] == 1)
            {
                board[num][column] = pieceNum;//adding a piece to the connect four board
                pieces[num][column].setIcon(playerIcon);//Changing the image icon on the JPanel
                valid = true;
            }
            num++;
        }
    }
    //when a column button is selected it calls the setColour method
    //also switches the user if you are playing 2 player or calls the computer to pick a column
    public void buttonPressed(int col)
    {
            playSound("piecePlace.wav");
            if(!computer)
            {
                setColour(col,board,player);
                switchUsers();
                temp = p2;
                CheckMethods.checkWinPane(board,p1,temp);
            }
            else if(computer)
            {
                setColour(col,board,1);
                temp = comp;

                CheckMethods.checkWinPane(board,p1,temp);

                if(computer && CheckMethods.checkWin(board) != 'Y')
                {
                    int num;
                    num = comp.play();

                    while(board[5][num] == 2 || board[5][num] == 3)
                    {
                        num = comp.play();
                    }
                    if(board[5][num] != 2 || board[5][num] != 3)
                    {
                        setColour(num,board,2);
                        CheckMethods.checkWinPane(board,p1,temp);
                    }

                }
            }
            if(CheckMethods.checkWin(board) != 'N')
            {
                removeColListener();
                getScores();
                newGameclick = 0;
                resetBoard();
                save();
                playSound("john.wav");
            }
    }
    //switches the user when playing 2 player
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
