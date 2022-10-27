package Redis;

public class 跳表练习 {



    static class Node {
        int val;
        int level;
        Node[] next;
        public Node(int val, int level) {
            this.val = val;
            this.level = level;
            next = new Node[level];
        }
    }

    //当前实际有效的最大层数
    private static int curlevel;

    private static  int maxLevel = 32;

    static Node head;

    public 跳表练习() {
        curlevel = 0;
        head = new Node(-1, 32);
    }


    //找当前层,小于等于target的，最靠近target的左边元素

    public static   Node find(Node curnode, int level, int target) {

        while(curnode.next[level] != null && curnode.val <= target) {
            curnode = curnode.next[level];
        }

        return curnode;

    }

    public static boolean search(int target) {


        Node curNode = head;

        for(int i = curlevel - 1; i >= 0; i--) {

            Node findlost = find(curNode, i, target);

            if(findlost.next[i] != null && findlost.next[i].val == target) {
                return true;
            }
        }

        return false;
    }
    public static void insert(int target, int level) {

        Node curNode = head;
        Node newNode = new Node(target, level);

        for(int i = curlevel - 1; i >= 0; i--) {

            Node findclostNode = find(curNode, i, target);

            if(i < level) {
                    if(findclostNode.next[i] == null) {
                        findclostNode.next[i] = newNode;
                    } else {

                        Node temp = findclostNode.next[i];
                        findclostNode.next[i] = newNode;
                        newNode.next[i] = temp;
                    }
            }
        }

        if(level > maxLevel) {
            for(int i = level - 1; i >= maxLevel; i--) {
                head.next[i] = newNode;
            }

            curlevel = level;
        }


    }





}
