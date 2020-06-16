package Project.Visual.Graphs;

import Project.StorageObject.Records;
import Project.StorageObject.RecordsHolder;
import Project.StorageObject.SummaryOfRecords;
import Project.StorageObject.SummaryOfRecordsHolder;
import Project.Visual.Base.BaseController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GraphsController extends RecordsHolder {

    private boolean isNowWhat = true;
    private static int whereIam = 1;

    @FXML
    void buttonChangeGraphType(ActionEvent event) {

        if (whereIam == 5) {
            whereIam = 0;
        }
        if (whereIam == 4) {
            stackedBarChart2FX.setVisible(true);
            stackedBarChart1FX.setVisible(false);
            lineChart2FX.setVisible(false);
            lineChart1FX.setVisible(false);
            listViewForLineChartFX.setVisible(false);
            buttonForListViewFX.setVisible(false);
            tableGraphFx.setVisible(false);
            whereIam++;
        }
        if (whereIam == 3) {
            stackedBarChart2FX.setVisible(false);
            stackedBarChart1FX.setVisible(false);
            lineChart2FX.setVisible(true); listViewForLineChartFX.setVisible(true); buttonForListViewFX.setVisible(true);
            lineChart1FX.setVisible(false);
            tableGraphFx.setVisible(false);
            whereIam++;
        }
        if (whereIam == 2) {
            stackedBarChart2FX.setVisible(false);
            stackedBarChart1FX.setVisible(true);
            lineChart2FX.setVisible(false);
            lineChart1FX.setVisible(false);
            listViewForLineChartFX.setVisible(false);
            buttonForListViewFX.setVisible(false);
            tableGraphFx.setVisible(false);
            whereIam++;
        }
        if (whereIam == 1) {
            stackedBarChart2FX.setVisible(false);
            stackedBarChart1FX.setVisible(false);
            lineChart2FX.setVisible(false);
            lineChart1FX.setVisible(true);listViewForLineChartFX.setVisible(true); buttonForListViewFX.setVisible(true);
            tableGraphFx.setVisible(false);
            whereIam++;
        }
        if (whereIam == 0) {
            stackedBarChart2FX.setVisible(false);
            stackedBarChart1FX.setVisible(false);
            lineChart2FX.setVisible(false);
            buttonForListViewFX.setVisible(false);
            lineChart1FX.setVisible(false);
            listViewForLineChartFX.setVisible(false);
            tableGraphFx.setVisible(true);
            whereIam++;
        }
    }

    @FXML
    void GetValuesOnAction(ActionEvent event) {

        if (isNowWhat) {
            insertData();
            getValuesButton.setDisable(true);
        }
    }

    @FXML
    public static final ObservableList<DataInputerForTableView> valuesToInsert = FXCollections.observableArrayList();

    private void insertData() {


        ArrayList<SummaryOfRecords> summaryOfRecords = SummaryOfRecordsHolder.staticSumOfRecords();
        //Collections.reverse(summaryOfRecords);
        listViewForLineChartFX.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        for (SummaryOfRecords r : summaryOfRecords) {
            listViewForLineChartFX.getItems().add(r.getCountriesAndTerritories());
            valuesToInsert.add(new DataInputerForTableView(r.getCountriesAndTerritories(), r.getTotalCases(), r.getNewCases(),
                    r.getTotalDeaths(), r.getNewDeaths(), r.getPopData2018(),
                    Float.parseFloat(String.valueOf(r.getTotalDeaths())) / Float.parseFloat(String.valueOf(r.getTotalCases())),
                    Float.parseFloat(String.valueOf(r.getTotalCases())) / Float.parseFloat(String.valueOf(r.getPopData2018()))));
        }

        c1Country.setCellValueFactory(new PropertyValueFactory<DataInputerForTableView, String>("c1Country"));
        c2TotalCases.setCellValueFactory(new PropertyValueFactory<DataInputerForTableView, String>("c2TotalCases"));
        c3NewCases.setCellValueFactory(new PropertyValueFactory<DataInputerForTableView, String>("c3NewCases"));
        c4TotalDeaths.setCellValueFactory(new PropertyValueFactory<DataInputerForTableView, String>("c4TotalDeaths"));
        c5NewDeaths.setCellValueFactory(new PropertyValueFactory<DataInputerForTableView, String>("c5NewDeaths"));
        c6Population.setCellValueFactory(new PropertyValueFactory<DataInputerForTableView, String>("c6Population"));
        c7Mortality.setCellValueFactory(new PropertyValueFactory<DataInputerForTableView, String>("c7Mortality"));
        c8AttackRate.setCellValueFactory(new PropertyValueFactory<DataInputerForTableView, String>("c8AttackRate"));

        tableGraphFx.setItems(valuesToInsert);

        //Collections.sort(_records, Comparator.comparing(Records::getDateRep));
        //Collections.sort(_records, Comparator.comparing(Records::getMonth));
        Collections.reverse(_records);
        stackedBarChartInputer();

    }

    private void lineChartInputer() {


        lineChart1FX.getData().clear();
        lineChart2FX.getData().clear();
        lineChart1FX.setTitle("Covid-19 Cases By County");
        lineChart2FX.setTitle("Covid-19 Deaths By County");

        XYChart.Series series = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();

        boolean isThisFirst = true;
        boolean isThisFirstCountry = true;
        String lastCountry = "";
        int totalCases = 0, totalDeaths = 0;
        int index = 0;

        ObservableList<String> items = FXCollections.observableArrayList();
        items = listViewForLineChartFX.getSelectionModel().getSelectedItems();
        String itemsInString = items.toString();
        String[] itemsInArray;
        itemsInString = itemsInString.replaceAll("\\[", "");
        itemsInString = itemsInString.replaceAll("]", "");
        itemsInArray = itemsInString.split(", ");

        for (Records r : _records) {
            for (String m : itemsInArray) {
                if (m.equals(r.getCountriesAndTerritories())) {

                    if (isThisFirst) {

                        lastCountry = r.getCountriesAndTerritories();
                        series.setName(r.getCountriesAndTerritories());
                        series2.setName(r.getCountriesAndTerritories());
                        isThisFirst = false;
                    }

                    if (!(r.getCountriesAndTerritories().equals(lastCountry)) && !isThisFirst) {
                        lineChart1FX.getData().add(series);
                        lineChart2FX.getData().add(series2);
                        series = new XYChart.Series();
                        series2 = new XYChart.Series();
                        lastCountry = r.getCountriesAndTerritories();
                        series.setName(lastCountry);
                        series2.setName(lastCountry);
                        totalCases = 0;
                        totalDeaths = 0;
                        isThisFirstCountry = false;
                    } else {
                        totalCases += r.getCases();
                        totalDeaths += r.getDeaths();

                        if (BaseController.theStaticDate.isBefore(LocalDate.of(r.getYear(), r.getMonth(), r.getDay())) || BaseController.theStaticDate.isEqual(LocalDate.of(r.getYear(), r.getMonth(), r.getDay()))) {
                            if (isThisFirstCountry) {
                                while (true) {
                                    if (BaseController.totalDates.get(index).isEqual(LocalDate.of(r.getYear(), r.getMonth(), r.getDay()))) {
                                        break;
                                    } else {

                                        series.getData().add(new XYChart.Data(BaseController.totalDates.get(index).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")).replaceAll("-", "/"), totalCases));
                                        series2.getData().add(new XYChart.Data(BaseController.totalDates.get(index).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")).replaceAll("-", "/"), totalDeaths));
                                        index++;
                                    }
                                }

                            } else {

                                series.getData().add(new XYChart.Data(r.getDateRep(), totalCases));
                                series2.getData().add(new XYChart.Data(r.getDateRep(), totalDeaths));
                                index++;
                            }


                        }
                    }
                }
            }

        }
        lineChart1FX.getData().add(series);
        lineChart2FX.getData().add(series2);
        series = new XYChart.Series();
        series2 = new XYChart.Series();
        series.setName(lastCountry);
        series2.setName(lastCountry);
    }

    public void stackedBarChartInputer() {


        int sum = 0;
        String[] continents = {"Asia", "Africa", "America", "Oceania", "Europe"};
        LocalDate tempLocalDate;
        String lastOne = "";

        for (int d = 0; d<2; d++) {
            for (String i : continents) {
                XYChart.Series series = new XYChart.Series<>();
                series.setName(i);
                sum = 0;
                for (Records r : _records) {
                    tempLocalDate = LocalDate.of(r.getYear(), r.getMonth(), r.getDay());
                    if (!lastOne.equals(r.getCountriesAndTerritories())) {
                        lastOne = r.getCountriesAndTerritories();
                        sum = 0;
                    }
                    if (r.getContinentExp().equals(i)) {
                        if(d==0){
                            sum += r.getCases();}
                        else{
                            sum += r.getDeaths();}

                        if (tempLocalDate.isAfter(BaseController.theStaticDate) || tempLocalDate.isEqual(BaseController.theStaticDate)) {
                            series.getData().add(new XYChart.Data(r.getDateRep(), sum));
                        }
                    }
                }
                if(d == 0){
                    stackedBarChart1FX.getData().add(series);
                }else {
                    stackedBarChart2FX.getData().add(series);
                }
            }
        }
    }

    @FXML
    void buttonForListViewOnAction(ActionEvent event) {
        lineChartInputer();
    }

    public void Draw() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(GraphsController.class.getResource("Graphs.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 900, 500);
            Stage stage = new Stage();
            stage.setTitle("Window For Graphs");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GraphsController() {

    }

    @FXML
    private ImageView imageViewFX;

    @FXML
    private ListView listViewForLineChartFX;

    @FXML
    private Button buttonForListViewFX;

    @FXML
    private StackedBarChart stackedBarChart2FX;

    @FXML
    private LineChart lineChart2FX;

    @FXML
    private NumberAxis lineChardNumberAxsisFx;

    @FXML
    private TableView<DataInputerForTableView> tableGraphFx;

    @FXML
    private Button buttonChangeGraphTypeFx1;

    @FXML
    private LineChart lineChart1FX;

    @FXML
    private TableColumn c1Country;

    @FXML
    private TableColumn c2TotalCases;

    @FXML
    private TableColumn c3NewCases;

    @FXML
    private TableColumn c4TotalDeaths;

    @FXML
    private TableColumn c5NewDeaths;

    @FXML
    private TableColumn c6Population;

    @FXML
    private TableColumn c7Mortality;

    @FXML
    private TableColumn c8AttackRate;

    @FXML
    private Button getValuesButton;

    @FXML
    private StackedBarChart stackedBarChart1FX;

}