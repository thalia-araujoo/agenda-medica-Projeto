public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        Medico medico = new Medico("Dr. João", "12345");
        Paciente paciente = new Paciente("Maria", "CPF123", "Rua A", "123456789");

        Consulta consultaMedico = new Consulta(medico, "Consulta de Rotina", "2024-02-16", 10.5);
        Consulta consultaPaciente = new Consulta(paciente, "Consulta de Acompanhamento", "2024-02-17", 15.0);

        agenda.cadastrarConsulta(consultaMedico);
        agenda.cadastrarConsulta(consultaPaciente);

        agenda.removerConsulta("Maria");
        agenda.listarConsultas();
    }


}

    
