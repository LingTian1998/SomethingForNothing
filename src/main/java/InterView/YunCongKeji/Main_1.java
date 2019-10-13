package InterView.YunCongKeji;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            long candies = scanner.nextLong();
            long num_people = scanner.nextLong();

            if (num_people == 0)
                continue;
            if (num_people == 1){
                System.out.println("["+candies+"]");
            }

            long sum = (1+num_people)*num_people/2;
            long add_per_time = num_people*num_people;

            int count = 0;
            long cur_sum = count*add_per_time + sum;
            while (candies>cur_sum){
                candies -= cur_sum;
                count++;
                cur_sum = count*add_per_time + sum;
            }

            int index =1;
            long temp_val = count*num_people+index;
            while (candies>temp_val){
                candies -=  temp_val;
                index++;
                temp_val = count*num_people+index;
            }

            List<Long> result = new ArrayList<>();
            for (int i=1; i<index; i++){
                long temp = (1+count)*count/2 *num_people + i*(count+1);
                result.add(temp);
            }
            long temp = (1+count-1)*count/2 *num_people + index*(count)+ candies;
            result.add(temp);

            count--;
            for (int i= index+1; i<=num_people;i++){
                temp = (1+count)*count/2 *num_people + i*(count+1);
                result.add(temp);
            }

            //[1,2,3,1]
            System.out.print("[");
            int i=0;
            for (; i<result.size()-1;i++){
                System.out.print(result.get(i)+",");
            }
            System.out.println(result.get(i)+"]");
        }
    }
}
