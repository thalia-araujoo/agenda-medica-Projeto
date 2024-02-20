class Medico extends Pessoa {
    private String codigoCRM;

    public Medico(String nome, String codigoCRM) {
        super(nome);
        this.codigoCRM = codigoCRM;
    }

    public String getCodigoCRM() {
        return codigoCRM;
    }
}