package Project.Visual.Base;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import Project.Controller.DataAccessThreadHandler;
import Project.Visual.Graphs.GraphsController;
import javafx.scene.text.Text;
import java.time.LocalDate;
import java.util.ArrayList;

public class BaseController {

    GraphsController GH = new GraphsController();
    public static LocalDate theStaticDate;
    public static ArrayList<LocalDate> totalDates = new ArrayList<>();

    @FXML
    private DatePicker datePickerFX;

    @FXML
    private Text textValidDateFX;

    @FXML
    private TextField textBoxForUrl1;

    @FXML
    void urlGoButton1(ActionEvent event) {

        try {
            theStaticDate = datePickerFX.getValue();
            LocalDate start = theStaticDate;
            LocalDate end = LocalDate.parse(java.time.LocalDate.now().toString());

            while (!start.isAfter(end)) {
                totalDates.add(start);
                start = start.plusDays(1);
            }

            DataAccessThreadHandler DATH = new DataAccessThreadHandler("thread1DataAccess", textBoxForUrl1.getText());
            DATH.start();
            GH.Draw();
            ((Node) (event.getSource())).getScene().getWindow().hide();

        }
        catch (Exception e){
            textValidDateFX.setVisible(true);
        }

    }

    public void BaseController(String[] args) {

    }

}
