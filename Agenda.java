import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Agenda {
    private List<Consulta> consultas = new ArrayList<>();
    private Connection connection;
    @SuppressWarnings("unused")
    private Scanner scanner = new Scanner(System.in);

    public Agenda() {
        conectarAoBancoDeDados();
    }

    private void conectarAoBancoDeDados() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://DESKTOP-V23C37Q:3306/agendamedica";
            String usuario = "root";
            String senha = "estalloneh_1";
            connection = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    

    public void cadastrarConsulta(Consulta consulta) {
        try {
            String sql = "INSERT INTO Consulta (pessoa_nome, nome, data, horario) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, consulta.getPessoa().getNome());
                statement.setString(2, consulta.getNome());
                statement.setString(3, consulta.getData());
                statement.setDouble(4, consulta.getHorario());

                statement.executeUpdate();
            }

            System.out.println("Consulta cadastrada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar a consulta no banco de dados", e);
        }
    }

    public void removerConsulta(String nomePessoa) {
        try {
            String sql = "DELETE FROM Consulta WHERE pessoa_nome = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, nomePessoa);

                statement.executeUpdate();
            }

            System.out.println("Consulta removida com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover a consulta do banco de dados", e);
        }
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

    public void fecharConexao() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", e);
        }
    }
    
}
