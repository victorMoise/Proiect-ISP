package test;

import org.junit.jupiter.api.Test;
import proiect.Student;
import proiect.StudyGroup;
import proiect.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JoinStudyGroupTest {
    @Test
    void JoinStudyGroup() {
        List<User> users = new ArrayList<>();
        Student student = new Student(1, "student", "student@student.com", "student");
        Student dummy = new Student(2, "dummy", "dummy@dummy.com", "dummy");
        users.add(student);
        users.add(dummy);

        List<StudyGroup> groups = new ArrayList<>();
        StudyGroup group1 = new StudyGroup("Math", null);
        StudyGroup group2 = new StudyGroup("Science", null);
        groups.add(group1);
        groups.add(group2);

        String goodUsername = "student";
        String goodPassword = "student";
        boolean goodUserFound = false;
        for (User user : users) {
            if (user.getUsername().equals(goodUsername) && user.getPassword().equals(goodPassword)) {
                goodUserFound = true;
                break;
            }
        }

        String badUsername = "badStudent";
        String badPassword = "badStudent";
        boolean badUserFound = false;
        for (User user : users) {
            if (user.getUsername().equals(badUsername) && user.getPassword().equals(badPassword)) {
                badUserFound = true;
                break;
            }
        }

        assertTrue(goodUserFound, "Good user should be found");
        assertFalse(badUserFound, "Bad user should not be found");

        student.joinStudyGroup(group1);
        group1.addMember(student);
        assertTrue(student.getGroups().contains(group1), "Student should be in the group");
        assertTrue(group1.getMembers().contains(student), "Group should contain the student");

        assertFalse(student.getGroups().contains(group2), "Student should not be in the second group");
    }
}
