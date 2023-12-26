package mine.loader.hotSwap.hotSwapFileListener;

import mine.loader.hotSwap.hotSwapApplication.HotSwapApplication;
import mine.loader.hotSwap.hotSwapApplication.HotSwapClassLoader;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;

import java.io.File;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2023/12/26 16:26
 */
public class FileListener extends FileAlterationListenerAdaptor {

    @Override
    public void onFileChange(File file){
        if(file.getName().indexOf(".class")!=-1){
            try{
                HotSwapClassLoader classLoader = new HotSwapClassLoader(HotSwapApplication.rootPath, HotSwapApplication.rootPath + "/mine");
                HotSwapApplication.start0(classLoader);
            }  catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
