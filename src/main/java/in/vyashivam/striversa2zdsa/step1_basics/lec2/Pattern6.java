package in.vyashivam.striversa2zdsa.step1_basics.lec2;

public class Pattern6 {
    public static void nTriangle(int n) {
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n-i+1; j++) {
                System.out.printf(j + " ");
            }
            System.out.println();
        }
    }
}
//link: Refer to pattern 5
