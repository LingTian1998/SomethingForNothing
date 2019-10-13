package InterView.HuaWei.mine;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class test {
    public static void main(String[] args){
       Queue<Character> queue = new LinkedList<>();
       queue.add('H');
       queue.add('i');
       queue.add('!');
       Character i = queue.poll();
       queue.add(i);
       System.out.println(changeQueue_to_String(queue));
    }
    public static String changeQueue_to_String(Queue queue){
        StringBuffer stringBuffer = new StringBuffer("");
        for (Iterator<Character> iterator = queue.iterator(); iterator.hasNext();){
            stringBuffer.append(iterator.next());
        }
        return stringBuffer.toString();
    }
}
