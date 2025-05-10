import java.util.ArrayList;
import java.util.List;

public class Room {
    private int id;
    private String name;
    private Topic topic;
    private List<Student> students;
    private List<StudyResource> studyResource;
    private List<StudySession> studySession;

    public Room(int id, String name, Topic topic) {
        this.id = id;
        this.name = name;
        this.topic = topic;
        this.students = new ArrayList<>();
        this.studyResource = new ArrayList<>();
        this.studySession = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", topic=" + topic +
                ", students=" + students +
                ", studyResource=" + studyResource +
                ", studySession=" + studySession +
                '}';
    }
}
