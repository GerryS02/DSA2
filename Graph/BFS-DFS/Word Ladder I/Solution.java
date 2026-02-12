import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Pair{
    String first;
    int second;

    Pair(String word, int steps){
        this.first = word;
        this.second = steps;
    }
}

class Solution{
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));

        Set<String> st = new HashSet<String>();
        for(String word : wordList){
            st.add(word);
        }
        st.remove(beginWord);

        while(!q.isEmpty()){
            Pair p = q.poll();
            String word = p.first;
            int steps = p.second;

            if(word.equals(endWord)) return steps;

            for(int i=0; i<word.length(); i++){

                for(char ch='a'; ch<='z'; ch++){
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;

                    String newWord = new String(replacedCharArray);

                    if(st.contains(newWord)){
                        st.remove(newWord);
                        q.offer(new Pair(newWord, steps+1));
                    }
                }
            }
        }

        return 0;
    }
}