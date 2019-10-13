package 字节跳动2019春招研发部分编程题汇总;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 万万没想到之聪明的编辑 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            String[] data = new String[n];

            for (int i=0; i<n;i++){
                data[i] = scanner.next();
            }

            for (int i=0; i<n; i++){
                solve(data[i]);
            }
        }
    }
    public static void solve(String string){
        char[] chars = string.toCharArray();
        LinkedList<Character> queue = new LinkedList<>();

        StringBuilder builder = new StringBuilder("");
        int status = 0;
        for (int i=0; i<chars.length; i++){
            if (status == 0){
                queue.add(chars[i]);
                status = 1;
            }
            else if (status == 1){
                if (queue.peekFirst().equals(chars[i]))
                    status = 2;
                else{
                    builder.append(queue.pollFirst());
                    queue.add(chars[i]);
                    status = 0;
                }
            }
            else if (status == 2){

            }
        }
    }
}
