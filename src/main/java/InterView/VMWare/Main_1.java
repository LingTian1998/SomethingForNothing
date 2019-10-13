package InterView.VMWare;

import java.util.Scanner;

/**
 * 一个不含前导0的非负整数，如果从左往右看和从右往左看，它都是一样的，就称其为回文数，例如12321，123321，8，88，707，1920291均为回文数，
 * 而29，887，96，9990，8088均不是回文数。现要求你输出所有n位回文数中的第k小。
 */
public class Main_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n= scanner.nextInt();
            Pair_n_k[] pair_n_ks = new Pair_n_k[n];
            for (int i=0; i<n; i++){
                pair_n_ks[i] = new Pair_n_k(scanner.nextInt(), scanner.nextInt());
            }

            for (int i=0; i<n; i++){
                solve(pair_n_ks[i].n,pair_n_ks[i].k);
            }
        }
    }

    private static void solve(int n, int k) {
        if (n%2==1) {
            int count = (n+1)/2;
            if (count == 1) {
                count = 10;
                System.out.println(k-1);
            }
            else {
                int sum = 9;
                for (int i = 1; i<count; i++)
                    sum = sum*10;

                int temp_count = 0;
                String builder = "";
                char[] chars = String.valueOf(k).toCharArray();
                Reverse(chars);

                while (temp_count < chars.length){
                    if (temp_count == count -1) {
                        builder = (chars[temp_count]-'0'+1) + builder + (chars[temp_count]-'0'+1);
                        temp_count++;
                    }
                    else if (temp_count == 0){
                        builder = builder+(chars[temp_count] - '0' - 1);
                        temp_count++;
                    }
                    else {
                        builder = (chars[temp_count]-'0') + builder + (chars[temp_count]-'0');
                        temp_count++;
                    }
                }
                while (temp_count<count){
                    if (temp_count == count -1) {
                        builder = (1) + builder + (1);
                        temp_count++;
                    }else {
                        builder = (0) + builder + (0);
                        temp_count++;
                    }
                }
                System.out.println(builder);
            }

        }else {
            int count = n/2;
            if (count==1){
                System.out.println(k+""+k);
            }else {
                char[] chars = String.valueOf(k).toCharArray();
                Reverse(chars);

                String builder = "";
                int temp_count = 0;
                while (temp_count<chars.length){
                    if (temp_count == count-1){
                        builder = (chars[temp_count]-'0' +1)+builder+(chars[temp_count]-'0' +1);
                        temp_count++;
                    }else if (temp_count == 0){
                        builder = builder+(chars[temp_count] -'0'-1)+(chars[temp_count] -'0'-1);
                        temp_count++;
                    }else {
                        builder =   (chars[temp_count]-'0')+builder+(chars[temp_count]-'0');
                    }
                }
                while (temp_count<count){
                    if (temp_count == count -1) {
                        builder = (1) + builder + (1);
                        temp_count++;
                    }else {
                        builder = (0) + builder + (0);
                        temp_count++;
                    }
                }
                System.out.println(builder);
            }

        }
    }

    private static void Reverse(char[] chars) {
        int i=0;
        int j=chars.length-1;
        while (i<j){
            swap(chars,i,j);
            i++;
            j--;
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
class Pair_n_k{
    int n;
    int k;
    public Pair_n_k(int n,int k){
        this.n = n;
        this.k = k;
    }
}