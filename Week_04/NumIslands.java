/**
 * @author Liutianyou
 * @date 2020/8/2 10:42 下午
 */
public class NumIslands {
  public int numIslands(char[][] grid) {
    int count =0;
    for(int i=0;i<grid.length;i++){
      for(int j=0;j<grid[i].length;j++){
        if(grid[i][j]=='1'){
          loop(grid,i,j);
          count++;

        }
      }
    }
    return count;
  }
  private void loop(char[][] grid,int i,int j){
    if(i<0||j<0||i>=grid.length||j>=grid[i].length||grid[i][j]!='1'){
      return;
    }
    grid[i][j]='0';
    loop(grid,i,j+1);
    loop(grid,i,j-1);
    loop(grid,i+1,j);
    loop(grid,i-1,j);
  }


  public static void main(String[] args) {
    NumIslands numIslands = new NumIslands();
    char[][] grid=new char[][]{{'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}
    };
    System.out.println(numIslands.numIslands(grid));
  }



}
