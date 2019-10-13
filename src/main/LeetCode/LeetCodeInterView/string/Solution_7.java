package string;

import java.util.ArrayList;
import java.util.List;

public class Solution_7 {
    public static void main(String[] args){
        Solution_7 solution_7 = new Solution_7();
        solution_7.partition("aab");
    }
    public static List<List<String>> resultList = new ArrayList<>();
    public  List<List<String>> partition(String s) {
        resultList.clear();
        List<String> tempList = new ArrayList<>();
        bfs(tempList,s);
        return resultList;
    }

    public void bfs(List<String> tempList, String current){
        if (current.equals(""))
            return;

        StringBuilder next_left = new StringBuilder("");
        char[] array = current.toCharArray();
        for (int i=0; i<array.length; i++){
            next_left.append(array[i]);
            if (isPalindrome(next_left.toString())){
                List<String> nextList =new ArrayList<>();
                nextList.addAll(tempList);
                nextList.add(next_left.toString());

                if (i+1 == array.length)
                    resultList.add(nextList);

                StringBuilder next_right = new StringBuilder("");
                for(int k=i+1; k<array.length;k++){
                    next_right.append(array[k]);
                }
                bfs(nextList,next_right.toString());
            }
        }

    }

    //用于验证一个字符串是否是回文串
    public boolean isPalindrome(String s) {
        if (s.length() == 0)
            return true;

        char[] chars = s.toLowerCase().toCharArray();
        int i = 0;
        int j = s.length()-1;
        while ( j > i){
            if (isValid(chars[i]) && isValid(chars[j])){
                if (chars[i] != chars[j])
                    return false;
            }

            if (!isValid(chars[i])){
                i++;
                continue;
            }
            if (!isValid(chars[j])){
                j--;
                continue;
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean isValid(char c){
        if (c >= 'a' && c <='z')
            return true;
        else if (c>='0' && c<='9')
            return true;
        return false;
    }
}
