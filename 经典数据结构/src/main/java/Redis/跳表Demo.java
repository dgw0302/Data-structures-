package Redis;

public class 跳表Demo {

    class Node{
        int val;
        //当前结点，每一层指向的下一个结点。
        Node[] next;
        public Node(int val, int level) {
            this.val = val;
            this.next = new Node[level];
        }
    }


    //随机数概率因子
    private static final double gailv = 0.25;

    //最大层数
    private static final int MAX_LEVEL = 32;

    //当前实际有效的最大层数
    private int curLevel;

    //头节点
    Node head;

    //生成随机层
    private int randomLevel() {
        int level = 0;//从1开始
        while (Math.random() < gailv && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }


    public 跳表Demo() {
        curLevel = 0;
        head = new Node(-1, MAX_LEVEL);
    }



    //从当前结点开始，寻找level层最靠近target的结点

    public static Node findCloset(Node curNode, int level, int target) {

        while(curNode.next[level] != null && curNode.next[level].val < target) {
            curNode = curNode.next[level];
        }
        return curNode;
    }


    public boolean search(int target) {

        Node curNode = head;

        for(int i = curLevel - 1; i >= 0; i--) {
            curNode = findCloset(curNode, i, target);
            if(curNode.next[i] != null && curNode.next[i].val == target) {
                return true;
            }
        }

        return false;

    }


    public void add(int num) {

        int level = randomLevel();
        Node newNode = new Node(num, level);
        Node curNode = head;
        for(int i = curLevel - 1; i >= 0; i--) {
            Node leftNode = findCloset(curNode, i, num);

          //如果新的level小于当前最大level,那等i < level再插入，比较是从当前最大层开始插入的。
          //如果新的level大于当前最大Level,那么先处理i层以及i层以下的，大于的部分单独处理

          if(i < level) {
              if(leftNode.next[i] != null) {
                  Node temp = leftNode.next[i];
                  leftNode.next[i] = newNode;
                  newNode.next[i] = temp;
              } else {
                  leftNode.next[i] = newNode;
              }
          }
        }


        if(level > curLevel) {

            for(int i = curLevel; i < level; i++) {
                head.next[i] = newNode;
            }
            curLevel = level;
        }




    }



}
