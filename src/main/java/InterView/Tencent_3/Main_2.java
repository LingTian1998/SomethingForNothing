package InterView.Tencent_3;

import java.util.*;
// 1 2 2 3 3 3 4 4 4 4
public class Main_2 {  //100%
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[][] data = new int[n][2];
            int sum = 0;
            for (int i=0; i<n; i++){
                data[i][0] = scanner.nextInt();
                data[i][1] = scanner.nextInt();
                sum += data[i][0];
            }

            Arrays.sort(data, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });

            int max = Integer.MIN_VALUE;
            int start = 0;
            int end = data.length - 1;
            while (start < end){
                int avg = (data[start][1] + data[end][1]);
                if (avg > max)
                    max = avg;
                if (data[start][0] > data[end][0]){
                    data[start][0] -= data[end][0];
                    data[end][0] = 0;
                }
                else if (data[start][0] == data[end][0]){
                    data[start][0] = 0;
                    data[end][0] = 0;
                }
                else {
                    data[end][0] -= data[start][0];
                    data[start][0] = 0;
                }

                if (data[start][0] == 0)
                    start++;
                if (data[end][0] == 0)
                    end--;
            }

            System.out.println(max);
        }
    }
}
