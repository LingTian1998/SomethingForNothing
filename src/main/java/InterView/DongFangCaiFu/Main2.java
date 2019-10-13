package InterView.DongFangCaiFu;

import java.util.*;

public class Main2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i=0; i<n; i++){
                array[i] = scanner.nextInt();
            }

            if (n==2){
                if (array[1]-array[0]<0){
                    System.out.println(0);
                    return;
                }else{
                    System.out.println(array[1]-array[0]);
                    return;
                }
            }

            List<Integer> list = new ArrayList<>();

            int last = 0;
            for (int i=0; i<n; i++){
                int j = i+1;
                for (;j<n; j++){
                    int temp = array[j] - array[i];
                    if (temp>last)
                        last = temp;
                    else
                        break;
                }
                i=j-1;
                list.add(last);
                last=0;
            }

            Collections.sort(list);

            int sum;
            if (list.size()>=2) {
                sum = list.get(list.size() - 1) + list.get(list.size() - 2);
            }
            else
                sum = list.get(0);

            System.out.println(sum);
        }
    }
}
