package Project.Bussines;

public class DataReshapeThreadHandler implements Runnable {

    private Thread T;
    private String threadName;
    private String rawData;

    @Override
    public void run() {
        DataReshape DR = new DataReshape();
        DR.splitRawData(rawData);
    }

    public void start() {

        if (T == null) {
            T = new Thread(this, threadName);
            T.start();
        }
    }

    public DataReshapeThreadHandler(String threadName, String rawData) {
        this.threadName = threadName;
        this.rawData = rawData;
    }
}
