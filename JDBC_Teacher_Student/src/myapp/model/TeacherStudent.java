package myapp.model;

public class TeacherStudent {
    private long idStudent;
    private long idTeacher;

    public TeacherStudent(long idStudent, long idTeacher) {
        this.idStudent = idStudent;
        this.idTeacher = idTeacher;
    }

    public long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(long idStudent) {
        this.idStudent = idStudent;
    }

    public long getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(long idTeacher) {
        this.idTeacher = idTeacher;
    }
}

