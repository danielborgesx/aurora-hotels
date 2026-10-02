package hotels.aurora.configurations;

public class HotelConfig {

    private final int maxFloor;
    private final int roomsPerFloor;

    public HotelConfig(int maxFloor, int roomsPerFloor) {
        this.maxFloor = maxFloor;
        this.roomsPerFloor = roomsPerFloor;
    }

    public boolean accepts(int floor, int roomNumber) {
        return floor >= 1 && floor <= maxFloor
                && roomNumber > 0 && roomNumber <= roomsPerFloor;
    }
    /*
    -> Métodos implantados futuramente no projeto

    public boolean acceptsFloor(int floor){

    }

    public boolean hasRoomLeftOnFloor(long registeredRooms) {

    }
    */
}
