package pl.novomatic.enums;

public enum ProjectCategory {
    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E");

    private String name;

    ProjectCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
