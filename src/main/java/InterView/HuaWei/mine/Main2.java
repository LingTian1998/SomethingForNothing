package InterView.HuaWei.mine;

import java.util.*;

public class Main2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String source_string_1 = scanner.nextLine();
            String target_string_1 = scanner.nextLine();
            String source_string_2 = scanner.nextLine();
            String target_string_2 = scanner.nextLine();
            String source_string_3 = scanner.nextLine();
            String target_string_3 = scanner.nextLine();

            StringBuffer stringBuffer = new StringBuffer("");
            stringBuffer.append(Solution(source_string_1,target_string_1));
            stringBuffer.append(Solution(source_string_2,target_string_2));
            stringBuffer.append(Solution(source_string_3,target_string_3));
            System.out.print(stringBuffer.toString());
        }
    }

    public static int Solution(String source_string, String  target_string){
        Queue<Character> queue = new LinkedList<>();
        char[] chars = source_string.toCharArray();

        for (int i=0; i< chars.length; i++){
            queue.add(chars[i]);
        }

        int flag = 0;  //0 不结束   1 正常循环结束  2 有解 结束
        boolean result = false;
        while (flag==0){
            Character temp = queue.poll();
            queue.add(temp);
            String tempString = changeQueue_to_String(queue);
            if (tempString.contains(target_string)){
                result = true;
                flag = 2;
            }

            if (source_string.equals(tempString)){
                flag = 1;
            }
        }

        if (result==false&&flag==1)
            return 0;
        else
            return 1;
    }

    public static String changeQueue_to_String(Queue queue){
        StringBuffer stringBuffer = new StringBuffer("");
        for (Iterator<Character> iterator = queue.iterator(); iterator.hasNext();){
            stringBuffer.append(iterator.next());
        }
        return stringBuffer.toString();
    }
}
