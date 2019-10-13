package Week_157;

public class Solution_4 {
    public int countVowelPermutation(int n) {
        long suffix_a = 1;
        long suffix_e = 1;
        long suffix_i = 1;
        long suffix_o = 1;
        long suffix_u = 1;

        long tar = 1_000_000_007;

        int index = 1;
        while (index<n){
            long temp_suffix_a = suffix_e + suffix_i + suffix_u;
            long temp_suffix_e = suffix_a + suffix_i;
            long temp_suffix_i = suffix_e + suffix_o;
            long temp_suffix_o = suffix_i;
            long temp_suffix_u = suffix_i + suffix_o;

            suffix_a = temp_suffix_a % tar;
            suffix_e = temp_suffix_e % tar;
            suffix_i = temp_suffix_i % tar;
            suffix_o = temp_suffix_o % tar;
            suffix_u = temp_suffix_u % tar;

            index++;
        }
        long sum = (suffix_a+ suffix_e + suffix_i + suffix_o + suffix_u) %tar;

        return (int)sum;
    }
}
