package hotels.aurora.room.service;

import hotels.aurora.room.Room;
import hotels.aurora.repository.Repository;

import java.util.Collections;
import java.util.List;

public class RoomService {

    private final Repository repository;

    public RoomService(Repository repository) {
        this.repository = repository;
    }

    public boolean roomsRegistration(Room room) {
        for (Room q : repository.getRooms()) {
            if (q.getRoomNumber() == room.getRoomNumber()) {
                return false;
            }
        }
        repository.save(room);
        return true;
    }

    public Room findByNumber(int roomNumber) {
        return repository.findRoomByNumber(roomNumber);
    }

    public List<Room> roomsList(){
        return Collections.unmodifiableList(repository.getRooms());
    }


}
