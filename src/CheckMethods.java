/**
 * Created by jonathan on 09/11/2016.
 */
public class CheckMethods {
    private CheckMethods()
    {

    }

    public static int[][] playerCheck (int[][] board,int column,int player)
    {
        boolean valid = false;
        int num = 0;

        while(!valid) {
            valid = false;
            if(player == 1)
            {
                if(board[num][column-1] == 1){//checking if a piece exists in the spot
                    board[num][column-1] = 2;//adding a piece to the connect four board
                    valid = true;
                }
            }
            if(player == 2)
            {
                if(board[num][column-1] == 1){//checking if a piece exists in the spot
                    board[num][column-1] = 3;//adding a piece to the connect four board
                    valid = true;
                }
            }

            num++;
        }

        return board;
    }
    public static char checkHorizontalWin(int[][] board)
    {
        int numOfYellow = 0;
        int numOfRed = 0;
        //Algorithm for Checking for 4 in a row horizontally
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (board[i][j] == 2) {
                    numOfYellow++;
                    numOfRed = 0;
                }
                if (board[i][j] == 3) {
                    numOfRed++;
                    numOfYellow = 0;
                }
                if (board[i][j] == 1) {
                    numOfRed = 0;
                    numOfYellow = 0;
                }
                if (numOfYellow == 4) {
                    return 'Y';
                }
                if (numOfRed == 4) {
                    return 'R';
                }
            }
            numOfRed = 0;
            numOfYellow = 0;
        }
        return 'N';
    }
}
