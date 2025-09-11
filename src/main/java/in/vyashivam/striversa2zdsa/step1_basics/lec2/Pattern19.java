package in.vyashivam.striversa2zdsa.step1_basics.lec2;

public class Pattern19 {
    public static void nStarSquare(int n) {
        int initSpaces = 0;
        //first half
        for (int i = 1; i <= n; i++) {
            //stars
            for (int j = 1; j <= n-i+1; j++) {
                System.out.print("*");
            }

            //spaces
            for(int j = 0; j < initSpaces; j++) {
                System.out.print(" ");
            }

            //stars
            for (int j = 1; j <= n-i+1; j++) {
                System.out.print("*");
            }
            initSpaces += 2;
            System.out.println();
        }

        //second half
        initSpaces = 2*n - 2;
        for(int i = 1; i <= n; i++) {
            //stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            //spaces
            for (int j = 0; j < initSpaces; j++) {
                System.out.print(" ");
            }


            //stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            initSpaces -= 2;
            System.out.println();
        }

    }
}
