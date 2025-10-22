package in.vyashivam.striversa2zdsa.step4_binary_search.lec2;
/*
    Given two numbers N and M, find the Nth root of M.
    The nth root of a number M is defined as a number X when raised to the power N equals M.
    If the nth root is not an integer, return -1.
*/
public class BinarySearch2 {
    // brute-force solution
    public static int NthRootOfM(int N, int M) {
        long ans = 1; // to avoid integer overflow
        int nthRoot = 1;
        for (int i = 1; i <= M; i++) { // Traversing from 1 to M (it will barely reach M)
            ans = (long) Math.pow(i, N);
            if (ans == M) {
                nthRoot = i; // found the Nth Root
                break;
            } else if (ans > M) {
                nthRoot = -1; // It surely means, anything nth power of i will not be the ans. Hence, break.
                break;
            }
        }
        return nthRoot;
    }

    // optimal solution - Binary Search Method
    public static int NthRoot (int N, int M) {
        int nthRoot = -1, low = 1, high = M;
        while (low <= high) {
            long mid = (low + high) / 2; // to avoid integer overflow
            long ans = (long) Math.pow(mid, N);
            if (ans == M) {
                nthRoot = (int) mid; // mid is the nth Root of M and leave the loop
                break;
            } else if (ans < M) {
                low = (int) (mid + 1); // move the low to the right side for larger answer
            } else {
                high = (int) (mid - 1); // move the high to the left side for smaller answer
            }
        }
        return nthRoot;
    }
}
//link: https://www.naukri.com/code360/problems/nth-root-of-m_1062679
