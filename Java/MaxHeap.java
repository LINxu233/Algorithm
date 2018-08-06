/**
 * ClassName MaxHeap
 * Author  Lin
 * Date 2018/8/6 21:27
 **/

public class MaxHeap {
    public static void main(String[] args) {
        int num[] = {1,2,5,12,7,17,25,19,36,99,22,28,46,92};
        heapSort(num,num.length);
        for(int i:num){
            System.out.print(" " + i );
        }

    }
   public static  void heapSort(int[] nums,int n){
        creatHeap(nums,n);
        for(int i = n-1 ; i >= 1 ; i --){
            //交换0和i+1两个位置上的数
            swap(nums,0,i);
            //堆的大小从i+1变成i,并调整堆
            siftDown(nums,0,i);
        }

   }

   public static void swap(int[] nums, int i,int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
   }
    public static void creatHeap(int[] nums,int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(nums, i, nums.length);
        }
    }

    public static void siftUp(int[] nums, int k) {
        if( k == 0 ) return;
        int i = k;
        while(i/2 > 0 ){
            if(nums[i/2] < nums[i])
                swap(nums,i/2,i);
            else
                break;
        }

    }

    public static void siftDown(int[] nums, int k,int n) {
        int i = k;
        int m = 2 * k + 1;
        while (m < n) {
            //int left = nums[m];
            if (m + 1 < n && nums[m + 1] > nums[m]) {
                m = m + 1;
            }
            if(nums[m] > nums[k]){
                swap(nums,m,k);
                k = m;
            }
            else
                break;
        }
    }
}