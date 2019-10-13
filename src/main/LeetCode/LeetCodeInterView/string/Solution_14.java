package string;

public class Solution_14 {
    char temp;
    public void reverseString(char[] s) {
        int length = s.length;

        int i = 0;
        int j = length-1;
        while (j>i) {
            swap(s, i, j);
            i++;
            j--;
        }
    }
    public void swap(char[] s, int x, int y){
        temp = s[x];
        s[x] = s[y];
        s[y] = temp;
    }
}
