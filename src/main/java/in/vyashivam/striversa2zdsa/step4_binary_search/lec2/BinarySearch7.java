package in.vyashivam.striversa2zdsa.step4_binary_search.lec2;
/*
    You are given a strictly increasing array ‘arr’ and a positive integer 'k'.
    Find the 'kth' positive integer missing from 'arr'.
*/
public class BinarySearch7 {
    // brute-force solution
    public int findKthPositiveNo(int[] arr, int k) {
        /*
            Iterate through each element in arr.
            For every number <= k, it means one smaller missing number is "skipped", so increment k.
            Stop when arr[i] > k, because k now points to the missing number.
         */
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= k) {
                k++; // If arr[i] exists, missing number shifts further
            } else {
                break; // Stop once we cross 'k'
            }
        }
        return k; // Return the final kth missing number
    }

    // optimal solution - Binary search - Refer to Video for explanation and dry run of the code
    public static int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            int missingNos = arr[mid] - (mid + 1); // Count of missing numbers until arr[mid]

            if(missingNos < k) {
                low = mid + 1; // Not enough missing numbers yet -> search right side
            } else {
                high = mid - 1; // Already enough missing numbers -> search left side
            }
        }

        return k + low; // Because low represents how many actual elements are ≤ the position, and this will be the kth missing number
    }

}
//link: https://leetcode.com/problems/kth-missing-positive-number/description/
//link2: https://www.naukri.com/code360/problems/kth-missing-element_893215
