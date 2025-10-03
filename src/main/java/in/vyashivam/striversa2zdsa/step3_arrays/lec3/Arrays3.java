package in.vyashivam.striversa2zdsa.step3_arrays.lec3;

import java.util.*;

/*
    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
    such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
    Note that the solution set must not contain duplicate triplets.
    Order of the output and the order of the triplets does not matter.
*/

public class Arrays3 {
    //brute-force
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new LinkedHashSet<>(); //for storing unique triplets

        // picking all combinations of triplets
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    List<Integer> innerList = new ArrayList<>(); //storing the three numbers in a list
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        innerList.add(nums[i]);
                        innerList.add(nums[j]);
                        innerList.add(nums[k]);
                        Collections.sort(innerList); //sorting the innerList to handle duplicate triplets
                        set.add(innerList); //adding sorted innerList to set
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set); //putting set into the final ArrayList
        return ans;
    }

    //better solution
    public static List<List<Integer>> threeSumTriplet(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new LinkedHashSet<>(); //for storing unique triplets

        for (int i = 0; i < n; i++) {
            Set<Integer> tempSet = new HashSet<>(); // to track visited number nums[j] for two-sum
            for (int j = i + 1; j < n; j++) {
                int temp = -(nums[i] + nums[j]); //since nums[i] + nums[j] + nums[k] = 0 => nums[k] = - (nums[i] + nums[j])

                // if temp value already in tempSet, we found a triplet
                if (tempSet.contains(temp)) {
                    List<Integer> innerList = new ArrayList<>();
                    innerList.add(nums[i]);
                    innerList.add(nums[j]);
                    innerList.add(temp);
                    Collections.sort(innerList); //sorting the innerList
                    set.add(innerList); //adding unique sorted elements to arrayList
                }
                tempSet.add(nums[j]); //if not found, then put nums[j] into temporary set, and mark current value as seen
            }
        }

        List<List<Integer>> ans = new ArrayList<>(set); //putting set into the final List

        // sort the list of triplets for consistent output
        Collections.sort(ans, Comparator.comparingInt(
                (List<Integer> list) -> list.get(0)).
                thenComparingInt(list -> list.get(1)).
                thenComparingInt(list -> list.get(2)));
        return ans;
    }

    //optimal solution
    public static List<List<Integer>> tripletThreeSum(int[] arr, int n) {
        Arrays.sort(arr); // To handle two-pointer and duplicate skipping
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) { // Fix the first element
            if (i >= 1 && arr[i] == arr[i - 1]) {
                continue;
            }
            int j = i + 1; // left pointer
            int k = n - 1; // right pointer
            int sum = 0;

            // two-pointer search for remaining two elements
            while (j < k) {
                sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) {
                    j++; // need bigger sum → move left pointer
                } else if (sum > 0) {
                    k--; // need smaller sum → move right pointer
                } else {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(arr[i]);
                    tempList.add(arr[j]);
                    tempList.add(arr[k]);
                    ans.add(tempList);
                    j++;
                    k--;

                    // skip duplicates for second element
                    while (j < k && arr[j] == arr[j - 1]) {
                        j++;
                    }

                    // skip duplicates for third element
                    while (j < k && arr[k] == arr[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return ans;
    }
}
//link: https://leetcode.com/problems/3sum/description/
//link2: https://www.naukri.com/code360/problems/three-sum_6922132
