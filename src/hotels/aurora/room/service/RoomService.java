package hotels.aurora.room.service;

import hotels.aurora.configurations.HotelConfig;
import hotels.aurora.room.Room;
import hotels.aurora.repository.Repository;

import java.util.Collections;
import java.util.List;

public class RoomService {

    private final Repository repository;
    private final HotelConfig hotelConfig;

    public RoomService(Repository repository, HotelConfig hotelConfig) {
        this.repository = repository;
        this.hotelConfig = hotelConfig;
    }

    public boolean roomsRegistration(Room room) {
        // 1. andar válido?        -> config decide (exceção se inválido)
        // 2. número já existe?    -> return false
        // 3. andar já está cheio? -> conta os quartos daquele andar no repositório,
        //                            config diz o máximo (exceção se cheio)
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
