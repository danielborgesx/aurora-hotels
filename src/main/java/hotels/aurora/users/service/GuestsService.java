package hotels.aurora.users.service;

import hotels.aurora.users.Cpf;
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

    public boolean guestsRegistration(Guest guest) {
        for (Guest g : repository.getGuests()) {
            if (Objects.equals(g.getCpf(), guest.getCpf())) {
                return false;
            }
        }
        repository.save(guest);
        return true;
    }

    public Guest findByCpf(Cpf cpf) {
        return repository.findGuestByCpf(cpf);
    }

    public List<Guest> guestsList() {
        return Collections.unmodifiableList(repository.getGuests());
    }
}
