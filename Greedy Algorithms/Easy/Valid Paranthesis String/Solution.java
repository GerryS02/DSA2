class Solution {
    public boolean checkValidString(String s) {

        // min = minimum possible number of open '('
        // max = maximum possible number of open '('
        int min = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                // '(' increases both min and max open count
                min++;
                max++;
            } 
            else if (ch == ')') {
                // ')' decreases both min and max open count
                min--;
                max--;
            } 
            else { // '*'
                // ')' -> decrease open count (min--)
                // '(' -> increase open count (max++)
                min--;
                max++;
            }

            //we cannot have negative open brackets
            //if min < 0, reset to 0
            if (min < 0) {
                min = 0;
            }

            //if max < 0, too many ')'
            if (max < 0) {
                return false;
            }
        }

        //if min == 0, there exists a valid assignment
        return min == 0;
    }
}
