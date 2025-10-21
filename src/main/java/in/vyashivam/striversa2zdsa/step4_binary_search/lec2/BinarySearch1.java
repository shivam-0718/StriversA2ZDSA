package in.vyashivam.striversa2zdsa.step4_binary_search.lec2;
/*
    You are given a positive integer n.
    Your task is to find and return its square root.
    If ‘n’ is not a perfect square, then return the floor value of sqrt(n).
*/
public class BinarySearch1 {
    // brute-force solution
    public static int sqrtN (int n) {
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            if (i * i <= n) {
                ans = i;
            } else {
                break;
            }
        }
        return ans;
    }

    // optimal solution - binary search - 1 - using variable to return
    public static int squareRootNumber(int x) {
        long low = 1L, high = x, ans = 1;

        while (low <= high) {
            long mid = (low + high) / 2; // to avoid integer overflow
            long val = mid * mid; // to avoid integer overflow

            if (val <= x) {
                ans = mid;
                low = mid + 1; // that value might be the answer, hence move right for better ans
            } else {
                high = mid - 1; // that can't be the answer, hence move left for the better ans
            }
        }

        return (int) ans;
    }


    // optimal solution - binary search - 2 - using without extra variable
    public static int squareRootX(int x) {
        long low = 1L, high = x;

        while (low <= high) {
            long mid = (low + high) / 2; // to avoid integer overflow
            long val = mid * mid; // to avoid integer overflow

            if (val <= x) {
                low = mid + 1; // that value might be the answer, hence move right for better ans
            } else {
                high = mid - 1; // that can't be the answer, hence move left for the better ans
            }
        }

        return (int) high;  // high moves from right to left, hence high will point to the correct ans.
    }

}
// link: https://www.naukri.com/code360/problems/square-root_893351
//link2: https://leetcode.com/problems/sqrtx/
