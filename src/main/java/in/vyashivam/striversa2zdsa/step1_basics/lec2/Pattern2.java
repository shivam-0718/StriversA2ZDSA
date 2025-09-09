package in.vyashivam.striversa2zdsa.step1_basics.lec2;

public class Pattern2 {
    public static void nForest(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
//link: https://www.naukri.com/code360/problems/n-2-forest_6570178
