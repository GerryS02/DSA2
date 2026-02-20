#include <iostream>
using namespace std;

class Solution {  
public:
    bool isValid(string s) {
        int min = 0;
        int max = 0;

        for(int i=0; i<s.size(); i++){
            char ch = s[i];

            if(ch == '('){
                min++;
                max++;
            } else if(ch == ')'){
                min--;
                max--;
            } else if(ch == '*'){
                min--;
                max++;
            }

            if(min < 0) min = 0;
            if(max < 0) return false;
        }

        return min == 0;
    }
};