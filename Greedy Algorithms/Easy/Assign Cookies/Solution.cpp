#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());

        int child = 0, cookie = 0;

        //loop while we still have children and cookies left
        while(child < g.size() && cookie < s.size()){
            //if current cookie can satisfy current child
            if(s[cookie] >= g[child]){
                child++;    //move to next child
            }

            cookie++;   //move to next cookie
        }

        return child;
    }
};