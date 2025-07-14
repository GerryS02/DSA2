#include <iostream>
#include <vector>

using namespace std;

class Solution{
public:
    vector<int> bubbleSort(vector<int>& arr){
        int n = arr.size();

        for(int i=0; i<n-1; i++){
            bool isSwap = false;

            for(int j=0; j<n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr[j], arr[j+1]);
                    isSwap = true;
                }
            }

            if(!isSwap){
                break;
            }
        }

        return arr;
    }
};

int main(){
    Solution sol;

    vector<int> arr = {64, 34, 25, 12, 22, 11, 90};

    cout << "Original array: ";
    for (int num : arr) {
        cout << num << " ";
    }
    cout << endl;

    vector<int> sortedArr = sol.bubbleSort(arr);

    cout << "Sorted array:   ";
    for (int num : sortedArr) {
        cout << num << " ";
    }
    cout << endl;

    return 0;
}