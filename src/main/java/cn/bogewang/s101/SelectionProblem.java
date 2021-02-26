package cn.bogewang.s101;

import org.junit.Test;

import java.util.Random;

/**
 * 选择问题,从N个数中,取出第k大的数.
 * Created by bogewang on 2017/3/20.
 */
public class SelectionProblem {
    private static final int TOTAL = 100000;
    private static final int k = TOTAL/2;

    @Test
    public void testFind() {
        int[] arr = new int[TOTAL];
        Random rand = new Random();
        //初始化待排序的数组;
        for(int i=0;i<TOTAL;i++){
            arr[i] = rand.nextInt(TOTAL);
        }

        System.out.println(TOTAL+"个数中第"+k+"大的数为:"+findKMax(arr,k));
        System.out.println("========================");
        int kMax2 = findKMax2(arr, k);
        System.out.println(TOTAL+"个数中第"+k+"大的数为:"+kMax2);
    }

    /**
     * 找出数组中第K大的数,才用的是冒泡排序法;
     * @param arr 待查找数组;
     * @param k k
     * @return 查找到的数;
     */
    public int findKMax(int[] arr,int k){
        long start = System.currentTimeMillis();
        int length = arr.length;
        for (int i=length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        long end = System.currentTimeMillis();
        long costTime = end - start;

        System.out.println("冒泡排序花费时间:"+costTime);
        return arr[k-1];
    }

    /**
     *找出数组中第K大的数,采用先建立一个大小为k数组,然后并进行排序(递减方式)
     * 然后将剩余的元素与第k个元素进行比较,较小则直接舍弃,否则插入原先数组大小对应位置;
     * @param oldArr 待排序数组
     * @param k 需要返回的位置
     * @return 返回的第k大的数
     */
    public int findKMax2(int[] oldArr,int k){
        long start = System.currentTimeMillis();
        int[] newArr = new int[k];
        //初始化结束;
        for(int i=0;i<k;i++){
            newArr[i] = oldArr[i];
        }

        //对新数组进行排序
        for (int i=0;i<k;i++){
            for (int j=i;j>0;j--){
                if(newArr[j] > newArr[j-1]){
                    int temp = newArr[j];
                    newArr[j] = newArr[j-1];
                    newArr[j-1] = temp;
                }
            }
        }
        
        //将原数组k之后的数据插入新数组;
        for(int i=k;i<oldArr.length;i++){
            //如果该数小于newArr的最后一个则直接遗弃;
            if (oldArr[i] <= newArr[k-1]){
                continue;
            }
            for(int j=0;j<=k-1;j++){
                if (oldArr[i] > newArr[j]){//找到在新数组中的插入位置,j
                    //j开始元素往后移动一位;;
                    for(int n=k-2;n>=j;n--){
                        newArr[n+1] = newArr[n];
                    }
                    //将新元素插入;
                    newArr[j] = oldArr[i];
                    break;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("第二种排序话费时间为(毫秒):"+(end - start));

        return newArr[k-1];
    }

    @Test
    public void testZuoYi(){
        int num = 3;
        System.out.println(3<<2);
    }
}
