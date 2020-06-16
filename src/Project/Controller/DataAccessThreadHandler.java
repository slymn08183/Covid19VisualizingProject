package Project.Controller;

public class DataAccessThreadHandler implements Runnable {
    private Thread T;
    private String threadName;
    private String url;

    @Override
    public void run() {
        DataAccess DA = new DataAccess();
        DA.getDataFromUrl(url);
    }

    public void start() {

        if (T == null) {
            T = new Thread(this, threadName);
            T.start();
        }
    }

    public DataAccessThreadHandler(String thread, String url) {
        this.threadName = thread;
        this.url = url;
    }
}

