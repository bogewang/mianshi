package cn.bogewang.s113;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by bogewang on 2017/3/22.
 */
public class MyCollectionTest {
    private MyCollection collection= new MyCollection();

    public void testMakeEmpty() {

    }

    @Test
    public void testInsert() {
        String name = "user1";
        collection.insert(name);
        Assert.assertTrue(collection.isEmpty());

    }

    public void testRemove() {

    }

    public void testIsPresent() {

    }

    @Test
    public void testIsEmpty() {
        boolean result = collection.isEmpty();
        System.out.println(result);
    }
}
