package in.vyashivam.striversa2zdsa.step1_basics.lec2;

public class Pattern17 {
    public static void nCharacterTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            //spaces
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }

            //characters
            char ch = 'A';
            int breakpoint = (2*i - 1) / 2;
            for(int j = 1; j <= 2*i-1; j++) {
                System.out.print(ch);
                if (j <= breakpoint) {
                    ch++;
                } else {
                    ch--;
                }
            }

            //spaces
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
//link: https://www.naukri.com/code360/problems/star-triangle_6573671
