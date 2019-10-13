package InterView.DongFangCaiFu;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str1 = scanner.next();
            String str2 = scanner.next();
            String str3 = scanner.next();

            char[] chars_1 = str1.toCharArray();
            char[] chars_2 = str2.toCharArray();
            char[] chars_3 = str3.toCharArray();

            int index =0;
            int i=0;
            int j=0;
            boolean result = false;
            while (index<chars_3.length){
                if (i<chars_1.length&&chars_3[index]==chars_1[i]){
                    index++;
                    i++;
                }
                else if (j<chars_2.length&&chars_3[index]==chars_2[j]){
                    index++;
                    j++;
                }else
                    break;
            }

            if (index==chars_3.length&&i==chars_1.length&&j==chars_2.length)
                result = result|| true;

            index =0;
            i=0;
            j=0;
            while (index<chars_3.length){
                if (j<chars_2.length&&chars_3[index]==chars_2[j]){
                    index++;
                    j++;
                }
                else if (i<chars_1.length&&chars_3[index]==chars_1[i]){
                    index++;
                    i++;
                }
                else
                    break;
            }

            if (index==chars_3.length&&i==chars_1.length&&j==chars_2.length)
                result = result|| true;

            if (result)
                System.out.println("TRUE");
            else
                System.out.println("FALSE");
        }
    }
}
