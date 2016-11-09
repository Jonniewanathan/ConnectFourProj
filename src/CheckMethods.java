/**
 * Created by jonathan on 09/11/2016.
 */
public class CheckMethods {

    public CheckMethods()
    {

    }

    public static int[][] playerCheck (int[][] board,int column)
    {
        boolean valid = false;
        int num = 0;

        while(!valid) {
            valid = false;
            if(board[num][column-1] == 1){//checking if a piece exists in the spot
                board[num][column-1] = 2;//adding a piece to the connect four board
                valid = true;
            }
            num++;
        }

        return board;
    }
}
