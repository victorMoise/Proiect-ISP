package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import proiect.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ViewStudyMaterialsTest {
    private Student student;
    private StudyGroup studyGroup;

    @BeforeEach
    void setUp() {
        Admin admin = new Admin(1, "admin", "admin@admin.com", "adminPassword");
        student = new Student(2, "Andrei", "andrei@example.com", "pass123");
        studyGroup = new StudyGroup("Math Group", admin);
        student.joinStudyGroup(studyGroup);
        studyGroup.addMember(student);
    }

    @Test
    void testViewStudyMaterials() {

        List<StudyGroup> studentGroups = student.getGroups();
        assertFalse(studentGroups.isEmpty(), "You are not part of any study groups.");


        StudyGroup selectedGroup = studentGroups.getFirst();
        assertEquals("Math Group", selectedGroup.getName());


        List<StudyMaterial> materials = selectedGroup.getMaterials();
        assertTrue(materials.isEmpty(), "No study materials available.");


        StudyMaterial material = new StudyMaterial("Lecture Notes", "http://example.com/notes", MaterialType.LINK, selectedGroup);
        selectedGroup.addMaterial(material);
        materials = selectedGroup.getMaterials();
        assertFalse(materials.isEmpty(), "Study materials should be available.");
        assertEquals(1, materials.size());
        assertEquals("Lecture Notes", materials.getFirst().getTitle());


        System.out.println("Study Materials for " + selectedGroup.getName() + ":");
        for (StudyMaterial mat : materials) {
            System.out.println("Title: " + mat.getTitle());
            System.out.println("Link: " + mat.getLink());
            System.out.println("Type: " + mat.getType());
        }

        assertEquals("Lecture Notes", materials.getFirst().getTitle());
        assertEquals("http://example.com/notes", materials.getFirst().getLink());
        assertEquals(MaterialType.LINK, materials.getFirst().getType());


    }
}