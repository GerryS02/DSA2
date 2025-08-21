import java.util.HashMap;

class Solution{
    public boolean isIsomorphic(String s, String t){
        if(s.length() != t.length()) return false;

        HashMap<Character, Character> m1 = new HashMap<>(); //store the character mapping from s to t
        HashMap<Character, Boolean> m2 = new HashMap<>(); //track if a character from t has already been mapped

        for(int i=0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            //if c1 (from s) has been seen before
            if(m1.containsKey(c1)){
                //if it's mapped to a different character than c2, return false
                if(m1.get(c1) != c2){
                    return false;
                }
            } ////c1 is not seen before
            else{
                //if c2 has been seen in m2, it means it's already mapped to a different character, return false
                if(m2.containsKey(c2)){
                    return false;
                } else{
                    //map c1 to c2 and mark c2 as used in m2
                    m1.put(c1, c2);
                    m2.put(c2, true);
                }
            }
        }

        return true;
    }
}