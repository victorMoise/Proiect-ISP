import java.util.ArrayList;
import java.util.List;

public class StudyGroup {
    private String name;
    private Admin createdBy;
    private List<Student> groups = new ArrayList<>();
    private List<StudySession> sessions  = new ArrayList<>();
    private List<StudyMaterial> materials = new ArrayList<>();

    public StudyGroup(String name, Admin createdBy) {
        this.name = name;
        this.createdBy = createdBy;
    }

    public void addMember(Student student) {

    }

    public void addSession(StudySession s) {

    }

    public void addMaterial(StudyMaterial m) {

    }

    public List<StudySession>  getSessions()  {
        return sessions;
    }
    public List<StudyMaterial> getMaterials() {
        return materials;
    }
}
