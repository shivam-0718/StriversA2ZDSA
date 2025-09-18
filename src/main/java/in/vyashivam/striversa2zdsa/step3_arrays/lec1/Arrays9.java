package in.vyashivam.striversa2zdsa.step3_arrays.lec1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

//Union and Intersection of 2 sorted arrays.
public class Arrays9 {
    //Union of 2 sorted arrays

    //brute-force approach
    public static int[] unionArray(int[] nums1, int[] nums2) {
        Set<Integer> union = new LinkedHashSet<>();

        //adding elements into set
        for (int i = 0; i < nums1.length; i++) {
            union.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            union.add(nums2[i]);
        }

        //converting from LinkedHashSet to Array and returning it
        return union.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    //optimal approach - 2 pointer
    public static List<Integer> unionSortedArray(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();

        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0, j = 0;

        //comparing nums1[i] with nums2[j]
        while (i < n1 && j < n2) {
            if(nums1[i] <= nums2[j]) {
                //putting nums1[i] into list if not there by comparing it with last inserted element in ans, if there, then skip and increment the i
                if(ans.isEmpty() || ans.get(ans.size() - 1) != nums1[i]) {
                    ans.add(nums1[i]);
                }
                i++;
            } else {
                //putting nums2[j] into list if not there by comparing it with last inserted element in ans, if there, then skip and increment the j
                if(ans.isEmpty() || ans.get(ans.size() - 1) != nums2[j]) {
                    ans.add(nums2[j]);
                }
                j++;
            }
        }

        //if one of array gets exhausted, then putting remaining elements into list as per the same logic above.
        while (i < n1) {
            if(ans.isEmpty() || ans.get(ans.size() - 1) != nums1[i]) {
                ans.add(nums1[i]);
            }
            i++;
        }

        while (j < n2) {
            if(ans.isEmpty() || ans.get(ans.size() - 1) != nums2[j]) {
                ans.add(nums2[j]);
            }
            j++;
        }
        return ans;
    }


    //second half
    //brute-force approach
    public static int[] intersectionArray(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        int[] visit = new int[nums2.length]; // marks whether nums2[j] is already matched
        int n1 = nums1.length, n2 = nums2.length;

        // putting only those elements which are present in both arrays, making sure that other is already used up.
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if(nums1[i] == nums2[j] && visit[j] == 0) {
                    ans.add(nums1[i]); // found common element
                    visit[j] = 1; // mark nums2[j] as used
                    break;
                }
                if (nums2[j] > nums1[i]) {  // works only if arrays are sorted
                    break;
                }
            }
        }

        return ans.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    //optimal approach - 2 pointer
    public static List<Integer> intersectionSortedArray(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();

        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0, j = 0;

        // traverse both arrays until one ends
        while (i < n1 && j < n2) {
            if(nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                ans.add(nums1[i]); // common element found
                i++;
                j++;
            }
        }

        return ans;
    }



}
//link: https://www.naukri.com/code360/problems/sorted-array_6613259
//link2: https://www.naukri.com/code360/problems/intersection-of-2-arrays_1082149
