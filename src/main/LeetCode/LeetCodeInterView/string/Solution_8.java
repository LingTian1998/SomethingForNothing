package string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_8 {
    //超时  对于只需要输出对错的题，不太需要模拟整个过程
    //优化  加入记忆链表，去除重复操作
    public boolean wordBreak(String s, List<String> wordDict) {
       return dfs(s,wordDict);
    }
    public boolean dfs(String current, List<String> wordDict){
        boolean result = false;
        char[] array = current.toCharArray();
        StringBuilder current_left = new StringBuilder("");
        for (int i=0; i<array.length; i++){
            current_left.append(array[i]);
            if (wordDict.contains(current_left.toString())){
                StringBuilder next = new StringBuilder("");

                if (i+1 == array.length)
                    return true;

                for (int k = i+1; k<array.length; k++){
                    next.append(array[k]);
                }
                result = result || dfs(next.toString(),wordDict);
            }
        }

        return result;
    }

    public boolean wordBreak_fast(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }
    public boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }

    public static void main(String[] args){

    }
}
