package Project.StorageObject;

public class Records {

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

    public Records(String dateRep, int day, int month, int year, int cases, int deaths, String countriesAndTerritories, String geoId, String countryterritoryCode, int popData2018, String continentExp) {
        this.dateRep = dateRep;
        this.day = day;
        this.month = month;
        this.year = year;
        this.cases = cases;
        this.deaths = deaths;
        this.countriesAndTerritories = countriesAndTerritories;
        this.geoId = geoId;
        this.countryterritoryCode = countryterritoryCode;
        this.popData2018 = popData2018;
        this.continentExp = continentExp;
    }

    public  Records(){}

    public String getDateRep() {
        return dateRep;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getCases() {
        return cases;
    }

    public int getDeaths() {
        return deaths;
    }

    public String getCountriesAndTerritories() {
        return countriesAndTerritories;
    }

    public String getGeoId() {
        return geoId;
    }

    public String getCountryterritoryCode() {
        return countryterritoryCode;
    }

    public int getPopData2018() {
        return popData2018;
    }

    public String getContinentExp() {
        return continentExp;
    }
}
