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

    public boolean cadastrarQuarto(Room room) {
        for (Room q : repository.getQuartos()) {
            if (q.getRoomNumber() == room.getRoomNumber()) {
                return false;
            }
        }
        repository.salvar(room);
        return true;
    }

    public List<Room> listaDeQuartos(){
        return Collections.unmodifiableList(repository.getQuartos());
    }


}
