package 实现一个阻塞队列;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 阻塞队列 {



    Deque<Integer> queue = new ArrayDeque<>();

    Lock lock = new ReentrantLock();
    Condition notEmpty = lock.newCondition();
    Condition notFull = lock.newCondition();

    public Object poll() {


        lock.lock();

        try {

            while (queue.isEmpty()) {
                notEmpty.await();
            }

            Object res = queue.pollFirst();
            notFull.signal();

            return res;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            lock.unlock();
        }

        return null;
    }


}
