package in.vyashivam.striversa2zdsa.step1_basics.lec5;

//Print factorial of n using recursion
public class Recursion6 {
    static int fact = 1;
    public static int nFactorial(int n) {
        if(n == 0) {
            return fact;
        }

        fact *= n;
        nFactorial(n - 1);

        return fact;

    }
}
