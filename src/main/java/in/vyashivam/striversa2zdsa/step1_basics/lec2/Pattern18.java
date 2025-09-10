package in.vyashivam.striversa2zdsa.step1_basics.lec2;

public class Pattern18 {
    public static void nCharacterRightTriangle(int n) {
        char ch = 'E';
        for (int i = 1; i <= n; i++) {
            for (char j = (char) ('F' - i); j < 'F'; j++) {
                System.out.print(j+ " ");
            }
            System.out.println();
        }
    }
}
