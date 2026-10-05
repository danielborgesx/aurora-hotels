package hotels.aurora.accommodation.service;

import hotels.aurora.accommodation.Accommodation;
import hotels.aurora.accommodation.service.Interface.IAccommodationService;
import hotels.aurora.room.Room;
import hotels.aurora.repository.Repository;
import hotels.aurora.users.Guest;


import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class AccommodationService implements IAccommodationService {

    private final Repository repository;

    public AccommodationService(Repository repository) {
        this.repository = repository;
    }

    public boolean checkIn(Guest guest, Room room) {
        if (findInHouseAccommodation(guest) != null) {
            return false;
        }
        if (!room.isAvailable()) {
            return false;
        }
        room.occupy();
        repository.save(new Accommodation(guest, room, LocalDate.now()));
        return true;
    }

    public boolean checkOut(Guest guest) {
        Accommodation accommodation = findInHouseAccommodation(guest);
        if (accommodation == null) {
            return false;
        }

        accommodation.checkOut(LocalDate.now());
        Room room = accommodation.getRoom();
        room.release();
        return true;
    }

    private Accommodation findInHouseAccommodation(Guest guest) {
        for (Accommodation accommodation : repository.getAccommodations()) {
            if (accommodation.isInHouse(guest)) {
                return accommodation;
            }
        }
        return null;
    }

    public List<Accommodation> accommodationList(){
        return Collections.unmodifiableList(repository.getAccommodations());
    }


}
