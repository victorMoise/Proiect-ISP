import java.util.List;

public class Admin extends User {
    public Admin(int id, String name, String email, String password) {
        super(id, name, email, password);
    }

    public StudyGroup createGroup(String name, List<StudyGroup> groups) {
        groups.add(new StudyGroup(name, this));
        return groups.getLast();
    }

    public void deleteGroup(StudyGroup group, List<StudyGroup> groups) {
        if (groups.contains(group)) {
            groups.remove(group);
        } else {
            System.out.println("Group not found.");
        }
    }
}
