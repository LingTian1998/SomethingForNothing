package InterView.TenCent_1;

import java.util.Scanner;

public class Main_4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] lou = new int[n];
            for (int i=0; i<n; i++){
                lou[i] = scanner.nextInt();
            }

            int[] result = new int[n];
            for (int i=0; i<n; i++){
                int left = look_left(lou, i);
                int right = look_right(lou, i);
                result[i] = left + right + 1;
            }

            int i;
            for (i=0; i<result.length-1; i++){
                System.out.print(result[i]+" ");
            }
            System.out.print(result[i]);
        }
    }

    private static int look_right(int[] lou, int i) {
        if (i == lou.length-1)
            return 0;

        int count =1;
        int max = lou[i+1];
        for (int k = i+2 ; k<lou.length; k++){
            if (lou[k] > max){
                count++;
                max = lou[k];
            }
        }

        return count;
    }

    private static int look_left(int[] lou, int i) {
        if (i == 0)
            return 0;

        int count = 1;
        int max = lou[i-1];
        for (int k = i-2; k>=0; k--){
            if (lou[k]>max){
                count++;
                max = lou[k];
            }
        }
        return count;
    }
}
