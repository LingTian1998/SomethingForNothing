package InterView.PinDuoDuo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m =  scanner.nextInt();
            int[][] data = new int[m][];
            int[] map = new int[n];
            long sum = 0;
            List<Long> result =new ArrayList<>();
            int right = -1;
            for (int i=0; i< m; i++){
                data[i] = new int[2];
                data[i][0]= scanner.nextInt();
                data[i][1]= scanner.nextInt();
                long temp = 0;
                for (int j=data[i][0] -1; j<=data[i][1]-1; j++) {
                    if (map[j] != 1) {
                        map[j] = 1;
                        temp++;
                    }
                }
                sum+= temp;

                result.add(sum);
            }

            for (int i=0; i<result.size(); i++)
                System.out.println(result.get(i));
        }
    }
}
