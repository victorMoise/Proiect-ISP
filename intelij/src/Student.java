import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private List<StudyGroup> groups = new ArrayList<>();

    public Student(int id, String username, String email, String password) {
        super(id, username, email, password);
    }

    public void joinStudyGroup(StudyGroup group) {
        groups.add(group);
    }

    public List<StudyGroup> getGroups() {
        return groups;
    }

    public void uploadMaterial(StudyMaterial material) {

    }
}
