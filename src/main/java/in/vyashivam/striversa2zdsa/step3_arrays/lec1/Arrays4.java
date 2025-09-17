package in.vyashivam.striversa2zdsa.step3_arrays.lec1;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

//Removing duplicates from an array
public class Arrays4 {
    //brute-force solution
    public static int removeDuplicates(int[] nums) {
        //Adding array elements into set
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        //mapping unique elements of set into the current array
        int index = 0;
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            nums[index] = it.next();
            index++;
        }

        return index;
    }

    //optimal solution - 2 pointer approach
    public static int removeDuplicateElements(int[] arr) {
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if(arr[j] != arr[i]) {
                arr[i+1] = arr[j];
                i++;
            }
        }
        return i+1;
    }
}
//link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
//link2: https://www.naukri.com/code360/problems/remove-duplicates-from-sorted-array_1102307
