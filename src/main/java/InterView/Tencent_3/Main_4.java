package InterView.Tencent_3;

import java.util.Arrays;
import java.util.Scanner;
// 3 5 6 8 8 10 10
public class Main_4 {  //100%
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n =scanner.nextInt();
            int k = scanner.nextInt();
            int[] data = new int[n];
            for (int i=0; i<n; i++)
                data[i] = scanner.nextInt();

            Arrays.sort(data);

            int index = 0;
            int out_index = 0;
            int left_sum=0;
            while (index < k && out_index<data.length){
                int temp = data[out_index] - left_sum;
                if (temp < 0){
                    out_index++;
                    continue;
                }
                else if (temp == 0){
                    int j = out_index;
                    while (j < data.length&&data[j] -left_sum==0)
                        j++;
                    if (j==data.length){
                        for (; index<k; index++)
                            System.out.println(0);

                        break;
                    }
                    else {
                        out_index++;
                        continue;
                    }
                }
                else
                    System.out.println(temp);

                left_sum += temp;
                out_index++;

                index++;
            }
            int j = out_index;
            while (j < data.length&&data[j] -left_sum==0)
                j++;
            if (j==data.length){
                for (; index<k; index++)
                    System.out.println(0);
            }
        }
    }
}
