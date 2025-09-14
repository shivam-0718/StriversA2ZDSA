package in.vyashivam.striversa2zdsa.step1_basics.lec6;

import java.util.ArrayList;
import java.util.List;

public class Hashing2 {
    public static List<List<Integer>> countFrequencies(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        //pre-computation
        int[] freqArray = new int[10000];
        for (int i = 0; i < nums.length; i++) {
            freqArray[nums[i]] += 1;
        }

        //adding list into bigger list
        for(int i = 0; i < freqArray.length; i++) {
            List<Integer> innerList = new ArrayList<>();
            if(freqArray[i] < 1) {
                continue;
            }
            innerList.add(i);
            innerList.add(freqArray[i]);
            ans.add(innerList);
        }

        return ans;
    }
}

