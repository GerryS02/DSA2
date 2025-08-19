
class Solution {
    public String largestOddNumber(String num){

        //look from the last digit to the first
        for(int i=num.length()-1; i>0; i--){
            //convert the character at position i to an integer
            int val = num.charAt(i) - '0';

            //if that integer is odd
            if(val%2 != 0){
                //return the substring from start to this position (inclusive)
                return num.substring(0, i+1);
            }
        }

        //else, return empty string
        return "";
    }
}
