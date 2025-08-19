
class Solution {
    public String reverseWords(String s){
        //remove leading spaces and split by spaces
        String[] words = s.trim().split(" ");

        StringBuilder sb = new StringBuilder();

        for(int i=words.length-1; i>=0; i--){
            //if there is a word, then add it to the string builder
            if(words[i].length() > 0){
                sb.append(words[i]);
                sb.append(' '); //add a space after it
            }
        }

        return sb.substring(0, sb.length()-1).toString();
    }
}
