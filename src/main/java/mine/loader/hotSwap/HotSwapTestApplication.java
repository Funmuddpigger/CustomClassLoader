package mine.loader.hotSwap;

import mine.loader.hotSwap.common.TestHotSwap;
import mine.loader.hotSwap.hotSwapApplication.HotSwapApplication;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2023/12/25 15:16
 */
public class HotSwapTestApplication {

    public void testHotSwapMethod(){
        System.out.println("version: 230.0");
        System.out.println("current ClassLoader: " + HotSwapTestApplication.class.getClassLoader());
    }

    public static void main(String[] args) throws Exception {
        HotSwapApplication.run(HotSwapTestApplication.class);
    }

}
