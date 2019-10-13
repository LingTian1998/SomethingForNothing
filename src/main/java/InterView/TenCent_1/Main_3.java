package InterView.TenCent_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int L = scanner.nextInt();

            Qujian[] qujians = new Qujian[n];
            for (int i=0; i<n ; i++){
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                qujians[i]= new Qujian(x,y,y-x);
            }

            int max_y = Integer.MIN_VALUE;
            for (int i=0; i<qujians.length; i++){
                if (qujians[i].y > max_y)
                    max_y = qujians[i].y;
            }
            if (max_y<L)
            {
                System.out.println(-1);
                continue;
            }

            int judge[] = new int[L+1];
            for (int i=0; i<qujians.length; i++){
                for (int k = qujians[i].x; k<=L&&k<= qujians[i].y ; k++)
                    judge[k] = 1;
            }

            boolean flag =false;
            for (int i=1; i<judge.length ; i++){
                if (judge[i]!=1)
                {
                    System.out.println(-1);
                    flag = true;
                    continue;
                }
            }
            if (flag)
                continue;

            Arrays.sort(qujians, new Comparator<Qujian>() {
                @Override
                public int compare(Qujian o1, Qujian o2) {
                    if (o1.x == o2.x)
                        return o1.cha - o2.cha;
                    return o1.x - o2.x;
                }
            });

            int count = 0;
            int sum = 0;
            int i = 0;
            while (sum < L&& i<qujians.length){
                int temp_max = Integer.MIN_VALUE;
                for ( ;i<qujians.length && qujians[i].x <= sum; i++){
                    if (qujians[i].cha > temp_max)
                        temp_max = qujians[i].cha;
                }

                sum = sum + temp_max;
                i--;
                count++;
            }
            System.out.println(count);
        }
    }
}
class Qujian{
    int x;
    int y;
    int cha;
    public Qujian(int x,int y, int cha){
        this.x = x;
        this.y = y;
        this.cha = cha;
    }
}