package Project.Controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import Project.Bussines.DataReshapeThreadHandler;

public class DataAccess {
    private String url = "null";

    public void getDataFromUrl(String url){
        this.url = url;
        try {
            getDataFromUrlWorker();
        } catch (IOException e) { e.printStackTrace();}
    }

    private void getDataFromUrlWorker() throws IOException {

        String temp = "null";
        String dataInString = "null";
        URL U = new URL(this.url);
        URLConnection Uconn = U.openConnection();
        InputStreamReader ISR = new InputStreamReader(Uconn.getInputStream());
        Scanner SC = new Scanner(ISR);
        int counter =0;
        StringBuilder  dataInStringList = new StringBuilder();
        while (SC.hasNextLine()) {
            dataInStringList.append(SC.nextLine());
            counter++;
            //if (counter == 10006){break;}
            System.out.println(counter);
        }
        SC.close();
        System.out.println("Veriler Çekildi");
        DataReshapeThreadHandler DATH = new DataReshapeThreadHandler("thread1DataReshape", dataInStringList.toString());
        DATH.start();
    }
}
