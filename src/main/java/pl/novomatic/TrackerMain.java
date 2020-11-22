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
        trackerLogic.getTaskTIme(1);
        trackerLogic.getTaskTIme(107);

       // TrackerMain.printObjectsInfo(tasks);
      //  TrackerMain.printObjectsInfo(workLogs);

    }

    public static void printObjectsInfo(TaskReader taskReader) {
        taskReader.getObjectsFromFile().stream().forEach(x -> System.out.println(x.toString()));

    }

    public static void printObjectsInfo(WorkLogsReader workLogsReader) {
        workLogsReader.getObjectsFromFile().stream().forEach(x -> System.out.println(x.toString()));

    }


}
