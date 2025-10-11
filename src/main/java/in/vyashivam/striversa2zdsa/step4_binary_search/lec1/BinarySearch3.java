package in.vyashivam.striversa2zdsa.step4_binary_search.lec1;

/*
    You are given an array 'arr' sorted in non-decreasing order and a number 'x'.
    You must return the index of the upper bound of 'x'.

    Upper bound is the smallest index i in the array such that arr[i] > x
*/
public class BinarySearch3 {
    public static int upperBound(int []arr, int n, int x) {
        int ans = n; // default: if no element > x, return end index (n)
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2; // finding the mid-index
            if(arr[mid] > x) {
                ans = mid; // potential lower bound found
                high = mid - 1; // Moving to the left half to check if a smaller index also satisfies
            } else {
                low = mid + 1; // Otherwise, move to the right half if above condition is false.
            }
        }
        return ans;
    }
}
//link: https://www.naukri.com/code360/problems/implement-upper-bound_8165383
