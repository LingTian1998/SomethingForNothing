package InterView.Ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int n = Integer.parseInt(line);
        int[][] area = new int[n][n];

        for (int i = 0; i < n; i++) {
            line = scanner.nextLine();
            String[] split = line.split(",");
            if (split.length != n) {
                throw new IllegalArgumentException("错误输入");
            }
            int j = 0;
            for (String num : split) {
                area[i][j++] = Integer.parseInt(num);
            }
        }

        int minimumTimeCost = getMinimumTimeCost(n,area);
        System.out.println(minimumTimeCost);
    }

    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    private static int getMinimumTimeCost(int n, int[][] area) {
        int min = Integer.MAX_VALUE;
        for (int j=0; j<area[0].length; j++)
        {
            List<Integer> way = new ArrayList<>();
            way.add(j);
            int temp = solve(0, j , area,way, 0);
            if (temp>=0 && temp < min)
                min = temp;
        }
        return min;
    }

    private static int solve(int i,int j, int[][] area, List<Integer> Way, int time) {

        int left = 101;
        int right = 101;
        int down = 101;

        if (j-1>=0 )
            left = area[i][j-1];

        if (j+1<area[i].length)
            right = area[i][j+1];

        if (i+1 < area.length)
            down = area[i+1][j];

        int min = Integer.MAX_VALUE;
        if (left<= right && left <= down){
            List<Integer> cur = new ArrayList<>();
            cur.addAll(Way);
            int index_1 = i*area.length + j-1;
            int index_2 = i*area.length + j-2;
            if (cur.contains(index_1))
                return Integer.MIN_VALUE;
            cur.add(index_1);
            cur.add(index_2);

            if (j-2 < 0)
                return  Integer.MIN_VALUE;
            int temp = solve(i, j-2, area, cur, time+left);
            if (temp >=0 && temp< min)
                min = temp;
        }

        if (right<= left && right <= down){
            List<Integer> cur = new ArrayList<>();
            cur.addAll(Way);
            int index_1 = i*area.length + j+1;
            int index_2 = i*area.length + j+2;
            if (cur.contains(index_1))
                return Integer.MIN_VALUE;
            cur.add(index_1);
            cur.add(index_2);

            if (j+2>=area.length)
                return Integer.MIN_VALUE;
            int temp = solve(i, j+2,area, cur, time+right);
            if (temp >=0 && temp< min)
                min = temp;
        }

        if (down<= right&& down <= left){
            List<Integer> cur = new ArrayList<>();
            cur.addAll(Way);
            int index_1 = (i+1)*area.length + j;
            int index_2 = (i+2)*area.length + j;
            if (cur.contains(index_1))
                return Integer.MIN_VALUE;
            cur.add(index_1);
            cur.add(index_2);
            if (i+1 == area.length - 1)
                return time + area[i+1][j];
            if (i+2 == area.length - 1)
                return time + area[i+2][j];
            int temp = solve(i+2, j,area, cur, time+down);
            if (temp >=0 && temp< min)
                min = temp;
        }

        return min;
    }
}
