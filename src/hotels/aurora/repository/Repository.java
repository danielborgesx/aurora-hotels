package hotels.aurora.repository;

import hotels.aurora.accommodation.Accommodation;
import hotels.aurora.room.Room;
import hotels.aurora.users.Guest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Repository {

    private List<Room> rooms = new ArrayList<>();
    private List<Guest> guests = new ArrayList<>();
    private List<Accommodation> accommodations = new ArrayList<>();

    public void save(Room room) {
        rooms.add(room);
    }

    public void save(Guest guest) {
        guests.add(guest);
    }

    public void save(Accommodation accommodation) {
        accommodations.add(accommodation);
    }

    public Guest findGuestsByCpf(String cpf){
        for(Guest guest : guests){
            if(cpf.equals(guest.getCpf())){
                return guest;
            }
        }
        return null;
    }

    public Room findRoomByNumber(int roomNumber){
        for(Room room : rooms){
            if(room.getRoomNumber() == roomNumber){
                return room;
            }
        }
        return null;
    }

    public boolean accommodationResearch(LocalDate checkInDate){
        for(Accommodation accommodation : accommodations){
            if(accommodation.getCheckInDate().isEqual(checkInDate)){
                return true;
            }
        }
        return false;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public List<Accommodation> getAccommodations(){
        return accommodations;
    }
}
