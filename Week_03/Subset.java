/**
 * @author Liutianyou
 * @date 2020/7/26 10:46 下午
 */
//78. 子集
//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
//说明：解集不能包含重复的子集。
//
//示例:
//
//输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]

import java.util.*;
public class Subset {
    public  static List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> ans = new ArrayList();
      List<Integer> tem  = new ArrayList();
      ans.add(tem);
      for(int i=0;i<nums.length;i++){
        //遍历之前的结果集。复制一份并且加入当前元素，然后 加入到结果集
        int size = ans.size();
        for(int j=0;j<size;j++){
          tem = new ArrayList();
          tem.addAll(ans.get(j));
          tem.add(nums[i]);
          ans.add(tem);
        }
      }
      return ans;
    }


  public static void main(String[] args) {
    int[] nums = new int[]{1,2,3};
    List<List<Integer>> subsets = subsets(nums);
    System.out.println(subsets);

  }

}
