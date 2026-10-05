package hotels.aurora.accommodation.service.Interface;

import hotels.aurora.accommodation.Accommodation;
import hotels.aurora.room.Room;
import hotels.aurora.users.Guest;

import java.util.List;

public interface IAccommodationService {

    public boolean checkIn(Guest guest, Room room);
    public boolean checkOut(Guest guest);
    public List<Accommodation> accommodationList();


}
