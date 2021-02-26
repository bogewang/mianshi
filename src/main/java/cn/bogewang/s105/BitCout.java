package cn.bogewang.s105;

import org.junit.Test;

/**
 * 计算一个数n转化为二进制中所包含的1的个数;
 * Created by bogewang on 2017/3/22.
 */
public class BitCout {
    @Test
    public void testCount(){
        int n = 15;
        System.out.println(n + "中包含的1的个数为:" + bitCount1(n));
        System.out.println(n + "中包含的1的个数为:" + bitCount2(n));
    }

    /**
     * 移位+计数，很简单，不多说了，直接上代码
     * 这种方法的运算次数与输入n最高位1的位置有关，最多循环32次。
     * @param n
     * @return
     */
    int bitCount1(int n){
        int count = 0; //计数器
        for (;n>0;n >>=1){
            count += (n&1);
        }
        return count;
    }

    /**
     * 这种方法速度比较快，其运算次数与输入n的大小无关，
     * 只与n中1的个数有关。如果n的二进制表示中有k个1，
     * 那么这个方法只需要循环k次即可。
     * 其原理是不断清除n的二进制表示中最右边的1，
     * 同时累加计数器，直至n为0，代码如下
     * @param n
     * @return
     */
    int bitCount2(int n){
        int count = 0;
        for (; n > 0; ++count){
            /*
                为什么n &= (n – 1)能清除最右边的1呢？
                因为从二进制的角度讲，n相当于在n - 1的最低位加上1。
                举个例子，8（1000）= 7（0111）+ 1（0001），
                所以8 & 7 = （1000）&（0111）= 0（0000），
                清除了8最右边的1（其实就是最高位的1，因为8的二进制中只有一个1）。
                再比如7（0111）= 6（0110）+ 1（0001），
                所以7 & 6 = （0111）&（0110）= 6（0110），
                清除了7的二进制表示中最右边的1（也就是最低位的1）。
             */
            n &= (n - 1); //清楚最低位的1
        }
        return count;
    }
}
