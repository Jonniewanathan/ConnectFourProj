/**
 * Created by t11125172 on 15/11/2116.
 */
public class CheckTests {

    public static void main(String[] args) {
        int[][] boardTest1 = new int[][]{{2,2,2,2,1,1,1},
                                        {1,1,1,1,1,1,1},
                                        {1,1,1,1,1,1,1},
                                        {1,1,1,1,1,1,1},
                                        {1,1,1,1,1,1,1},
                                        {1,1,1,1,1,1,1}};
        int[][] boardTest2 = new int[][]{{1,1,1,1,1,1,1},
                                        {1,1,1,1,1,1,1},
                                        {1,2,1,1,1,1,1},
                                        {1,1,2,1,1,1,1},
                                        {1,1,1,2,1,1,1},
                                        {1,1,1,1,2,1,1}};
        int[][] boardTest3 = new int[][]{{1,1,1,2,3,2,2},
                                         {1,1,1,3,2,2,3},
                                         {1,1,1,2,3,3,2},
                                         {1,1,1,1,2,3,3},
                                         {1,1,1,1,1,1,3},
                                         {1,1,1,1,1,1,1}};
        int[][] boardTest4 = new int[][]{{2,3,2,2,1,1,1},
                                         {1,1,1,1,1,1,2},
                                         {1,1,1,1,1,2,1},
                                         {1,1,1,1,2,1,1},
                                         {1,1,1,2,1,1,1},
                                         {1,1,1,1,1,1,1}};


        System.out.println(CheckMethods.checkWin(boardTest1));
        System.out.println(CheckMethods.checkWin(boardTest2));
        System.out.println(CheckMethods.checkWin(boardTest3));
        System.out.println(CheckMethods.checkWin(boardTest4));
    }
}
