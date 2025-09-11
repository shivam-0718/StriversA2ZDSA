package in.vyashivam.striversa2zdsa.step1_basics.lec4;

public class CountDigits1 {
    //brute-force approach
    public static int countDigits(int n){
       int count = 0;
        while (n > 0) {
           int lastDigit = n % 10; //opt
           count++;
           n /= 10;
       }
        return count;
    }

    //optimal approach
    public static int countNoOfDigits(int n) {
        return (int) (Math.log10(n) + 1);
    }
}
//link: https://www.naukri.com/code360/problems/number-of-digits_9173
