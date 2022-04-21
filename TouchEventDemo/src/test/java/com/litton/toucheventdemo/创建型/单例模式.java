package com.litton.toucheventdemo.创建型;

/**
 * 饿汉式
 * 1. 私有化构造方法，不让外部调用
 * 2. 内部创建私有变量 Instance，该类唯一实例。
 * 3. 提供newInstance 方法返回唯一实例。
 */
class SingletonJava1 {
    private SingletonJava1() {
    }

    private static SingletonJava1 ourInstance = new SingletonJava1();

    public static SingletonJava1 newInstance() {
        return ourInstance;
    }

    public void println(String hello) {
        println(hello);
    }
}

/**
 * 懒汉式
 * 1. 私有化构造方法
 * 2. 单例引用先赋值为 NULL
 * 3. 加入同步锁（先判断单例对象是否为空，避免重复创建）
 */
class SingletonJava2 {
    private SingletonJava2() { }

    private static SingletonJava2 ourInstance = null;

    public static synchronized SingletonJava2 getInstance() {
        if (ourInstance == null) {
            ourInstance = new SingletonJava2();
        }
        return ourInstance;
    }
}
/**
 * 双重校验锁
 * 1. 私有化构造方法
 * 2. 单例引用先赋值为 NULL
 * 3. 先判断单例对象是否为空，不为空直接返回
 * 4. 为空的话同步锁内继续判断是否为空，此时为空进行单例对象的创建
 */
class SingletonJava3 {
    private SingletonJava3() { }

    private static SingletonJava3 ourInstance = null;

    public static SingletonJava3 newInstance() {

        if (ourInstance == null) {
            synchronized (SingletonJava3.class) {
                if (ourInstance == null) {
                    ourInstance = new SingletonJava3();
                }
            }
        }
        return ourInstance;
    }
}


