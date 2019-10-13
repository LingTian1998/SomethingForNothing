package InterView.WangYi;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int q = scanner.nextInt();

            int[] array = new int[n];
            for (int i =0; i<n; i++){
                array[i] = scanner.nextInt();
            }

            Arrays.sort(array);

            int[] tar = new int[q];
            for (int i=0; i<q; i++){
                tar[i] =scanner.nextInt();
            }

            for (int i=0; i<q; i++){
                int counter = 0;
                for (int j=0; j<n ; j++){
                    if (array[j]>=tar[i]){
                        array[j]--;
                        counter++;
                    }
                }
                System.out.println(counter);
            }
        }
    }
}
