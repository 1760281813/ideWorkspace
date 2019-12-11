package classloader;

/**
 * 后台启动线程不断刷新重新加载
 */
public class ThreadLoader implements  Runnable {
    @Override
    public void run() {
        while(true){
            BaseManage baseManage = ManagerFactory.getManager(ManagerFactory.MY_MANAGER);
            baseManage.login();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
