package in.vyashivam.striversa2zdsa.step1_basics.lec4;

public class GcdHcf4 {
    //brute-force approach
    public static int gcd2Numbers(int n1, int n2) {
        int gcd = 1;
        for(int i = 1; i <= (int) Math.min(n1, n2); i++) {
            if(n1 % i == 0 && n2 % i == 0){
                gcd = i;
            }
        }
        return gcd;
    }

    //optimized approach
    public static int gcdOfNumbers(int n1, int n2) {
        int gcd = 1;
        for(int i = Math.min(n1, n2); i >= 1; i--) {
            if(n1 % i == 0 && n2 % i == 0){
                gcd = i;
                break;
            }
        }
        return gcd;
    }

    /**
     * Euclidean Algorithm:
     * GCD (a, b) = GCD (a-b, b) if a > b;
     * If after performing the steps as per the above algorithm:
     * If a = 0, or b = 0 , then the other number will be GCD.
     *
     *
     * Alternate, GCD(a, b) = GCD (a%b, b) if a > b
     */

    public static int gcdOf2Numbers(int a, int b) {
        int gcd = 0;
        while (a > 0 && b > 0) {
            if(a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }
        if(a == 0)
            return b;
        else
            return a;
    }
}
//link: https://www.naukri.com/code360/problems/hcf-and-lcm_840448
