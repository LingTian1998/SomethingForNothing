package InterView.TenCent_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int[] boxes = new int[n+1];
            for (int i=1; i<=n; i++){
                boxes[i] = scanner.nextInt();
            }

            long sec = 0;
            int working = -1;
            int ganlu = 0;
            int ganlu_index = 0;
            int index = 1;
            while (boxes[n]!=0){
                sec++;

                if (ganlu_index == index){
                    m = m + ganlu;
                    ganlu = 0;
                }
                if (ganlu!=0)
                    ganlu_index++;

                if (working!=0&&boxes[index]==0){
                    ganlu = working;
                    working = 0;
                    ganlu_index = index-1;
                }

                if (m> boxes[index]) {
                    m = m - boxes[index];
                    working = boxes[index];
                    boxes[index] = 0;
                } else{
                    boxes[index] -= m;
                }

                if (boxes[index]==0)
                    index++;
            }
            if (working!=0)
                sec++;
            System.out.println(sec);
        }
    }
}
class worker{
    int nums;
    int remain_time;
    public worker(int nums,int remain_time){
        this.nums = nums;
        this.remain_time = remain_time;
    }
}