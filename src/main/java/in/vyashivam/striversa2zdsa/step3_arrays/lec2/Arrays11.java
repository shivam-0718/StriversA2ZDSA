package in.vyashivam.striversa2zdsa.step3_arrays.lec2;

/*
    Given an m x n integer matrix, if an element is 0, set its entire row and column to 0. You must do it in place.

*/
public class Arrays11 {
    //brute-force solution
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length; //row
        int n = matrix[0].length; //column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    //mark the rows and columns which need to be marked as zero <=> matrix[i][j] == 0
                    markRow(i, matrix);
                    markColumn(j, matrix);
                }
            }
        }

        //Replace the placeholder values with zero
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /*
        Note: Here, we are assuming that the matrix does not contain any negative numbers.
        But if it contains negatives, we need to find some other ways to mark the cells instead of marking them with -1
    */

    // Helper to mark the given row with placeholder values
    private static void markRow(int row, int[][] arr) {
        int n = arr[row].length;
        for (int j = 0; j < n; j++) {
            if(arr[row][j] != 0) {
                arr[row][j] = -1;
            }
        }
    }

    // Helper to mark the given row with placeholder values
    private static void markColumn(int column, int[][] arr) {
        int m = arr.length;
        for (int i = 0; i < m; i++) {
            if(arr[i][column] != 0) {
                arr[i][column] = -1;
            }
        }
    }

    //better solution
    public static void setZero(int[][] matrix) {
        int m = matrix.length; //row
        int n = matrix[0].length; //column

        int[] row = new int[m]; // row markers -> to mark the respective ith row as 1 if matrix[i][j] == 0
        int[] col = new int[n]; // column markers -> to mark the respective jth col as 1 if matrix[i][j] == 0

        // Step 1: Mark rows and columns where 0s are found
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        // Step 2: Set cells to 0 if their row or column was marked
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //optimal solution
    public static void setZeros(int[][] matrix) {
        //column -> matrix[0][j] -> as column keeps on changing -> used for marking the columns
        //row -> matrix[i][0] -> as row keeps on changing -> used for marking rows

        int m = matrix.length;
        int n = matrix[0].length;
        int col0 = 1; //flag for first column

        // Step 1: Use 1st row and 1st column as markers
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0; //mark the ith row
                    if(j == 0) {
                        col0 = 0; // special case: first column
                    } else {
                        matrix[0][j] = 0; //mark the jth column
                    }
                }
            }
        }

        // Step 2: Update the inner matrix (excluding first row & column as these are column marker & row marker)
        for(int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 3: Update the first row (based on matrix[0][0])
        if(matrix[0][0] == 0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 4: Update the first column (based on col0 variable)
        if(col0 == 0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
//link: https://leetcode.com/problems/set-matrix-zeroes/
