CREATE TABLE Pessoa (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE Medico (
    pessoa_id INT PRIMARY KEY,
    codigoCRM VARCHAR(10) NOT NULL,
    FOREIGN KEY (pessoa_id) REFERENCES Pessoa(id)
);

CREATE TABLE Paciente (
    pessoa_id INT PRIMARY KEY,
    cpf VARCHAR(15) NOT NULL,
    endereco VARCHAR(255),
    telefone VARCHAR(15),
    FOREIGN KEY (pessoa_id) REFERENCES Pessoa(id)
);

CREATE TABLE Consulta (
    id INT PRIMARY KEY AUTO_INCREMENT,
    pessoa_id INT,
    nome VARCHAR(255) NOT NULL,
    data DATE NOT NULL,
    horario TIME NOT NULL,
    FOREIGN KEY (pessoa_id) REFERENCES Pessoa(id)
);





