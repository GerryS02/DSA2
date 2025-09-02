// Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

class Solution {
    public int myAtoi(String s) {
        //remove leading and trailing whitespaces
        s = s.trim();

        //if the string is empty after trimming, return 0
        if(s.length() == 0) return 0;

        long ans = 0;      //this will hold the result as a long to prevent overflow
        boolean neg = false; //flag to track if the number is negative

        //loop through each character in the string
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i); //get the current character

            //check for signs ('+' or '-') at the beginning
            if(i == 0){
                if(ch == '-') { 
                    neg = true; 
                    continue;
                } else if(ch == '+'){ 
                    neg = false;
                    continue; 
                }
            }

            //check if the current character is a digit (0-9)
            if(ch >= '0' && ch <= '9') {
                //convert the character to a digit
                int digit = ch - '0';
                
                //build the number digit by digit
                ans = ans * 10 + digit;

                //check for overflow conditions
                if(neg) {
                    long check = -ans;
                    if(check < Integer.MIN_VALUE) { //if the number is less than Integer.MIN_VALUE, return Integer.MIN_VALUE
                        return Integer.MIN_VALUE;
                    }
                } else {
                    if(ans > Integer.MAX_VALUE) { //if the number is greater than Integer.MAX_VALUE, return Integer.MAX_VALUE
                        return Integer.MAX_VALUE;
                    }
                }

            } else {
                //if the character is not a digit, stop the process
                break;
            }
        }

        //apply the negative sign if needed
        if(neg) {
            ans = -ans;
        }

        //return the result, casting it to an int
        return (int) ans;
    }
}
