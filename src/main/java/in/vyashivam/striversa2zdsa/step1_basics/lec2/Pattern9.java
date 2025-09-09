package in.vyashivam.striversa2zdsa.step1_basics.lec2;

public class Pattern9 {
    public static void nDiamond(int n) {
        //combination of Pattern 7 and Pattern 8
        Pattern7.nStarTriangle(n);
        Pattern8.nStarReverseTriangle(n);
    }
}
