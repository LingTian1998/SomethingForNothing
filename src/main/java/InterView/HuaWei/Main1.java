package InterView.HuaWei;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int input = scanner.nextInt();
            if (input==0)
                break;
            else
                System.out.println(input/2);
        }
    }
}
