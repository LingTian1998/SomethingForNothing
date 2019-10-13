package InterView.PinDuoDuo;

import java.util.*;

public class Main_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] data = new int[n];
            for (int i=0; i<n; i++)
                data[i] = scanner.nextInt();

            Arrays.sort(data);
            List<Long> list = new ArrayList<>();
            int start = 0;
            int end = m*2 - 1;

            while (start<end){
                long temp1 = data[start];
                long temp2 = data[end];
                list.add(temp1*temp2);
                start++;
                end--;
            }

            Collections.sort(list);

            long sum = 0;
            for (int i=0; i< m&& i<list.size(); i++){
                sum+= list.get(i);
            }
            System.out.println(sum);
        }
    }
}
