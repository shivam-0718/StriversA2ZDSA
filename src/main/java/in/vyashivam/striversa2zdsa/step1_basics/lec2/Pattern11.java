package in.vyashivam.striversa2zdsa.step1_basics.lec2;

public class Pattern11 {
    public static void binaryRightTriangle(int n) {
        int ans = 1;
        for(int i = 1; i <= n; i++) {
            if(i % 2 == 0) {
                ans = 0;
            } else {
                ans = 1;
            }
            for(int j = 1; j <= i; j++) {
                System.out.print(ans + " ");
                ans = 1-ans;
            }
            System.out.println();
        }
    }
}
//link: https://www.naukri.com/code360/problems/binary-number-triangle_6581890
