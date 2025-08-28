class Solution {
    public int maxDepth(String s) {
        int count = 0; // keeps track of current depth of parentheses
        int ans = 0;   // stores the maximum depth found

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            //if we see an opening bracket, increase depth
            if (ch == '(') {
                count++;
                //update the maximum depth
                ans = Math.max(count, ans);
            } 

            //if we see a closing bracket, decrease depth
            if (ch == ')') {
                count--;
            }
        }

        return ans;
    }
}
