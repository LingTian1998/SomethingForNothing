package JZOffer;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_2 {
    public String PrintMinNumber(int [] numbers) {
        String[] strings = new String[numbers.length];
        for (int i=0; i< numbers.length; i++)
            strings[i] = String.valueOf(numbers[i]);

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });

        StringBuilder builder = new StringBuilder("");
        for (int i=0; i<strings.length; i++){
            builder.append(strings[i]);
        }
        return builder.toString();
    }
}
