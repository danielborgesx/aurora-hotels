package hotels.aurora.room.service.Interface;

import hotels.aurora.room.Room;

import java.util.List;

public interface IRoomService {
    boolean roomsRegistration(Room room);
    Room findByNumber(int roomNumber);
    List<Room> roomsList();
}
