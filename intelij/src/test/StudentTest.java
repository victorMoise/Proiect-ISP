package test;

import proiect.Student;
import proiect.StudyGroup;

import static org.junit.Assert.*;

class StudentTest {
    @org.junit.jupiter.api.Test
    void joinStudyGroup() {
        Student student1 = new Student(1, "student1", "student1@student.com", "student");
        Student student2 = new Student(2, "student2", "student2@student2.com", "student");
        StudyGroup group = new StudyGroup("Math", null);

        student1.joinStudyGroup(group);
        group.addMember(student1);
        assertTrue(student1.getGroups().contains(group));
        assertTrue(group.getMembers().contains(student1));

        assertFalse(student2.getGroups().contains(group));
    }

    @org.junit.jupiter.api.Test
    void getGroups() {
        Student student = new Student(1, "student1", "student1@student.com", "student");
        StudyGroup group1 = new StudyGroup("Math", null);
        StudyGroup group2 = new StudyGroup("Science", null);

        student.joinStudyGroup(group1);
        student.joinStudyGroup(group2);

        assertEquals(2, student.getGroups().size());
        assertTrue(student.getGroups().contains(group1));
        assertTrue(student.getGroups().contains(group2));
    }
}