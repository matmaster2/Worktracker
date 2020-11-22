package pl.novomatic.models;

public class Task implements IModel {

    private final Long id;
    private final String project;
    private final String category;
    private final Long parent;
    private Task(Long id, String project, String category, Long parent) {
        this.id = id;
        this.project = project;
        this.category = category;
        this.parent = parent;
    }

    public Long getId() {
        return id;
    }

    public String getProject() {
        return project;
    }

    public String getCategory() {
        return category;
    }

    public Long getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "Task id:" + getId() +
                "/nproject:" + getProject() +
                "/ncategory:" + getCategory() +
                "/nparent" + getParent();
    }

    public static class Builder {
        private Long id;
        private String project;
        private String category;
        private Long parent;

        public Builder() {
        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setProject(String project) {
            this.project = project;
            return this;
        }

        public Builder setCategory(String category) {
            this.category = category;
            return this;
        }

        public Builder setParent(Long parent) {
            this.parent = parent;
            return this;
        }

        public Task build() {
            return new Task(id, project, category, parent);
        }
    }


}
