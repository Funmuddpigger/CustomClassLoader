package mine.loader.hotSwap.hotSwapRun;

import mine.loader.hotSwap.HotSwapApplication;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2023/12/25 15:16
 */
public class HotSwapTest {

    public HotSwapTest() {

    }

    public void testHotSwap(){
        System.out.println("version: 24.0");
        System.out.println("current ClassLoader: " + HotSwapTest.class.getClassLoader());
    }

    public static void main(String[] args) throws Exception {
        HotSwapApplication.run(HotSwapTest.class);
    }
}
