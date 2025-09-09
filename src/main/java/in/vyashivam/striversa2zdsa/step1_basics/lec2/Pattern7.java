package in.vyashivam.striversa2zdsa.step1_basics.lec2;

public class Pattern7 {
    public static void nStarTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            //spaces
            for (int j = 1; j <= n-i; j++) {
                System.out.printf(" ");
            }

            //stars
            for(int j = 1; j <= 2*i-1; j++) {
                System.out.printf("*");
            }

            //spaces
            for (int j = 1; j <= n-i; j++) {
                System.out.printf(" ");
            }
            System.out.println();
        }
    }
}
//link: https://www.naukri.com/code360/problems/star-triangle_6573671
