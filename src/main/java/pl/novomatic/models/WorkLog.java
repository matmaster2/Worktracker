package pl.novomatic.models;

public class WorkLog {

    private final String author;
    private final Long timeLogged;
    private final Long date;
    private final Long taskID;

    private WorkLog(String author, Long timeLogged, Long date, Long taskID) {
        this.author = author;
        this.timeLogged = timeLogged;
        this.date = date;
        this.taskID = taskID;
    }


    public String getAuthor() {
        return author;
    }

    public Long getTimeLogged() {
        return timeLogged;
    }

    public Long getDate() {
        return date;
    }

    public Long getTaskID() {
        return taskID;
    }

    @Override
    public String toString() {
        return "Author: " + getAuthor() +
                "\ntimeLogged: " + getTimeLogged() +
                "\ndate: " + getDate() +
                "\ntaskID: " + getTaskID();
    }

    public static class Builder {
        private String author;
        private Long timeLogged;
        private Long date;
        private Long taskID;

        public Builder() {
        }

        public Builder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder setTimeLogged(Long timeLogged) {
            this.timeLogged = timeLogged;
            return this;
        }

        public Builder setDate(Long date) {
            this.date = date;
            return this;
        }

        public Builder setTaskID(Long taskID) {
            this.taskID = taskID;
            return this;
        }

        public WorkLog build() {
            return new WorkLog(author, timeLogged, date, taskID);
        }

    }


}
