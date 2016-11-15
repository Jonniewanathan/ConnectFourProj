/**
 * Created by jonathan on 15/11/2016.
 */
public class Board {
    private int height;
    private int width;
    private int[][] board;

    Board()
    {
        this(1,1);
    }
    Board(int height,int width)
    {
        setHeight(height);
        setWidth(width);
    }
    public void setHeight(int height)
    {
        this.height = height;
    }
    public void setWidth(int width)
    {
        this.width = width;
    }
    public int getHeight()
    {
        return height;
    }

    public int getWidth()
    {
        return width;
    }

    public int[][] createBoard()
    {

        board = new int[getWidth()][getHeight()];
        return board;
    }
    public void setBoard()
    {
        int[][] board = getBoard();
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                board[i][j] = 1;
            }
        }
    }
    public int[][] getBoard()
    {
        createBoard();
        return board;
    }
}
