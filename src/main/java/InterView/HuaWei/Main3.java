package InterView.HuaWei;

import java.math.BigInteger;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String string1 = scanner.next();
            String string2 = scanner.next();
            BigInteger bigInteger1 = new BigInteger(string1);
            BigInteger bigInteger2 = new BigInteger(string2);
            System.out.println(bigInteger1.add(bigInteger2).toString());
        }
    }
}
