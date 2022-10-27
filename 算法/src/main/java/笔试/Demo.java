package main.java.笔试;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode jiou(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;


        ListNode ji = head;

        ListNode ou = head.next;

        ListNode ouHead = ou;

        while(ou != null && ou.next != null) {
             ji.next = ou.next;
             ji = ji.next;
             ou.next = ji.next;
             ou = ou.next;
        }

        ji.next = ouHead;
        return dummy.next;


  }




    public static void main(String[] args) {






    }







}
