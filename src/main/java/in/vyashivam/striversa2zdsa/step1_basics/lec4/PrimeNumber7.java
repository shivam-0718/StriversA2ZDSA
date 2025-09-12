package in.vyashivam.striversa2zdsa.step1_basics.lec4;

public class PrimeNumber7 {
    //brute-force approach
    public static boolean isPrime(int n) {
        int count;
        count = 0;
        for (int i = 1; i <= n; i++) {
            if (n%i == 0) {
                count++;
            }
        }
        return count == 2;
    }

    //optimized approach
    public static boolean isPrimeNumber(int n) {
        int count = 0;
        for (int i = 1; i*i <= n; i++) {
            if (n%i == 0) {
                count++;
                if((n / i) != i) {
                    count++;
                }
            }
        }
        return count == 2;
    }
}
//link: https://www.naukri.com/code360/problems/check-prime_624674
