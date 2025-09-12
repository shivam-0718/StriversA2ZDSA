package in.vyashivam.striversa2zdsa.step1_basics.lec4;

public class ArmstrongNumber5 {
    public static boolean isArmstrong(int n) {
        int power = (int) (Math.log10(n) + 1);
        int nCopy = n, armNo = 0;

        while (n > 0) {
            int lastDigit = n % 10;
            armNo += (int) Math.pow(lastDigit, power);
            n /= 10;
        }
        return (nCopy == armNo);
    }
}
//link: https://www.naukri.com/code360/problems/check-armstrong_589
