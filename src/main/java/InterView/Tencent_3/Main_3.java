package InterView.Tencent_3;

import java.util.Arrays;
import java.util.Scanner;
// 3 4 9 10 12 13 18 18
//A:
//B:
public class Main_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int T = scanner.nextInt();
            int[][] data_ = new int[T][];
            for (int i=0; i<T; i++){
                int n= scanner.nextInt();
                int[] data = new int[n];
                for (int j=0; j<n; j++){
                    data[j] = scanner.nextInt();
                }
                data_[i] = data;
            }

            for (int i=0; i< T; i++)
                solve(data_[i],data_[i].length);
        }
    }
    public static void solve(int[] data,int n){
        Arrays.sort(data);

        int max_size = 0;
        if (n%2==0)
            max_size = n/2;
        if (n%2==1)
            max_size = (n/2) +1;

        int sum_A= 0;
        int sum_B= 0;
        int size_A = 0;
        int size_B = 0;

        //int start = 0;
        int end = data.length-1;

        while (end >= 0){
            if (sum_A<=sum_B){
                sum_A += data[end];
                size_A++;
                end--;
            }else{
                sum_B +=data[end];
                size_B++;
                end--;
            }
            if (size_A== max_size || size_B ==max_size)
                break;
        }
        if (size_A == max_size){
            while (end>=0) {
                sum_B += data[end];
                end--;
            }
        }else if (size_B == max_size){
            while (end>=0){
                sum_A += data[end];
                end--;
            }
        }


        if (sum_A>sum_B){
            int temp = sum_A;
            sum_A = sum_B;
            sum_B = temp;
        }

        System.out.println(sum_A+" "+sum_B);
    }
}
