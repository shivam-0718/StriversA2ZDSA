package in.vyashivam.striversa2zdsa.step3_arrays.lec3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order.
    Merge nums1 and nums2 into a single array sorted in non-decreasing order.

    NOTE: In the follow-up question, we have to make sure that merging must occur without using an external third array.
*/
public class Arrays8 {
    //brute-force solution
    public static void merge2SortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        List<Integer> ansArray = new ArrayList<>();
        int left = 0, //index for nums1 array at the start
                right = 0; //index for nums2 array at the start

        //comparing the elements and adding the elements into the sorted array
        while ((left < m) && (right < n)) {
            if(nums1[left] <= nums2[right]) {
                ansArray.add(nums1[left]);
                left++;
            } else {
                ansArray.add(nums2[right]);
                right++;
            }
        }

        //if second array exhausts, put the remaining elements from the first array in the sorted array.
        while (left < m) {
            ansArray.add(nums1[left]);
            left++;
        }

        //if first array exhausts, put the remaining elements from the first array in the sorted array.
        while (right < n) {
            ansArray.add(nums2[right]);
            right++;
        }

        //putting the first m elements into nums1 array.
        for (int i = 0; i < m; i++) {
            nums1[i] = ansArray.get(i);
        }

        //Finding the current index at the ansArray from which remaining elements will be added in nums2.
        int index = ansArray.size() - m;

        //putting the remaining index - m elements into nums2 array.
        for (int i = 0; i < n; i++) {
            nums2[i] = ansArray.get(index - 1  + i);
        }
    }

    //optimal solution - 1
    public static void mergeTwoSortedArrays(int[] nums1, int[] nums2) {
        int left = nums1.length - 1;
        int right = 0;

        while (left >= 0 && right < nums2.length) {
            if(nums1[left] > nums2[right]) {
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }

    //optimal solution - 2
    public static void mergeTheTwoSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int len = m + n; //length of imaginary one array

        //Initial gap value
        int gap = (len / 2) + (len % 2);

        // Compare and swap across the virtual merged array
        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            while (right < len) {

                //Case 1: left pointer on arr 1 and right pointer on arr 2
                if(left < m && right >= m) {
                    swapElements(nums1, nums2, left, right - m); //(right - m) -> to make the right index in accordance to nums2[]
                }

                //Case 2: both left and right pointer are on arr2
                else if (left >= m) {
                    swapElements(nums2, nums2, left - m, right - m);
                }

                //Case 3: both left and right pointer are on arr1
                else {
                    swapElements(nums1, nums1, left, right);
                }
                left++;
                right++;
            }

            if(gap == 1) {
                break;
            }
            gap = (gap / 2) + (gap % 2);

        }
    }

    private static void swapElements(int[] arr1, int[] arr2, int index1, int index2) {
        if(arr1[index1] > arr2[index2]) {
            int temp = arr1[index1];
            arr1[index1] = arr2[index2];
            arr2[index2] = temp;
        }
    }

}
//link1: https://leetcode.com/problems/merge-sorted-array/
//link2: https://www.naukri.com/code360/problems/ninja-and-sorted-arrays_1214628
