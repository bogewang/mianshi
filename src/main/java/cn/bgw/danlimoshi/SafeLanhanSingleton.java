package cn.bgw.danlimoshi;

public class SafeLanhanSingleton {
    private static SafeLanhanSingleton instance = null;

    private SafeLanhanSingleton() {
    }

    public static synchronized SafeLanhanSingleton getInstance(){
        if (instance == null){
            instance = new SafeLanhanSingleton();
        }

        return instance;
    }
}
