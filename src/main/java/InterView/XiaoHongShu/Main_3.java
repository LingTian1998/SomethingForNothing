package InterView.XiaoHongShu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            baowu[] baowus = new baowu[n];
            for (int i=0; i<n; i++){
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                baowus[i] = new baowu(x, y);
            }

            Arrays.sort(baowus, new Comparator<baowu>() {
                @Override
                public int compare(baowu o1, baowu o2) {
                    if (o1.cha == o2.cha)
                        return o1.x - o2.x;
                    return o1.cha - o2.cha;
                }
            });

            int count = 0;
            int max_x = -1;
            int max_y = -1;
            for (int i=0; i<baowus.length; i++){
                if (baowus[i].x >= max_x && baowus[i].y >= max_y){
                    count ++ ;
                    max_x = baowus[i].x;
                    max_y = baowus[i].y;
                }
                else
                    break;
            }

            System.out.println(count);
        }
    }
}
class baowu{
    int x;
    int y;
    int cha;
    public baowu(int x,int y){
        this.x = x;
        this.y = y;
        this.cha = Math.abs(x-y);
    }
}