package hotels.aurora.users.service.Interface;

import hotels.aurora.users.Cpf;
import hotels.aurora.users.Guest;

import java.util.List;

public interface IGuestsService {
    boolean guestsRegistration(Guest guest);
    Guest findByCpf(Cpf cpf);
    List<Guest> guestsList();
}
