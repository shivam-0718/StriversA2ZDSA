package in.vyashivam.striversa2zdsa.step1_basics.lec4;

public class ReverseNumber2 {
    //Coding Ninjas Problem
    public static long reverseNumber(long n) {
        long rev = 0;
        while (n > 0) {
            long lastDigit = n % 10;
            rev = (rev * 10) + lastDigit;
            n /= 10;
        }
        return rev;
    }

    //Leetcode Problem
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            rev = (rev * 10) + (x % 10);
            if(x <= Integer.MIN_VALUE || x >= Integer.MAX_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return rev;
    }
}
//link: https://www.naukri.com/code360/problems/reverse-of-a-number_893271
//link2: https://leetcode.com/problems/reverse-integer/
