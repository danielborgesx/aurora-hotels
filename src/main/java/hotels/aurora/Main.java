package hotels.aurora;

import hotels.aurora.accommodation.service.AccommodationService;
import hotels.aurora.configurations.HotelConfig;
import hotels.aurora.menu.Menu;
import hotels.aurora.room.service.RoomService;
import hotels.aurora.repository.Repository;
import hotels.aurora.users.service.GuestsService;

public class Main {
    public static void main(String[] args) {
        Repository repository = new Repository();
        GuestsService guestsService = new GuestsService(repository);
        HotelConfig hotelConfig = new HotelConfig(15, 10);
        RoomService roomService = new RoomService(repository, hotelConfig);
        AccommodationService accommodationService = new AccommodationService(repository);
        Menu menu = new Menu(guestsService, roomService, accommodationService);

        menu.mainMenu();
    }
}
