package InterView.TenCent_2;

import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] boxes = new int[n];
            int boxes_counter_ou = 0;
            int boxes_counter_ji = 0;
            for (int i=0; i< n; i++) {
                boxes[i] = scanner.nextInt();
                if (boxes[i]%2==0)
                    boxes_counter_ou++;
            }
            boxes_counter_ji = n - boxes_counter_ou;

            int[] keys = new int[m];
            int keys_counter_ou = 0;
            int keys_counter_ji = 0;
            for (int i=0; i<m; i++) {
                keys[i] = scanner.nextInt();
                if (keys[i]%2==0)
                    keys_counter_ou++;
            }
            keys_counter_ji = m - keys_counter_ou;

            int sum = 0;
            if (boxes_counter_ji >= keys_counter_ou)
                sum+= keys_counter_ou;
            else
                sum+=boxes_counter_ji;
            if (keys_counter_ji >= boxes_counter_ou)
                sum+= boxes_counter_ou;
            else
                sum+=keys_counter_ji;

            System.out.println(sum);

        }
    }
}
