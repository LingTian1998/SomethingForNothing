package InterView.YinYuLiulishuo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            Temp[] temps = new Temp[n];
            for (int i=0; i<n; i++){
                temps[i] = new Temp(scanner.nextInt(),scanner.nextInt());
            }

            Arrays.sort(temps, new Comparator<Temp>() {
                @Override
                public int compare(Temp o1, Temp o2) {
                    int temp1 = Math.abs(o1.ci - o1.di);
                    int temp2 = Math.abs(o2.ci - o2.di);
                    return temp2 - temp1;
                }
            });

            int sum = 0;
            for (int i=0; i<n; i++){
                if (a==0){
                    while (i<n){
                        sum += temps[i].di;
                        i++;
                    }
                }
                if (b==0){
                    while (i<n){
                        sum+=temps[i].ci;
                        i++;
                    }
                }
                if (i<n&&a!=0 && (temps[i].ci < temps[i].di)){
                    sum += temps[i].ci;
                    a--;
                }
                else if (i<n&&b>0 && (temps[i].di < temps[i].ci)){
                    sum += temps[i].di;
                    b--;
                }
                //System.out.println(temps[i].ci +"+"+temps[i].di);

            }
            System.out.println(sum);
        }
    }
}
class Temp{
    int ci;
    int di;
    public Temp(int ci,int di){
        this.ci = ci;
        this.di = di;
    }
}