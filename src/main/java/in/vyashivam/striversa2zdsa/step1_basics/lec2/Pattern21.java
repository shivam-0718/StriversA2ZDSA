package in.vyashivam.striversa2zdsa.step1_basics.lec2;

public class Pattern21 {
    public static void hollowSquare(int n) {
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == 1 || j == 1 || i == n || j == n) {
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
