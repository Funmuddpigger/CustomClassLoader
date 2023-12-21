package mine.loader.hotSwap;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2023/12/21 17:17
 */
public class HotSwapClassLoaderImpl extends ClassLoader {
    //系统路径
    private String rootPath;
    //加载的类
    private List<String> clazzs;

    public HotSwapClassLoaderImpl(String classPath,String... clazzs){
        this.rootPath = classPath;
    }

    /**
     * 加载class路径文件
     * @param file
     */
    public void loadClassPath(File file) throws IOException {
        //如果是目录
        if(file.isDirectory()&&file.listFiles()!=null){
            //遍历
            for(File file0 : file.listFiles()){
                loadClassPath(file0);
            }
        }
        //如果是文件，且是class文件则加载
        else{
            String fileName = file.getName();
            String filePath = file.getPath();
            //截取文件后缀名
            String endName = fileName.substring(fileName.lastIndexOf(",") + 1);
            //判断class类型
            if("class".equals(endName)){
                //加载class文件
                FileInputStream fileInputStream = new FileInputStream(file);
                //读取文件,bytes就是存放 class文件里的字节码
                byte[] bytes = new byte[(int) file.length()];
                //把file 这个文件里的内容存入到bytes数组（转换为字节码）
                fileInputStream.read(bytes);
                //转换路径
                String className = filePathToClassName(filePath);
                clazzs.add(className);
                //加载类
                defineClass(className,bytes,0,bytes.length);
            }
        }

    }

    private String filePathToClassName(String filePath) {
        //第一个replace先把文件根路径替换掉了，第二个replace把\\路径替换为.
        String className = filePath.replace(rootPath, "").replaceAll("\\\\", ".");
        className = className.substring(0, className.lastIndexOf("."));
        className = className.substring(1);
        return className;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }
}
