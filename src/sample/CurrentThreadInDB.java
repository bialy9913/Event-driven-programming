package sample;

import database.ReadFromDatabase;

public class CurrentThreadInDB {
    private ReadFromDatabase readFromDatabase=null;
    public CurrentThreadInDB(){

    }
    public void setReadFromDatabase(ReadFromDatabase readFromDatabase) {
        this.readFromDatabase = readFromDatabase;
    }

    public ReadFromDatabase getReadFromDatabase() {
        return readFromDatabase;
    }
}
