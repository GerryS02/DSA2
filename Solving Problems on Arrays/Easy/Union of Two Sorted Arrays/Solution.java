import java.util.Arrays;

public class Solution {
    public int[] unionArray(int[] arr1, int[] arr2){
        int[] ans = new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i<arr1.length && j<arr2.length){
            if(arr1[i] <= arr2[j]){
                if(k==0 || ans[k-1] != arr1[i]){
                    ans[k++] = arr1[i];
                }
                i++;
            } else{
                if(k==0 || ans[k-1] != arr2[j]){
                    ans[k++] = arr2[j];
                }
                j++;
            }
        }

        while(i<arr1.length){
            if(k==0 || ans[k-1] != arr1[i]){
                ans[k++] = arr1[i];
            }
            i++;
        }

        while(j<arr2.length){
            if(k==0 || ans[k-1] != arr2[j]){
                ans[k++] = arr2[j];
            }
            j++;
        }

        return Arrays.copyOf(ans, k); // Trim the array to the actual size
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {1, 2, 4, 5, 6};
        int[] arr2 = {2, 3, 5, 7};

        int[] union = sol.unionArray(arr1, arr2);

        System.out.println("Union of arrays: " + Arrays.toString(union));
    }
};
