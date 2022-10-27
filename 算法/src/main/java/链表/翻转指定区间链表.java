package 链表;

class Node{
    int val;
    Node next;
    public Node(int val){
        this.val = val;
    }
    public Node(){}
}

public class 翻转指定区间链表 {

    //给定头结点，和left 和right 翻转left与right之间的结点、
    public static Node reverse2(Node head,int left, int right) {

        Node temp = head;
        for(int i = 0; i < left - 1; i++) {
            temp = temp.next;
        }
        Node cur = temp;
        Node pre = null;

        for(int j = 0; j < right - left; j++) {
            pre = cur;
            cur = cur.next;
            pre.next = temp.next;
            temp.next = pre;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next = new Node(5);
        head.next.next.next.next = null;

        reverse2(head,3,5);
    //   Node t =head;
        //while (t!= null) {
            System.out.println(head.next.next.next.val);
           // t = t.next;
        //}

    }

}
