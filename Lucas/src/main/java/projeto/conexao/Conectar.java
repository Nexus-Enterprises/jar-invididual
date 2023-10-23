package projeto.conexao;

import projeto.captura.Monitoramento;
import projeto.menu.Menu;

import java.sql.*;

public class Conectar {

    private String url = "jdbc:mysql://localhost:3306/NEXUS";
    private String user = "root";
    private String passwd = "12345678";

    private Menu menu = new Menu();

    private String email;
    private String pass;
    private Boolean logado;

    public Boolean Logar(String email, String pass) {
        this.email = email;
        this.pass = pass;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, user, passwd);

            Statement statement = conexao.createStatement();

            String sqlSelect = "SELECT email, token FROM Usuario;";

            ResultSet resposta = statement.executeQuery(sqlSelect);

            while (resposta.next()) {
                String username = resposta.getString("email");
                String token = resposta.getString("token");

                if (this.email.equals(username) && this.pass.equals(token)) {
                    logado = true;
                    System.out.println("""
                            Login Realizado com Sucesso!
                            
                                Seja Bem-Vindo
                            """);
                    Monitoramento monitor = new Monitoramento();
                    monitor.monitor();
                }
            }

            resposta.close();
            statement.close();
            conexao.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            System.out.println("""
                                        
                    Nenhum usuario encontrado
                                        
                    Por favor verifique as credenciais
                    """);
            logado = false;
        }
        return logado;
    }

    public void realizarCadastro(String email, String pass, Integer fkFuncionario) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, user, passwd);
            String cadastro = "INSERT INTO Usuario VALUES (NULL, ?, ?, (SELECT idFuncionario FROM Funcionario WHERE emailCorporativo = ?));";
            PreparedStatement instrucao = conexao.prepareStatement(cadastro);

            instrucao.setString(1, email);
            instrucao.setString(2, pass);
            instrucao.setString(3, email);

            instrucao.execute();
            instrucao.close();
            menu.exibirMenu();
            conexao.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            System.err.println("Cadastro Nao realizado\nUsuario ja existente");
            throwables.printStackTrace();
        }
    }

    public Conectar DadosDisco(String nome, String modelo, Double discTotal, String montagem) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, user, passwd);

            String cadastro = "INSERT INTO Componente VALUES (NULL, ?, ?, ?, ?, ?);";

            PreparedStatement instrucao = conexao.prepareStatement(cadastro);

            instrucao.setString(1, "Disco Rígido");
            instrucao.setString(2, nome);
            instrucao.setDouble(3, discTotal);
            instrucao.setString(4, montagem);
            instrucao.setInt(5, 1);

            instrucao.execute();

            instrucao.close();
            conexao.close();
        } catch (
                SQLException | ClassNotFoundException throwables) {
            System.err.println("conexao nao estabelecida");
            throwables.printStackTrace();
        }
        return null;
    }

    public Conectar inserirProcessos(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, user, passwd);

            String cadastro = "INSERT INTO Componente VALUES (NULL, ?, ?, ?, ?, ?);";

            PreparedStatement instrucao = conexao.prepareStatement(cadastro);

            instrucao.execute();

            instrucao.close();
            conexao.close();
        } catch (
                SQLException | ClassNotFoundException throwables) {
            System.err.println("conexao nao estabelecida");
            throwables.printStackTrace();
        }
        return null;
    }

    public Conectar inserirMemoria(Double total){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, user, passwd);

            String cadastro = "INSERT INTO Componente (nome, capacidadeMax, fkMaquina) VALUES (?, ?, ?);";

            PreparedStatement instrucao = conexao.prepareStatement(cadastro);

            instrucao.setString(1, "Memória RAM");
            instrucao.setDouble(2, total);
            instrucao.setInt(3, 1);

            instrucao.execute();

            instrucao.close();
            conexao.close();
        } catch (
                SQLException | ClassNotFoundException throwables) {
            System.err.println("conexao nao estabelecida");
            throwables.printStackTrace();
        }
        return null;
    }

    public Conectar inserirProcessador(String modelo){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, user, passwd);

            String cadastro = "INSERT INTO Componente (nome, modelo, fkMaquina) VALUES (?, ?, ?);";

            PreparedStatement instrucao = conexao.prepareStatement(cadastro);

            instrucao.setString(1, "Processador");
            instrucao.setString(2, modelo);
            instrucao.setInt(3, 1);

            instrucao.execute();

            instrucao.close();
            conexao.close();
        } catch (
                SQLException | ClassNotFoundException throwables) {
            System.err.println("conexao nao estabelecida");
            throwables.printStackTrace();
        }
        return null;
    }
}