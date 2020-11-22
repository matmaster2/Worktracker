package pl.novomatic.readers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import pl.novomatic.models.IModel;
import pl.novomatic.models.Task;

import java.util.ArrayList;

public class TaskReader implements IFileReader {

    private ArrayList<IModel> tasks = new ArrayList<>();
    private String filePath = "tasks.json";

    @Override
    public String getFilePath() {
        return filePath;
    }

    public ArrayList<IModel> getObjectsFromFile() {
        JSONReader jsonReader = new JSONReader(this);
        JSONArray jsonArray = jsonReader.getJSONArrayFromFile();
        jsonArray.forEach(task -> parseTaskObject((JSONObject) task));
        return tasks;
    }

    private void parseTaskObject(JSONObject task) {
        String category = (String) task.get("category");
        Long id = (Long) task.get("id");
        String project = (String) task.get("project");
        Long parent = (Long) task.get("parent");

        Task taskObj = new Task.Builder()
                .setCategory(category)
                .setId(id)
                .setProject(project)
                .setParent(parent)
                .build();
        tasks.add(taskObj);
    }

}
