// Given two strings s and goal, return true if and only if s can become goal after some 
// number of shifts on s.

class Solution {
    public boolean rotateString(String s, String goal){
        //if the lengths of s and goal are not the same, return false
        if(s.length() != goal.length()){
            return false;
        }

        //concatenate s with itself, and check if goal is a substring of s + s
        String doubleStr = s+s;

        return doubleStr.contains(goal);
    }
}
