package 链表;
class Node{
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
    public Node() {}


}

class List {
    Node head;
    Node tail;

    public List() {}


    public void add(Node node) {
        if(this.tail == null) {
            this.head = node;
            this.tail = node;
            return;
        }
        this.tail.next = node;
        this.tail = node;
    }


    public boolean delete(int  val) {
        Node pre = new Node();
        pre.next = head;
        Node cur = pre.next;

        while(cur != null) {
            if(cur.val == val) {
                pre.next = cur.next;
                //  cur.next = null;
                return true;
            }
            pre = pre.next;
            cur = cur.next;
        }


        return false;
    }

    public Node find(int val) {

        Node cur = head;

        while(cur != null) {
            if(cur.val == val) {
                return cur;
            }
            cur = cur.next;
        }

        return null;
    }

    public boolean update(int val, int newVal) {
        Node node = find(val);
        if(node != null) {
            node.val = newVal;
            return true;
        }
        return false;
    }

    public void print() {
        Node cur = head;

        while(cur != null) {
            System.out.print(cur.val);
            cur = cur.next;
        }
    }


}

public class Main {
    public static void main(String[] args) {
        List list = new List();

      //  Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 5; i++) {
            Node temp = new Node(i + 1);
            list.add(temp);
        }

        list.print();
        System.out.print(" ");

        list.update(2, 8);
        list.print();
        System.out.print(" ");

        Node res = list.find(8);
        System.out.print(res.val);


        System.out.print(" ");

        //list.print();

        boolean res2 = list.delete(8);
        System.out.print(" ");
        list.print();


    }



}
