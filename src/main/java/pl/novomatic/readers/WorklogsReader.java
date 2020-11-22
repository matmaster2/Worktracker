package pl.novomatic.readers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.novomatic.models.IModel;
import pl.novomatic.models.WorkLog;

import java.io.*;
import java.util.ArrayList;

public class WorklogsReader implements IFileReader {
    ArrayList<IModel> workLogs = new ArrayList<>();
    String filePath = "worklogs.json";
    @Override
    public String getFilePath() {
        return filePath;
    }

    public ArrayList<IModel> getObjectsFromFile() {
        JSONReader jsonReader = new JSONReader(this);
        JSONArray jsonArray = jsonReader.getJSONArrayFromFile();
        jsonArray.forEach(task -> parseWorkslogsObject((JSONObject) task));
        return workLogs;
    }

    private void parseWorkslogsObject(JSONObject worklog) {
        String author = (String) worklog.get("author");
        Long timeLogged = (Long) worklog.get("timeLogged");
        Long date = (Long) worklog.get("date");
        Long taskID = (Long) worklog.get("taskID");

        WorkLog workLogsObj = new WorkLog.Builder()
                .setAuthor(author)
                .setTimeLogged(timeLogged)
                .setDate(date)
                .setTaskID(taskID)
                .build();
        workLogs.add(workLogsObj);
    }
}
