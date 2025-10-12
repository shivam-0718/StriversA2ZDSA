package in.vyashivam.striversa2zdsa.step4_binary_search.lec1;
/*
    You are given a sorted array arr of distinct values and a target value x.
    You need to search for the index of the target value in the array.

    If the value is present in the array, then return its index.
    Otherwise, determine the index where it would be inserted in the array while maintaining the sorted order.
 */
public class BinarySearch4 {
    //Binary Search method
    public static int searchInsert(int [] arr, int m) {
        int ans = arr.length;
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= m) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
//link: https://www.naukri.com/code360/problems/algorithm-to-find-best-insert-position-in-sorted-array_839813
//link2: https://leetcode.com/problems/search-insert-position/description/
