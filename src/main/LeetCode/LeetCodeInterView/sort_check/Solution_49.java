package sort_check;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_49 {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i=0; i<nums.length; i++){
            strings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo((o1+o2));
            }
        });

        StringBuilder builder = new StringBuilder("");
        for (int i=0; i<strings.length; i++) {
            builder.append(strings[i]);
        }
        String temp = builder.toString();
        char[] array = temp.toCharArray();
        if (array[0]=='0'&&array[array.length-1]=='0')
            return "0";
        return temp;
    }
}
