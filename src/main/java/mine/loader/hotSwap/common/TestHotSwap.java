package mine.loader.hotSwap.common;

import mine.loader.hotSwap.HotSwapTestApplication;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2023/12/26 17:57
 */
public class TestHotSwap {
    public void testHotSwapMethod(){
        System.out.println("version: 229.0");
        System.out.println("current ClassLoader: " + HotSwapTestApplication.class.getClassLoader());
    }
}
