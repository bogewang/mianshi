package cn.bgw.danlimoshi;

/**
 * 饿汉模式；
 */
public class EhanSingleton {
    private static EhanSingleton instance = new EhanSingleton();

    private EhanSingleton() {
    }

    public static EhanSingleton getInstance(){
        return instance;
    }
}
