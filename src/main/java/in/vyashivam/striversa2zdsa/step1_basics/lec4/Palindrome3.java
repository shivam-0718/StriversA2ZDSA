package in.vyashivam.striversa2zdsa.step1_basics.lec4;

public class Palindrome3 {
    public static boolean palindromeNumber(int n){
        int nCopy = n, rev = 0;
        while(n > 0) {
            rev = rev*10 + (n % 10);
            n /= 10;
        }
        return (rev == nCopy);
    }
}
//link: https://www.naukri.com/code360/problems/palindrome-number_624662
//link2: https://leetcode.com/problems/palindrome-number/description/
