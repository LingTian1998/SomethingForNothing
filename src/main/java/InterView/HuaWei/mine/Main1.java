package InterView.HuaWei.mine;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            double D = scanner.nextDouble();

            double max_price = D*10000;

            int cur_sum = 0;
            int cur_num = Integer.MAX_VALUE;
            double min_cha = Integer.MAX_VALUE;

            for (int i=1; i<=10000; i++){
                for (int j =(int)D*i-1; j<=max_price; j++){
                    if ((double)j/i > D+1)
                        break;

                    double cur_avg_price = (double)j/i;
                    double cha = Math.abs(cur_avg_price - D);
                    if (cha<min_cha){
                        min_cha = cha;
                        cur_sum = j;
                        cur_num = i;
                    }

                    if (cha == min_cha && j< cur_num){
                        cur_num = i;
                        cur_sum = j;
                    }

                }
            }
            System.out.println(cur_sum+" "+cur_num);

        }
    }
}
