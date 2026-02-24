#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int candy(vector<int>& ratings) {
        int candies = 1;
        int i = 0;
        int n = ratings.size();

        while(i<n){
            if(ratings[i] == ratings[i-1]){
                candies++;

                i++;
            }

            int peak = 1;

            while(i<n && ratings[i] > ratings[i-1]){
                peak++;
                candies += peak;

                i++;
            }

            int down = 1;

            while(i<n && ratings[i] < ratings[i-1]){
                candies += down;
                down++;

                i++;
            }

            if(down > peak) candies += down - peak;
        }

        return candies;
    }
};