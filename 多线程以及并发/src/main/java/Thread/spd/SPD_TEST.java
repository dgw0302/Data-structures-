//package Thread.spd;
//
//import java.util.concurrent.Semaphore;
//
//public class SPD_TEST {
//
//    static Semaphore[][] semaphores;
//
//    public static Thread[] AOEThreads(float[][] matrix) {
//        int v = 0;
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (matrix[i][j] != 0 && matrix[i][j] != Float.POSITIVE_INFINITY) {
//                    v++;
//                    semaphores[i][j] = new Semaphore(0);
//                }
//            }
//        }
//        Thread[] threads = new Thread[v];
//        int index = 0;
//
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; i++) {
//                if (semaphores[i][j] == null) continue;
//                int x = i;
//                int y = j;
//                 float f = matrix[x][y];
//
//                threads[index++] = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            for (int k = 0; k < semaphores.length; k++) {
//                                if (semaphores[k][x] != null) {
//                                    semaphores[k][x].acquire();
//                                }
//                            }
//                            System.out.println(Thread.currentThread().getName() + "开始执行");
//                            Thread.currentThread().sleep((int) f * 2000);
//                            System.out.println(Thread.currentThread().getName() + "执行了" + f + "妙后执行完毕");
//                            for (int k = 0; k < semaphores.length; k++) {
//                                if (semaphores[x][k] != null) {
//                                    semaphores[x][k].release();
//                                }
//                            }
//
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, "vertex[" + x + "][" + y + "]");
//            }
//        }
//        return threads;
//    }
//
//    public static void main(String[] args) {
//        float[][] mar = new float[][]{{0, 3, 2, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY},
//                {Float.POSITIVE_INFINITY, 0, Float.POSITIVE_INFINITY, 2, 3, Float.POSITIVE_INFINITY},
//                {Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, 0, Float.POSITIVE_INFINITY, 2},
//                {Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, 0, 2},
//                {Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, 0}
//        };
//        Thread[] threads = AOEThreads(mar);
//        for (Thread thread : threads) {
//            thread.start();
//        }
//    }
//
//}
