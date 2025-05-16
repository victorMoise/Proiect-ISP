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
                studentMenu(student);
            } else if (currentUser instanceof Admin admin) {
                adminMenu(admin, studyGroups);
            }
        }
    }

    public static void studentMenu(Student currentUser) {

    }

    public static void adminMenu(Admin admin, List<StudyGroup> studyGroups) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nAdmin Menu");
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
            System.out.println("2. Register (Student)");
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

                default -> System.out.println("Invalid option. Please select 1 or 2.");
            }
        }

        return currentUser;
    }
}