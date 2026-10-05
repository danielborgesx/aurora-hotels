package hotels.aurora.users;

public class Guest extends Person {

   public Guest(String name, Cpf cpf, String address, String cellphone) {
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.cellphone = cellphone;
    }

    public String getName() {
        return name;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public String toString(){
        return "Nome: " + name +
                "\nCPF: " + cpf +
                "\nEndereço: " + address +
                "\nTelefone: " + cellphone;
    }
}
