public class Admin extends User {
    public Admin(int id, String name, String email, String password) {
        super(id, name, email, password);
    }

    public StudyGroup createGroup(String name) {
        return null;
    }

    public void deleteGroup(StudyGroup group) {

    }
}
