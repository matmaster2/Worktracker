package pl.novomatic.models;

public class WorkLog implements IModel {

    private String author;

    private Long timeLogged;

    private Long date;

    private Long taskID;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getTimeLogged() {
        return timeLogged;
    }

    public void setTimeLogged(Long timeLogged) {
        this.timeLogged = timeLogged;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getTaskID() {
        return taskID;
    }

    public void setTaskID(Long taskID) {
        this.taskID = taskID;
    }


}
