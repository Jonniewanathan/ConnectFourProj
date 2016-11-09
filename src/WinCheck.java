//Connect four game

import java.util.Scanner;

//Class start

public class WinCheck{
    public static void main(String args[])
    {
        int [][] board = new int[6][7];
        //fills the 2-d array with 1 which signifies a blank space
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = 1;
            }
        }

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}