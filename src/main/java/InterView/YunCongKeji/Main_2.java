package InterView.YunCongKeji;

import java.util.*;

public class Main_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String data1 = scanner.nextLine();
            String data2 = scanner.nextLine();

            String[] data_1 = data1.subSequence(1,data1.length()-1).toString().split(",");
            String[] data_2 = data2.subSequence(1,data2.length()-1).toString().split(",");

            HashSet<Integer> set_1= new HashSet<>();
            HashSet<Integer> set_2 = new HashSet<>();

            for (int i=0; i<data_1.length; i++){
                int temp = Integer.valueOf(data_1[i]);
                set_1.add(temp);
            }

            for (int i=0; i< data_2.length; i++){
                int temp = Integer.valueOf(data_2[i]);
                set_2.add(temp);
            }

            Set<Integer> temp_set = new HashSet<>();
            temp_set.addAll(set_1);

            temp_set.removeAll(set_2);
            set_1.removeAll(temp_set);

            List<Integer> result = new ArrayList<>();
            result.addAll(set_1);
            Collections.sort(result);

            System.out.print("[");
            int i=0;
            for (; i<result.size()-1; i++){
                System.out.print(result.get(i)+",");
            }
            System.out.println(result.get(i)+"]");
        }
    }
}
