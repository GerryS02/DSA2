#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution{
public:
    //comparator function to sort items
    static bool compare(pair<long long, long long>& a, pair<long long, long long>& b){
        //calculate value per unit weight for both items
        double r1 = (double) a.first/a.second;
        double r2 = (double) b.first/b.second;

        return r1>r2;   //return true if item 'a' should come before item 'b'
    }

    double fractionalKnapsack(vector<long long>& val, vector<long long>& wt, long long capacity){
        vector<pair<long long, long long>> items;

        //store items as {value, weight}
        for(int i=0; i<val.size(); i++){
            items.push_back({val[i], wt[i]});
        }

        sort(items.begin(), items.end(), compare);

        double ans = 0.0;

        for(int i=0; i<items.size(); i++){
            //if we can take the whole item
            if(capacity >= items[i].second){
                ans += items[i].first;          //add full value
                capacity -= items[i].second;    //reduce capacity
                continue;
            }

            //else, take only the fraction that fits
            double valPerWeight = (double) items[i].first/items[i].second;
            ans += valPerWeight * capacity;     //add fractional val
            capacity = 0;                       //set capacity to 0
            break;                              //knapsack is full, stop
        }

        return ans;
    }
};