package mine.loader.hotSwap;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2023/12/25 15:16
 */
public class HotSwapTest {

    public HotSwapTest() {
    }

    public void testHotSwap(){
        System.out.println("version: 21.0");
        System.out.println("current ClassLoader: " + HotSwapTest.class.getClassLoader());
    }
}
