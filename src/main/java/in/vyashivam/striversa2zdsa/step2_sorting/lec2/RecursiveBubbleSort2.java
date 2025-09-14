package in.vyashivam.striversa2zdsa.step2_sorting.lec2;

public class RecursiveBubbleSort2 {
    public static int[] recursiveBubbleSort(int[] arr) {
        bubbleSort(arr, arr.length);
        return arr;
    }

    //bubble sort using recursion
    private static void bubbleSort(int[] arr, int length) {
        if (length == 1) {
            return;
        }

        boolean didSwap = false;

        for (int i = 0; i < length - 1; i++) {
            if(arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                didSwap = true;
            }
        }
        if(!didSwap) {
            return;
        }

        bubbleSort(arr, length - 1);
    }
}
