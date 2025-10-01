package in.vyashivam.striversa2zdsa.step3_arrays.lec2;

import java.util.ArrayList;
import java.util.List;
/*
    Given an m x n matrix, return all elements of the matrix in spiral order.
*/

public class Arrays13 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();

        //Initializing boundaries of matrix
        int left = 0, right = n - 1, top = 0, bottom = m - 1;

        //Continuing spiral traversal within boundaries
        while(left <= right && top <= bottom) {
            //1. Left to Right along Top row
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++; // Move top boundary down

            //2. Top to Bottom along Right column
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--; // Move right boundary left

            //3. Right to left along Bottom row
            // Check if there's still a row to traverse (prevents revisiting in single-row case)
            if(top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--; // Move bottom boundary up
            }

            //4. Bottom to top
            // Check if there's still a column to traverse (prevents revisiting in single-column case)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}
//link: https://www.naukri.com/code360/problems/spiral-matrix_840698
//link2: https://leetcode.com/problems/spiral-matrix/
