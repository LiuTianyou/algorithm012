/**
 * @author Liutianyou
 * @date 2020/7/19 8:48 下午
 */
//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
//示例:
//
//输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
//说明:  
//
//1 是丑数。
//n 不超过1690。
//
public class NthUglyNumber {

  public int nthUglyNumber(int n) {
    if (n == 0) {
      return 0;
    }
    int ugly[] = new int[n];
    ugly[0] = 1;
    int p2 = 0, p3 = 0, p5 = 0;

    for (int i = 1; i < n; i++) {
      int lastMax = ugly[i - 1];
      while (lastMax >= ugly[p2] * 2) {
        p2++;
      }
      while (lastMax >= ugly[p3] * 3) {
        p3++;
      }
      while (lastMax >= ugly[p5] * 5) {
        p5++;
      }
      ugly[i] = Math.min(Math.min(ugly[p2] * 2, ugly[p3] * 3), ugly[p5] * 5);
    }
    return ugly[n - 1];
  }
}
