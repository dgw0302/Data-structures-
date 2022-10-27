package lc额外算法题;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 会议室2 {

    /**
     *
     *
     *给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],…] (si < ei)，为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
     *
     *输入: [[0, 30],[5, 10],[15, 20]]
     * 输出: 2
     * 示例 2:
     *
     * 输入: [[7,10],[2,4]]
     * 输出: 1
     *
     *
     * @param
     */

    public static int huiyishi(int[][] intervals) {
        //先考虑特殊情况
        if(intervals == null || intervals.length == 0) return 0;
        //优先队列、最小堆，存放的是正在进行会议的结束时间
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        //数组排序,数组的每个元素是一个一维数组
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        int res = 0;

        //记住，堆里面维护的是同时开始进行的会议
        for(int[] temp : intervals) {
            //如果，当前会议的开始时间大于堆内最早结束的会议，那么就把当前会议开始前以及结束了的会议全都清除了。
            //也就是清除与当前会议的时间段没有交集的会议
            while(!queue.isEmpty() && queue.peek() <= temp[0]) {
                queue.poll();
            }

            //把当前会议的结束时间添加到堆里面，重写开始维护更新字段值
            queue.offer(temp[1]);


            res = Math.max(res, queue.size());
        }
        return res;

    }

}
