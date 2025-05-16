package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import proiect.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StudyGroupTest {
    private StudyGroup studyGroup;
    private Admin admin;

    @BeforeEach
    void setUp() {
        admin = new Admin(1, "admin", "admin@admin.com", "adminPassword");
        studyGroup = new StudyGroup("Math Group", admin);
    }

    @Test
    void addMember() {
        Student student = new Student(2, "Alice", "alice@example.com", "pass123");
        studyGroup.addMember(student);
        List<Student> members = studyGroup.getMembers();
        assertEquals(1, members.size());
        assertTrue(members.contains(student));
    }

    @Test
    void addSession() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date sessionDate = formatter.parse("2025-05-16 18:00");
        StudySession session = new StudySession(
            Topic.BUSINESS,
            sessionDate,
            "Room 101",
            studyGroup
        );
        studyGroup.addSession(session);
        List<StudySession> sessions = studyGroup.getSessions();
        assertEquals(1, sessions.size());
        assertEquals(Topic.BUSINESS, sessions.getFirst().getTopic());
    }

    @Test
    void addMaterial() {
        StudyMaterial material = new StudyMaterial("Lecture Notes", "http://example.com/notes", MaterialType.LINK, studyGroup);
        studyGroup.addMaterial(material);
        List<StudyMaterial> materials = studyGroup.getMaterials();
        assertEquals(1, materials.size());
        assertEquals("Lecture Notes", materials.getFirst().getTitle());
    }

    @Test
    void getMembers() {
        assertTrue(studyGroup.getMembers().isEmpty());
        studyGroup.addMember(new Student(3, "Bob", "bob@example.com", "pass321"));
        assertEquals(1, studyGroup.getMembers().size());
    }

    @Test
    void getSessions() throws ParseException {
        assertTrue(studyGroup.getSessions().isEmpty());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date sessionDate = formatter.parse("2025-05-16 18:00");
        StudySession session = new StudySession(
                Topic.BUSINESS,
                sessionDate,
                "Room 101",
                studyGroup
        );
        studyGroup.addSession(session);
        assertEquals(1, studyGroup.getSessions().size());
    }

    @Test
    void getMaterials() {
        assertTrue(studyGroup.getMaterials().isEmpty());
        studyGroup.addMaterial(new StudyMaterial("Slides", "http://example.com/slides", MaterialType.LINK, studyGroup));
        assertEquals(1, studyGroup.getMaterials().size());
    }

    @Test
    void getName() {
        assertEquals("Math Group", studyGroup.getName());
    }

    @Test
    void getCreatedBy() {
        assertEquals(admin, studyGroup.getCreatedBy());
    }
}