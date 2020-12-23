//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 172 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：最小的k个数
public class P剑指 Offer 40最小的k个数{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 40最小的k个数().new Solution();
        // TO TEST
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数(快排法解决问题)
        return quickSort(arr, 0, arr.length - 1, k - 1);

    }

    private int[] quickSort(int[] arr, int start, int end, int k) {
        //得到j，j左边的比j对应元素小，右边的比j对应元素大
        int j = partition(arr, start, end);
        //j刚好等于k就返回j及其左边元素
        if (j == k) {
            return Arrays.copyOf(arr, j + 1);
        }
        //否则根据j和k的关系判断继续拆分左边还是右边
        return j > k ? quickSort(arr, start, j - 1, k) : quickSort(arr, j + 1, end, k);
    }

    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    private int partition(int[] arr, int start, int end) {
        //初始化最开始的基准元素
        int base = arr[start];
        int i = start;//负责寻找小于基准的元素
        int j = end + 1;//负责寻找大于基准的元素
        /*while (i<j) {
            while (++i <= end && arr[i] >= base) {
                while (--j >= start && arr[j] <= base) {
                    if (i >= j) {
                        break;
                    }
                    //找到第一个大于和小于base的值之后交换两者的值
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }*/
        while (true) {
            while (++i <= end && arr[i] < base) {
                ;
            }

            while (--j >= start && arr[j] > base) {
                ;
            }
            if (i >= j) {
                break;
            }
            //找到第一个大于和小于base的值之后交换两者的值
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        //跳出循环之后，base与j下标位置的数字进行交换
        arr[start] = arr[j];
        arr[j] = base;
        return j;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
