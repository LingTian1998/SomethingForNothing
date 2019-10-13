package InterView.XieChen;

import java.util.Scanner;

public class Main_2 {  //85%
    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static int index;
    static String resolve(String expr) {
        char[] chars = expr.toCharArray();
        int count = 0;
        for (int i=0; i<chars.length; i++){
            if (chars[i] =='(')
                count++;
            if (chars[i] ==')')
                count--;
        }
        if (count!=0)
            return "";  // 这一步就能A掉29%的案例

        StringBuilder builder = new StringBuilder("");
        for (index=0; index<chars.length; index++){
            if (chars[index]=='('){
                builder.append(getString(chars));  //87%
            }else {
                builder.append(chars[index]);  //这一步能a掉28%的案例
            }
        }
        return builder.toString();
    }

    private static String getString(char[] chars) {
        StringBuilder builder = new StringBuilder("");
        for (index=index+1; index<chars.length; index++){
            if (chars[index] =='('){
                builder.append(getString(chars));
            }else if (chars[index]==')'){
                return Reverse(builder.toString());
            } else {
                builder.append(chars[index]);
            }
        }
        return null;
    }

    private static String Reverse(String toString) {
        char[] chars = toString.toCharArray();
        StringBuilder builder = new StringBuilder("");
        for (int i=chars.length-1; i>=0; i--){
            builder.append(chars[i]);
        }
        return builder.toString();
    }

    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}
