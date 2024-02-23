class Consulta {
    private Pessoa pessoa;
    private String nome;
    private String data;
    private double horario;

    public Consulta(Pessoa pessoa, String nome, String data, double horario) {
        this.pessoa = pessoa;
        this.nome = nome;
        this.data = data;
        this.horario = horario;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public double getHorario() {
        return horario;
    }
}
