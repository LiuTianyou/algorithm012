学习笔记
### 递归代码模板
```java
class CodeTemplate{
    public void recur(int level, int param) { 
      // terminator 
      // 递归结束的条件
      if (level > MAX_LEVEL) {
        // 这里对结果进行 处理 例如将 结果加入到一个结果集中
        // process result 
        return; 
      }
      // 处理当前层的逻辑
      // process current logic 
      process(level, param); 
      //下探到下一层递归
      // drill down 
      recur(level + 1, newParam); 
      //恢复当前的状态。
      // restore current status 
    }
}
```
### 分治代码模板
```java
class codeTemplate{
    public int divide_conquer(Problem problem, int params) {
      // recursion terminator
      if (problem == nullptr) {
         process_result();
        return return_result;
      }

      // process current problem
      subproblems = split_problem(problem, data);
      subresult1 = divide_conquer(subproblem[0], p1);
      subresult2 = divide_conquer(subproblem[1], p1);
      subresult3 = divide_conquer(subproblem[2], p1);
      ...
    
      // merge
      result = process_result(subresult1, subresult2, subresult3);
      // revert the current level status
     
      return 0;
    }
}
```
