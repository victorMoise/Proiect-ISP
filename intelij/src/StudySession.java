import java.util.Date;

public class StudySession {
    private Topic topic;
    private Date   date;
    private String location;

    public StudySession(Topic topic, Date date, String location) {
        this.topic = topic;
        this.date = date;
        this.location = location;
    }
}
