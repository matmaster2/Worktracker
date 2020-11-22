package pl.novomatic.readers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import pl.novomatic.models.WorkLog;

import java.util.ArrayList;

public class WorkLogsReader extends IFileReader {
    private ArrayList<WorkLog> workLogs = new ArrayList<>();
    private String filePath = "worklogs.json";

    @Override
    public String getFilePath() {
        return filePath;
    }

    public ArrayList<WorkLog> getObjectsFromFile() {
        JSONArray jsonArray = this.getJSONArrayFromFile();
        jsonArray.forEach(workLogs -> parseWorksLogsObject((JSONObject) workLogs));
        return workLogs;
    }

    private void parseWorksLogsObject(JSONObject workLog) {
        String author = (String) workLog.get("author");
        Long timeLogged = (Long) workLog.get("timeLogged");
        Long date = (Long) workLog.get("date");
        Long taskID = (Long) workLog.get("taskID");

        WorkLog workLogsObj = new WorkLog.Builder()
                .setAuthor(author)
                .setTimeLogged(timeLogged)
                .setDate(date)
                .setTaskID(taskID)
                .build();
        workLogs.add(workLogsObj);
    }
}
