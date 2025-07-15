#include<iostream>
#include <vector>

using namespace std;

class Solution{
public:
    vector<int> mergeSort(vector<int>& arr, int st, int ed){
        // Base case: an array of size 1 is already sorted
        if(st == ed){
            return {arr[st]};
        }

        int mid = st + (ed-st)/2;

        vector<int> left = mergeSort(arr, st, mid); //recursively solve the left part
        vector<int> right = mergeSort(arr, mid+1, ed); //recursively solve the right part

        return mergeArray(left, right); //merge the sorted left and right parts
    }

    vector<int> mergeArray(const vector<int>& arr1, const vector<int>& arr2){
        vector<int> res(arr1.size() + arr2.size());

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < arr1.size() && j < arr2.size()){
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

        // Handle remaining elements of arr1
        while(i < arr1.size()){
            res[k] = arr1[i];
            i++;
            k++;
        }

        // Handle remaining elements of arr2
        while(j < arr2.size()){
            res[k] = arr2[j];
            j++;
            k++;
        }

        return res;
    }
};

int main(){
    Solution sol;

    vector<int> arr = {5, 1, 4, 4, 1};
    int st = 0;
    int ed = arr.size() - 1;  // Adjust the end index to the last element in the array

    vector<int> sortedArr = sol.mergeSort(arr, st, ed);

    // Output the sorted array
    for (int i : sortedArr) {
        cout << i << ", ";
    }

    return 0;
}