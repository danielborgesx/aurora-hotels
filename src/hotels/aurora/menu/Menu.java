package hotels.aurora.menu;

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
    private final Scanner scanner = new Scanner(System.in);

    public Menu(GuestsService guestsService, RoomService roomService) {
        this.guestsService = guestsService;
        this.roomService = roomService;
    }

    public void menu() {
        while (true) {
            principaisOpcoes();
            opcoesSecundariasComEntradaDeDados();
        }
    }

    private void principaisOpcoes() {
        int i = 1;
        ArrayList<String> opcoes = new ArrayList<>();
        System.out.println("Bem-vindo ao Aurora Hotels");
        opcoes.add("Cadastrar hóspedes");
        opcoes.add("Cadastrar quartos");
        opcoes.add("Listar hóspedes");
        opcoes.add("Listar quartos");
        System.out.println("Escolha uma opção: ");
        for (String opcao : opcoes) {
            System.out.println(i + ". " + opcao);
            i++;
        }
    }

    private void opcoesSecundariasComEntradaDeDados(){
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if (opcao == 1) {
            opcao1();
            System.out.println();
        } else if (opcao == 2) {
            opcao2();
            System.out.println();
        } else if (opcao == 3) {
            opcao3();
            System.out.println();
        } else if (opcao == 4) {
            opcao4();
            System.out.println();
        } else {
            System.out.println("Digite um número válido.");
            System.out.println();
        }
    }

    private void opcao1() {
        System.out.print("Digite o nome do hóspede: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do hóspede: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o endereço do hóspede: ");
        String endereco = scanner.nextLine();
        System.out.print("Digite o telefone do hóspede: ");
        long telefone = scanner.nextLong();
        Guest guest = new Guest(nome, cpf, endereco, telefone);
        if (guestsService.cadastrarHospede(guest)) {
            System.out.println("Hóspede cadastrado com sucesso!");
            System.out.println();
            return;
        }
        System.out.println("Hóspede já existe no sistema.");
        System.out.println();
    }

    private void opcao2() {
        System.out.print("Digite o andar do quarto: ");
        int andar = scanner.nextInt();
        System.out.print("Digite o número do quarto: ");
        int numero = scanner.nextInt();
        Room room = new Room(andar, numero, RoomStatus.VAGO, Housekeeping.LIMPO);
        if (roomService.cadastrarQuarto(room)) {
            System.out.println("Quarto cadastrado com sucesso!");
            System.out.println();
            return;
        }
        System.out.println("Quarto já cadastrado");
        System.out.println();
    }

    private void opcao3() {
        System.out.println("Lista de hóspedes: ");
        for (Guest guest : guestsService.listaDeHospedes()) {
            System.out.println(guest);
        }
    }

    private void opcao4() {
        System.out.println("Lista de quartos: ");
        for (Room room : roomService.listaDeQuartos()) {
            System.out.println(room);
        }
    }

}
