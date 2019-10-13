package InterView.XiaoHongShu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String data = scanner.nextLine();
            char[] chars = data.toCharArray();

            List<Character> queue = new ArrayList<>();
            int count = 0;
            for (int i=0; i<chars.length; i++){
                if (count==0&&chars[i]>='a'&&chars[i]<='z' || chars[i]>='A'&&chars[i]<='Z')
                    queue.add(chars[i]);

                if (count==0&&chars[i]=='<' && queue.size()!=0)
                    queue.remove(queue.size()-1);

                if (chars[i]=='(')
                    count++;
                if (chars[i]==')')
                    count--;
            }

            StringBuilder builder = new StringBuilder("");
            for (int i=0; i<queue.size(); i++){
                builder.append(queue.get(i));
            }
            System.out.println(builder.toString());
        }
    }
}
