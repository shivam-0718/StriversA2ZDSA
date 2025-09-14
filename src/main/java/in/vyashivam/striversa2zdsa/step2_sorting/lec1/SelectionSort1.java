package in.vyashivam.striversa2zdsa.step2_sorting.lec1;

public class SelectionSort1 {
    //Selection sort: Select minimum and swap
    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i <= arr.length - 2; i++) {
            int min = i;
            for (int j = i; j <= arr.length - 1; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
