package in.vyashivam.striversa2zdsa.step3_arrays.lec3;

import java.util.HashMap;
import java.util.Map;

//Count the number of subarrays out of the array with given xor of K
// (Analogous to "Count subarrays with sum K" but using XOR properties)
public class Arrays6 {
    //Brute-force solution
    public static int subarraysWithXorK(int[] nums, int ans) {
        int n = nums.length;
        int count = 0;

        // Generate all possible subarrays and compute XOR for each.
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int xor = 0;
                for (int k = i; k <= j; k++) {
                    xor ^= nums[k];
                }
                if(xor == ans) {
                    count++;
                }
            }
        }
        return count;
    }

    //Better solution
    public static int subarraysHavingXorK(int[] nums, int ans) {
        int n = nums.length;
        int count = 0;

        // For each starting index, keep a running XOR for subarrays ending at j.
        for (int i = 0; i < n; i++) {
            int xor = 0;
            for (int j = i; j < n; j++) {
                xor ^= nums[j];
                if(xor == ans) {
                    count++;
                }
            }
        }
        return count;
    }

    //Optimal solution - Hashing
    public static int subarraysWithXorEqualsK (int[] nums, int ans) {
        int n = nums.length;
        int xor = 0, count = 0;
        Map<Integer, Integer> preXorMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            xor ^= nums[i]; // prefix XOR up to index i

            //Case 1: If prefix xor of subarray is ans, then increase count
            if(xor == ans) {
                count++;
            }

            // Case 2: Check if there exists a prefix XOR such that xor ^ prevXor = ans
            int rem = xor ^ ans;

            // Add all occurrences of such prefix XORs
            if(preXorMap.containsKey(rem)) {
                count += preXorMap.get(rem);
            }

            // Update current prefix XOR frequency in the map
            if(preXorMap.containsKey(xor)) {
                int currentCount = preXorMap.get(xor);
                preXorMap.put(xor, ++currentCount);
            }

            //put the xor in the map if xor does not exist.
            if (!preXorMap.containsKey(xor)){
                preXorMap.put(xor, 1);
            }
        }
        return count;
    }
}
//link: https://www.naukri.com/code360/problems/subarrays-with-xor-k_6826258
//link2: https://leetcode.com/problems/sum-of-all-subset-xor-totals/description/ (Similar kind of problem in LeetCode)
