//Connect four game

import java.util.Scanner;

//Class start

public class TestClass {
    public static void main(String args[])
    {
        int [][] board = new int[6][7];
        int column;
        int num = 0;
        boolean valid = false;
        //fills the 2-d array with 1 which signifies a blank space
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = 1;
            }
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a Column: ");
        column = input.nextInt();

        board = CheckMethods.playerCheck(board,column);

        for (int i = 5; i >= 0; i--) {//Prints the board out in the console
            for (int j = 0; j < 7; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}