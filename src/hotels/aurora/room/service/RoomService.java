package hotels.aurora.room.service;

import hotels.aurora.configurations.HotelConfig;
import hotels.aurora.room.Room;
import hotels.aurora.repository.Repository;

import java.util.Collections;
import java.util.List;

public class RoomService {

    private final Repository repository;
    private Room room;

    public RoomService(Repository repository, HotelConfig hotelConfig) {
        this.repository = repository;
        if (!hotelConfig.accepts(room.getFloor(), room.getRoomNumber())) {
            throw new IllegalArgumentException("Quarto fora dos limites do hotel");
        }
    }

    public boolean roomsRegistration(Room room) {
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

    public List<Room> roomsList(){
        return Collections.unmodifiableList(repository.getRooms());
    }


}
