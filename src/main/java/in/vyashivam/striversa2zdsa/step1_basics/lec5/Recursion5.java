package in.vyashivam.striversa2zdsa.step1_basics.lec5;

//Print sum of first n natural numbers using recursion
public class Recursion5 {
    static int sum = 0;
    public static int NumbersSum(int n) {
        //base condition
        if(n == 0) {
            return sum;
        }

        //recursive call
        NumbersSum(n - 1);

        //print statement or calculations
        sum += n;
        return sum;
    }
}
