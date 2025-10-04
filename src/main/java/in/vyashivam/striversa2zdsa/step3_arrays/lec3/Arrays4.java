package in.vyashivam.striversa2zdsa.step3_arrays.lec3;

import java.util.*;

/*
    Given an integer array nums, return all the quadruples [nums[i], nums[j], nums[k], nums[l]]
    such that i != j != k != l, and nums[i] + nums[j] + nums[k] + nums[l] == target.
    Note that the solution set must not contain duplicate quadruples.
    Order of the output and the order of the quadruples does not matter.
*/
public class Arrays4 {

    //brute-force solution
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> setList = new LinkedHashSet<>(); //for storing unique quadruples
        int sum = 0;

        // picking all combinations of quadruples
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        sum = nums[i] + nums[j] + nums[k] + nums[l];
                        if(sum == target) {
                            List<Integer> tempList = Arrays.asList(nums[i], nums[j], nums[k], nums[l]); //storing the four numbers in a list
                            Collections.sort(tempList); //sorting the innerList to handle duplicate triplets
                            setList.add(tempList); //adding sorted innerList to set
                        }
                    }
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>(setList); //putting set into the final ArrayList
        return ans;
    }

    //better solution
    public static List<List<Integer>> fourSumQuadruple(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> setList = new LinkedHashSet<>(); //for storing unique quadruples
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Integer> tempSet = new HashSet<>(); // to track visited number nums[k] for three-sum
                for (int k = j + 1; k < n; k++) {
                    int temp = target - (nums[i] + nums[j] + nums[k]); //since nums[i] + nums[j] + nums[k] + nums[l] = target => nums[l] = target - (nums[i] + nums[j] + nums[k])

                    // if temp value already in tempSet, we found a quadruple
                    if(tempSet.contains(temp)) {
                        List<Integer> innerList = Arrays.asList(nums[i], nums[j], nums[k], temp); //storing the four numbers in a list
                        Collections.sort(innerList); //sorting the innerList to handle duplicate quadruples
                        setList.add(innerList); //adding sorted innerList to set
                    }
                    tempSet.add(nums[k]); //if not found, then put nums[k] into temporary set, and mark current value as seen
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>(setList); //putting set into the final ArrayList

        //sorting the list in lexicographical order -> Optional step depending upon the question, if they ask for returning the list in sorted fashion.
        Collections.sort(ans, Comparator.comparingInt(
                (List<Integer> list) -> list.get(0))
                .thenComparingInt(list -> list.get(1))
                .thenComparingInt(list -> list.get(2))
                .thenComparingInt(list -> list.get(3)));

        return ans;
    }

    //optimal solution
    public static List<List<Integer>> quadrupleFourSum(int[] nums, int target) {
        Arrays.sort(nums); // To handle three-pointer and duplicate skipping
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) { // Fix the first element
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n; j++) { // Fix the second element
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int k = j + 1; // left pointer
                int l = n - 1; // right pointer

                // two-pointer search for remaining two elements
                while (k < l) {
                    long sum = nums[i] + nums[j] + nums[k] + nums[l];

                    if(sum < target) {
                        k++; // need bigger sum → move left pointer
                    } else if (sum > target) {
                        l--; // need smaller sum → move right pointer
                    } else {
                        List<Integer> tempList = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        ans.add(tempList);
                        k++;
                        l--;

                        // skip duplicates for third element
                        while (k < l && nums[k] == nums[k-1]) {
                            k++;
                        }

                        // skip duplicates for fourth element
                        while (k < l && nums[l] == nums[l+1]) {
                            l--;
                        }
                    }
                }
            }
        }
        return ans;
    }

}
//link: https://leetcode.com/problems/4sum/description/
//link2: https://www.naukri.com/code360/problems/4sum_5713771
