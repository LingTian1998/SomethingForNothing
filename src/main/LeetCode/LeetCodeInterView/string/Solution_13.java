package string;

import java.util.HashMap;
import java.util.Map;

public class Solution_13 {
    public static int firstUniqChar(String s) {
        if (s.length() == 0)
            return -1;
        HashMap<Character, container> hashMap = new HashMap<>();
        char[] array = s.toCharArray();
        for (int i=0; i< array.length; i++){
            container temp = hashMap.get(array[i]);
            if (temp == null)
                hashMap.put(array[i],new container(1,i));
            else{
                container container = hashMap.get(array[i]);
                container.num += 1;
            }
        }

        int minIndex = Integer.MAX_VALUE;
        for (Map.Entry<Character,container> entry: hashMap.entrySet()){
            if (entry.getValue().num == 1 && entry.getValue().index<minIndex){
                minIndex = entry.getValue().index;
            }
        }

        if (minIndex == Integer.MAX_VALUE)
            return -1;
        return minIndex;
    }
    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
class container{
    int num;
    int index;
    public container(int num,int index){
        this.num = num;
        this.index = index;
    }
}