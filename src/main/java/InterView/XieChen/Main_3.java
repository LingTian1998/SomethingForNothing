package InterView.XieChen;

import java.util.Scanner;

public class Main_3 {  //86%


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int schedule(int m,int[] array) {
        if (array.length==1)
            return array[0];
        if (m==1){
            int sum=0;
            for (int i=0; i<array.length;i++)
                sum += array[i];

            return sum;
        }

        int max_min = Integer.MAX_VALUE;

        int sum =0;

        if (array.length < m){
            m = array.length;
        }
        for (int i=0; i+m-1<array.length; i++){
            sum = sum + array[i];
            int temp = -1;
            if (m-1>0)
                temp = bfs(i+1,m-1,array);

            if (sum >= temp){
                if (max_min > sum)
                    max_min = sum;
            }else if (temp > sum){
                if (max_min > temp)
                    max_min = temp;
            }
        }
        return max_min;
    }
    public static int bfs(int index,int m,int[] array){
        if (m==1){
            int sum = 0;
            for (int i=index; i<array.length;i++)
                sum +=array[i];
            return sum;
        }
        int sum_max = Integer.MIN_VALUE;

        int sum=0;
        for (int i=index; i+m-1<array.length; i++){
            sum += array[index];
            int temp = -1;
            if (m-1>0)
                temp = bfs(i+1,m-1,array);

            if (temp > sum)
                return temp;
            return sum;
        }
        return -1;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size  = in.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m,array);
        System.out.println(String.valueOf(res));
    }
}
