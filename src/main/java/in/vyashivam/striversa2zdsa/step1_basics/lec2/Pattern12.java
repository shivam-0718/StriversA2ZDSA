package in.vyashivam.striversa2zdsa.step1_basics.lec2;

public class Pattern12 {
    public static void numberRightTriangles(int n) {
        int spaces = 2 * (n-1);
        for (int i = 1; i <= n; i++) {
            //number
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            //spaces
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

            //number
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
            spaces -= 2;
        }

    }
}
/*
number, space, number
1, 6, 1
2, 4, 2
3, 2, 3
4, 0, 4
 */
