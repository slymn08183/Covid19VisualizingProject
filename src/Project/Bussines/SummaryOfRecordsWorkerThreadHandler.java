package Project.Bussines;

public class SummaryOfRecordsWorkerThreadHandler implements Runnable{

    private Thread T;
    private String threadName;
    private String rawData;

    @Override
    public void run() {
        SummaryOfRecordsWorker.sumRecords();
    }

    public void start() {

        if (T == null) {
            T = new Thread(this, threadName);
            T.start();
        }
    }

    public SummaryOfRecordsWorkerThreadHandler(String threadName) {
        this.threadName = threadName;
    }
}
