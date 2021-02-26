package cn.bgw.sort;

import java.util.Arrays;
import java.util.Random;

public class Sorting {

    private static final int LENGTH = 20000;
    private static int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

    public static void main(String[] args) {

        int[] a = getArray();
        //a = arr;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            bubbleSort(a.clone());
        }

        System.out.println("冒泡平均耗时: " + (System.currentTimeMillis() - start) / 10 + "ms");
        //========================================================================

        start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            selectionSort(a.clone());
        }

        System.out.println("选择排序平均耗时: " + (System.currentTimeMillis() - start) / 10 + "ms");
        //========================================================================

        start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            insertionSort(a.clone());
        }

        System.out.println("插入排序平均耗时: " + (System.currentTimeMillis() - start) / 10 + "ms");
        //========================================================================

        start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            ShellSort(a.clone());
        }

        System.out.println("希尔排序平均耗时: " + (System.currentTimeMillis() - start) / 10 + "ms");
        //========================================================================

        start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            MergeSort(a.clone());
        }

        System.out.println("归并排序平均耗时: " + (System.currentTimeMillis() - start) / 10 + "ms");
        //========================================================================

    }

    private static void afterPrint(int[] a, String s) {
        System.out.println(s);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static void beforePrint(int[] a) {
        afterPrint(a, "排序之前：");
        System.out.println();
    }

    public static int[] getArray() {
        Random r = new Random(LENGTH);
        int[] array = new int[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            array[i] = r.nextInt(LENGTH);
        }

        return array;
    }

    /**
     * 冒泡排序
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length - 1 - i; j++)
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
        return array;
    }

    /**
     * 选择排序
     *
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) //找到最小的数
                    minIndex = j; //将最小数的索引保存
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    /**
     * 插入排序
     *
     * @param array
     * @return
     */
    public static int[] insertionSort(int[] array) {
        if (array.length == 0)
            return array;
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }

    /**
     * 希尔排序
     *
     * @param array
     * @return
     */
    public static int[] ShellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }

    /**
     * 归并排序
     *
     * @param array
     * @return
     */
    public static int[] MergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(MergeSort(left), MergeSort(right));
    }
    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)//左边已经插入新数组完成;直接插入右边数组;
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }

    /**
     * 以下语句生成几个对象?
     * : 1
     */
    public static void test(){
        String s = "a" + "b" + "c" + "d";
    }

}
