class Paciente extends Pessoa {
    private String cpf;
    private String endereco;
    private String telefone;

    public Paciente(String nome, String cpf, String endereco, String telefone) {
        super(nome);
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }
}