package pl.novomatic.readers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.novomatic.models.Task;

import java.io.*;
import java.util.ArrayList;

public class TaskReader {

    ArrayList<Task> tasks = new ArrayList<>();
    private JSONParser jsonParser = new JSONParser();

    public static void main(String[] args) {
        TaskReader bla = new TaskReader();
        bla.dataFromFile();
    }
    InputStream is = getClass().getClassLoader().getResourceAsStream("tasks.json");
    public void dataFromFile() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            Object obj = jsonParser.parse(reader);
            JSONArray taskList = (JSONArray) obj;
            taskList.forEach(task -> parseTaskObject((JSONObject) task));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

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
