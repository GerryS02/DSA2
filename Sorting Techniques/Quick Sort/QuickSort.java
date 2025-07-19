import java.util.Arrays;

class QuickSort {

    public void quickSort(int[] arr, int lo, int hi) {
        // Base case: if the subarray has 1 or 0 elements, no need to sort
        if (lo >= hi) {
            return;
        }

        // Choose the last element as the pivot
        int pivot = arr[hi];
        
        // Partition the array and get the pivot's correct index
        int pivotIdx = partition(arr, pivot, lo, hi);

        // Recursively sort the left part of the array
        quickSort(arr, lo, pivotIdx - 1);
        
        // Recursively sort the right part of the array
        quickSort(arr, pivotIdx + 1, hi);
    }

    public int partition(int[] arr, int pivot, int lo, int hi) {
        int i = lo; // i tracks the position for elements smaller than the pivot
        int j = lo; // j will track the current element during the iteration

        // Go through each element and compare with the pivot
        while (i <= hi) {
            if (arr[i] > pivot) {
                // If the current element is greater than the pivot, just move i
                i++;
            } else {
                // If the current element is smaller or equal to the pivot, swap it
                swap(arr, i, j);
                i++; // Move i forward
                j++; // Move j forward
            }
        }

        // Return the pivot's final index after partitioning
        return j - 1;
    }

    // Helper function to swap two elements in the array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        QuickSort sol = new QuickSort(); 

        int[] arr = {8, 5, 1, 3, 7, 2, 9, 6};

        sol.quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}
