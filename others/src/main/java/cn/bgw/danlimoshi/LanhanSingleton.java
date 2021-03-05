package cn.bgw.danlimoshi;

/**
 * 懒汉模式；
 */
public class LanhanSingleton {
    private static LanhanSingleton instance = null;

    private LanhanSingleton(){

    }

    public static LanhanSingleton getInstance(){
        if (instance == null){
            instance = new LanhanSingleton();
        }

        return instance;
    }


}
