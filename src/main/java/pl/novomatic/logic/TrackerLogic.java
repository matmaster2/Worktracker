package pl.novomatic.logic;

import pl.novomatic.enums.ProjectCategory;
import pl.novomatic.models.Task;
import pl.novomatic.models.WorkLog;
import pl.novomatic.readers.TaskReader;
import pl.novomatic.readers.WorkLogsReader;
import pl.novomatic.validation.TrackerValidation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
            getTaskTime(i);
        }
    }


    public void getTaskTime(int taskId) {
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
                    System.err.println("Error in task " + taskId + ". Invalid category in related task " + task.getId());
                    isValid = false;
                    break;
                }
                ids.add(task.getId());
            }
            if (isValid) {
                for (int j = 0; j < workLogs.size(); j++) {
                    WorkLog workLog = workLogs.get(j);
                    for (int k = 0; k < ids.size(); k++) {
                        if (workLog.getTaskID().equals(ids.get(k))) {
                            if (workLog.getTimeLogged() > 0) {
                                time = time + workLog.getTimeLogged();
                            } else {
                                System.err.println("Error - time logged value is too low.");
                            }

                        }
                    }
                }
                System.out.println("Time for task " + taskId + " is: " + time);
            }
        } else {
            System.err.println("Error - id value is too high.");
        }
    }

    public void getAllProjectsTime() {
        Map<String, Long> projects = new HashMap<>();

        for (ProjectCategory projectCategory : ProjectCategory.values()) {
            projects.put(projectCategory.getName(), null);
        }

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            projects.put(task.getProject(), task.getId());
        }


    }


}
