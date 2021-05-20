public class Solver {
    static int[][] ars = {

            {0, 0, 0, 2, 6, 0, 7, 0, 1},
            {6, 8, 0, 0, 7, 0, 0, 9, 0},
            {1, 9, 0, 0, 0, 4, 5, 0, 0},
            {8, 2, 0, 1, 0, 0, 0, 4, 0},
            {0, 0, 4, 6, 0, 2, 9, 0, 0},
            {0, 5, 0, 0, 0, 3, 0, 2, 8},
            {0, 0, 9, 3, 0, 0, 0, 7, 4},
            {0, 4, 0, 0, 5, 0, 0, 3, 6},
            {7, 0, 3, 0, 1, 8, 0, 0, 0},


    };


    public static void main(String[] args) {
        System.out.println("this is before");
        printSudokoBoard();
        System.out.println("\n");
        solver();
        System.out.println("this is after");
        printSudokoBoard();

    }

    static void printSudokoBoard() {
        for (int i = 0; i < ars.length; i++) {
            if(i%3 == 0 && i != 0){
                System.out.println("--------------------");
            }


            for (int j = 0; j < ars[i].length; j++) {

                if(j%3 == 0 && j != 0){
                    System.out.print("|");
                    System.out.print("|");
                }

                System.out.print(ars[i][j] + " ");
            }
            System.out.println();
        }
    }


    {

    }

    public static boolean checkColumn(int x, int y, int n) {
        // check columns for constraints
        for (int j = 0; j <= 8; j++) {
            if (ars[j][y] == n) {
                //System.out.println("checking column");
                return false;
            }

        }
        return true;
    }

    public static boolean checkRow(int x, int y, int n) {
        // checks the rows for constraints

        for (int i = 0; i <= 8; i++) {
            if (ars[x][i] == n) {
                //System.out.println("checking Rows");
                return false;
            }

        }
        return true;
    }

    public static boolean checksquare(int x, int y, int n) {
// check squares for  constrains
        int a0 = (x / 3) * 3;
        int b0 = (y / 3) * 3;


        for (int z = 0; z < 3; z++) {

            for (int k = 0; k < 3; k++) {


                if (ars[a0 + z][b0 + k] == n) {

                    return false;
                }

            }
        }

        return true;

    }

    public static boolean isValid(int x,int y,int z){
        return true ==checkColumn(x,y,z) && true == checksquare(x,y,z) && true == checkRow(x,y,z);

    }




    public static boolean solver() {
// two for loops used for searching for 0


        for (int i = 0; i < ars.length; i++) {

            for (int j = 0; j < ars[i].length; j++) {

                if (ars[i][j] == 0) {

                    // entering values between 1 - 9 and checking if it doesn't break constaints
                    for (int z = 1; z < 10; z++) {

                        if (isValid(i,j,z)) {
                            // z does not break constraints
                            ars[i][j] = z;
                            // uses backtracking. If a placement works, it will return true.
                            // Else if that placement doesn't work, it resets it position to 0.
                            if(solver()){
                                // solver returns true if all 0's are filled with values that obey constraints
                                return true;
                            }else{
                                ars[i][j] = 0;
                            }

                        }


                    }
                    // input value goes through 1 - 9 and none of the values obey the constraints. This means we need to backtrack and set previous value to zero
                    return false;
                }


            }

        }
        // sudoko board is solved. End of two for loops. reached the end of 2d array.
        return true;
    }
}


