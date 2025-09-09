package in.vyashivam.striversa2zdsa.step1_basics.lec2;

public class Pattern4 {
    public static void nTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
//link: https://www.naukri.com/code360/problems/n-triangles_6573689
