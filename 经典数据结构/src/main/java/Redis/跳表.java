package Redis;

public class 跳表 {



    //随机数概率因子
    private static final  double P_FACTOR  = 0.25;
    //最大层数
    private static final int MAX_LEVEL = 32;
    //当前实际有效的最大层数
    private int curLevel;
    //头结点,这个头节点相当于虚拟结点
    Node head;



     class Node {
         int val;
         Node[] next;
         public  Node(int Cval, int Clevel) {
             val = Cval;
             next = new Node[Clevel];
         }

     }

     /*
     用给定规则生成随机数（非静态方法也可以调用静态变量）
      */
     private int randomLevel() {
         //层数level从1开始
         int level = 1;
         while (Math.random() < P_FACTOR && level < MAX_LEVEL) {
             level++;
         }

         return  level;
     }


     public 跳表(){
        curLevel = 0;

        head = new Node(-1, MAX_LEVEL);
     }

    /**
     * 找某一层level中，从左边开始最靠近target结点的左边结点
     */
    private Node findCloest(Node curNode, int level, int target) {

        while (curNode.next[level] != null && curNode.val < target) {
            curNode = curNode.next[level];
        }

        return curNode;
    }

    /*
    search 查找
     */

    private boolean search(int target) {
        Node curNode = head;
        //从当前最高层开始查找
        for(int i = curLevel - 1; i > 0; i--) {
            curNode = findCloest(curNode, i, target);
            //此时curNode是当前层离target结点最近的结点
            if(curNode.next[i] != null && curNode.next[i].val == target) {
                return true;
            }
        }
        return false;
    }


    /*
    add 增加跳表新结点
     */






    private void  add(int num) {

        //生成随机层
        int level = randomLevel();
        //生成新结点
        Node newNode = new Node(num, level);

        Node curNode = head;

        //还是老规矩，从当前最大层开始循环
        for(int i = curLevel - 1; i > 0; i--) {
            //找到要插入的位置
            curNode = findCloest(curNode, i, num);


            if(i < level) {
                if(curNode.next[i] == null) {
                    curNode.next[i] = newNode;
                }else {
                    Node temp = curNode.next[i];
                    curNode.next[i] = newNode;
                    newNode.next[i] = temp;
                }
            }

        }

        if(level > MAX_LEVEL) {
            for(int i = MAX_LEVEL; i < level; i++) {
                head.next[i] = newNode;
            }
            curLevel = level;

        }



    }


















}
