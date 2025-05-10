import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StudySession {
    private Integer id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public StudySession(Integer id, String startTime, Integer duration) {
        this.id = id;
        this.startTime = LocalDateTime.parse(startTime, formatter);
        this.endTime = this.startTime.plusMinutes(duration);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public String getStartTime() {
        return startTime.format(formatter);
    }

    public String getEndTime() {
        return endTime.format(formatter);
    }
}