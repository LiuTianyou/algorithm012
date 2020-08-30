/**
 * @author Liutianyou
 * @date 2020/8/30 11:03 下午
 */

import java.util.*;

class TotalNQueens {

  public int totalNQueens(int n) {
    List<List<int[]>> res = new ArrayList();
    nQueensFunc(0, 0, 0, 0,
        0, n, new ArrayList<int[]>(), res);
    return res.size();
  }

  public void nQueensFunc(int rows, int columsSet, int rowsSet, int pieSet, int naSet, int n,
      List<int[]> ans, List<List<int[]>> res) {
    for (int colums = 0; colums < n; colums++) {
      if (getNBit(rowsSet,rows) == 0 && getNBit(columsSet,colums) == 0
          && getNBit(pieSet,(colums+rows)) == 0 && getNBit(naSet,(rows-colums)) == 0) {
        int[] point = new int[]{rows, colums};
        ans.add(point);
        if (ans.size() == n) {
          res.add(new ArrayList(ans));
        }
        int c = setNBit(columsSet,colums);
        int r = setNBit(rowsSet,rows);
        int p = setNBit(pieSet,(rows+colums));
        int na = setNBit(naSet,(rows-colums));
        //进入下一行
        nQueensFunc(rows + 1, c, r, p, na, n, ans, res);
        //清理
        ans.remove(point);
      }
    }
  }
  
  public int setNBit(int num,int n){
    return  num | (1 << n);
  }
  public int getNBit(int num,int n){
    return ((num>>n)& 1);
  }

  public static void main(String[] args) {
    TotalNQueens totalNQueens = new TotalNQueens();
    System.out.println(totalNQueens.totalNQueens(4));
  }
}
