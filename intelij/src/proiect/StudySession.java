package proiect;

import java.util.Date;

public class StudySession {
    private Topic topic;
    private Date date;
    private String location;
    StudyGroup group;

    public StudySession(Topic topic, Date date, String location, StudyGroup group) {
        this.topic = topic;
        this.date = date;
        this.location = location;
        this.group = group;
    }

    public Topic getTopic() {
        return topic;
    }

    public String getDetails() {
        return "Topic: " + topic + ", Date: " + date.toString() + ", Location: " + location;
    }
}
