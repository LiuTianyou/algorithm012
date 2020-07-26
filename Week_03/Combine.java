import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//77. 组合
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
//示例:
//
//输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]

/**
 * @author Liutianyou
 * @date 2020/7/26 10:24 下午
 */
public class Combine {



    public static List<List<Integer>> combine(int n, int k) {
      List<List<Integer>> ans = new LinkedList();
      int[] array = new int[n];
      for(int i =0;i<n;i++){
        array[i]=i+1;
      }
      loop(0,k,new LinkedList<Integer>(),ans,array);
      return ans;
    }
    public static void loop(Integer index,Integer k,LinkedList<Integer> list,List<List<Integer>> ans,int[] array){
      if(list.size()==k){
        ans.add(new ArrayList(list));
        return;
      }
      for(int i=index;i<array.length; i++){
        list.add(array[i]);
        loop(i+1,k,list,ans,array);
        list.pollLast();
      }
  }

  public static void main(String[] args) {
    List<List<Integer>> combine = combine(4, 2);
    System.out.println(combine);

  }

}
