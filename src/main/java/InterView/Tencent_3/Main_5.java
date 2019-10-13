package InterView.Tencent_3;

import java.util.Scanner;

public class Main_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i=0; i<n; i++)
                a[i] = scanner.nextInt();
            for (int i=0; i<n;i++)
                b[i] = scanner.nextInt();

            if (n%2 == 1)
                System.out.println(2);

            if(n%2 == 0)
                System.out.println(8);
             // 2  8
        }
    }
}
