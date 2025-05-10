public class Admin extends Student {
    public Admin() {
        super();
        this.setSeries("Admin");
        this.setGroup(-1);
        this.setYear(-1);
        this.setUsername("Admin");
        this.setPassword("admin");
        this.setEmail("admin@admin.com");
        this.setRole(Role.ADMIN);
    }

    @Override
    public String toString() {
        return String.format(
                """
                        Admin {
                          Username: %s
                          Email: %s
                          Password: %s
                          Role: %s
                          Year: %d
                          Group: %d
                          Series: %s
                        }""",
                this.getUsername(),
                this.getEmail(),
                this.getPassword(),
                this.getRole(),
                this.getYear(),
                this.getGroup(),
                this.getSeries()
        );
    }


    void createRoom() {

    }

    void deleteRoom() {

    }

    void manageUsers() {

    }

    void manageRooms() {

    }
}