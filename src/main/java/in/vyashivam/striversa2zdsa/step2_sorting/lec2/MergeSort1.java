package in.vyashivam.striversa2zdsa.step2_sorting.lec2;

import java.util.ArrayList;
import java.util.List;

public class MergeSort1 {
    //Divide and Merge
    public static void mergeSort(int [] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid); //Left half
        mergeSort(arr, mid+1, high); //Right half
        merge(arr, low, mid, high); //Merging both sorted halves
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low; //starting index of left half of array
        int right = mid + 1; //starting index of right half of array

        //storing elements in the temporary array in a sorted manner
        while ((left <= mid) && (right <= high)) {
            if(arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        //if elements in the left half of array are still there
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //if elements in the right half of array are still there
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        //storing the elements from the array list into the original array in sorted order.
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
     }
}
