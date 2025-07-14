#include<iostream>
#include <vector>

using namespace std;

class Solution{
public:
    vector<int> selectionSort(vector<int>& arr){
        int n = arr.size();

        for(int i=0; i<n-1; i++){
            int smallestIdx = i;
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[smallestIdx]){
                    smallestIdx = j;
                }
            }

            swap(arr[i], arr[smallestIdx]);
        }

        return arr;
    }
};

int main() {
    Solution sol;

    vector<int> nums = {64, 25, 12, 22, 11};

    cout << "Original array: ";
    for (int num : nums) {
        cout << num << " ";
    }
    cout << endl;

    vector<int> sorted = sol.selectionSort(nums);

    cout << "Sorted array: ";
    for (int num : sorted) {
        cout << num << " ";
    }
    cout << endl;

    return 0;
}