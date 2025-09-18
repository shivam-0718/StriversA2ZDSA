package in.vyashivam.striversa2zdsa.step3_arrays.lec1;

//linear search in array
public class Arrays8 {
    public static int linearSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                return i;
        }
        return -1;
    }
}
//link: https://www.naukri.com/code360/problems/linear-search_624470
