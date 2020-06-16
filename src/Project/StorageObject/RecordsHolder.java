package Project.StorageObject;

import java.util.ArrayList;

public class RecordsHolder {

    static public ArrayList<Records> _records;

    public RecordsHolder(){}

    public ArrayList<Records> getRecords() {
        return this._records;
    }

    public void setRecords(ArrayList<Records> records){
        this._records = records;

    }

    public static ArrayList<Records> staticRecords(){
        return _records;
    }
}
