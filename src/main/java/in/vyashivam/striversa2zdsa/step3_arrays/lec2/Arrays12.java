package in.vyashivam.striversa2zdsa.step3_arrays.lec2;
import java.util.ArrayList;

/*
    Given an N * N 2D integer matrix, rotate the matrix by 90 degrees clockwise.
    Then rotate the another given matrix by 90 degrees anticlockwise.
    The rotation must be done in place, meaning the input 2D matrix must be modified directly.
*/

public class Arrays12 {
    //First part: Rotate a matrix by 90 degrees clockwise
    //brute-force solution
    public static int[][] rotateMatrix(int[][] matrix) {
        int n = matrix.length; // matrix is square -> rows = cols = n
        int[][] ans = new int[n][n]; //answer matrix which will return the rotated matrix

        // Observation: first row of input -> last column of output, and so on
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][n - 1 - i] = matrix[i][j];
            }
        }
        return ans;
    }

    //optimal solution
    public static void rotateClockwise(int[][] matrix){
        //1. Transpose the matrix - every row becomes column and every column becomes row
        //2. Reverse each row to complete 90 degrees clockwise rotation
        int n = matrix.length;

        // Step 1: Transpose the matrix -> swap elements across the diagonal, but only once -> upper triangle to prevent double swapping
        for(int i = 0; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //Step 2: Reverse each row to complete 90 degrees clockwise rotation
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }

    //Second part: Rotate a matrix by 90 degrees anti-clockwise
    //brute-force
    public static ArrayList<ArrayList<Integer>> rotateMatrix(ArrayList<ArrayList<Integer>> matrix){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = matrix.size();

        // Step 1: Initialize ans as n x n matrix filled with zeros
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0); // fill with 0 initially so .set() works
            }
            ans.add(row);
        }

        // Step 2: Place elements from original matrix into their rotated positions when rotated 90 degrees clockwise.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans.get(n-1-j).set(i, matrix.get(i).get(j));
            }
        }
        return ans;
    }

    public static ArrayList<ArrayList<Integer>> rotateAntiClockwise(ArrayList<ArrayList<Integer>> matrix) {
        //1. Transpose the matrix - every row becomes column and every column becomes row
        //2. Reverse every column to get the rotated matrix 90 degrees anticlockwise

        int n = matrix.size();

        // Step 1: Transpose the matrix
        for (int i = 0; i <= n-2; i++) {
            for (int j = i + 1; j <= n-1; j++) {
                int temp = matrix.get(i).get(j);
                matrix.get(i).set(j, matrix.get(j).get(i));
                matrix.get(j).set(i, temp);
            }
        }

        //Step 2: Reverse each column
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix.get(i).get(j);
                matrix.get(i).set(j, matrix.get(n-1-i).get(j));
                matrix.get(n-1-i).set(j, temp);
            }
        }

        return matrix;
    }
}
//link: https://leetcode.com/problems/rotate-image/
//link2: https://www.naukri.com/code360/problems/rotate-matrix-by-90-degrees_981261
//link3: https://www.naukri.com/code360/problems/rotate-the-matrix_6825090
