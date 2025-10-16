package in.vyashivam.striversa2zdsa.step4_binary_search.lec1;

public class BinarySearch11 {
    public static int findKRotation(int []arr){
        int ans = Integer.MAX_VALUE; // stores min value
        int index = -1; // stores index of minimum (rotation count)
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if(arr[low] <= arr[high]) { // if array is already sorted, then element at low will be min
                if (arr[low] < ans) { // update answer and index
                    ans = arr[low];
                    index = low;
                }
                break; // no need to search further
            }

            // if left portion is sorted
            if (arr[low] <= arr[mid]) { // update answer with smaller element
                if (arr[low] < ans) {
                    ans = arr[low];
                    index = low;
                }
                low = mid + 1; // move to right half

            // else if right portion is sorted
            } else {
                if (arr[mid] < ans) { // update answer with smaller element
                    ans = arr[mid];
                    index = mid;
                }
                high = mid - 1; // move to left half
            }
        }
        return index;
    }
}
//link: https://www.naukri.com/code360/problems/rotation_7449070
