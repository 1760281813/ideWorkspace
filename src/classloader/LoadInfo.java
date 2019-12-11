package classloader;

/**
 * 封装加载信息
 */
public class LoadInfo {
    //自定义加载类
    private ClassLoaderFree myLoader;

    private long loadTime;

    private BaseManage baseManage;

    public BaseManage getBaseManage() {
        return baseManage;
    }

    public void setBaseManage(BaseManage baseManage) {
        this.baseManage = baseManage;
    }

    public LoadInfo(ClassLoaderFree myLoader, long loadTime) {
        this.myLoader = myLoader;
        this.loadTime = loadTime;
    }

    public ClassLoaderFree getMyLoader() {
        return myLoader;
    }

    public void setMyLoader(ClassLoaderFree myLoader) {
        this.myLoader = myLoader;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(long loadTime) {
        this.loadTime = loadTime;
    }
}
