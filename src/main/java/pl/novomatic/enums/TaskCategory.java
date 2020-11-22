package pl.novomatic.enums;

public enum TaskCategory {
    EPIC("Epic", 4),
    STORY("Story", 3),
    TASK("Task", 2),
    SUBTASK("Sub-Task", 1);

    private String name;
    private int id;

    TaskCategory(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName(){return name;}

    public int getId(){return id;}
}
