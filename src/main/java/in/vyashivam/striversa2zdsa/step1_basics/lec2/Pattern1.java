package in.vyashivam.striversa2zdsa.step1_basics.lec2;

public class Pattern1 {
    public static void nForest(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
//link: https://www.naukri.com/code360/problems/n-forest_6570177


/*
Logic of solving pattern problems:
1. For the outer loop, count the number of rows
2. For the inner loop, focus on the columns and connect them somehow to the rows.
3. Print the "*" inside the inner for loop.
4. Observe symmetry (optional)
 */