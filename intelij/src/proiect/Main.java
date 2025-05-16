package proiect;

import java.util.*;

public class Main {
    private static boolean exit = false;
    private static final String EXIT_COMMAND = "exit";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<User> users = new ArrayList<>();
        List<StudyGroup> studyGroups = new ArrayList<>();

        Admin predefinedAdmin = new Admin(1, "admin", "admin@admin.com", "adminPassword");
        users.add(predefinedAdmin);

        while (!exit) {
            User currentUser = loginRegister(scanner, users);

            if (currentUser instanceof Student student) {
                studentMenu(student, studyGroups);
            } else if (currentUser instanceof Admin admin) {
                adminMenu(admin, studyGroups);
            }
        }
    }

    public static void studentMenu(Student currentUser, List<StudyGroup> studyGroups) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nStudent Menu");
            System.out.println("1. View Study Groups");
            System.out.println("2. Join Study Group");
            System.out.println("3. Leave Study Group");
            System.out.println("4. View Study Sessions");
            System.out.println("5. Upload Study Material");
            System.out.println("6. Logout");
            System.out.println("7. Exit");

            System.out.print("Select an option: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    System.out.println("Your Study Groups:");
                    if (currentUser.getGroups().isEmpty()) {
                        System.out.println("You are not part of any study groups.");
                    } else {
                        for (StudyGroup group : currentUser.getGroups()) {
                            System.out.println("- " + group.getName());
                        }
                    }
                }
                case "2" -> {
                    System.out.println("Available Study Groups:");
                    for (StudyGroup group : studyGroups) {
                        System.out.println("- " + group.getName());
                    }
                    System.out.print("Enter the name of the group to join: ");
                    String groupName = scanner.nextLine().trim();
                    StudyGroup groupToJoin = null;
                    for (StudyGroup group : studyGroups) {
                        if (group.getName().equalsIgnoreCase(groupName)) {
                            groupToJoin = group;
                            break;
                        }
                    }
                    if (groupToJoin != null) {
                        currentUser.joinStudyGroup(groupToJoin);
                        groupToJoin.addMember(currentUser);
                        System.out.println("You have joined the group: " + groupName);
                    } else {
                        System.out.println("Group not found.");
                    }
                }
                case "3" -> {
                    System.out.println("Your Study Groups:");
                    if (currentUser.getGroups().isEmpty()) {
                        System.out.println("You are not part of any study groups.");
                    } else {
                        for (StudyGroup group : currentUser.getGroups()) {
                            System.out.println("- " + group.getName());
                        }
                        System.out.print("Enter the name of the group to leave: ");
                        String groupName = scanner.nextLine().trim();
                        StudyGroup groupToLeave = null;
                        for (StudyGroup group : currentUser.getGroups()) {
                            if (group.getName().equalsIgnoreCase(groupName)) {
                                groupToLeave = group;
                                break;
                            }
                        }
                        if (groupToLeave != null) {
                            currentUser.getGroups().remove(groupToLeave);
                            groupToLeave.getMembers().remove(currentUser);
                            System.out.println("You have left the group: " + groupName);
                        } else {
                            System.out.println("Group not found.");
                        }
                    }
                }
                case "4" -> {
                    System.out.println("Study Sessions:");
                    for (StudyGroup group : currentUser.getGroups()) {
                        System.out.println("Group: " + group.getName());
                        if (group.getSessions().isEmpty()) {
                            System.out.println("  No sessions available.");
                        } else {
                            for (StudySession session : group.getSessions()) {
                                System.out.println("  - " + session.getDetails());
                            }
                        }
                    }
                }
                case "5" -> {
                    System.out.println("Your Study Groups:");
                    if (currentUser.getGroups().isEmpty()) {
                        System.out.println("You are not part of any study groups.");
                    } else {
                        for (StudyGroup group : currentUser.getGroups()) {
                            System.out.println("- " + group.getName());
                        }
                        System.out.print("Enter the name of the group to upload material to: ");
                        String groupName = scanner.nextLine().trim();
                        StudyGroup targetGroup = null;
                        for (StudyGroup group : currentUser.getGroups()) {
                            if (group.getName().equalsIgnoreCase(groupName)) {
                                targetGroup = group;
                                break;
                            }
                        }
                        if (targetGroup != null) {
                            System.out.print("Enter material title: ");
                            String title = scanner.nextLine().trim();
                            System.out.print("Enter material link: ");
                            String link = scanner.nextLine().trim();
                            System.out.print("Enter material type (e.g., DOCUMENT, VIDEO): ");
                            String typeInput = scanner.nextLine().trim();
                            MaterialType type = MaterialType.valueOf(typeInput.toUpperCase());
                            StudyMaterial material = new StudyMaterial(title, link, type, targetGroup);
                            targetGroup.addMaterial(material);
                            System.out.println("Material uploaded successfully to group: " + groupName);
                        } else {
                            System.out.println("Group not found.");
                        }
                    }
                }
                case "6" -> {
                    System.out.println("Logging out...");
                    return;
                }
                case "7" -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Please select again.");
            }
        }
    }

    public static void adminMenu(Admin admin, List<StudyGroup> studyGroups) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n.Admin Menu");
            System.out.println("1. Create Study Group");
            System.out.println("2. Delete Study Group");
            System.out.println("3. View Study Groups");
            System.out.println("4. Logout");
            System.out.println("5. Exit");

            System.out.print("Select an option: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    System.out.print("Enter group name: ");
                    String groupName = scanner.nextLine().trim();
                    StudyGroup newGroup = admin.createGroup(groupName, studyGroups);
                    System.out.println("Group created: " + newGroup.getName());
                }
                case "2" -> {
                    System.out.print("Enter group name to delete: ");
                    String groupName = scanner.nextLine().trim();
                    StudyGroup groupToDelete = null;
                    for (StudyGroup group : studyGroups) {
                        if (group.getName().equalsIgnoreCase(groupName)) {
                            groupToDelete = group;
                            break;
                        }
                    }
                    if (groupToDelete != null) {
                        admin.deleteGroup(groupToDelete, studyGroups);
                        System.out.println("Group deleted: " + groupName);
                    } else {
                        System.out.println("Group not found.");
                    }
                }
                case "3" -> {
                    System.out.println("Study Groups:");
                    for (StudyGroup group : studyGroups) {
                        System.out.println("- " + group.getName());
                    }
                }
                case "4" -> {
                    System.out.println("Logging out...");
                    return;
                }
                case EXIT_COMMAND -> {
                    System.out.println("Exiting...");
                    exit = true;
                    return;
                }
                default -> System.out.println("Invalid option. Please select again.");
            }
        }
    }

    public static User loginRegister(Scanner scanner, List<User> users) {
        boolean loggedIn = false;
        User currentUser = null;

        while (!loggedIn) {
            System.out.println("\n=== Study Group App ===");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    System.out.print("Email: ");
                    String emailInput = scanner.nextLine().trim();
                    System.out.print("Password: ");
                    String passwordInput = scanner.nextLine().trim();

                    for (User u : users) {
                        if (u.getEmail().equalsIgnoreCase(emailInput) && u.getPassword().equals(passwordInput)) {
                            currentUser = u;
                            loggedIn = true;
                            System.out.println("Login successful! Welcome, " + u.getUsername());
                            break;
                        }
                    }

                    if (!loggedIn) {
                        System.out.println("Invalid email or password. Try again.");
                    }
                }
                case "2" -> {
                    int newId = users.size() + 1;
                    System.out.print("Name: ");
                    String name = scanner.nextLine().trim();
                    System.out.print("Email: ");
                    String email = scanner.nextLine().trim();
                    System.out.print("Password: ");
                    String password = scanner.nextLine().trim();

                    Student student = new Student(newId, name, email, password);
                    users.add(student);
                    System.out.println("Registration successful! You can now log in.");
                }
                case "3" -> {
                    System.out.println("Exiting...");
                    exit = true;
                    return null;
                }

                default -> System.out.println("Invalid option. Please select 1 or 2.");
            }
        }

        return currentUser;
    }
}