import java.security.SecureRandom;
import java.util.Scanner;

public class GameGrid {

    public void run() {
        int[][] aiGrid = new int[10][10]; //imagine ([y],[x])
        //TODO: suggest making game pieces ...they can be numbers or letters...just not 1 or 0
        String[][] printBoard = new String[10][10];
        String wall = "X";
        String hiddenSpace = "-";
        String clearedSpace = "#";
        String playerPiece = "P";

        SecureRandom oRand = new SecureRandom();
        int iWallChance = 25;
        int iTempNum;


        // Create nested loop to create game grid.
        //TODO: use this loop just to fill in the aiGrid array, don't print.
        //NOW ALSO FILLS IN  printBoard array.
        for (int y = 0; y < aiGrid.length; y++) { //aiGrid.length = 10
            for (int x = 0; x < aiGrid[0].length; x++) {

                //Use wall chance to decide whether wall or path here.
                iTempNum = oRand.nextInt(100);
                if (iTempNum < iWallChance) {
                    aiGrid[y][x] = 1;
                } else {
                    aiGrid[y][x] = 0;
                }
                //TODO >>> I ADDED THIS
                printBoard[y][x] = hiddenSpace; //now every item in array printBoard is a hiddenSpace
                //aiGrid[y][x] = oRand.nextInt(2);

                //TODO: suggest not printing the grid here ....comment out line below or leave so u can see answers to test game

                // System.out.print(aiGrid[y][x] + "  ");

            }
            //TODO: same thing,  remove the print.

            // System.out.println(""); //prints empty line with or w/out quotes
        }
        int iUserRow = 0;
        int iUserCol = 0;
        aiGrid[0][0] = 0;

        //TODO: so print the grid but print everything as a hiddenSpace from your variables at the top of run()
        //except for aiGrid[0][0] ..print the playerPiece
        /**
         * so what im saying is ...do a loop using aiGrid but use if statemnts to check what to print instead of the value thats in aiGrid
         */
        //print board
        for (int y = 0; y < aiGrid.length; y++) { //aiGrid.length = 10
            for (int x = 0; x < aiGrid[0].length; x++) {
                if (y == iUserCol && x == iUserRow) {
                    printBoard[y][x] = playerPiece;
                }
                System.out.print(printBoard[y][x] + "  ");
            }
            System.out.println();
        }


        while (iUserRow < 9 || iUserCol < 9) {
            System.out.println("Press 1 to move right or 2 to go down");
            Scanner scanner = new Scanner(System.in);
            int ans = scanner.nextInt();

            if (ans == 1) {
                printBoard[iUserCol][iUserRow] = clearedSpace;
                iUserRow++;
                printBoard[iUserCol][iUserRow] = playerPiece;
            } else if (ans == 2) {
                printBoard[iUserCol][iUserRow] = clearedSpace;
                iUserCol++;
                printBoard[iUserCol][iUserRow] = playerPiece;
            }
            if (aiGrid[iUserCol][iUserRow] == 1) {
                //DONE: SET printBoard[iUserCol][iUserRow] = wall;
                printBoard[iUserCol][iUserRow] = wall;

                //print board
                for (int y = 0; y < aiGrid.length; y++) { //aiGrid.length = 10
                    for (int x = 0; x < aiGrid[0].length; x++) {
                        System.out.print(printBoard[y][x] + "  ");
                    }
                    System.out.println();
                }

                System.out.println("You lose");
                break;
            }

            //print board
            for (int y = 0; y < aiGrid.length; y++) { //aiGrid.length = 10
                for (int x = 0; x < aiGrid[0].length; x++) {
                    System.out.print(printBoard[y][x] + "  ");
                }
                System.out.println();
            }

            //check for winner
            if (iUserRow == 9 || iUserCol == 9) {
                System.out.println("You win!");
                break;
            }
        }
    }
}