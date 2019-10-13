package InterView.Bilibili;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String data = scanner.nextLine();
            String[] dights = data.split(",");
            Arrays.sort(dights, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return (o1+o2).compareTo(o2+o1);
                }
            });

            for (int i=0; i<dights.length; i++){
                if (Integer.valueOf(dights[i]) != 0)
                    System.out.print(dights[i]);
            }
            System.out.println();
        }
    }
}
