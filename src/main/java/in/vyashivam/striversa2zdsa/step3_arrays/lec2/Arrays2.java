package in.vyashivam.striversa2zdsa.step3_arrays.lec2;

import java.util.ArrayList;
import java.util.List;

//Sorting an array containing 0s, 1s and 2s
public class Arrays2 {
    //brute-force solution
    public static void sortZeroOneTwo(int[] nums) {
        //Using merge sort to sort the array
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        sort(nums, low, mid);
        sort(nums, mid+1, high);
        merge(nums, low, mid, high);
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        List<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if(nums[left] <= nums[right]) {
                list.add(nums[left]);
                left++;
            } else {
                list.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
            list.add(nums[left]);
            left++;
        }

        while (right <= high) {
            list.add(nums[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            nums[i] = list.get(i - low);
        }
    }

    //better solution - having count variables for 0, 1, and 2
    public static void sortArrayZeroOneTwo(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
            } else if (nums[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        for (int i = 0; i < count0; i++) {
            nums[i] = 0;
        }

        for (int i = count0; i < (count0 + count1); i++) {
            nums[i] = 1;
        }

        for (int i = (count0 + count1); i < nums.length; i++) {
            nums[i] = 2;
        }
    }

    //Optimal solution - Dutch National Flag Algorithm
    public static void sortArray(ArrayList<Integer> arr, int n) {
        //3 - pointers used for DNF Algorithm.
        // low -> boundary for 0s, mid -> current element, high -> boundary for 2s
        // Refer the DNF Algorithm for understanding the thought process of this.
        int low = 0, mid = 0, high = n - 1;

        while (mid <= high) {
            if (arr.get(mid) == 0) {
                // Swap 0 to the front (low position)
                int temp = arr.get(low);
                arr.set(low, arr.get(mid));
                arr.set(mid, temp);
                low++;
                mid++;
            }

            // 1 is already in the middle, just move mid
            else if (arr.get(mid) == 1) {
                mid++;
            }

            else {
                // Swap 2 to the end (high position)
                int temp = arr.get(mid);
                arr.set(mid, arr.get(high));
                arr.set(high, temp);
                high--;
            }
        }
    }

}
//link: https://leetcode.com/problems/sort-colors/submissions/1777790276/
//link2: https://www.naukri.com/code360/problems/sort-an-array-of-0s-1s-and-2s_892977
