package in.vyashivam.striversa2zdsa.step2_sorting.lec1;

public class InsertionSort3 {
    //Insertion sort: Take an element and place it in the correct order
    public static int[] insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;

            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        return arr;
    }
}
