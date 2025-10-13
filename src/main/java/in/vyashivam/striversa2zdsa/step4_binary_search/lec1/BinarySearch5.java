package in.vyashivam.striversa2zdsa.step4_binary_search.lec1;

/*
    You're given a sorted array arr of n integers and an integer x. Find the floor and ceiling of x in arr[0 .... n-1].

    The floor of x is the largest element in the array at a particular index such that arr[index] <= x
    The ceiling of x is the smallest element in the array at a particular index such that arr[index] >= x.
*/
public class BinarySearch5 {
    // returns floor and ceil of x in an array
    public static int[] getFloorAndCeil(int[] a, int n, int x) {
        int ceil = ceilValue(a, n, x); // find ceil using binary search
        int floor = floorValue(a, n, x); // find floor using binary search
        return new int[]{floor, ceil};
    }

    // by careful observation, it looks fully like lower-bound problem
    // ceil -> the smallest element in the array such that arr[index] >= x
    private static int ceilValue (int[] arr, int n, int x) {
        int ans = -1; // default if no ceil exists
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2; // find mid index
            if(arr[mid] >= x) {
                ans = arr[mid]; // possible ceil found
                high = mid - 1; // check left half for smaller valid ceil
            } else {
                low = mid + 1; // move right if arr[mid] < x
            }
        }
        return ans; // return smallest element >= x
    }

    // ceil -> the largest element in the array such that arr[index] >= x
    private static int floorValue(int[] arr, int n, int x) {
        int ans = -1; // default if no floor exists
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2; // find mid index
            if(arr[mid] <= x) {
                ans = arr[mid]; // possible floor found
                low = mid + 1; // check right half for larger valid floor
            } else {
                high = mid - 1; // move left if arr[mid] > x
            }
        }
        return ans; // return largest element <= x
    }
}
//link: https://www.naukri.com/code360/problems/ceiling-in-a-sorted-array_1825401

