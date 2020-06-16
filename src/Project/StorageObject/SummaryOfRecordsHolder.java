package Project.StorageObject;

import java.util.ArrayList;

public class SummaryOfRecordsHolder {

    private static ArrayList<SummaryOfRecords> summaryOfRecordsfRecords;

    public ArrayList<SummaryOfRecords> getSummaryOfRecordsfRecords() {
        return summaryOfRecordsfRecords;
    }

    public static void setSummaryOfRecordsfRecords(ArrayList<SummaryOfRecords> summaryOfRecordsfRecords) {
        SummaryOfRecordsHolder.summaryOfRecordsfRecords = summaryOfRecordsfRecords;
    }

    public SummaryOfRecordsHolder() {
    }

    public static ArrayList<SummaryOfRecords> staticSumOfRecords()
    {
        return summaryOfRecordsfRecords;
    }
}
