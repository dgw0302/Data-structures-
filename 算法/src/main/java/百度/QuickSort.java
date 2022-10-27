package main.java.百度;

public class QuickSort {

    public static void main(String[] args) {

        int[] nums = new int[] {2,3,8,1,6};
    //    quickSort(nums, 0, nums.length - 1);
        dui(nums);
        for(int num : nums) {
            System.out.println(num);
        }

    }

    public static void dui(int[] nums) {

        for(int i = nums.length - 1; i >= 0; i--) {
            heapfiy(nums, i,nums.length);
        }
        int heapSize = nums.length;

        swap(nums, 0, --heapSize);
        while (heapSize > 0) {
          // O(logN)
            heapfiy(nums, 0, heapSize);
            swap(nums, 0, --heapSize);
        }



    }


    public static void heapfiy(int[] nums, int index, int heapSize) {
//        if (nums == null || nums.length < 2) {
//            return;
//        }

        int left = 2 * index + 1 ;
        while (left < heapSize) {
            int lagretIndex = left + 1 < heapSize && nums[left] < nums[left + 1] ? left + 1: left;
            //int lagretIndex = left + 1 < heapSize && nums[left] > nums[left + 1] ? left: left + 1;

            lagretIndex = nums[index] > nums[lagretIndex] ? index : lagretIndex;
            if(lagretIndex == index) break;

            swap(nums, lagretIndex, index);
            index = lagretIndex;
            left = 2  * index + 1;
        }
    }
//    public static void heapfiy(int[] arr, int index, int heapSize) {
//        int left = index * 2 + 1; // 左孩子的下标
//        while (left < heapSize) { // 下方还有孩子的时候
//            // 两个孩子中，谁的值大，把下标给largest
//            // 1）只有左孩子，left -> largest
//            // 2) 同时有左孩子和右孩子，右孩子的值<= 左孩子的值，left -> largest
//            // 3) 同时有左孩子和右孩子并且右孩子的值> 左孩子 的值， right -> largest
//            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
//            // 父和较大的孩子之间，谁的值大，把下标给largest
//            largest = arr[largest] > arr[index] ? largest : index;
//            if (largest == index) {
//                break;
//            }
//            swap(arr, largest, index);
//            index = largest;
//            left = index * 2 + 1;
//        }
//    }







    public static void quickSort(int[] nums, int left, int right) {
        if(left >= right) return;
        int privot = left;
        int i = left, j = right;

        while(i < j) {
            while (i < j && nums[j] >= nums[privot]) j--;
            while (i < j && nums[i] <= nums[privot]) i++;
            swap(nums, i, j);
        }
        swap(nums, privot, i);

        quickSort(nums,left, j - 1);
        quickSort(nums, j + 1, right);

    }
    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
