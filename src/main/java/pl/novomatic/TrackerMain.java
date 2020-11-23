package pl.novomatic;

import pl.novomatic.logic.TrackerLogic;
import pl.novomatic.readers.TaskReader;
import pl.novomatic.readers.WorkLogsReader;

public class TrackerMain {

    public static void main(String[] args) {
        TaskReader tasks = new TaskReader();
        WorkLogsReader workLogs = new WorkLogsReader();
        TrackerLogic trackerLogic = new TrackerLogic(tasks, workLogs);
        trackerLogic.getAllTasksTime();
       // TrackerMain.printObjectsInfo(tasks);
      //  TrackerMain.printObjectsInfo(workLogs);

    }
}
