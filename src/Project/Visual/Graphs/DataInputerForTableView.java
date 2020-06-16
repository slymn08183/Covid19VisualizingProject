package Project.Visual.Graphs;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DataInputerForTableView {

    private SimpleStringProperty c1Country;
    private SimpleIntegerProperty c2TotalCases;
    private SimpleIntegerProperty c3NewCases;
    private SimpleIntegerProperty c4TotalDeaths;
    private SimpleIntegerProperty c5NewDeaths;
    private SimpleIntegerProperty c6Population;
    private SimpleFloatProperty c7Mortality;
    private SimpleFloatProperty c8AttackRate;

    public DataInputerForTableView(String c1Country, int c2TotalCases, int c3NewCases, int c4TotalDeaths, int c5NewDeaths, int c6Population, Float c7Mortality, Float c8AttackRate) {
        this.c1Country = new SimpleStringProperty(c1Country);
        this.c2TotalCases = new SimpleIntegerProperty(c2TotalCases);
        this.c3NewCases = new SimpleIntegerProperty(c3NewCases);
        this.c4TotalDeaths = new SimpleIntegerProperty(c4TotalDeaths);
        this.c5NewDeaths = new SimpleIntegerProperty(c5NewDeaths);
        this.c6Population = new SimpleIntegerProperty(c6Population);
        this.c7Mortality = new SimpleFloatProperty(c7Mortality);
        this.c8AttackRate = new SimpleFloatProperty(c8AttackRate);
    }

    public String getC1Country() {
        return c1Country.get();
    }

    public SimpleStringProperty c1CountryProperty() {
        return c1Country;
    }

    public void setC1Country(String c1Country) {
        this.c1Country.set(c1Country);
    }

    public int getC2TotalCases() {
        return c2TotalCases.get();
    }

    public SimpleIntegerProperty c2TotalCasesProperty() {
        return c2TotalCases;
    }

    public void setC2TotalCases(int c2TotalCases) { this.c2TotalCases.set(c2TotalCases); }

    public int getC3NewCases() {
        return c3NewCases.get();
    }

    public SimpleIntegerProperty c3NewCasesProperty() {
        return c3NewCases;
    }

    public void setC3NewCases(int c3NewCases) {
        this.c3NewCases.set(c3NewCases);
    }

    public int getC4TotalDeaths() {
        return c4TotalDeaths.get();
    }

    public SimpleIntegerProperty c4TotalDeathsProperty() {
        return c4TotalDeaths;
    }

    public void setC4TotalDeaths(int c4TotalDeaths) { this.c4TotalDeaths.set(c4TotalDeaths); }

    public int getC5NewDeaths() {
        return c5NewDeaths.get();
    }

    public SimpleIntegerProperty c5NewDeathsProperty() {
        return c5NewDeaths;
    }

    public void setC5NewDeaths(int c5NewDeaths) {
        this.c5NewDeaths.set(c5NewDeaths);
    }

    public int getC6Population() {
        return c6Population.get();
    }

    public SimpleIntegerProperty c6PopulationProperty() {
        return c6Population;
    }

    public void setC6Population(int c6Population) {
        this.c6Population.set(c6Population);
    }

    public float getC7Mortality() { return c7Mortality.get(); }

    public SimpleFloatProperty c7MortalityProperty() { return c7Mortality; }

    public void setC7Mortality(float c7Mortality) { this.c7Mortality.set(c7Mortality); }

    public float getC8AttackRate() { return c8AttackRate.get(); }

    public SimpleFloatProperty c8AttackRateProperty() { return c8AttackRate; }

    public void setC8AttackRate(float c8AttackRate) { this.c8AttackRate.set(c8AttackRate); }

}