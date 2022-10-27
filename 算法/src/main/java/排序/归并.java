package 排序;


public class 归并 {

    // 非递归方法实现
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int N = arr.length;
        int mergeSize = 1;
        while (mergeSize < N) {
            int L = 0;

            while (L < N){
                int M = L + mergeSize - 1;
                //左边数不齐mergeSize,这种情况也是发生在最后，不管，因为已经有序
                if(M >= N) break;
                //右边数不齐，这种情况只能是最后
                int R = Math.min(M + mergeSize, N -1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            if(mergeSize > (N / 2)) break;
            mergeSize <<= 1;
        }

    }


    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int p1 = L, p2 = M + 1;
        int i = 0;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        //要么p1越界，要么p2越界
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }

        while (p2 <= M) {
            help[i++] = arr[p2++];
        }

        //copy
        for(i = 0; i< help.length; i++) {
            arr[L + i] = help[i];
        }


    }








}
