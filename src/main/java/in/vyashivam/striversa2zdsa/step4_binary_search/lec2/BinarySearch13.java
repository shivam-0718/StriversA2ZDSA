package in.vyashivam.striversa2zdsa.step4_binary_search.lec2;

import java.util.ArrayList;

/*
    Given two sorted arrays arr1 and arr2 of size m and n respectively, return the median of the two sorted arrays.
    The median is defined as the middle value of a sorted list of numbers.
    In case the length of the list is even, the median is the average of the two middle elements.
*/
public class BinarySearch13 {
    //Brute-force solution
    public static double findMedian(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int n1 = nums1.length, n2 = nums2.length;
        int n = n1 + n2;
        double median = 0;
        ArrayList<Integer> list = new ArrayList<>();

        //Merging both sorted arrays into single array
        while(i < n1 && j < n2) {
            if(nums1[i] < nums2[j]) {
                list.add(nums1[i]);
                i++;
            } else {
                list.add(nums2[j]);
                j++;
            }
        }

        // Add remaining elements from nums1 (if any)
        while(i < n1) {
            list.add(nums1[i]);
            i++;
        }

        // Add remaining elements from nums2 (if any)
        while(j < n2) {
            list.add(nums2[j]);
            j++;
        }

        // Compute median based on total length
        if(n % 2 == 0) {
            median = (list.get(n / 2) + list.get((n / 2) - 1)) / 2.0;
        } else {
            median = list.get(n / 2);
        }

        return median;
    }

    //Better solution
    public static double median(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int n = n1 + n2;
        double median = 0;
        int i = 0, j = 0;
        int count = 0;
        int index2 = n / 2; // second middle element
        int index1 = (n / 2) - 1; // first middle element (only used when n is even)
        int index1ele = Integer.MIN_VALUE;
        int index2ele = Integer.MIN_VALUE;

        //Iterate like merge, but count will be there to point elements just like combined array(imaginary)
        while(i < n1 && j < n2) {
            if(nums1[i] < nums2[j]) {
                if(count == index1)
                    index1ele = nums1[i];
                if(count == index2)
                    index2ele = nums1[i];
                count++;
                i++;
            } else {
                if(count == index1)
                    index1ele = nums2[j];
                if(count == index2)
                    index2ele = nums2[j];
                count++;
                j++;
            }
        }

        while(i < n1) {
            if(count == index1)
                index1ele = nums1[i];
            if(count == index2)
                index2ele = nums1[i];
            count++;
            i++;
        }

        while(j < n2) {
            if(count == index1)
                index1ele = nums2[j];
            if(count == index2)
                index2ele = nums2[j];
            count++;
            j++;
        }

        if(n % 2 == 1) { // If total elements odd -> middle element is index2
            median = index2ele;
        } else { // If even -> median is average of two middle elements
            median = (index1ele + index2ele) / 2.0;
        }

        return median;
    }

    //Optimal solution
    public static double medianOfTwoSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if(n1 > n2) {
            return medianOfTwoSortedArrays(nums2, nums1); // Make sure array nums1 is the smaller one to minimize binary search range
        }
        int n = n1 + n2;
        int low = 0, high = n1;
        int left = (n1 + n2 + 1) / 2;
        double median = 0.0;

        // Binary search on the smaller array
        while(low <= high) {
            // Calculate mid-points for both arrays
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;

            // Get values to the left and right of the partition
            // Use Integer.MIN_VALUE and MAX_VALUE to handle edge cases
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            // Sometimes it might happen that mid1 or mid2 might point to the index existing out of bounds,
            // hence condition has been put to validate before assigning l1, l2, r1 and r2
            if(mid1 < n1) { //if mid1 is inside n1, then r1 exists
                r1 = nums1[mid1];
            }
            if(mid2 < n2) { //if mid2 is inside n2, then r2 exists
                r2 = nums2[mid2];
            }

            if(mid1 - 1 >= 0) { //if there is an element to the left of mid1, then l1 exists
                l1 = nums1[mid1 - 1];
            }

            if(mid2 - 1 >= 0) { //if there is an element to the left of mid2, then l2 exists
                l2 = nums2[mid2 - 1];
            }

            // If partition is valid
            if(l1 <= r2 && l2 <= r1) {
                if(n % 2 == 0) { // If total elements are even
                    median = (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                    break;
                } else { // Odd total elements => max of left parts
                    median = Math.max(l1, l2);
                    break;
                }
            } else if(l1 > r2) { // Move left in array nums1
                high = mid1 - 1;
            } else { // Move right in array nums1
                low = mid1 + 1;
            }
        }
        return median;
    }
}
//link: https://leetcode.com/problems/median-of-two-sorted-arrays/description/
//link2: https://www.naukri.com/code360/problems/median-of-two-sorted-arrays_985294
