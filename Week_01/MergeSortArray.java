/**
 * @author Liutianyou
 * @date 2020/7/12 8:49 下午
 */

//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
//
//
// 说明:
//
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//
//
//
//
// 示例:
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6]
// Related Topics 数组 双指针

public class MergeSortArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
      if (m == 0 && n != 0) {
        //nums1为空 且 nums2 不为空，将nums2 拷贝进nums1
          System.arraycopy(nums2, 0, nums1, 0, n);
          return;
      }
      //nums2 为空不需要任何操作
      if (n <= 0) {
        return;
      }
      //当前写入数据的位置
      int lastIndex = m + n - 1;
      m--;
      n--;
      while (n >= 0) {
        //数据从后面开始向前合并，当前位置始终写入较大的元素
        //数组1的下标 m的 元素大于数组2 小标为n的元素,当前位置写入 nums1[m];
        if (m >= 0 && nums1[m] >= nums2[n]) {
          nums1[lastIndex--] = nums1[m--];
        } else {
          nums1[lastIndex--] = nums2[n--];
        }
      }
    }
}
