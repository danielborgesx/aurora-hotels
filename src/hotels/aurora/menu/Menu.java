package hotels.aurora.menu;

import hotels.aurora.accommodation.Accommodation;
import hotels.aurora.accommodation.service.AccommodationService;
import hotels.aurora.configurations.Cpf;
import hotels.aurora.room.Housekeeping;
import hotels.aurora.room.Room;
import hotels.aurora.room.RoomStatus;
import hotels.aurora.room.service.RoomService;
import hotels.aurora.users.Guest;
import hotels.aurora.users.service.GuestsService;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private final GuestsService guestsService;
    private final RoomService roomService;
    private final AccommodationService accommodationService;
    private final Scanner scanner = new Scanner(System.in);

    public Menu(GuestsService guestsService, RoomService roomService, AccommodationService accommodationService) {
        this.guestsService = guestsService;
        this.roomService = roomService;
        this.accommodationService = accommodationService;
    }

    public void mainMenu() {
        int iterator = 1;
        while (iterator == 1) {
            mainOptions();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    registerGuest();
                    System.out.println();
                    break;
                case 2:
                    registerRoom();
                    System.out.println();
                    break;
                case 3:
                    guestsList();
                    System.out.println();
                    break;
                case 4:
                    roomsList();
                    System.out.println();
                    break;
                case 5:
                    checkIn();
                    System.out.println();
                    break;
                case 6:
                    checkOut();
                    System.out.println();
                    break;
                case 7:
                    accommodationList();
                    System.out.println();
                    break;
                case 8:
                    iterator++;
                    break;
                default:
                    System.out.println("Digite um número válido.");
                    System.out.println();

            }
        }
    }

    private void mainOptions() {
        int i = 1;
        ArrayList<String> options = new ArrayList<>();
        System.out.println("Bem-vindo ao Aurora Hotels! Você deseja: ");
        options.add("Cadastrar hóspedes");
        options.add("Cadastrar quartos");
        options.add("Listar hóspedes");
        options.add("Listar quartos");
        options.add("Fazer check in");
        options.add("Fazer check out");
        options.add("Lista de hospedagens");
        System.out.println("Escolha uma opção: ");
        for (String option : options) {
            System.out.println(i + ". " + option);
            i++;
        }
    }

    private void registerGuest() {
        System.out.print("Digite o nome do hóspede: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do hóspede: ");
        String writenCpf = scanner.nextLine();
        Cpf cpf = new Cpf(writenCpf);
        System.out.print("Digite o endereço do hóspede: ");
        String endereco = scanner.nextLine();
        System.out.print("Digite o telefone do hóspede: ");
        long telefone = scanner.nextLong();
        Guest guest = new Guest(nome, cpf, endereco, telefone);
        if (guestsService.guestsRegistration(guest)) {
            System.out.println("Hóspede cadastrado com sucesso!");
            System.out.println();
            return;
        }
        System.out.println("Hóspede já existe no sistema.");
        System.out.println();
    }

    private void registerRoom() {
        System.out.print("Digite o andar do quarto: ");
        int andar = scanner.nextInt();
        System.out.print("Digite o número do quarto: ");
        int numero = scanner.nextInt();
        Room room = new Room(andar, numero, RoomStatus.VAGO, Housekeeping.LIMPO);
        if (roomService.roomsRegistration(room)) {
            System.out.println("Quarto cadastrado com sucesso!");
            System.out.println();
            return;
        }
        System.out.println("Quarto já cadastrado");
        System.out.println();
    }

    private void guestsList() {
        System.out.println("Lista de hóspedes: ");
        for (Guest guest : guestsService.guestsList()) {
            System.out.println(guest);
        }
    }

    private void roomsList() {
        System.out.println("Lista de quartos: ");
        for (Room room : roomService.roomsList()) {
            System.out.println(room);
        }
    }

    private void checkIn() {
        System.out.println("Digite o CPF do hóspede: ");
        String writenCpf = scanner.nextLine();
        Cpf cpf = new Cpf(writenCpf);
        Guest guest = guestsService.findByCpf(cpf);

        if (guest == null) {
            System.out.println("Hóspede não cadastrado. Favor registrá-lo primeiro: ");
            registerGuest();
            return;
        }

        System.out.println("Digite o número do quarto: ");
        int roomNumber = scanner.nextInt();
        Room room = roomService.findByNumber(roomNumber);
        if (room == null) {
            System.out.println("Quarto não cadastrado. Favor escolher outro. " +
                    "Você pode acessar a lista de quartos disponíveis na lista de quartos.");
            return;
        }
        if (accommodationService.checkIn(guest, room)) {
            System.out.println("Check in efetuado com sucesso! Aproveite a estadia.");
        } else {
            throw new IllegalArgumentException("O check out não foi efetuado. Confira os dados e tente novamente.");
        }
    }

    private void checkOut() {
        System.out.println("Digite o CPF do hóspede: ");
        String writenCpf = scanner.nextLine();
        Cpf cpf = new Cpf(writenCpf);
        Guest guest = guestsService.findByCpf(cpf);
        if (guest == null) {
            System.out.println("Hóspede não está hospedado. Não é possível fazer check out.");
            return;
        }
        if (accommodationService.checkOut(guest)) {
            System.out.println("Check-out efetuado com sucesso! Agradecemos a preferência!");
        } else {
            throw new IllegalArgumentException("O check out não foi efetuado. Confira os dados e tente novamente.");
        }


    }

    private void accommodationList(){
        System.out.println("Lista de hospedagens: ");
        for(Accommodation accomodation : accommodationService.accommodationList()) {
            System.out.println(accomodation);
        }
    }

}
