import java.util.Stack;

class Solution {
    public String removeOuterParentheses(String s){
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i); //get the character at the current index

            //if it's an opening bracket -> (
            if(ch == '('){
                //only add to result if it's not the outermost '('
                if(st.size() > 0){
                    sb.append(ch); //append the '(' to result string
                }
                st.push(ch); //push '(' onto the stack
            } 
            //if it's a closing parenthesis -> )
            else{
                st.pop(); //pop the opening '(' from the stack

                //only add to result if it's not the outermost
                if(st.size() > 0){
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }
}
