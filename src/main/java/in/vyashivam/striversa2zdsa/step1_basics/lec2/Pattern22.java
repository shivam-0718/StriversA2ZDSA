package in.vyashivam.striversa2zdsa.step1_basics.lec2;

public class Pattern22 {
    public static void getNumberSquarePattern(int n) {
        for (int i = 0; i < 2*n-1; i++) {
            for (int j = 0; j < 2*n-1; j++) {
                int top = i;
                int left = j;
                int right = (2*n-1)-1-j;
                int bottom = (2*n-1)-1-i;
                int number = Math.min(Math.min(top, bottom), Math.min(left, right));
                System.out.print((n - number) + " ");
            }
            System.out.println();
        }
    }
}
