package in.vyashivam.striversa2zdsa.step1_basics.lec2;

public class Pattern10 {
    public static void nRightDiamond(int n) {
        for(int i = 1; i <= 2*n - 1; i++) {
            int stars = i;
            if(i > n) {
                stars = 2*n - i;
            }
            for (int j = 1; j <= stars; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
