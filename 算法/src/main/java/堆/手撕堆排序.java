package main.java.堆;

public class 手撕堆排序 {

    public static void main(String[] args) {

        int[] nums = new int[] {2,6,8,5,3,6,7,9,4,1};

        for(int i = nums.length -1; i >= 0; i--) {
            heapify(nums, i, nums.length);
        }

        int heapSize = nums.length;

        swap(nums, 0, --heapSize);

        while (heapSize > 0) {
            heapify(nums, 0, heapSize); // O(logN)
            swap(nums, 0, --heapSize);
        }
        for (int x : nums) {
            System.out.println(x);
        }

    }
    public static void heapify(int[] nums, int index, int heapSize) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int left = index * 2 + 1;

        while(left < heapSize) {

           // int largest = left + 1 < heapSize && nums[left] > nums[left + 1] ? left : left + 1;
            int largest = left + 1 < heapSize && nums[left + 1] > nums[left] ? left + 1 : left;
            largest = nums[index] > nums[largest] ? index : largest;

            if(largest == index) {break;}

            swap(nums, largest, index);
            index = largest;
            left = index * 2 + 1;
        }


    }


    public static  void  swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
