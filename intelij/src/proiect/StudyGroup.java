package proiect;

import java.util.ArrayList;
import java.util.List;

public class StudyGroup {
    private final String name;
    private final Admin createdBy;
    private final List<Student> students;
    private final List<StudySession> sessions;
    private final List<StudyMaterial> materials;

    public StudyGroup(String name, Admin createdBy) {
        this.name = name;
        this.createdBy = createdBy;
        this.students = new ArrayList<>();
        this.sessions = new ArrayList<>();
        this.materials = new ArrayList<>();
    }

    public void addMember(Student student) {
        students.add(student);
    }

    public void addSession(StudySession session) {
        sessions.add(session);
    }

    public void addMaterial(StudyMaterial material) {
        materials.add(material);
    }

    public List<Student> getMembers() {
        return students;
    }

    public List<StudySession>  getSessions()  {
        return sessions;
    }

    public List<StudyMaterial> getMaterials() {
        return materials;
    }

    public String getName() {
        return this.name;
    }

    public Admin getCreatedBy() {
        return createdBy;
    }
}
