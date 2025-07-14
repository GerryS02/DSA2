#include<iostream>
#include <vector>

using namespace std;

class Solution{
public: 
    vector<int> insertionSort(vector<int>& arr){
        int n = arr.size();

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
};

int main(){
    Solution sol;

    vector<int> arr = {4,1,5,2,3};

    cout << "Original array: ";
    for (int num : arr) {
        cout << num << " ";
    }
    cout << endl;

    vector<int> sortedArr = sol.insertionSort(arr);

    cout << "Sorted array:   ";
    for (int num : sortedArr) {
        cout << num << " ";
    }
    cout << endl;

    return 0;
}