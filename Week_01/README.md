## 第一周学习总结
### 刷题：
1. 不要死磕，死磕会浪费太多的精力，看题5分钟没有思路直接看题解。
2. 题解看不懂就先抄一遍，一遍不行就再来一遍。实在理解不来，就在纸上画画图。
3. 要多看优秀的代码，leetCode中文站和国际站的高票题解。
4. 刷题要复习，不能做过一遍就放下不管了。要多做几遍，然后多复习。
### 优秀解题思路
#### 递归中增加缓存，把需要重读计算的值存起来，加速代码的执行。
```java
class Solution {
    public int climbStairs(int n) {
        HashMap<Integer,Integer> cache = new HashMap();
        cache.put(1,1);
        cache.put(2,2);
        return loop(n,cache);
    }
    public int loop(int n ,HashMap<Integer,Integer> cache){
        if(cache.get(n)!=null){
            return cache.get(n);
        }
        int f1= loop(n-1,cache);
        int f2= loop(n-2,cache);
        cache.put(n,f1+f2);
        return f1+f2;
    }
}
```
时间复杂度从O(2^n)降到了O(n) 典型的用空间换时间的
#### 做本来就应该做的事
再翻转链表这个题目里本来要做的事情就是 原链表的后一个节点指向前一个节点就好了我想到的思路从头结点开始将每个节点插入到原链表的最后一个节点后面。
于是就写出了下面的代码。

```java
class Solution {
     public ListNode reverseList(ListNode head) {
         if(head==null){
             return null;
         }
         int count = 0;
         ListNode lastNode = head;
         ListNode current  = head;
         ListNode temp = head;
         //寻找最后一个节点
         while(lastNode.next!=null){
             count++;
             lastNode=lastNode.next;
         }
         while(count>0){
             temp = current.next;
             if(lastNode.next==null){
                 lastNode.next = current;
                 current.next=null;
             }else{
                 current.next = lastNode.next;
                 lastNode.next = current;
             }
             count--;
             current= temp;
         }
         return lastNode;
   }
}
```
如果是使用后一个节点指向前一个节点的思路 代码就可以简化到下面这样
```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev =null;
        ListNode current = head;
        while(current!=null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
```
### 总结
1. 阅读过得优秀代码太少了，思路被限制了，只能在自己熟悉的操作中摸索。
2. 之前总是觉得算法题就应该死磕到底直到自己写出来为止，这周的课程学完之后马上就摒弃了这种错误的想法。只有阅读的优秀代码多了思路才会开阔。写代码才会更"漂亮"，死磕最终只是浪费时间。
3. 看不懂的代码debug+画图能够更快理解。
4. 刷题要坚持。
5. IntellijIDEA 写Markdown 体验真的很好。特别是如果文档里有代码。






