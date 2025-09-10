package in.vyashivam.striversa2zdsa.step1_basics.lec2;

public class Pattern13 {
    public static void sumRightTriangle(int n) {
        int sum = 1;
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(sum + " ");
                sum += 1;
            }
            System.out.println();

        }
    }
}
