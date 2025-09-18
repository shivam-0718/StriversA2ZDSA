package in.vyashivam.striversa2zdsa.step3_arrays.lec1;

import java.util.ArrayList;
import java.util.List;

//Moving zeros to the end of array
public class Arrays7 {
    //brute-force approach
    public static void moveZeroes(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();

        //take an arraylist and add the elements in arrayList without zero
        int zeroCount = 0;
        List<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            if (num != 0) {
                temp.add(num);
            } else {
                zeroCount++;
            }
        }

        //put the elements from the arrayList to the array
        for (int i = 0; i < temp.size(); i++) {
            nums[i] = temp.get(i);
        }


        //zeros = array.length - arrayList.length, accordingly put the zeros
        for (int i = nums.length - zeroCount; i < nums.length; i++) {
            nums[i] = 0;
        }

        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    //Optimal solution - 2 pointer approach
    public static void moveZeroesRight(int[] nums) {
        int j = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        if (j == -1)
            return;

        for (int i = j + 1; i < n; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}
//link: https://www.naukri.com/code360/problems/ninja-and-the-zero-s_6581958
//link2: https://leetcode.com/problems/move-zeroes/description/
