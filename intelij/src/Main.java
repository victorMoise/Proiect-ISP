import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<User> users = new ArrayList<>();

        Admin admin = new Admin(1, "admin", "admin@admin.com", "adminPassword");
        users.add(admin);

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

        System.out.println("\n--- Logged in User ---");
        System.out.println("ID:    " + currentUser.getId());
        System.out.println("Name:  " + currentUser.getUsername());
        System.out.println("Email: " + currentUser.getEmail());
        System.out.println("Role:  " + (currentUser instanceof Admin ? "Admin" : "Student"));
    }
}
