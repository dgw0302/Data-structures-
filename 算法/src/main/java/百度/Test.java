package main.java.百度;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        this.val = x;
    }
}

class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) {
        this.val = x;
    }
}
public class Test {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(3);
//
//        System.out.println(isJ(root.left, root.right));

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode newHead = xuan(head, 2);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }


        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        map.put(1,3);

    }

    /**
     * 判断二叉树是否镜像
     */

    public static boolean isJ(TreeNode left, TreeNode right) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(left);
        queue.offer(right);
        while(!queue.isEmpty()) {
            TreeNode l1 = queue.poll();
            TreeNode l2 = queue.poll();
            if(l1 == null && l2 == null) continue;
            if((l1 == null || l2 == null) || (l1.val != l2.val)) return false;

            queue.offer(l1.left);
            queue.offer(l2.right);

            queue.offer(l1.right);
            queue.offer(l2.left);
        }
        return true;
    }

    //head 旋转链表 向右移动k个位置， K = 2，1 2 3 4 5               4 5 1 2 3

    public static ListNode xuan(ListNode head, int k) {
        if(head == null || head.next == null) return  head;
        int len = 1;
        ListNode cur = head;
        while(cur.next != null) {
            cur = cur.next;
            len++;
        }
        //链表成环
        cur.next = head;
        //找到倒数第K + 1个结点
        int count =  len - k % len;

        for(int i = 0; i < count; i++) {
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        return newHead;
    }



    //用户信息 --浏览帖子 发布帖子
    //用户 和用户之间关注


    /**
     *
     *
     *
     *      用户信息表 （userid）
     *     浏览表 (userid(哪个用户浏览) 帖子id（浏览过的帖子，哪个帖子） )
     *     发布表 (userid（哪个用户）  帖子id )
     *     关注 { userid1(userid2,useri3), userid2(userid1, userid3)  }
     *
     *
     *
     *     selct  帖子id from 发布表  where userid in   ( select 关注userID from 关注表  where userid = id; )
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */















}
