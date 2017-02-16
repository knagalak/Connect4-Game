import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by csclass on 10/10/16.
 */


public class Connect4 {

    //Instance Variables

    private char[][] board = {{' ', ' ', ' ', ' ', ' ', ' ', ' '},
    {' ', ' ', ' ', ' ', ' ', ' ', ' '},
    {' ', ' ', ' ', ' ', ' ', ' ', ' '},
    {' ', ' ', ' ', ' ', ' ', ' ', ' '},
    {' ', ' ', ' ', ' ', ' ', ' ', ' '},
    {' ', ' ', ' ', ' ', ' ', ' ', ' '}};
    private char red;
    private char yellow;
    public char empty;

    //Constructor

    public Connect4() {

        this.red = 'O';
        this.yellow = 'X';
        this.empty = ' ';

    }

    //Return Board

    public char [][] getBoard() {

        return Arrays.copyOf(board, board.length);}

    // Inserts a piece

    public int putPiece(int column, char color) {

        if (board[5][column] == empty) {
            board[5][column] = color;
            return 5;}
        else if (board[4][column] == empty) {
            board[4][column] = color;
            return 4;}
        else if (board[3][column] == empty) {
            board[3][column] = color;
            return 3;}
        else if (board[2][column] == empty) {
            board[2][column] = color;
            return 2;}
        else if (board[1][column] == empty) {
            board[1][column] = color;
            return 1;}
        else if (board[0][column] == empty) {
            board[0][column] = color;
            return 0;}
        else return -1;

    }

    // Checks Alignment

    public char checkAlignment(int row, int column) {

        //Checking the row
         if (board [row] [0] != ' ' && board[row][0] == board[row][1] && board[row][1] == board[row][2] &&
                board[row][2] == board[row][3])
             return board[row][0];

         else if (board [row] [1] != ' ' && board[row][1] == board[row][2] && board[row][2] == board[row][3] &&
                 board[row][3] == board[row][4])
             return board[row][1];

         else if (board [row] [2] != ' ' && board[row][2] == board[row][3] && board[row][3] == board[row][4] &&
                 board[row][4] == board[row][5])
             return board[row][2];

         else if (board [row] [3] != ' ' && board[row][3] == board[row][4] && board[row][4] == board[row][5] &&
                 board[row][5] == board[row][6])
             return board[row][3];

        //Checking the column

        if (board[5][column]== board[4][column] && board[4][column]== board[3][column] && board[3][column]==
                board[2][column] && board[5][column] != ' ')
            return board[5][column];

        else if (board[4][column]== board[3][column] && board[3][column]== board[2][column] && board[2][column]==
                board[1][column] && board[4][column] != ' ')
            return board[4][column];

        else if (board[3][column]== board[2][column] && board[2][column]== board[1][column] && board[1][column]==
                board[0][column] && board[3][column] != ' ')
            return board[3][column];


        //Checking diagonal towards right

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] == board[3][3] && board[0][0] !=
                ' ')
            return board[0][0];

        else if (board[1][1] == board[2][2] && board[2][2] == board[3][3] && board[3][3] == board[4][4] &&
                board[1][1] != ' ')
            return board[1][1];

        else if (board[2][2] == board[3][3] && board[3][3] == board[4][4] && board[5][5] == board[4][4] &&
                board[4][4] != ' ')
            return board[2][2];





        if (board[0][1] == board[1][2] && board[1][2] == board[2][3] && board[2][3] == board[3][4] && board[2][3] != ' ')
            return board[0][1];

        else if (board[1][2] == board[2][3] && board[2][3] == board[3][4] && board[3][4] == board[4][5] &&
                board[4][5] != ' ')
            return board[1][2];

        else if (board[2][3] == board[3][4] && board[3][4] == board[4][5] && board[5][6] == board[4][5] &&
                board[4][5] != ' ')
            return board[2][3];





        if (board[1][0] == board[2][1] && board[2][1] == board[3][2] && board[3][2] == board[4][3] && board[3][2] !=
                ' ')
            return board[1][0];

        else if (board[2][1] == board[3][2] && board[3][2] == board[4][3] && board[4][3] == board[5][4] &&
                board[3][2] != ' ')
            return board[2][1];




        if (board[0][2] == board[1][3] && board[1][3] == board[2][4] && board[2][4] == board[3][5] && board[2][4] !=
                ' ')
            return board[0][2];
        else if (board[1][3] == board[2][4] && board[2][4] == board[3][5] && board[3][5] == board[4][6] &&
                board[4][6] !=
                ' ')
            return board[1][3];



        if (board[2][0] == board[3][1] && board[3][1] == board[4][2] && board[4][2] == board[5][3] && board[5][3] !=
                ' ')
            return board[2][0];



        if (board[0][3] == board[1][4] && board[1][4] == board[2][5] && board[2][5] == board[3][6] && board[3][6] !=
                ' ')
            return board[0][3];



        //Check diagonal towards left

        if (board[0][6] == board[1][5] && board[1][5] == board[2][4] && board[2][4] == board[3][3] && board[0][6] !=
                ' ')
            return board[0][6];

        else if (board[1][5] == board[2][4] && board[2][4] == board[3][3] && board[3][3] == board[4][2] &&
                board[1][5] != ' ')
            return board[1][5];

        else if (board[2][4] == board[3][3] && board[3][3] == board[4][2] && board[5][1] == board[4][2] &&
                board[4][2] != ' ')
            return board[2][4];





        if (board[0][5] == board[1][4] && board[1][4] == board[2][3] && board[2][3] == board[3][2] && board[2][3] !=
                ' ')
            return board[0][5];

        else if (board[1][4] == board[2][3] && board[2][3] == board[3][2] && board[3][2] == board[4][1] &&
                board[4][1] != ' ')
            return board[1][4];

        else if (board[2][3] == board[3][2] && board[3][2] == board[4][1] && board[5][0] == board[4][1] &&
                board[4][1] != ' ')
            return board[2][3];





        if (board[1][6] == board[2][5] && board[2][5] == board[3][4] && board[3][4] == board[4][3] && board[3][4] !=
                ' ')
            return board[1][6];

        else if (board[2][5] == board[3][4] && board[3][4] == board[4][3] && board[4][3] == board[5][2] &&
                board[3][4] != ' ')
            return board[2][5];




        if (board[0][4] == board[1][3] && board[1][3] == board[2][2] && board[2][2] == board[3][1] && board[2][2] !=
                ' ')
            return board[0][4];
        else if (board[1][3] == board[2][2] && board[2][2] == board[3][1] && board[3][1] == board[4][0] &&
                board[4][0] !=
                        ' ')
            return board[1][3];


        if (board[2][6] == board[3][5] && board[3][5] == board[4][4] && board[4][4] == board[5][3] && board[5][3] !=
                ' ')
            return board[2][6];


        if (board[0][3] == board[1][2] && board[1][2] == board[2][1] && board[2][1] == board[3][0] && board[3][0] !=
                ' ')
            return board[0][3];


        return empty;
    }



    public void printScreen() {
        System.out.println("     0     1     2     3     4     5     6    ");
        System.out.println("---------------------------------------------");
        System.out.println("A |  " + board[0][0] + "  |  " + board[0][1] + "  |  " + board[0][2] + "  |  " +
                board[0][3] + "  |  " + board[0][4] + "  |  " + board[0][5] + "  |  " + board[0][6] + "  | ");
        System.out.println("---------------------------------------------");
        System.out.println("B |  " + board[1][0] + "  |  " + board[1][1] + "  |  " + board[1][2] + "  |  " +
                board[1][3] + "  |  " + board[1][4] + "  |  " + board[1][5] + "  |  " + board[1][6] + "  | ");
        System.out.println("---------------------------------------------");
        System.out.println("C |  " + board[2][0] + "  |  " + board[2][1] + "  |  " + board[2][2] + "  |  " +
                board[2][3] + "  |  " + board[2][4] + "  |  " + board[2][5] + "  |  " + board[2][6] + "  | ");
        System.out.println("---------------------------------------------");
        System.out.println("D |  " + board[3][0] + "  |  " + board[3][1] + "  |  " + board[3][2] + "  |  " +
                board[3][3] + "  |  " + board[3][4] + "  |  " + board[3][5] + "  |  " + board[3][6] + "  | ");
        System.out.println("---------------------------------------------");
        System.out.println("E |  " + board[4][0] + "  |  " + board[4][1] + "  |  " + board[4][2] + "  |  " +
                board[4][3] + "  |  " + board[4][4] + "  |  " + board[4][5] + "  |  " + board[4][6] + "  | ");
        System.out.println("---------------------------------------------");
        System.out.println("F |  " + board[5][0] + "  |  " + board[5][1] + "  |  " + board[5][2] + "  |  " +
                board[5][3] + "  |  " + board[5][4] + "  |  " + board[5][5] + "  |  " + board[5][6] + "  | ");
        System.out.println("---------------------------------------------");

    }


    public void play() {

        boolean done = false;
        boolean draw = false;

        do {

            Scanner scan = new Scanner(System.in);

            //Red Turn
            printScreen();
            System.out.println("Current Player:  'O'");
            System.out.println("Choose a column: ");
            int cR = scan.nextInt();

            //Check if cR is Valid
            while (!(cR >= 0 && cR <= 6)) {
                System.out.println("Invalid Column. Enter column in range 0 to 6 only");
                System.out.println("Choose a column: ");
                cR = scan.nextInt();
            }

            int rR = putPiece(cR,red);

            // If Full Column
            while (rR == -1) {

                //If Full Board
                int count = 0;

                for (int i = 0; i <board.length ; i ++) {
                    for (int j = 0; j < board[i].length; j++) {
                        if (board[i][j] == empty)
                            count++;}
                }

                if (count == 0) {
                    draw = true;
                    System.out.println("The Game is a Draw");
                    break;
                }

                System.out.println("Column is Full. Enter another column");
                System.out.println("Choose a column: ");
                cR = scan.nextInt();
                rR = putPiece(cR,red);
            }

            if (draw == true)
                break;


            if (checkAlignment(rR,cR) == empty) {
                //Yellow Turn
                printScreen();
                System.out.println("Current Player:  'X'");
                System.out.println("Choose a column: ");
                int cY = scan.nextInt();

                //Check if cY is Valid
                while (!(cY >= 0 && cY <= 6)) {
                    System.out.println("Invalid Column. Enter column in range 0 to 6 only");
                    System.out.println("Choose a column: ");
                    cY = scan.nextInt();
                }

                int rY = putPiece(cY,yellow);

                // If Full Column
                while (rY == -1) {

                    //If Full Board
                    int count = 0;

                    for (int i = 0; i <board.length ; i ++) {
                        for (int j = 0; j < board[i].length; j++) {
                            if (board[i][j] == empty)
                                count++;}
                    }

                    if (count == 0) {
                        draw = true;
                        System.out.println("The Game is a Draw");
                        break;
                    }

                    System.out.println("Column is Full. Enter another column");
                    System.out.println("Choose a column: ");
                    cY = scan.nextInt();
                    rY = putPiece(cR,yellow);
                }

                if (draw == true)
                    break;

                if (checkAlignment(rY,cY) != empty) {
                    done = true;
                    printScreen();
                    System.out.println("!!! Winner is Player 'X' !!!"); }
            }

            else {
                done = true;
                printScreen();
                System.out.println("!!! Winner is Player 'O' !!!");
            }

        } while(!done && !draw);




    }











}
