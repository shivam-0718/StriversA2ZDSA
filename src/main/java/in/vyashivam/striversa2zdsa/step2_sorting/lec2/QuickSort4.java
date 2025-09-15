package in.vyashivam.striversa2zdsa.step2_sorting.lec2;

public class QuickSort4 {
    //divide and conquer
    public static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            //finding first element greater than pivot in left side
            while (arr[i] <= pivot && i <= high - 1) {
                i++;
            }

            //finding first element less than pivot in right side
            while (arr[j] > pivot && j >= low + 1) {
                j--;
            }

            //if j moved to the right side of i (or they crossed each other)
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //swapping the pivot with the last element from j after crossing i
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }

}
