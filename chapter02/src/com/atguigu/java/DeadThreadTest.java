package com.atguigu.java;

/**
 * clinit方法调用的时候虚拟机会自动加锁，来保证初始化的线程安全问题
 * 所以说在singleton中，实现线程安全就有一个使用内部类的方式，这里就是原因了
 * 因为类的static修饰的代码都是被clinit来执行的，但是虚拟机已经保证在多线程下
 * 对clini执行加锁，从而保证线程安全，从而导致了静态内部类实现单例的线程安全
 * @author shkstart
 * @create 2020 上午 11:23
 */
public class DeadThreadTest {
    public static void main(String[] args) {
        //java8 lambda表达式
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + "开始");
            DeadThread dead = new DeadThread();
            System.out.println(Thread.currentThread().getName() + "结束");
        };

        Thread t1 = new Thread(r,"线程1");
        Thread t2 = new Thread(r,"线程2");

        t1.start();
        t2.start();
    }
}

class DeadThread{
    static{
        if(true){
            System.out.println(Thread.currentThread().getName() + "初始化当前类");
            while(true){

            }
        }
    }
}
