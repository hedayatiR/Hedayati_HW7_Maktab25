package myapp.model;

public class Teacher {
    private long id;
    private String name;
    private int code;

    public Teacher(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public Teacher() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}