package in.vyashivam.striversa2zdsa.step1_basics.lec2;

public class Pattern8 {
    public static void nStarReverseTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            //spaces
            for (int j = 1; j <= i; j++) {
                System.out.printf(" ");
            }

            //stars
            //as last problem j<= 2i - i -> subtract this whole from 2n
            // j<= 2n - (2i - 1) => 2(n-i) + 1
            for(int j = 1; j <= 2*(n-i) + 1; j++) {
                System.out.printf("*");
            }

            //spaces
            for (int j = 1; j <= i; j++) {
                System.out.printf(" ");
            }
            System.out.println();
        }
    }
}
