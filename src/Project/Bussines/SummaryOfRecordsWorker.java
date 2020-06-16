package Project.Bussines;

import Project.StorageObject.Records;
import Project.StorageObject.RecordsHolder;
import Project.StorageObject.SummaryOfRecords;
import Project.StorageObject.SummaryOfRecordsHolder;
import Project.Visual.Graphs.GraphsController;
import java.util.ArrayList;
import java.util.Collections;

public class SummaryOfRecordsWorker extends GraphsController {

    public static void sumRecords() {

        ArrayList<Records> recorsToSum = RecordsHolder.staticRecords();
        //Collections.reverse(recorsToSum);
        ArrayList<SummaryOfRecords> summaryOfRecords = new ArrayList<SummaryOfRecords>();
        SummaryOfRecordsHolder SORH = new SummaryOfRecordsHolder();

        String lastCountryCode = "null";
        int index = -1;

        for (Records i : recorsToSum) {

            if (!(i.getCountryterritoryCode().equals(lastCountryCode))) {
                index++;
                lastCountryCode = i.getCountryterritoryCode();
                summaryOfRecords.add(new SummaryOfRecords(i.getDateRep(), i.getDay(), i.getMonth(), i.getYear(), i.getCases(), i.getDeaths(), i.getCountriesAndTerritories(), i.getCountryterritoryCode(), i.getGeoId(), i.getPopData2018(), i.getContinentExp(), i.getDeaths(), i.getCases()));
            } else {
                summaryOfRecords.get(index).setTotalCases(i.getCases() + summaryOfRecords.get(index).getTotalCases());
                summaryOfRecords.get(index).setTotalDeaths(i.getDeaths() + summaryOfRecords.get(index).getTotalDeaths());
            }


        }
        SORH.setSummaryOfRecordsfRecords(summaryOfRecords);


    }
}
