#include <iostream>
#include <vector>
using namespace std;

class Solution{
public:
    bool lemonadeChange(vector<int>& bills){
        //count how many $5 and $10 bills we currently have
        int five = 0, ten = 0;

        //go through each customer's bill
        for(int i=0; i<bills.size(); i++){
            //if customer pays with $5, no change needed -> increase the count of $5
            if(bills[i] == 5){
                five++;
            } 
            //if customer pays with $5, we must give back $5 as change
            else if(bills[i] == 10){

                //if we have at least one $5 bill
                if(five != 0){
                    five--;     //give one $5 as change
                    ten++;      //receive one $10
                }else{
                    return false;   //no $5 available → cannot give change
                }
            } 
            //if customer pays with $20, we must give back $15 as change
            else{
                //best case: give one $10 and one $5
                if(five != 0 && ten != 0){
                    five--;
                    ten--;
                }
                //otherwise, give three $5 bills 
                else if(five >= 3){
                    five = five -3;
                } 
                //if we cannot give $15 change, return false
                else{
                    return false;
                }
            }
        }

        return true;    //if we successfully gave change to all customers -> return true
    }
};