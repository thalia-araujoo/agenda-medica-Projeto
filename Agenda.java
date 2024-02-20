import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// Classe Agenda que gerencia as consultas
class Agenda {
    private List<Consulta> consultas = new ArrayList<>();
    @SuppressWarnings("unused")
    private Scanner scanner = new Scanner(System.in);

    public void cadastrarConsulta(Consulta consulta) {
        consultas.add(consulta);
        System.out.println("Consulta cadastrada com sucesso!");
    }

    public void removerConsulta(String nomePessoa) {
        consultas.removeIf(consulta -> consulta.getPessoa().getNome().equalsIgnoreCase(nomePessoa));
        System.out.println("Consulta removida com sucesso!");
    }

    public Consulta buscarConsulta(String nomePessoa) {
        for (Consulta consulta : consultas) {
            if (consulta.getPessoa().getNome().equalsIgnoreCase(nomePessoa)) {
                return consulta;
            }
        }
        return null;
    }

    public void editarConsulta(String nomePessoa, Consulta novaConsulta) {
        for (int i = 0; i < consultas.size(); i++) {
            if (consultas.get(i).getPessoa().getNome().equalsIgnoreCase(nomePessoa)) {
                consultas.set(i, novaConsulta);
                System.out.println("Consulta editada com sucesso!");
                return;
            }
        }
        System.out.println("Consulta não encontrada para edição.");
    }

    public void listarConsultas() {
        System.out.println("Consultas agendadas:");
        for (Consulta consulta : consultas) {
            Pessoa pessoa = consulta.getPessoa();
            System.out.println("Nome: " + pessoa.getNome() +
                    ", Data: " + consulta.getData() +
                    ", Horário: " + consulta.getHorario() +
                    ", Nome da Consulta: " + consulta.getNome());
        }
    }
}