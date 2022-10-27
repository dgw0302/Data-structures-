package 堆;

public class 堆排序 {

    public static void main(String[] args) {
        int[] a = new int[]{2,6,45,8,6};
        heapSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }


//

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // O(N*logN)
//		for (int i = 0; i < arr.length; i++) { // O(N)//经典堆排序
//			heapInsert(arr, i); // O(logN)//从上往下建堆
//		}
        for (int i = arr.length - 1; i >= 0; i--) {//优化
            heapify(arr, i, arr.length);//从下往上建堆
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        // O(N*logN)
        while (heapSize > 0) { // O(N)
            heapify(arr, 0, heapSize); // O(logN)
            swap(arr, 0, --heapSize); // O(1)
        }
    }


    // arr[index]刚来的数，往上

    //这个也就说是构建大根堆
//    public static void heapInsert(int[] arr, int index) {
//        while (arr[index] > arr[(index - 1) / 2]) {//大于父结点
//            swap(arr, index, (index - 1) / 2); //就交换，然后，不断网上看是否大于父结点
//            index = (index - 1) / 2;
//        }
//    }

    // arr[index]位置的数，能否往下移动
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1; // 左孩子的下标
        while (left < heapSize) { // 下方还有孩子的时候
            // 两个孩子中，谁的值大，把下标给largest
            // 1）只有左孩子，left -> largest
            // 2) 同时有左孩子和右孩子，右孩子的值<= 左孩子的值，left -> largest
            // 3) 同时有左孩子和右孩子并且右孩子的值> 左孩子 的值， right -> largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            // 父和较大的孩子之间，谁的值大，把下标给largest
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }









}
