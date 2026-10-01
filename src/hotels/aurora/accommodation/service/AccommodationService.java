package hotels.aurora.accommodation.service;

import hotels.aurora.accommodation.Accommodation;
import hotels.aurora.room.Housekeeping;
import hotels.aurora.room.Room;
import hotels.aurora.room.RoomStatus;
import hotels.aurora.repository.Repository;
import hotels.aurora.users.Guest;


import java.time.LocalDate;

public class AccommodationService {

    private final Repository repository;

    public AccommodationService(Repository repository) {
        this.repository = repository;
    }

    public boolean checkInTheGuest(Guest guest, Room room) {
        if (findInHouseAccommodation(guest) != null) {
            return false;
        }
        if (room.getHousekeeping() != Housekeeping.LIMPO
                || room.getStatus() != RoomStatus.VAGO) {
            return false;
        }

        room.setHousekeeping(Housekeeping.SUJO);
        room.setStatus(RoomStatus.OCUPADO);
        repository.salvar(new Accommodation(guest, room, LocalDate.now()));
        return true;
    }

    public boolean checkOutTheGuest(Guest guest) {
        Accommodation accommodation = findInHouseAccommodation(guest);
        if (accommodation == null) {
            return false;
        }

        accommodation.checkOut(LocalDate.now());

        Room room = accommodation.getRoom();
        room.setStatus(RoomStatus.VAGO);
        room.setHousekeeping(Housekeeping.SUJO);
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


}
