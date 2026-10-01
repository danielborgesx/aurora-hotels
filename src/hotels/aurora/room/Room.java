package hotels.aurora.room;

public class Room {
    private int floor;
    private int roomNumber;
    private RoomStatus status;
    private Housekeeping housekeeping;

    public Room(int floor, int roomNumber, RoomStatus status, Housekeeping housekeeping) {
        this.floor = floor;
        this.roomNumber = roomNumber;
        this.status = status;
        this.housekeeping = housekeeping;
    }

    public int getFloor() {
        return floor;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public Housekeeping getHousekeeping() {
        return housekeeping;
    }

    public String toString(){
        return "Quarto: " + roomNumber +
                "\nAndar: " + floor +
                "\nStatus: " + status +
                "\nGovernança: " + housekeeping;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public void setHousekeeping(Housekeeping housekeeping) {
        this.housekeeping = housekeeping;
    }
}
