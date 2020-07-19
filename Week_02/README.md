# 第二周学习总结
### 树的相关题目
#### 二叉树遍历
前序遍历：根->左->右

递归
```java
 public void  loop(TreeNode node,List<Integer> res){
        if(node!=null){
            res.add(node.val);
            loop(node.left,res); 
            loop(node.right,res);
        }
    }
```

迭代

```java
    public List<Integer> preorderTraversal(TreeNode root) {  
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode  node = stack.pop();
            res.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
    }
     return res;
}
```
---


中序遍历：左->根->右
```java
 public void  loop(TreeNode node,List<Integer> res){
        if(node!=null){
            loop(node.left,res);
            res.add(node.val);
            loop(node.right,res);
        }
    }
```
迭代
```java
public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // loop(root,res);
        // return res; 
        Stack<TreeNode> stack = new Stack();
        TreeNode cur=root;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            res.add(cur.val);
            cur=cur.right;
        }
        return res;
    }
```
---

后序遍历：左->右->根
```java
 public void  loop(TreeNode node,List<Integer> res){
        if(node!=null){
            loop(node.left,res);
            loop(node.right,res);
            res.add(node.val);
        }
    }
```
迭代
```java

  public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<TreeNode> stack = new LinkedList<>();
    LinkedList<Integer> output = new LinkedList<>();
    if (root == null) {
      return output;
    }

    stack.add(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pollLast();
      output.addFirst(node.val);
      if (node.left != null) {
        stack.add(node.left);
      }
      if (node.right != null) {
        stack.add(node.right);
      }
    }
    return output;
  }
```






 
