import java.util.List;

public class RoomManager {
    private List<Room> rooms;

    public RoomManager(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void createRoom(String name, Topic topic) {
        int id = rooms.size() + 1;
        Room room = new Room(id, name, topic);
        rooms.add(room);
        System.out.println("Room created successfully!");
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
