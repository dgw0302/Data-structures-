package 美团笔试;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Question01 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            items.add(new Item(scan.nextInt(), 0));
        }
        for (int i = 0; i < n; i++) {
            items.get(i).back = scan.nextInt();
        }
        items.sort(Comparator.comparing(item -> item.front));
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Item item : items) {
            countMap.put(item.front, countMap.getOrDefault(item.front, 0) + 1);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < items.size(); i++) {
            int curFront = items.get(i).front;
            int frontCount = countMap.get(curFront);
            int backCount = n / 2 - frontCount;
            int k = backCount;
            for (Item item : items) {
                if (item.front != curFront && item.back == curFront) {
                    k--;
                }
            }
            if (k == 0) {
                min = Math.min(min, backCount);
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
        scan.close();
    }

    public static class Item {
        public int front;
        public int back;

        public Item() {
        }

        public Item(int front, int back) {
            this.front = front;
            this.back = back;
        }
    }




}