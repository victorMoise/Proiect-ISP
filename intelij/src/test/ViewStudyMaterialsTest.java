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
        student = new Student(2, "Alice", "alice@example.com", "pass123");
        studyGroup = new StudyGroup("Math Group", admin);
        student.joinStudyGroup(studyGroup);
        studyGroup.addMember(student);
    }

    @Test
    void testViewStudyMaterials() {
        // Step 1: Check if the student is part of any study groups
        List<StudyGroup> studentGroups = student.getGroups();
        assertFalse(studentGroups.isEmpty(), "You are not part of any study groups.");

        // Step 2: Select a study group
        StudyGroup selectedGroup = studentGroups.getFirst();
        assertEquals("Math Group", selectedGroup.getName());

        // Step 3: Check if the selected group has any study materials
        List<StudyMaterial> materials = selectedGroup.getMaterials();
        assertTrue(materials.isEmpty(), "No study materials available.");

        // Step 4: Add a study material and verify it is displayed
        StudyMaterial material = new StudyMaterial("Lecture Notes", "http://example.com/notes", MaterialType.LINK, selectedGroup);
        selectedGroup.addMaterial(material);
        materials = selectedGroup.getMaterials();
        assertFalse(materials.isEmpty(), "Study materials should be available.");
        assertEquals(1, materials.size());
        assertEquals("Lecture Notes", materials.getFirst().getTitle());
    }
}