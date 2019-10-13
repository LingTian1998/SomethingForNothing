package InterView.WangYi;

import java.util.*;

public class Main3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i=0; i<n; i++){
                array[i] = scanner.nextInt();
            }

            for (int i=0; i<n; i++){
                boolean flag = true;
                while (flag) {
                    ArrayList<container> temp = new ArrayList<>();
                    for (int j = i + 1; j < n; j++) {
                        boolean result = isGreater(array[i], array[j]);
                        if (result) {
                            temp.add(new container(String.valueOf(array[j]), j));
                        }
                    }

                    if (temp.size() == 0){
                        flag = false;
                    }
                    else {
                        Collections.sort(temp, new Comparator<container>() {
                            @Override
                            public int compare(container o1, container o2) {
                                return o1.value.compareTo(o2.value);
                            }
                        });
                        int index = temp.get(0).index;
                        swap(array, i, index);
                    }
                }
            }

            for (int i=0; i<n-1 ; i++){
                System.out.print(array[i]+" ");
            }

            System.out.println(array[n-1]);
        }
    }

    private static void swap(int[] array, int i, int index) {
        int temp = array[i];
        array[i] = array[index];
        array[index] = temp;
    }

    //大于返回true
    private static boolean isGreater(int i, int j) {
        int sum = i+j;
        if (sum %2 ==0)
            return false;
        if (String.valueOf(i).compareTo(String.valueOf(j))>0){
            return true;
        }
        return false;
    }
}
class container{
    String value;
    int index;
    public container(String value, int index){
        this.index =index;
        this.value = value;
    }
}