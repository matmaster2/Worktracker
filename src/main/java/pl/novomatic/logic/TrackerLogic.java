package pl.novomatic.logic;

import pl.novomatic.models.Task;
import pl.novomatic.models.WorkLog;
import pl.novomatic.readers.TaskReader;
import pl.novomatic.readers.WorkLogsReader;
import pl.novomatic.validation.TrackerValidation;

import java.util.ArrayList;

public class TrackerLogic {

    private TaskReader taskReader;
    private WorkLogsReader worklogsReader;
    private TrackerValidation validation = new TrackerValidation(this);
    private ArrayList<Task> tasks;
    private ArrayList<WorkLog> workLogs;

    public TrackerLogic(TaskReader taskReader, WorkLogsReader workLogsReader) {
        this.taskReader = taskReader;
        this.worklogsReader = workLogsReader;
        tasks = taskReader.getObjectsFromFile();
        workLogs = workLogsReader.getObjectsFromFile();
    }


    public void getAllTasksTime() {
        for (int i = 0; i < tasks.size(); i++) {
            getTaskTIme(i);
        }
    }


    public void getTaskTIme(int taskId) {
        if (taskId < tasks.size()) {
            boolean isValid = true;
            Task task = tasks.get(taskId);
            ArrayList<Long> ids = new ArrayList<>();
            long time = 0;
            ids.add(task.getId());
            while (task.getParent() != -1) {
                long parentId = task.getParent();
                String category = task.getCategory();
                task = tasks.get((int) parentId);
                if (!validation.isCategoryTaskValid(category, task.getCategory())) {
                    System.out.println("Error in task " + taskId + ". Invalid category in related task " + task.getId());
                    isValid = false;
                    break;
                }
                ids.add(task.getId());
            }
            if (isValid) {
                for (int j = 0; j < workLogs.size(); j++) {
                    WorkLog workLog = workLogs.get(j);

                    for (int k = 0; k < ids.size(); k++) {
                        if (workLog.getTaskID() == ids.get(k)) {
                            time = time + workLog.getTimeLogged();
                        }
                    }
                }
                System.out.println("Time for task " + taskId + " is: " + time);
            }
        } else {
            System.out.println("Error - id value is too high.");
        }
    }


}
