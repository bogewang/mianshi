package cn.bogewang.s113;

import java.util.Arrays;

/**
 * 这是一个泛型类,它存储Object对象的集合(在数组中),
 * 以及该集合的当前的大小,提供public方法 isEmpty,makeEmpty,insert,remove
 * ,isPresent(x)当且仅当该集合中存在(有equals定义)等于x的一个Object时返回true;
 * Created by bogewang on 2017/3/22.
 */
public class MyCollection<T extends Object> {
    private T[] objs ;

    public void makeEmpty(){
    }

    public void insert(T obj){
    }

    public void remove(int index){}

    public boolean isPresent(Object obj){
        return false;
    }

    /**
     * 判断集合是否为空
     * @return
     */
    public boolean isEmpty(){
        if (objs == null || objs.length == 0){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "MyCollection{" +
                "objs=" + Arrays.toString(objs) +
                '}';
    }

    public Object[] getObjs() {
        return objs;
    }

    public void setObjs(T[] objs) {
        this.objs = objs;
    }
}
