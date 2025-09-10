package in.vyashivam.striversa2zdsa.step1_basics.lec2;

public class Pattern15 {
    public static void letterRightTriangle(int n) {
        for (int i = 1; i <= n ; i++) {
            char ch = 'A';
            for (int j = 1; j <= n-i+1; j++) {
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();

        }
    }
}
