package InterView.YunCongKeji;

import java.util.Scanner;

public class Main_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String data = scanner.nextLine();
            int amount = Integer.valueOf(scanner.nextLine());

            String[] string_array = data.subSequence(1,data.length()-1).toString().split(",");
            int[] coins = new int[string_array.length];
            for (int i=0; i<coins.length; i++){
                coins[i] = Integer.valueOf(string_array[i].trim());
            }

            int[] dp = new int[amount+1];
            for (int j=0; j<coins.length; j++)
                dp[coins[j]] = 1;

            for (int i=1; i<dp.length; i++){
                if (dp[i] == 0)
                    continue;

                for (int j=0; j<coins.length; j++){
                    int index =  i+ coins[j];
                    if (index>=dp.length)
                        continue;

                    if (dp[index] == 0)
                        dp[index] = dp[i]+1;
                    else
                        dp[index] = Math.min(dp[index],dp[i]+1);
                }
            }

            if (dp[amount]==0)
                System.out.println(-1);
            else
                System.out.println(dp[amount]);
        }
    }
}
