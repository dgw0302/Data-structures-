package Thread.线程练习题;

public class Test {
    private  static int count = 0;
    private static final Object object = new Object();
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (object) {
                        if(count % 2 == 0) {
                            System.out.println(Thread.currentThread().getName() +"  "+ count++ +"偶数线程");
                        }
                    }
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (object) {
                        if(count % 2 != 0) {
                            System.out.println(Thread.currentThread().getName() + " " + count++ +"奇数线程");
                        }
                    }
                }
            }
        }).start();

    }


    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //先沿斜对角线翻转
        for(int i = 0;i < n;i ++)
            for(int j = 0;j < i;j ++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        //再沿垂直竖线翻转
        for(int i = 0;i < n;i ++)
            for(int j = 0, k = n - 1; j < k ; j++, k--){
                int temp = matrix[i][k];
                matrix[i][k] = matrix[i][j];
                matrix[i][j] = temp;
            }
    }










}
