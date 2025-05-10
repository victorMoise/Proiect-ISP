import java.util.ArrayList;

public class Student extends User {
    private int year;
    private int group;
    private String series;
    private String major;
    private String university;
    private ArrayList<Topic> topic = new ArrayList<>();

    public Student() {

    }

    public Student(String username, String email, String password, Role role, int year, int group, String series, String major, String university) {
        super(username, email, password, role);
        this.year = year;
        this.group = group;
        this.series = series;
        this.major = major;
        this.university = university;
    }

    public int getYear() {
        return year;
    }

    public int getGroup() {
        return group;
    }

    public String getSeries() {
        return series;
    }

    public String getMajor() {
        return major;
    }

    public String getUniversity() {
        return university;
    }

    public ArrayList<Topic> getTopic() {
        return topic;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setTopic(ArrayList<Topic> topic) {
        this.topic = topic;
    }

    public void addTopic(Topic topic) {
        this.topic.add(topic);
    }

    public void removeTopic(Topic topic) {
        this.topic.remove(topic);
    }

    public void clearTopics() {
        this.topic.clear();
    }
}