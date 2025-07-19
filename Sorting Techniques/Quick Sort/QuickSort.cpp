#include <iostream>
#include <vector>

using namespace std;

class Solution{
public:
    void quickSort(vector<int>& arr, int lo, int hi){
        if( lo >= hi) return;

        int pivot = arr[hi];
        int pivotIdx = partition(arr, pivot, lo, hi);

        quickSort(arr, lo, pivotIdx -1);
        quickSort(arr, pivotIdx +1, hi);
    }

    int partition(vector<int>& arr, int pivot, int lo, int hi){
        int i = lo, j = lo;

        while(i <= hi){
            if(arr[i] > pivot){
                i++;
            } else{
                swap(arr, i, j);
                i++;
                j++;
            }
        }

        return j-1;
    }

    void swap(vector<int>& arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

};

int main(){
    Solution sol;

    vector<int> arr = {8, 5, 1, 3, 7, 2, 9, 6};

    sol.quickSort(arr, 0, arr.size()-1);

    for (int i = 0; i < arr.size(); ++i) {
        cout << arr[i] << ", ";
    }
    cout << endl;
}