package Project.StorageObject;

public class SummaryOfRecords {

    private String dateRep;
    private int day;
    private int month;
    private int year;
    private int totalCases;
    private int totalDeaths;
    private int newCases;
    private int newDeaths;
    private String countriesAndTerritories;
    private String countryterritoryCode;
    private String geoId;
    private int popData2018;
    private String continentExp;

    public SummaryOfRecords(String dateRep, int day, int month, int year, int totalCases, int totalDeaths, String countriesAndTerritories, String countryterritoryCode, String geoId, int popData2018, String continentExp,int newDeaths,int newCases) {
        this.dateRep = dateRep;
        this.day = day;
        this.month = month;
        this.year = year;
        this.totalCases = totalCases;
        this.totalDeaths = totalDeaths;
        this.countriesAndTerritories = countriesAndTerritories;
        this.countryterritoryCode = countryterritoryCode;
        this.geoId = geoId;
        this.popData2018 = popData2018;
        this.continentExp = continentExp;
        this.newCases = newCases;
        this.newDeaths = newDeaths;
    }

    public String getDateRep() {
        return dateRep;
    }

    public void setDateRep(String dateRep) {
        this.dateRep = dateRep;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(int totalCases) {
        this.totalCases = totalCases;
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(int totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public String getCountriesAndTerritories() {
        return countriesAndTerritories;
    }

    public void setCountriesAndTerritories(String countriesAndTerritories) {
        this.countriesAndTerritories = countriesAndTerritories;
    }

    public String getCountryterritoryCode() {
        return countryterritoryCode;
    }

    public void setCountryterritoryCode(String countryterritoryCode) {
        this.countryterritoryCode = countryterritoryCode;
    }

    public String getGeoId() {
        return geoId;
    }

    public void setGeoId(String geoId) {
        this.geoId = geoId;
    }

    public int getPopData2018() {
        return popData2018;
    }

    public void setPopData2018(int popData2018) {
        this.popData2018 = popData2018;
    }

    public String getContinentExp() {
        return continentExp;
    }

    public void setContinentExp(String continentExp) {
        this.continentExp = continentExp;
    }

    public int getNewCases() {
        return newCases;
    }

    public void setNewCases(int newCases) {
        this.newCases = newCases;
    }

    public int getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(int newDeaths) {
        this.newDeaths = newDeaths;
    }

}