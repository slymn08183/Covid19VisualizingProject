package Project.Bussines;

import Project.StorageObject.Records;
import Project.StorageObject.RecordsHolder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DataReshape {

    private String dateRep;
    private int day;
    private int month;
    private int year;
    private int cases;
    private int deaths;
    private String countriesAndTerritories;
    private String geoId;
    private String countryterritoryCode;
    private int popData2018;
    private String continentExp;
    private ArrayList<Records> records = new ArrayList<Records>();
    private ArrayList<String> whatDidYouTook = new ArrayList<String>();

    public void splitRawData(String rawData) {
        splitThoseRecords(rawData);
    }

    private void splitThoseRecords(String inputToSplit) {


        String cleaner1 = "<record>(.*?)<\\/record>";
        String cleaner2 = "(?<=>)(.*?)<";
        inputToSplit = inputToSplit.replaceAll("\\s", "");
        Pattern cleaner1GP = Pattern.compile(cleaner1);
        Pattern cleaner2GP = Pattern.compile(cleaner2);
        Matcher cleaner1GM = cleaner1GP.matcher(inputToSplit);
        Matcher cleaner2GM;

        String nonClearData;
        ArrayList<String> temp = new ArrayList<String>();
        String[] temp2;

        while (cleaner1GM.find()) {
            temp.add(cleaner1GM.group(1));
        }

        int dataSet = 0;

        for (String i : temp) {

            cleaner2GM = cleaner2GP.matcher(i);
            nonClearData = "";
            while (cleaner2GM.find()) {
                nonClearData += cleaner2GM.group();
            }

            temp2 = nonClearData.split("<<");

            if (temp2.length != 11 || temp2[9].equals("")) {
                continue;
            }
            dateRep = temp2[0];
            day = Integer.parseInt(temp2[1]);
            month = Integer.parseInt(temp2[2]);
            year = Integer.parseInt(temp2[3]);
            cases = Integer.parseInt(temp2[4]);
            deaths = Integer.parseInt(temp2[5]);
            countriesAndTerritories = temp2[6];
            geoId = temp2[7];
            countryterritoryCode = temp2[8];
            popData2018 = Integer.parseInt(temp2[9]);
            continentExp = temp2[10].replaceAll("<", "");
            records.add(new Records(dateRep, day, month, year, cases, deaths, countriesAndTerritories, geoId, countryterritoryCode, popData2018, continentExp));
            whatDidYouTook.add(countriesAndTerritories);
            dataSet++;
        }
        System.out.println("Veriler İşlendi");
        //Collections.sort(records, Comparator.comparing(Records::getDateRep));
        //Collections.sort(records, Comparator.comparing(Records::getMonth));
        Collections.sort(records, Comparator.comparing(Records::getCountriesAndTerritories));
        //Collections.reverse(records);

        RecordsHolder recordsHolder = new RecordsHolder();
        recordsHolder.setRecords(records);

        SummaryOfRecordsWorkerThreadHandler SOWHT = new SummaryOfRecordsWorkerThreadHandler("threadSummary1");
        SOWHT.start();
    }
}
