package InterView.XIaoMi;

import java.util.Scanner;

public class Main_2 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int i;
    static String solution(String input) {
        if (input.equals(""))
            return "";
        if (input.length()==1)
            return input;

        char[] data = input.toCharArray();
        i = 0;
        return solve(data);
    }
    public static String solve(char[] data){
        StringBuilder root = new StringBuilder("");
        StringBuilder left = new StringBuilder("");
        StringBuilder right = new StringBuilder("");
        int count =0;
        for ( ;i<data.length; i++){
            if (data[i]=='('){
                count++;
                int j=i-1;
                for (; j>=0&&data[j]!='('&&data[j]!=',';j--);
                if (j<0)
                    j=0;
                for (; j<i; j++)
                    root.append(data[j]);

                j=i+1;
                boolean flag = false;
                for (;j<data.length&&data[j]!=',';j++){
                    if (data[j]=='('){
                        flag = true;
                        break;
                    }
                }
                if (flag){
                    for (;i<data.length;i++)
                        if (data[i]=='(')
                            left.append(solve(data));
                }
                else {
                    for (;i<data.length&&data[i]!=',';i++)
                        left.append(data[i]);
                }
            }
            if (data[i]==','){
                int j=i+1;
                boolean flag = false;
                for (;j<data.length;j++)
                    if (data[j]=='(') {
                        flag = true;
                        break;
                    }
                if (!flag) {
                    for (; i < data.length && data[i] != ')'; i++)
                        right.append(data[i]);
                }
                else {
                    for (; i < data.length && data[i] != ')'; i++)
                        if (data[i]=='(')
                            right.append(data[i]);
                }
            }
            if (data[i]==')')
                count--;
            if (count==0)
                return left.append(root).append(right).toString();
        }
        return left.append(root).append(right).toString();
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }

        res = solution(_input);
        System.out.println(res);
    }
}
