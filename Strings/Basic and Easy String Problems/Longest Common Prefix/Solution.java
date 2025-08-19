
class Solution {
    public String longestCommonPrefix(String[] strs){
        //if the arrsy is empty, return empty string
        if(strs.length == 0){
            return "";
        }

        int len = 0; //length of the common prefix so far
        while(true){

            //is 'len' still within the first word's length
            if(len < strs[0].length()){
                boolean matched = true; //assume current position matches

                //get the character at 'len' position from the first string
                char ch = strs[0].charAt(len);

                //compare this character with the same position in all other strings
                for(int i=1; i<strs.length; i++){
                    if(len < strs[i].length() && strs[i].charAt(len) == ch){
                        //nothing to do -> caharcter is mstched
                    } else{ 
                        matched = false; //character did not match
                        break;
                    }
                }

                //if all strings matched at this position, move to next character
                if(matched == true){
                    len++;
                } //otherwise, break;
                else{
                    break;
                }

            } //stop if we've reached the end of the first string
            else{
                break;
            }
        }

        return strs[0].substring(0, len); //return the substring of the first string from 0 to 'len'
    }
}
