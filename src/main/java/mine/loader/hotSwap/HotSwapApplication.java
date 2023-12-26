package mine.loader.hotSwap;


import mine.loader.hotSwap.hotSwapApplication.HotSwapClassLoader;
import mine.loader.hotSwap.hotSwapFileListener.FileListener;
import mine.loader.hotSwap.hotSwapRun.HotSwapTest;
import org.apache.commons.io.monitor.*;

import java.io.File;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2023/12/26 9:50
 */
public class HotSwapApplication {

    public static String rootPath;

    public void init(){
        System.out.println("项目初始化");
    }

    public void start(){
        init();
        new HotSwapTest().testHotSwap();
    }

    public static void start0(HotSwapClassLoader classLoader) throws Exception{
        Class<?> aClass = classLoader.loadClass("mine.loader.hotSwap.HotSwapApplication");
        Object o = aClass.newInstance();
        aClass.getMethod("start").invoke(o);
    }

    public static void run(Class clazz) throws Exception {
        String rootPath = clazz.getResource("/").getPath().replaceAll("%20"," ");
        rootPath = new File(rootPath).getPath();
        HotSwapApplication.rootPath = rootPath;
        startFileListener(rootPath);
        /**
         * 用自定义加载器加载/mine包下面的类
         */
        HotSwapClassLoader classLoader = new HotSwapClassLoader(rootPath, rootPath + "/mine/loader/hotSwap");
        start0(classLoader);
    }

    public static void startFileListener(String rootPath) throws Exception {
        FileAlterationObserver observer = new FileAlterationObserver(rootPath);
        observer.addListener(new FileListener());
        FileAlterationMonitor monitor = new FileAlterationMonitor();
        monitor.addObserver(observer);
        monitor.start();
    }

}
