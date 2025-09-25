package in.vyashivam.striversa2zdsa.step3_arrays.lec2;

//Finding next permutation of a given array
//NOTE: Learn the concept of calculating the permutations of a given array before attempting this question. Refer ArraysC1

import java.util.ArrayList;
import java.util.List;

public class Arrays8 {
    //brute-force solution : NOT recommended as Time Complexity is too large
    public static List<Integer> nextGreaterPermutation(int[] A) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> permutations = permutation(A);

        // Sort permutations in lexicographical order
        permutations.sort((a, b) -> {
            for (int i = 0; i < a.size(); i++) {
                if (!a.get(i).equals(b.get(i))) {
                    return a.get(i) - b.get(i);
                }
            }
            return 0;
        });

        // Convert input array to a list for comparison
        List<Integer> current = new ArrayList<>();
        for (int num : A) {
            current.add(num);
        }

        // Find the next permutation
        for (int i = 0; i < permutations.size(); i++) {
            if (permutations.get(i).equals(current)) {
                // If last permutation, wrap around to the first
                if (i == permutations.size() - 1) {
                    return permutations.get(0);
                } else {
                    return permutations.get(i + 1);
                }
            }
        }

        return current; // fallback (should not happen)
    }

    private static List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recursivePermutation(0, nums, ans); // start from index 0
        return ans;
    }

    private static void recursivePermutation(int index, int[] nums, List<List<Integer>> ans) {
        // Base case: if index reaches end of array
        if(index == nums.length) {
            // add nums elements to ds and add ds to ans
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums); // Swap current index with i
            recursivePermutation(index+1, nums, ans); // Recurse for next index
            swap(i, index, nums); // Backtrack: swap back
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    //optimal solution
    public static List<Integer> nextGreaterPermutation(List<Integer> A) {
        int index = -1;
        int n = A.size();

        // Step 1: Find the break point in the array. This helps identify where the "descending" sequence starts.
        // Breakpoint = first index from the right where A[i] < A[i+1]
        for (int i = n - 2; i >= 0; i--) {
            if(A.get(i) < A.get(i+1)) {
                index = i;
                break;
            }
        }

        //Step 2: If no breakpoint, this means that it is the last permutation.
        // Then return the first permutation in the array, which can be done by reversing the entire array.
        if(index == -1) {
            int i = 0, j = A.size() - 1;
            while (i < j) {
                int temp = A.get(i);
                A.set(i, A.get(j));
                A.set(j, temp);
                i++;
                j--;
            }
            return A;
        }

        //Step 3: Find the element from the subarray part after breakpoint, which is slightly greater than nums[index]
        for (int i = n - 1; i > index ; i--) {
            if(A.get(i) > A.get(index)) {
                int temp = A.get(i);
                A.set(i, A.get(index));
                A.set(index, temp);
                break;
            }

        }

        // Step 4: Reverse the suffix (right side of index)
        // This ensures the sequence after index is the smallest possible (sorted in ascending order).
        int i = index+1, j = A.size() - 1;
        while (i < j) {
            int temp = A.get(i);
            A.set(i, A.get(j));
            A.set(j, temp);
            i++;
            j--;
        }
        return A;
    }
}
//link: https://leetcode.com/problems/next-permutation/description/


