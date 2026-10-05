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

    public String toString(){
        return "Quarto: " + roomNumber +
                "\nAndar: " + floor +
                "\nStatus: " + status +
                "\nGovernança: " + housekeeping;
    }

    public boolean isAvailable() {
        return status == RoomStatus.VAGO && housekeeping == Housekeeping.LIMPO;
    }

    public void occupy() {
        if (!isAvailable()) {
            throw new IllegalStateException("Quarto indisponível");
        }
        status = RoomStatus.OCUPADO;
        housekeeping = Housekeeping.SUJO;
    }
    // Método utilizado futuramente no projeto pela classe Governança. Responsável pela limpeza dos quartos.
    public void clean() {
        if (housekeeping == Housekeeping.LIMPO) {
            throw new IllegalStateException("Quarto já está limpo");
        }
        housekeeping = Housekeeping.LIMPO;
    }

    public void release() {
        status = RoomStatus.VAGO;
        housekeeping = Housekeeping.SUJO;
    }
    // Método utilizado futuramente no projeto pela classe Governança.
    public void dirty(){
        if (housekeeping == Housekeeping.SUJO) {
            throw new IllegalStateException("Quarto já está sujo");
        }
        housekeeping = Housekeeping.SUJO;
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
}
