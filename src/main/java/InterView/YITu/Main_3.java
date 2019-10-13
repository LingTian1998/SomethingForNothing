package InterView.YITu;

import java.util.Arrays;
import java.util.Scanner;

public class Main_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] v = new int[n+1];

            for (int i=1; i<=n; i++){
                v[i] = scanner.nextInt();
            }

            Arrays.sort(v);
            int[] dp =new int[n+1];
            int[] last_v = new int[n+1];

            for (int i=1; i<=n; i++){ // 6 9   19
                int temp = v[i]*2;
                int index = i;
                while (index<n+1 && v[index]<temp)
                    index++;
                for (int j= index; j<=n; j++){  //j代表 2倍的vi
                    if (last_v[i] != 0) {
                        if (last_v[j] * 2 <= v[i] && v[j] >= v[i] * 2 && last_v[i]  >= last_v[j]*2) {
                            dp[i] = 1;
                            last_v[j] = v[i];
                            break;
                        }
                    }else {
                        if (last_v[j] * 2 <= v[i] && v[j] >= v[i] * 2) {
                            dp[i] = 1;
                            last_v[j] = v[i];
                            break;
                        }
                    }
                }
            }

            int count =0 ;
            for (int i=1; i<n+1; i++)
                if (dp[i] == 0) {
                    count++;
                }

            System.out.println(count);
        }
    }
}
