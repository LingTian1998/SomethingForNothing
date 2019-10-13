package InterView.Didi;

import java.util.*;

public class Main_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = Integer.valueOf(scanner.nextLine());
            String data = scanner.nextLine();
            String[] val = data.split(" ");

            if (val.length == 1)
                System.out.println(val[0]);
            else {
                for (int i=1; i< 2*n-1; i+=2){
                    if (val[i].equals("+")) {
                        if (i-2>=0&&!val[i-2].equals("+"))
                            continue;
                        int start = i;
                        while (i+2 < 2 * n - 1 && val[i].equals("+") && !val[i + 2].equals("*") && !val[i + 2].equals("/")&& !val[i + 2].equals("-")) {
                            i += 2;
                        }
                        int end = i-2;
                        if (i+2 == 2*n-1)
                            end = i;
                        else if (val[i+2].equals("-"))
                            end = i;
                        Mysort(val, start, end);
                    }else if (val[i].equals("-")){
                        if (i-2>=0&&!val[i-2].equals("-"))
                            continue;
                        int start = i;
                        while (i+2 < 2 * n - 1 && val[i].equals("-") && !val[i + 2].equals("*") && !val[i + 2].equals("/")&& !val[i + 2].equals("+")) {
                            i += 2;
                        }
                        int end = i-2;
                        if (i+2 == 2*n-1)
                            end = i;
                        else if (val[i+2].equals("-"))
                            end = i;

                        Mysort(val, start, end);
                    }else if (val[i].equals("*")){
                        if (i-2>=0 && val[i-2].equals("/"))
                            continue;
                        int start = i;
                        while (i+2 < 2 * n - 1 && val[i].equals("*") && !val[i + 2].equals("+") && !val[i + 2].equals("-")&& !val[i + 2].equals("/")) {
                            i += 2;
                        }
                        int end = i;
                        Mysort(val, start, end);
                    }
                    else if (val[i].equals("/")){

                    }
                }

                System.out.print(val[0]);
                for (int i =1; i<val.length; i++){
                    System.out.print(" "+val[i]);
                }
                System.out.println();
            }
        }
    }

    private static void Mysort(String[] val, int start, int end) {
        List<Integer> list = new ArrayList<>();
        for (int i= start-1; i<= end+1; i+=2){
            list.add(Integer.valueOf(val[i]));
        }

        Collections.sort(list);
        int count =0;
        for (int i = start -1; i<= end+1; i+=2){
            val[i] = String.valueOf(list.get(count));
            count++;
        }
    }
}
