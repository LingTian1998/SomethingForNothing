package InterView.Tencent_3;

import java.util.Scanner;

public class Main_1 {  //70%
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            for (int i=0; i<n; i++){
                int t = scanner.nextInt();
                String data = scanner.next();
                solve(t,data);
            }
        }
    }

    private static void solve(int t, String data) {
        if (t<11){
            System.out.println("NO");
            return;
        }
        else if (t == 11){
            if (data.charAt(0)=='8')
                System.out.println("YES");
            else
                System.out.println("NO");
            return;
        }
        else {
            char[] chars = data.toCharArray();
            int index = 0;
            while (chars[index]!='8'){
                index++;
                t--;
            }
            if (t-index-1 >= 11){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
            return;
        }
    }
}
