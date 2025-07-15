import java.util.Arrays;

public class MergeSort {
    public int[] mergeSort(int[] arr, int st, int ed){
         if (st == ed) {
            return new int[] {arr[st]};  // Base case: an array of size 1 is already sorted
        }
        
        int mid = st + (ed - st)/2;

        int[] left = mergeSort(arr, st, mid);
        int[] right = mergeSort(arr, mid+1, ed);

        int[] res = mergeArray(left, right);

        return res;
    }

    public int[] mergeArray(int[] arr1, int[] arr2){
        int[] res = new int[arr1.length + arr2.length];
        
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < arr1.length && j < arr2.length){
            if(arr1[i] <= arr2[j]){
                res[k] = arr1[i];
                i++;
                k++;
            } else{
                res[k] = arr2[j];
                j++;
                k++;
            }
        }

        while(i < arr1.length){
            res[k] = arr1[i];
            i++;
            k++;
        }

        while(j < arr2.length){
            res[k] = arr2[j];
            j++;
            k++;
        }

        return res;
    }

    public static void main(String[] args){
        MergeSort sol = new MergeSort();

        int[] arr = {5,1,4,4,1};
        int st = 0;
        int ed = 4;

        int[] sortedArr = sol.mergeSort(arr, st, ed);

        System.out.println(Arrays.toString(sortedArr));
    }
}
