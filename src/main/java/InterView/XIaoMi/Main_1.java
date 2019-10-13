package InterView.XIaoMi;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1 {
    /*题目描述：
小米之家有很多米粉喜欢的产品，产品种类很多，价格也不同。比如某签字笔1元，某充电宝79元，某电池1元，某电视1999元等

假设库存不限，小明去小米之家买东西，要用光N元预算的钱，请问他最少能买几件产品？*/

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int solution(int[] prices, int budget) {
        Arrays.sort(prices);
        if (budget < prices[0])
            return -1;

        int[] dp =  new int[budget+1];
        for (int i=0; i<prices.length; i++) {
            if (prices[i]<dp.length)
                dp[prices[i]] = 1;
        }
        for (int i=0; i<dp.length; i++){
            if (dp[i]==0)
                continue;
            for (int j=0; j<prices.length; j++){
                int temp = i+prices[j];

                if (temp<dp.length){
                    if (dp[temp] ==0)
                        dp[temp]=dp[i]+1;
                    else
                        dp[temp] = Math.min(dp[temp],dp[i]+1);
                }
            }
        }
        if (dp[budget]==0)
            return -1;
        return dp[budget];
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _prices_size = 0;
        _prices_size = Integer.parseInt(in.nextLine().trim());
        int[] _prices = new int[_prices_size];
        int _prices_item;
        for(int _prices_i = 0; _prices_i < _prices_size; _prices_i++) {
            _prices_item = Integer.parseInt(in.nextLine().trim());
            _prices[_prices_i] = _prices_item;
        }

        int _budget;
        _budget = Integer.parseInt(in.nextLine().trim());

        res = solution(_prices, _budget);
        System.out.println(String.valueOf(res));

    }
}
