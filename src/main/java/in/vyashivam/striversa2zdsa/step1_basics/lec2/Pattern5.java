package in.vyashivam.striversa2zdsa.step1_basics.lec2;

public class Pattern5 {
    public static void nTriangle(int n) {
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n-i+1; j++) {
                System.out.printf("* ");
            }
            System.out.println();
        }
    }
}
//link: https://www.naukri.com/code360/problems/reverse-number-triangle_6581889
