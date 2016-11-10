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
    public static char checkWin(int[][] board){
        char win = 'N';

        win = CheckMethods.checkHorizontalWin(board);
        if(win == 'N'){
            win = CheckMethods.checkVerticalWin(board);
            if(win == 'N'){
                win = CheckMethods.checkDiagonal1Win(board);
                if(win == 'N'){
                    win = CheckMethods.checkDiagonal2Win(board);
                }
            }
        }
        return win;
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
    public static char checkVerticalWin(int[][]board)
    {
        //Algorithm for checking for 4 in a row vertically
        int numOfYellow = 0;
        int numOfRed = 0;
        for (int j = 0; j < 7; j++) {
            for (int h = 0; h < 6; h++) {
                if (board[h][j] == 2) {
                    numOfYellow++;
                    numOfRed = 0;
                }
                if (board[h][j] == 3) {
                    numOfRed++;
                    numOfYellow = 0;
                }
                if (board[h][j] == 1) {
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
    public static char checkDiagonal1Win(int[][]board) {
        int startRow = 0;
        int startColumn = 0;
        int column = 0;
        int row = 0;
        int numOfYellow = 0;
        int numOfRed = 0;
        //algorithm to find 4 in a row diagonal up to the right/down to the left

        for (int i = 0; i < 7; i++) {
            do {
                column = 0;
                row = 0;
                if(i == 1)
                {
                    column = 1;
                }
                if(i == 2)
                {
                    column = 2;
                }
                if(i == 3)
                {
                    column = 3;
                }
                if(i == 4)
                {
                    row = 1;
                }
                if(i == 5)
                {
                    row = 2;
                }
                for (int j = 0; j < 4; j++) {
                    if (j == 0) {
                        column += startColumn;
                        row += startRow;
                    }
                    if (board[row][column] == 2) {
                        numOfYellow++;
                        numOfRed = 0;
                    }
                    if (board[row][column] == 3) {
                        numOfRed++;
                        numOfYellow = 0;
                    }
                    if (board[row][column] == 1) {
                        numOfRed = 0;
                        numOfYellow = 0;
                    }
                    if (numOfYellow == 4) {
                        return 'Y';
                    }
                    if (numOfRed == 4) {
                        return 'R';
                    }
                    column++;
                    row++;
                }
                startColumn++;
                startRow++;
                numOfRed = 0;
                numOfYellow = 0;
            } while (row < 6 && column < 7);
            startColumn = 0;
            startRow = 0;
        }
        return 'N';
    }
    public static char checkDiagonal2Win(int[][]board) {
        int startRow = 0;
        int startColumn = 0;
        int column = 0;
        int row = 0;
        int numOfYellow = 0;
        int numOfRed = 0;
        //algorithm to find 4 in a row diagonal down to the right/up to the left

        for (int i = 0; i < 7; i++) {
            do {
                column = 6;
                row = 0;
                if(i == 1)
                {
                    column = 5;
                }
                if(i == 2)
                {
                    column = 4;
                }
                if(i == 3)
                {
                    column = 3;
                }
                if(i == 4)
                {
                    row = 1;
                }
                if(i == 5)
                {
                    row = 2;
                }
                for (int j = 0; j < 4; j++) {
                    if (j == 0) {
                        column -= startColumn;
                        row += startRow;
                    }
                    if (board[row][column] == 2) {
                        numOfYellow++;
                        numOfRed = 0;
                    }
                    if (board[row][column] == 3) {
                        numOfRed++;
                        numOfYellow = 0;
                    }
                    if (board[row][column] == 1) {
                        numOfRed = 0;
                        numOfYellow = 0;
                    }
                    if (numOfYellow == 4) {
                        return 'Y';
                    }
                    if (numOfRed == 4) {
                        return 'R';
                    }
                    column--;
                    row++;
                }
                startColumn++;
                startRow++;
                numOfRed = 0;
                numOfYellow = 0;
            } while (row < 6 && column > 0);
            startColumn = 0;
            startRow = 0;
        }
        return 'N';
    }
}
