package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import proiect.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ViewStudyMaterialsTest {
    private Student student;
    private StudyGroup studyGroup;

    @BeforeEach
    void setUp() {
        Admin admin = new Admin(1, "admin", "admin@admin.com", "adminPassword");
        student = new Student(2, "Andrei", "andrei@example.com", "pass123");
        studyGroup = new StudyGroup("Math Group", admin);
    }

    static Stream<TestData> provideTestData() {
        return Stream.of(
            // Case 1: Student without groups
            new TestData(new ArrayList<>(), null, "You are not part of any study groups."),
            // Case 2: Student with groups but no materials
            new TestData(List.of(new StudyGroup("Math Group", new Admin(1, "admin", "admin@admin.com", "adminPassword"))),
                         new ArrayList<>(), "No study materials available."),
            // Case 3: Student with groups and materials
            new TestData(List.of(new StudyGroup("Math Group", new Admin(1, "admin", "admin@admin.com", "adminPassword"))),
                         List.of(new StudyMaterial("Lecture Notes", "http://example.com/notes", MaterialType.LINK, null)),
                         "Materials available."),
            // Case 4: Edge case - empty material title
            new TestData(List.of(new StudyGroup("Math Group", new Admin(1, "admin", "admin@admin.com", "adminPassword"))),
                         List.of(new StudyMaterial("", "http://example.com/notes", MaterialType.LINK, null)),
                         "Invalid material title."),
            // Case 5: Exception case - null group
            new TestData(null, null, "Exception: Group is null.")
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void testViewStudyMaterials(TestData testData) {
        if (testData.groups != null) {
            for (StudyGroup group : testData.groups) {
                student.joinStudyGroup(group);
                if (testData.materials != null) {
                    for (StudyMaterial material : testData.materials) {
                        group.addMaterial(material);
                    }
                }
            }
        }

        try {
            List<StudyGroup> studentGroups = student.getGroups();
            if (studentGroups.isEmpty()) {
                assertEquals(testData.expectedMessage, "You are not part of any study groups.");
            } else {
                StudyGroup selectedGroup = studentGroups.get(0);
                List<StudyMaterial> materials = selectedGroup.getMaterials();
                if (materials.isEmpty()) {
                    assertEquals(testData.expectedMessage, "No study materials available.");
                } else {
                    assertEquals(testData.expectedMessage, "Materials available.");
                }
            }
        } catch (Exception e) {
            assertEquals(testData.expectedMessage, "Exception: " + e.getMessage());
        }
    }

    static class TestData {
        List<StudyGroup> groups;
        List<StudyMaterial> materials;
        String expectedMessage;

        TestData(List<StudyGroup> groups, List<StudyMaterial> materials, String expectedMessage) {
            this.groups = groups;
            this.materials = materials;
            this.expectedMessage = expectedMessage;
        }
    }
}