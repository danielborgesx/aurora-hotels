package hotels.aurora.accommodation;

import hotels.aurora.room.Room;
import hotels.aurora.users.Guest;

import java.time.LocalDate;

public class Accommodation {

    private final Guest guest;
    private final Room room;
    private final LocalDate checkInDate;
    private LocalDate checkOutDate;

    public Accommodation(Guest guest, Room room, LocalDate checkInDate) {
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = null;
    }

    public boolean isInHouse(Guest guest){
        return guest != null
                && this.guest.getCpf().equals(guest.getCpf())
                && checkInDate != null
                && checkOutDate == null;
    }

    public void checkOut(LocalDate date) {
        this.checkOutDate = date;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public Room getRoom() {
        return room;
    }

    public String toString(){
        return "Hóspede: " + guest.getName() +
                "\nQuarto: " + room.getRoomNumber() +
                "\nCheck-in: " + checkInDate +
                "\nCheck-out: " + checkOutDate;
    }
}

