package InterView.HuaWei;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int M = scanner.nextInt();
            int N = scanner.nextInt();

            int[] students = new int[M];

            for (int i =0 ; i<M ; i++){
                students[i] = scanner.nextInt();
            }

            for (int i =0; i< N ; i++){
                String C = scanner.next();
                int A = scanner.nextInt();
                int B = scanner.nextInt();

                if (C.equals("Q")){
                    int max = -1;
                    if (A>B){
                        int temp = A;
                        A = B;
                        B =temp;
                    }
                    for (int j = A-1; j<=B-1; j++){
                        if (students[j]>max)
                            max = students[j];
                    }
                    System.out.println(max);
                }

                if (C.equals("U"))
                {
                    students[A-1] = B;
                }
            }
        }
    }
}
