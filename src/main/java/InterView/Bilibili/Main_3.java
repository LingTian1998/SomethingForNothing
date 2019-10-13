package InterView.Bilibili;

import java.util.Scanner;

public class Main_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int[] weight = new int[N+1];
            for (int i=0; i<N; i++)
                weight[i+1] = scanner.nextInt();

            int[] value = new int[N+1];
            for (int i=0; i<N;i++)
                value[i+1] = scanner.nextInt();

            int[][] dp = new int[N+1][M+1];

            for (int i=1; i<= N; i++){
                for (int j= 1; j<= M; j++){
                    if (j>=weight[i]){
                        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
                    }else {
                        dp[i][j]= dp[i-1][j];
                    }
                }
            }
            System.out.println(dp[N][M]);
        }
    }
}
