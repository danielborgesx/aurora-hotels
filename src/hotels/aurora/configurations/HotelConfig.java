package hotels.aurora.configurations;

public class HotelConfig {

    private final int maxFloor;
    private final int roomsPerFloor;

    public HotelConfig(int maxFloor, int roomsPerFloor) {
        this.maxFloor = maxFloor;
        this.roomsPerFloor = roomsPerFloor;
    }

    public boolean accepts(int floor, int roomNumber) {
        return floor >= 0 && floor <= maxFloor
                && roomNumber > 0 && roomNumber <= roomsPerFloor;
    }

}
