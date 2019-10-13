package string;

public class Solution_6 {
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
