import java.util.Arrays;
import java.util.Random;

public class HeapSort {
    public static void main(String[] args) {
        int[] sizes = {8, 16, 32, 64, 128, 256};

        for (int size : sizes) {
            int[] arrayToSort = generateRandomArray(size);
            System.out.println("Original Array: " + Arrays.toString(arrayToSort));

            long startTime = System.nanoTime(); //measures start time
            heapSort(arrayToSort);
            long endTime = System.nanoTime(); //measures end time
            double TimeTaken = (endTime - startTime) / 1e9;  //CPU time // Convert nanoseconds to seconds

            System.out.println("Sorted Array:   " + Arrays.toString(arrayToSort));
            System.out.printf("Array Size: %d   CPU Time: %.6f seconds%n%n", size, TimeTaken);
        }
    }
    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1001); //generates random numbers between 0 and 1000
        }
        return array;
    }
    public static void heapSort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) { //first loop builds a max heap by calling heapify on each non-leaf node.
            heapify(array, array.length, i);
        }

        for (int i = array.length - 1; i > 0; i--) { //second loop extracts the maximum element from the heap and swaps it with the last element, then maintains the max heap property by calling heapify.
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }
    public static void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {  // Check if the left is larger than the root
            largest = left;
        }

        if (right < n && array[right] > array[largest]) { //Check if the right is larger than the current largest
            largest = right;
        }

        if (largest != i) { // Swap the root with the largest element if needed
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapify(array, n, largest);
        }
    }
}
