import java.util.Scanner;

public class 迷宫寻路 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            for (int i=0; i<n; i++){
                int t = scanner.nextInt();
                String data = scanner.next();

                char[] chars = data.toCharArray();
                int count = 0;
                for (int j=0; j<chars.length; j++){
                    if (chars[j]=='.'){
                        count++;
                        j+=2;
                    }

                    if (chars[j]=='X')
                        j++;
                }
            }
        }
    }
}
