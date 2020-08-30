# 第八周学习笔记
将x最右边的n位清零 x&(~0 << n)
```java
public class BitOperationTest {
  public static void main(String[] args) {
    //将x最右边n 位清零 (x &(~0<<n))
    //将 x中的所有位全部置位1 然后左移n位 后和x 相&
    int a = 15;
    System.out.println(Integer.toBinaryString(a));
    //0.将x的所有位 置1
    int b = a^(~a);
    //1.将置 1 后的结果左移n位 例如 左移3位
    b = b<<3;
    //2.和原数&
    a = a&b;
    System.out.println(Integer.toBinaryString(a));
  }
}
```
获取x的第n位值（0或1）： (x>>n)&1

获取x的第n位的幂值：x&(1 << (n-1))

仅将第n位置为1： x | (1 << n)

仅将第n位置为0：x&(1 << n)

将x最高位至第n位清零x &( (1 << n) -1)

将第n位至第0位清0：x&(~((1 << (n+1))-1))

