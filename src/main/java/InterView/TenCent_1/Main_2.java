package InterView.TenCent_1;

import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int num = 1<<n;
            int[] array = new int[num];
            for (int i=0; i<num; i++){
                array[i] = scanner.nextInt();
            }

            int qn = scanner.nextInt();
            int[] qs = new int[qn];
            for (int i=0; i< qn ;i++){
                qs[i] = scanner.nextInt();
            }

            for (int i=0; i<qn; i++){
                int temp = 1<<qs[i];
                for (int j=0; j<num; j++){
                    int target = j+temp -1;
                    int flag = target;
                    while (target > j){
                        swap(array,target,j);
                        target--;
                        j++;
                    }
                    j = flag;
                }

                int count = 0;
                for (int a =0; a< num ;a++){
                    for (int b=a+1; b<num; b++){
                        if (array[a]>array[b])
                            count++;
                    }
                }

                System.out.println(count);
            }
        }
    }
    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
