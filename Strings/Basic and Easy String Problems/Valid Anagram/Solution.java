// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or 
// phrase, typically using all the original letters exactly once.

import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> m = new HashMap<>();

        //count frequency of each character in string s
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            //if character already exists, increase its count, else put 1
            m.put(c1, m.getOrDefault(c1, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c2 = t.charAt(i);

            //if t has a character not in s → not an anagram
            if (!m.containsKey(c2)) {
                return false;
            } 
            //if character exists but count is exactly 1 → remove it from map
            else if (m.get(c2) == 1) {
                m.remove(c2);
            } 
            //if character exists with count > 1 → decrease the count by 1
            else {
                m.put(c2, m.get(c2) - 1);
            }
        }

        //if map is empty, all characters matched perfectly → it’s an anagram
        if (m.size() == 0) return true;

        //otherwise, some characters left unmatched → not an anagram
        return false;
    }
}
