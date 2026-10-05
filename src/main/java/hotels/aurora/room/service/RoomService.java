package hotels.aurora.room.service;

import hotels.aurora.configurations.HotelConfig;
import hotels.aurora.room.Room;
import hotels.aurora.repository.Repository;
import hotels.aurora.room.service.Interface.IRoomService;

import java.util.Collections;
import java.util.List;

public class RoomService implements IRoomService {

    private final Repository repository;
    private final HotelConfig hotelConfig;

    public RoomService(Repository repository, HotelConfig hotelConfig) {
        this.repository = repository;
        this.hotelConfig = hotelConfig;
    }
    public boolean roomsRegistration(Room room) {
        if (!hotelConfig.acceptsFloor(room.getFloor()) || !hotelConfig.hasRoomLeftOnFloor(room.getFloor())) {
            throw new IllegalArgumentException("Invalid floor");
        }

        for (Room r : repository.getRooms()) {
            if (r.getRoomNumber() == room.getRoomNumber()) {
                return false;
            }
        }

        repository.save(room);
        return true;
    }

    public Room findByNumber(int roomNumber) {
        return repository.findRoomByNumber(roomNumber);
    }

    public List<Room> roomsList() {
        return Collections.unmodifiableList(repository.getRooms());
    }

}
