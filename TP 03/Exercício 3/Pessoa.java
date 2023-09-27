public class Pessoa {
    private static int kp = 0;
    private String nome;
    private char sexo;
    private int idade;

    public Pessoa() {
        kp++;
    }

    public Pessoa(String nome, char sexo, int idade) {
        this();
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }

    public static int getKp() {
        return kp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        if (sexo == 'M' || sexo == 'F') {
            this.sexo = sexo;
        } else {
            // Tratamento de erro para sexo inválido
            throw new IllegalArgumentException("Sexo deve ser 'M' ou 'F'");
        }
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
