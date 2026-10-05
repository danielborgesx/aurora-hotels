package hotels.aurora.users;

public class Guest {

    private String name;
    private Cpf cpf;
    private String address;
    private long cellphone;

    public Guest(String name, Cpf cpf, String address, long cellphone) {
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
