package InterView.Bilibili;

import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.nextLine();

            String[] words = input.split("\\s+");
            int i=0;
            int j= words.length -1;
            while (j>i){
                swap(words, i, j);
                i++;
                j--;
            }
            for (int k =0; k<words.length; k++){
                if (k==0)
                    System.out.print(words[k]);
                else
                    System.out.print(" "+words[k]);
            }
            System.out.println();
        }
    }

    public static void swap(String[] words, int i, int j){
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }
}
