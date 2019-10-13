package InterView.YITu;

import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[][] towers = new int[n][2];
            for (int i=0; i< n; i++){
                towers[i][0] = scanner.nextInt();
                towers[i][1] = scanner.nextInt();
            }

            int[] dp = new int[n];
            for (int i=0; i<n; i++){
                int j= i-1;
                while (j>=0){
                    if (towers[j][0] > towers[i][0]) {
                        dp[j] += towers[i][1];
                        break;
                    }
                    j--;
                }

                j = i+1;
                while (j<n){
                    if (towers[j][0] > towers[i][0]) {
                        dp[j] += towers[i][1];
                        break;
                    }
                    j++;
                }
            }

            int max = Integer.MIN_VALUE;
            for (int i=0; i<n; i++){
                if (dp[i] > max)
                    max = dp[i];
            }

            System.out.println(max);

        }
    }
}
