package test;

import org.junit.jupiter.api.Test;
import proiect.StudyGroup;
import proiect.StudySession;
import proiect.Topic;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CreateStudySessionTest {

    @Test
    void testCreateStudySession() {
        Topic topic = Topic.MATHEMATICS;
        Date date = new Date();
        String location = "Room A101";
        StudyGroup group = new StudyGroup("Math Group", null);
        StudySession session = new StudySession(topic, date, location, group);

        assertNotNull(session, "StudySession object should not be null");

        assertEquals(topic, session.getTopic(), "Topic should match the provided topic");

        String expectedDetails = "Topic: " + topic + ", Date: " + date.toString() + ", Location: " + location;
        assertEquals(expectedDetails, session.getDetails(), "Session details should match expected format");

        assertTrue(session.getDetails().contains(location), "Details should contain the location");

        assertFalse(session.getDetails().contains("SCIENCE"), "Details should not contain unrelated topics");
    }
}
