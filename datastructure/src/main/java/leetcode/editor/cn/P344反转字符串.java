//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。 
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。 
//
// 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。 
//
// 
//
// 示例 1： 
//
// 输入：["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
// 
//
// 示例 2： 
//
// 输入：["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"] 
// Related Topics 双指针 字符串 
// 👍 329 👎 0


package leetcode.editor.cn;

//Java：反转字符串
public class P344反转字符串 {

    public static void main(String[] args) {
        Solution solution = new P344反转字符串().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void reverseString(char[] s) {
            if (s == null || s.length <= 1){
                return;
            }
            method1(s);
        }

        private void method1(char[] s) {
            //首先找到中间值
            int left = 0 ;
            int right = s.length-1;
            int mid = left +(right-left)/2;
            //如果长度是奇数比如123，这个mid就是2的下标，如果是偶数比如1234，这个mid就是中间两位第一位2的下标
            while (left<mid){
                //交换左右两边的值
                char tmp = s[left];
                s[left++] = s[right];
                s[right--] = tmp;
            }
            if (right == mid+1){
                //这种情况说明长度是偶数，交换mid和right
                char tmp = s[mid];
                s[mid] = s[right];
                s[right] = tmp;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
