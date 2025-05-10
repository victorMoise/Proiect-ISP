import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RoomManager roomManager = new RoomManager(new ArrayList<>());
        roomManager.createRoom("Room 1", Topic.BUSINESS);
        roomManager.createRoom("Room 2", Topic.SCIENCE);
        // print all rooms
        System.out.println("Rooms:");
        for (Room room : roomManager.getRooms()) {
            System.out.println(room);
        }

//        Scanner scanner = new Scanner(System.in);
//        List<User> users = new ArrayList<>();
//        List<Room> rooms = new ArrayList<>();
//
//        Admin admin = new Admin();
//        users.add(admin);
//
//        boolean loggedIn = false;
//        User currentUser = null;
//
//        //
//        while (!loggedIn) {
//            System.out.println("\nWelcome to the Study Session App!");
//            System.out.println("1. Login");
//            System.out.println("2. Register");
//            System.out.print("Please select an option: ");
//
//            int choice = -1;
//            try {
//                choice = Integer.parseInt(scanner.nextLine());
//            } catch (NumberFormatException e) {
//                System.out.println("Invalid input. Please enter a number.");
//                continue;
//            }
//
//            switch (choice) {
//                case 1 -> {
//                    System.out.print("Enter username: ");
//                    String username = scanner.nextLine();
//                    System.out.print("Enter password: ");
//                    String password = scanner.nextLine();
//
//                    for (User user : users) {
//                        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
//                            loggedIn = true;
//                            currentUser = user;
//                            System.out.println("Login successful! Welcome, " + user.getUsername());
//                            break;
//                        }
//                    }
//
//                    if (!loggedIn) {
//                        System.out.println("Invalid username or password. Please try again.");
//                    }
//                }
//
//                case 2 -> {
//                    System.out.print("Enter username: ");
//                    String newUsername = scanner.nextLine();
//                    System.out.print("Enter email: ");
//                    String email = scanner.nextLine();
//                    System.out.print("Enter password: ");
//                    String newPassword = scanner.nextLine();
//
//                    User newUser = new Student(newUsername, email, newPassword, Role.STUDENT, 1, 1, "Series", "Major", "University");
//                    users.add(newUser);
//                    System.out.println("Registration successful! You can now log in.");
//                }
//
//                default -> System.out.println("Invalid option. Please try again.");
//            }
//        }

        // Example after login
//        System.out.println("User info:");
//        System.out.println(currentUser);
    }
}
