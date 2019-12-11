package classloader;

import java.io.*;

/**
 * 自定义实现类热加载
 */
public class ClassLoaderFree extends ClassLoader {

    //要加载的java类的路径
    private String classpath;

    public String getClasspath() {
        return classpath;
    }

    public void setClasspath(String classpath) {
        this.classpath = classpath;
    }

    public ClassLoaderFree(String classpath) {
        super(ClassLoader.getSystemClassLoader());
        this.classpath = classpath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte []data=this.loadClassData(name);
        return this.defineClass(name,data,0,data.length);
    }

    /**
     * 加载类中的文件内容
     * @param name
     * @return
     */
    private byte[] loadClassData(String name) {
        name=name.replace(".","//");

        try {
            FileInputStream is = new FileInputStream(new File(classpath+name+".class"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;

            while ((b=is.read())!=-1){
                baos.write(b);
            }
            is.close();
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
