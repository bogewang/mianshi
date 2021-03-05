package cn.bgw._43;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁绑定多个条件；
 */
public class Test43 {

    public static void main(String[] args) {
        final ShareResource shareResource = new ShareResource();
        new Thread(() ->{
            for (int i = 0; i < 5; i++) {
                shareResource.print5();
            }
        },"A").start();

        new Thread(() ->{
            for (int i = 0; i < 5; i++) {
                shareResource.print10();
            }
        },"B").start();

        new Thread(() ->{
            for (int i = 0; i < 5; i++) {
                shareResource.print15();
            }
        },"C").start();
    }
}

class ShareResource{
    private int number = 1; // A:1 , B:2, C:3;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5(){
        lock.lock();
        try {
            while(number != 1){
                c1.await();
            }

            String s = "";
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() +"\t" + (s += "#"));
            }

            number = 2;
            c2.signal();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10(){
        lock.lock();
        try {
            while(number != 2){
                c2.await();
            }
            String s = "";
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() +"\t" + (s += "#"));
            }

            number = 3;
            c3.signal();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try {
            while(number != 3){
                c3.await();
            }

            String s = "";
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() +"\t" + (s += "#"));
            }

            number = 1;
            c1.signal();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
