// Given a Roman numeral, convert it to an integer.

class Solution {
    public int romanToInt(String s) {
        int num = 0;
        int i = 0 ;

        while(i<s.length()){
            char ch = s.charAt(i); 

            if(ch == 'M'){
                num += 1000;
            } 
            
            else if(ch == 'D'){
                num += 500;
            } 
            
            else if(ch == 'C' && i+1 < s.length() && s.charAt(i+1) == 'D'){
                num -= 100;
            } else if(ch == 'C' && i+1 < s.length() && s.charAt(i+1) == 'M'){
                num -= 100;
            } else if(ch == 'C'){
                num+= 100;
            } 
            
            else if(ch == 'L'){
                num += 50;
            } 
            
            else if(ch == 'X' && i+1 < s.length() && s.charAt(i+1) == 'L'){
                num -= 10;
            } else if(ch == 'X' && i+1 < s.length() && s.charAt(i+1) == 'C'){
                num -= 10;
            } else if(ch == 'X'){
                num += 10;
            } 
            
            else if(ch == 'V'){
                num += 5;
            } 

            else if(ch == 'I' && i+1 < s.length() && s.charAt(i+1) == 'V'){
                num -= 1;
            } else if(ch == 'I' && i+1 < s.length() && s.charAt(i+1) == 'X'){
                num -= 1;
            } else if(ch == 'I'){
                num += 1;
            }

            i++;
        }

        return num;
    }
}