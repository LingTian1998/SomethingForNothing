package before_start;

import java.util.Arrays;

public class Solution_5 {
//    public int superEggDrop(int K, int N) {
//        int[][] results = new int[K+1][N+1];
//        for (int i=1;i<=N;i++){
//            results[0][i] = i;
//            results[1][i] = i;
//        }
//        for (int i=1; i<=K;i++){
//            results[i][0] = 0;
//        }
//
//        for (int k=2; k<=K; k++){
//            for (int n=1; n<=N; n++){
//                int tMinDrop = N*N;
//                for (int x =1; x<=n; x++){
//                    tMinDrop= Math.min(tMinDrop,1 + Math.max(results[k-1][x-1],results[k][n-x]));
//                }
//                results[k][n] = tMinDrop;
//            }
//        }
//
//        return results[K][N];
//    }

    //O(KN)
//    public int superEggDrop(int K, int N) {
//        int[][] dp = new int[K + 1][N + 1];
//        for (int m = 1; m <= N; m++) {
//            dp[0][m] = 0; // zero egg
//            for (int k = 1; k <= K; k++) {
//                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
//                if (dp[k][m] >= N) {
//                    return m;
//                }
//            }
//        }
//        return N;
//    }

    //O(N)
    public int superEggDrop(int K, int N) {
        int[] res=new int[K];
        Arrays.fill(res,1);
        while (res[K-1]<N){
            for (int i=K-1;i>=1;i--){
                res[i]=res[i]+res[i-1]+1;
            }
            res[0]++;
        }
        return res[0];
    }
}
