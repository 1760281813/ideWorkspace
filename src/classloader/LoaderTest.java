package classloader;

public class LoaderTest {

    public static void main(String[] args) {
        new Thread(new ThreadLoader()).start();
    }
}
