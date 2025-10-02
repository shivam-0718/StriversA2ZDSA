package in.vyashivam.striversa2zdsa.step3_arrays.lec3;

import java.util.ArrayList;
import java.util.List;
/*
    Pascal Triangle Problems:
        Part i: Given row and col, print the element from Pascal Triangle.
        Part ii: Print the Nth row of Pascal Triangle.
        Part iii: Print Pascal Triangle up to N rows.

    Pascal Triangle: https://en.wikipedia.org/wiki/Pascal%27s_triangle
*/

public class Arrays1 {
    //Part i
    //Brute-force solution
    public static int printPascalTriangleElement(int row, int col) {
        // Formula to find the element at row and col of a Pascal Triangle: C(row-1, col-1)
        // General nCr = (n!) / (r! * (n-r)!)
        // Here, n = row - 1 and r = col - 1
        int ans = factorial(row - 1) / (factorial(col - 1) * factorial(row - col));
        return ans;
    }

    //Function to find the factorial of a given number
    private static int factorial(int num) {
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    //Optimal solution
    // Using direct nCr calculation instead of factorials
    // Formula: C(row-1, col-1)
    public static int printPascalTriangleEle(int row, int col) {
        int ans = nCr(row - 1, col - 1);
        return ans;
    }

    // Function to calculate nCr iteratively (avoids large factorials)
    // nCr = (n * (n-1) * ... * (n-r+1)) / (1 * 2 * ... (r-1) * r)
    private static int nCr(int n, int r) {
        int res = 1;

        // Run loop exactly r times (i = 0 → r-1)
        // Each step multiplies numerator by (n - i)
        // and divides denominator by (i + 1)
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    //Part ii
    //Brute-force solution
    public static int[] printNthRowPascalTriangle(int row) {
        int[] ans = new int[row];

        // Each element of the row can be computed as C(n-1, i)
        for (int i = 0; i < row; i++) {
            ans[i] = nCr(row - 1, i);
        }
        return ans;
    }

    //Optimal solution
    public static int[] printNthRowOfPascalTriangle(int row) {
        int[] ans = new int[row];
        ans[0] = 1; // first element is always 1
        int res = 1;

        // Each element can be derived from the previous one.
        for (int i = 1; i < row; i++) {
            res = res * (row - i);
            res = res / i;
            ans[i] = res;
        }

        return ans;
    }

    //Part iii
    //Brute-force solution
    public static List<List<Integer>> generatePascalTriangle(int rows) {
        List<List<Integer>> ans = new ArrayList<>();

        // For each row i, calculate all elements using nCr
        for (int row = 1; row <= rows; row++) {
            List<Integer> tempList = new ArrayList<>();
            for (int col = 1; col <= row; col++){
                tempList.add(nCr(row - 1, col - 1));
            }
            ans.add(tempList);
        }

        return ans;
    }

    //Optimal solution
    public static List<List<Integer>> generate(int rows) {
        List<List<Integer>> ans = new ArrayList<>();

        // Generate each row using iterative formula
        for (int row = 1; row <= rows; row++) {
            ans.add(generateRow(row));
        }
        return ans;
    }

    // Helper function to generate a single row.
    // Row starts with 1, then each element is derived from the previous one
    private static List<Integer> generateRow(int n) {
        List<Integer> row = new ArrayList<>();
        int res = 1;
        row.add(1);

        // Formula: res = res * (n - i) / i
        for (int i = 1; i < n; i++) {
            res = res * (n - i);
            res = res / i;
            row.add(res);
        }
        return row;
    }
}
//link: https://leetcode.com/problems/pascals-triangle/description/
//link2: https://www.naukri.com/code360/problems/pascal-s-triangle_1089580
