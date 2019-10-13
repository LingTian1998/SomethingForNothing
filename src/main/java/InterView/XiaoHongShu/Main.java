package InterView.XiaoHongShu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] map = new int[n][m];
            for (int i=0; i<k; i++){
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                map[x][y] = 1;
            }

            List<List<String>> result = new ArrayList<>();

            List<String> startList = new ArrayList<>();
            startList.add("("+0+","+0+")");
            result.add(startList);
            int last_size = -1;
            int size = -1;
            while (size!=last_size){
                last_size = result.size();

                List<List<String>> temp = new ArrayList<>();
                temp.addAll(result);
                result.clear();

                for (int i=0; i<temp.size(); i++){
                    List<String> temp_way = new ArrayList<>();

                }
            }
        }
    }
}