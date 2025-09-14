package in.vyashivam.striversa2zdsa.step2_sorting.lec1;

public class BubbleSort2 {
    //Bubble sort: Pushing maximum to the last by adjacent swaps
    public static int[] bubbleSort(int[] arr) {
        int count = 0;
        for (int i = arr.length - 1; i >= 1; i--) {
            boolean didSwap = false;
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    didSwap = true;
                }
            }
            count++;

            //If the array is sorted already, then we are breaking from the loop
            if(!didSwap) {
                break;
            }
        }
        System.out.println("Number of iterations: " + count);
        return arr;
    }
}
