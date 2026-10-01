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

    public void salvar(Room room) {
        rooms.add(room);
    }

    public void salvar(Guest guest) {
        guests.add(guest);
    }

    public void salvar(Accommodation accommodation) {
        accommodations.add(accommodation);
    }

    public boolean pesquisarHospede(String cpf){
        for(Guest guest : guests){
            if(cpf.equals(guest.getCpf())){
                return true;
            }
        }
        return false;
    }

    public boolean pesquisarQuarto(int numeroQuarto){
        for(Room room : rooms){
            if(numeroQuarto == room.getRoomNumber()){
                return true;
            }
        }
        return false;
    }

    public boolean pesquisarHospedagem(LocalDate dataEntrada){
        for(Accommodation accommodation : accommodations){
            if(accommodation.getCheckInDate().isEqual(dataEntrada)){
                return true;
            }
        }
        return false;
    }

    public List<Room> getQuartos() {
        return rooms;
    }

    public List<Guest> getHospedes() {
        return guests;
    }

    public List<Accommodation> getAccommodations(){
        return accommodations;
    }
}
