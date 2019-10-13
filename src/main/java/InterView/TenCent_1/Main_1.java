package InterView.TenCent_1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String data = scanner.next();
            if (data.length() ==0){
                System.out.println(data);
                continue;
            }

            char[] array = data.toCharArray();
            List<String> result = new ArrayList<>();

            for (int i=0; i<array.length; i++){
                if (array[i] != '[')
                    result.add(String.valueOf(array[i]));
                else {
                    Stack<Pair> stack = new Stack<>();
                    int count = 1;
                    while (count != 0){
                        ++i;
                        int num = 0;
                        for (;array[i]>='0'&&array[i]<='9';i++){
                            num = num*10 + (array[i]-'0');
                        }

                        StringBuilder temp = new StringBuilder("");
                        for (i= i+1; array[i]!='['&&array[i]!=']'; i++)
                            temp.append(array[i]);
                        if (array[i]=='[')
                            count++;
                        else if (array[i]==']'){
                            for (;i<array.length&&array[i]==']';i++)
                                count--;
                        }

                        stack.push(new Pair(num,temp.toString()));
                    }
                    i--;

                    StringBuilder builder = new StringBuilder("");
                    while (stack.size()!=0){
                        Pair temp = stack.pop();
                        String string = temp.symbol + builder.toString();
                        builder = new StringBuilder("");

                        for (int k=0; k<temp.num; k++){
                            builder.append(string);
                        }
                    }
                    result.add(builder.toString());
                }
            }
            StringBuilder resultString = new StringBuilder("");
            for (int i=0;i<result.size();i++)
                resultString.append(result.get(i));
            System.out.println(resultString);
        }
    }
}
class Pair{
    int num;
    String symbol;
    public Pair(int num, String symbol){
        this.num = num;
        this.symbol = symbol;
    }
}