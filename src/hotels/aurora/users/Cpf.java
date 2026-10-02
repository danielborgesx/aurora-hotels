package hotels.aurora.users;

public class Cpf {
    private final String value;

    public Cpf(String value) {
        String digits = value == null ? "" : value.replaceAll("\\D", "");
        if (!isValid(digits)) {
            throw new IllegalArgumentException("CPF inválido");
        }
        this.value = digits;
    }

    private static boolean isValid(String cpf) {
        if (cpf == null || !cpf.matches("\\d{11}")) {
            return false;
        }
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        int firstCheckDigit = calculateCheckDigit(cpf, 9, 10);
        if (Character.getNumericValue(cpf.charAt(9)) != firstCheckDigit) {
            return false;
        }

        int secondCheckDigit = calculateCheckDigit(cpf, 10, 11);
        return Character.getNumericValue(cpf.charAt(10)) == secondCheckDigit;
    }

    private static int calculateCheckDigit(String cpf, int length, int initialWeight) {
        int sum = 0;
        int weight = initialWeight;
        for (int i = 0; i < length; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * weight;
            weight--;
        }
        int remainder = sum % 11;
        return remainder < 2 ? 0 : 11 - remainder;
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof Cpf cpf && value.equals(cpf.value);
    }

    @Override
    public int hashCode() { return value.hashCode(); }

    @Override
    public String toString() { return value; }
}
