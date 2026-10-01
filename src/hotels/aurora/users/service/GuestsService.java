package hotels.aurora.users.service;

import hotels.aurora.repository.Repository;
import hotels.aurora.users.Guest;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GuestsService {

    private final Repository repository;

    public GuestsService(Repository repository) {
        this.repository = repository;
    }

    public boolean cadastrarHospede(Guest guest) {
        for (Guest h : repository.getHospedes()) {
            if (Objects.equals(h.getCpf(), guest.getCpf())) {
                return false;
            }
        }
        repository.salvar(guest);
        return true;
    }

    public List<Guest> listaDeHospedes(){
        return Collections.unmodifiableList(repository.getHospedes());
    }
}
