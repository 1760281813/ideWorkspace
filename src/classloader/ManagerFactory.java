package classloader;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * 加载manager的工厂
 */
public class ManagerFactory {

    private static final Map<String,LoadInfo> loadTimeMap = new HashMap<>();

    public static final String CLASS_PATH = "E:/ideWorkspace/out/production/ideWorkspace/stringPackage/";

    public static final String MY_MANAGER ="classloader.ClassLoaderFree";

    public static BaseManage getManager(String className){
        File loadFile = new File(CLASS_PATH+className.replaceAll("\\.","/")+".class");
        long lastModified = loadFile.lastModified();
        if (loadTimeMap.get(className) == null){
            load(className,lastModified);
        }else if(loadTimeMap.get(className).getLoadTime()!= lastModified){
            load(className,lastModified);
        }

        return  loadTimeMap.get(className).getBaseManage();
    }

    public static void load(String className,long loadTime){
        ClassLoaderFree myClassLoader = new ClassLoaderFree(CLASS_PATH);

        Class <?> loadClass = null;

        try {
            loadClass = myClassLoader.loadClass(className);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        BaseManage baseManage = newInsance(loadClass);
        LoadInfo loadInfo = new LoadInfo(myClassLoader,loadTime);
        loadInfo.setBaseManage(baseManage);

        loadTimeMap.put(className,loadInfo);
    }

    private static BaseManage newInsance(Class<?> loadClass) {

        try {
            return (BaseManage)loadClass.getConstructor(new Class[]{}).newInstance(new Object[]{});
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;

    }


}
