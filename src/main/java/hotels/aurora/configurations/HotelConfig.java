package hotels.aurora.configurations;

public class HotelConfig {

    private static final int FIRST_FLOOR = 1;

    private final int maxFloor;
    private final int roomsPerFloor;

    public HotelConfig(int maxFloor, int roomsPerFloor) {
        this.maxFloor = maxFloor;
        this.roomsPerFloor = roomsPerFloor;
    }

    public boolean acceptsFloor(int floor) {
        return floor >= FIRST_FLOOR && floor <= maxFloor;
    }

    public boolean accepts(int floor, int roomNumber) {
        return acceptsFloor(floor) && roomNumber > 0;
    }

    public boolean hasRoomLeftOnFloor(long registeredRooms) {
        return registeredRooms < roomsPerFloor;
    }

}
