import java.util.Arrays;

public class HeapSort2 {
    public static void main(String[] args) {
        // Define input arrays
        int[] input1 = {14, 99, 18, 67, 6, 5, 4, 3, 2, 1};
        int[] input2 = {1, 23, 3, 450, 5, 6, 7, 8, 9, 10};
        int[] input3 = {12, 33, 5, 77, 999, 1000, 8, 6, 4, 2};

        // Display original and sorted arrays for each input
        System.out.println("Original Array 1: " + Arrays.toString(input1));
        heapSort(input1);
        System.out.println("Sorted Array 1:   " + Arrays.toString(input1));
        System.out.println();

        System.out.println("Original Array 2: " + Arrays.toString(input2));
        heapSort(input2);
        System.out.println("Sorted Array 2:   " + Arrays.toString(input2));
        System.out.println();

        System.out.println("Original Array 3: " + Arrays.toString(input3));
        heapSort(input3);
        System.out.println("Sorted Array 3:   " + Arrays.toString(input3));
    }

    // Heap-Sort algorithm
    public static void heapSort(int[] array) {
        // Build a max heap
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }

        // Extract elements from the heap and maintain the max heap property
        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    // Heapify a subtree rooted at node i
    public static void heapify(int[] array, int n, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Find the largest among root, left child, and right child
        int largest = i;
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // If the largest is not the root, swap and recursively heapify the affected subtree
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapify(array, n, largest);
        }
    }
}
