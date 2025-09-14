package in.vyashivam.striversa2zdsa.step2_sorting.lec2;

public class RecursiveInsertionSort3 {
    public static int[] recursiveInsertionSort(int[] arr) {
        insertionSort(arr, 0);
        return arr;
    }

    private static void insertionSort(int[] arr, int length) {
        if(length == arr.length) {
            return;
        }
        int j = length;
        while (j > 0 && arr[j-1] > arr[j]){
            int temp = arr[j-1];
            arr[j-1] = arr[j];
            arr[j] = temp;
            j--;
        }

        insertionSort(arr, length+1);

    }
}
