import java.util.Arrays;

class SelectionSort{
    public int[] selectionSort(int[] arr){
        int n = arr.length;

        for(int i=0; i<n-1; i++){
            int smallestIdx = i;

            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[smallestIdx]){
                    smallestIdx = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[smallestIdx];
            arr[smallestIdx] = temp;
        }

        return arr;
    }

    public static void main(String[] args){
        
        SelectionSort sol = new SelectionSort();

        int[] arr = {64, 25, 12, 22, 11};

        System.out.println("Original Array: "+ Arrays.toString(arr));

        int[] sortedArr = sol.selectionSort(arr);

        System.out.println("Sorted Array: "+ Arrays.toString(sortedArr));    
    }
};

