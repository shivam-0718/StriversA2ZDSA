package in.vyashivam.striversa2zdsa.step1_basics.lec2;

public class Pattern20 {
    public static void nLeftRightDiamond(int n) {
        int spaces = 2*n - 2;
        for (int i = 1; i <= 2*n-1; i++) {
            int stars = i;
            if(i > n) {
                stars = 2*n - i;
            }

            //stars
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }

            //spaces
            for(int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            if(i < n) {
                spaces -= 2;
            }else {
                spaces += 2;
            }

            //stars
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
