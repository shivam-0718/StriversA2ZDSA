package in.vyashivam.striversa2zdsa.step3_arrays.lec3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
    Given 'N' number of intervals, where each interval contains two integers denoting the boundaries of the interval.
    The task is to merge all the overlapping intervals and return the list of merged intervals sorted in ascending order.
    Two intervals will be considered to be overlapping if the starting integer of one interval is less than or equal to
    the finishing integer of another interval, and greater than or equal to the starting integer of that interval.

    intervals[i][0] = start point of i'th interval
    intervals[i][1] = finish point of i'th interval

*/
public class Arrays7 {
    //brute-force solution
    public static ArrayList<ArrayList<Integer>> mergeIntervals(ArrayList<ArrayList<Integer>> intervals) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // Sort all intervals by start time (and secondarily by end time)
        intervals.sort((a, b) -> {
            for (int i = 0; i < a.size(); i++) {
                if (!a.get(i).equals(b.get(i))) {
                    return a.get(i) - b.get(i);
                }
            }
            return 0;
        });

        int n = intervals.size();

        // Traverse through all intervals
        for (int i = 0; i < n; i++) {
            int start = intervals.get(i).get(0);
            int end = intervals.get(i).get(1);

            // Skip if this interval lies inside the previous merged interval
            if(!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
                continue;
            }

            // Check for overlapping intervals and merge them
            for (int j = i + 1; j < n; j++) {
                // If next interval starts before current end, merge it
                if(intervals.get(j).get(0) <= end) {
                    end = Math.max(end, intervals.get(j).get(1));
                } else {
                    // No more overlaps
                    break;
                }
            }
            // Add the final merged interval to result
            ans.add(new ArrayList<>(Arrays.asList(start, end)));
        }
        return ans;
    }

    //brute-force solution (using arrays and arraylist as the final answer)
    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();

        // Sort intervals by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // Loop through all intervals
        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // Skip if interval already covered
            if(!ans.isEmpty() && end <= ans.get(ans.size() - 1)[1]) {
                continue;
            }

            // Merge overlapping intervals
            for (int j = i+1; j < n; j++) {
                if(intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }

            ans.add(new int[]{start, end});
        }
        // Convert list back to 2D array
        return ans.toArray(new int[ans.size()][]);
    }

    //optimal solution
    public static ArrayList<ArrayList<Integer>> mergeTheIntervals(ArrayList<ArrayList<Integer>> intervals) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // Sort intervals based on start time
        intervals.sort((a, b) -> {
            for (int i = 0; i < a.size(); i++) {
                if(!a.get(i).equals(b.get(i))) {
                    return a.get(i) - b.get(i);
                }
            }
            return 0;
        });

        int n = intervals.size();

        for (int i = 0; i < n; i++) {
            int start = intervals.get(i).get(0);
            int end = intervals.get(i).get(1);

            // If non-overlapping interval → directly add
            if (ans.isEmpty() || start > ans.get(ans.size() - 1).get(1)) {
                ans.add(intervals.get(i));
            } else {
                // Else, overlapping → merge with last one
                int temp = ans.get(ans.size() - 1).get(1);
                ans.get(ans.size() - 1).set(1, Math.max(temp, intervals.get(i).get(1)));
            }
        }
        return ans;
    }

    //optimal solution (using arrays and arraylist as the final answer)
    public static int[][] mergeIntervals(int[][] intervals) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();

        // Sort intervals based on starting point
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // If current interval does not overlap with last → add new
            if(ans.isEmpty() || start > ans.get(ans.size() - 1)[1]) {
                ans.add(new int[]{start, end});
            } else {
                // Else, overlap → update last interval’s end
                int temp = ans.get(ans.size() - 1)[1];
                ans.get(ans.size() - 1)[1] = Math.max(temp, intervals[i][1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
//link1: https://www.naukri.com/code360/problems/merge-overlapping-intervals_1082151
//link2: https://leetcode.com/problems/merge-intervals/description/
