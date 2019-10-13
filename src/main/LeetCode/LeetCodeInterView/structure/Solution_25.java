package structure;

public class Solution_25 {
    ListNode head = null;

    public Solution_25() {
    }

    public void push(int x) {
        if (head == null){
            head = new ListNode();
            Element element = new Element(x,x);
            head.val = element;
        }else {
            int min = Math.min(x,head.val.min_before);
            Element element = new Element(x,min);
            ListNode listNode = new ListNode();
            listNode.val = element;
            listNode.next = head;
            head = listNode;
        }
    }

    public void pop() {
        if (head == null){
            throw new RuntimeException();
        }
        else
            head = head.next;
    }

    public int top() {
        return head.val.val;
    }

    public int getMin() {
        return head.val.min_before;
    }
}
class Element{
    int val;
    int min_before;
    public Element(int val,int min_before){
        this.val = val;
        this.min_before = min_before;
    }
}
class ListNode{
    Element val;
    ListNode next;
}