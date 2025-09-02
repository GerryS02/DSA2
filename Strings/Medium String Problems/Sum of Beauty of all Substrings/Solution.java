class Solution {
    public int beautySum(String s) {
        int sum = 0; //sum of beauties

        for(int i = 0; i < s.length(); i++) {
            //create an array to store the frequency of each letter (a to z)
            int[] freq = new int[26];

            for(int j = i; j < s.length(); j++) {
                char ch = s.charAt(j); //get the character at position j

                //update the frequency of the character
                freq[ch - 'a']++;

                //calculate the beauty of the current substring
                //beauty = (max frequency) - (min frequency of non-zero counts)
                int beauty = getMaxCount(freq) - getMinCount(freq);

                //add the beauty to the total sum
                sum += beauty;
            }
        }

        return sum;
    }

    public int getMaxCount(int[] freq) {
        int count = 0; // Start with a count of 0

        for(int i = 0; i < 26; i++) {
            count = Math.max(count, freq[i]);
        }

        return count;
    }

    public int getMinCount(int[] freq) {
        int count = Integer.MAX_VALUE; // Start with the largest possible value

        for(int i = 0; i < 26; i++) {
            if(freq[i] != 0) { // Skip zero counts
                count = Math.min(count, freq[i]);
            }
        }

        return count;
    }
}
