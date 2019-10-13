package InterView.PinDuoDuo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 2 2 4  aabb
public class Main_3 {
    public static BigInteger count = new BigInteger("0");
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            BigInteger k = new BigInteger(scanner.next());

            count = new BigInteger("0");

            solve("",m,n,k);

        }
    }

    private static void solve(String temp, int m, int n, BigInteger k) {
        if (count.equals(k))
            System.out.println(temp);
        if (m>0 &&count.compareTo(k)<0) {
            count = count.add(new BigInteger("1"));
            solve(temp + "a", m - 1, n, k);
        }
        if (n>0&&count.compareTo(k)<0){
            count = count.add(new BigInteger("1"));
            solve(temp+"b",m,n-1,k);
        }
    }
}
