package cn.bgw.danlimoshi;

public class InnerSingleton {
    private InnerSingleton(){

    }

    public static class SingletonHolder{
        private static final InnerSingleton instance = new InnerSingleton();
    }

    public static InnerSingleton getInstance(){
        return SingletonHolder.instance;
    }
}
