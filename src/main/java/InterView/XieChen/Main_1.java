package InterView.XieChen;

import java.util.Scanner;

public class Main_1 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static ListNode partition(ListNode head,int m) {
        if (head ==null)
            return head;
        if (head.next==null)
            return head;

        boolean flag = false;
        for (ListNode listNode = head; listNode!=null; listNode = listNode.next){
            if(listNode.val < m)
                flag = true;
        }
        if (!flag)
            return head;

        ListNode temp = null;
        ListNode temp_pre = null;
        ListNode listNode_pre = null;
        if (head.val>m){
            temp = head;
            ListNode newHead = null;
            for (ListNode listNode = head; listNode !=null; listNode = listNode.next){
                if (listNode.val <= m){
                    listNode_pre.next = listNode.next;
                    newHead = listNode;
                    newHead.next = head;
                    head = newHead;
                }
                listNode_pre = listNode;
            }

            return head;
        }
        for (ListNode listNode = head; listNode!= null;listNode = listNode.next){
            if (temp!=null)
                temp_pre = listNode;

            if (listNode.val > m)
                temp = listNode;
            else if (listNode.val <= m && temp!=null){
                ListNode target = listNode;
                listNode_pre.next = target.next;
                listNode = listNode_pre;

                target.next = temp;
                temp_pre.next = target;
                temp_pre = temp_pre.next;
            }

            listNode_pre = listNode;
        }
        return head;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode head=null;
        ListNode node=null;
        int m=in.nextInt();
        while(in.hasNextInt()){
            int v=in.nextInt();
            if(head==null){
                node=new ListNode(v);
                head=node;
            }else{
                node.next=new ListNode(v);
                node=node.next;
            }
        }
        head= partition(head,m);
        if(head!=null){
            System.out.print(head.val);
            head=head.next;
            while(head!=null){
                System.out.print(",");
                System.out.print(head.val);
                head=head.next;
            }
        }
        System.out.println();
    }
}
