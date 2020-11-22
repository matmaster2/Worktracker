package pl.novomatic.validation;

import pl.novomatic.enums.TaskCategory;
import pl.novomatic.logic.TrackerLogic;

public class TrackerValidation {

    TrackerLogic trackerLogic;

    public TrackerValidation(TrackerLogic trackerLogic) {
        this.trackerLogic = trackerLogic;
    }

    public boolean isCategoryTaskValid(String category, String parentCategory) {
        int id = 0;
        int parentId = 0;
        for (TaskCategory taskCategory : TaskCategory.values()) {
            if (category.equals(taskCategory.getName())) {
                id = taskCategory.getId();
            }
            if (parentCategory.equals(taskCategory.getName())) {
                parentId = taskCategory.getId();
            }
        }

        if (id >= parentId) {
            return false;
        }
        return true;
    }
}
