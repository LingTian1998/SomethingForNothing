package string;

import java.util.Arrays;

public class Solution_12 {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length())
            return false;

        char[] array_a = s.toCharArray();
        char[] array_b = t.toCharArray();

        Arrays.sort(array_a);
        Arrays.sort(array_b);

        int i = 0;
        for (i=0; i<array_a.length&&array_a[i]==array_b[i];i++);

        if (i==array_a.length)
            return true;
        return false;
    }
}
