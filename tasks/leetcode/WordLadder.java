package tasks.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        wordList.add(endWord);
        wordList.remove(beginWord);
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String str = queue.poll();
                if(str.equals(endWord))return level;

                for(String neighbor : neighbors(str,wordList)){
                    queue.offer(neighbor);
                }
            }
            level++;
        }
        return 0;
    }

    public List<String> neighbors(String s, Set<String> wordList){
        List<String> res = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            char [] chars = s.toCharArray();
            for(char ch = 'a'; ch <= 'z'; ch++){
                chars[i] = ch;
                String word = new String(chars);
                if(wordList.remove(word)){
                    res.add(word);
                }
            }
        }
        return res;
    }

}
