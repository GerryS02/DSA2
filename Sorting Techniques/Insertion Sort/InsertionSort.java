import java.util.Arrays;

class InsertionSort {
    public int[] insertionSort(int[] arr){
        int n = arr.length;

        for(int i=1; i<n; i++){
            int curr = arr[i];
            int prev = i-1;

            while(prev >= 0 && arr[prev] > curr){
                arr[prev+1] = arr[prev];
                prev--;
            }

            arr[prev+1] = curr;
        }

        return arr;
    }

    public static void main(String[] args){
        InsertionSort sol = new InsertionSort();

        int[] arr = {4,1,5,2,3};

        System.out.println("Original Array: " + Arrays.toString(arr));

        int[] sortedArr = sol.insertionSort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(sortedArr));
    }
}
