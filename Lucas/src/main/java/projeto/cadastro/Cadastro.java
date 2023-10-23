package projeto.cadastro;

import projeto.conexao.Conectar;
import projeto.print.Prints;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Cadastro {
    private String email;
    private String token;
    private Integer fkFuncionario;

    public void cadastrar() {
        Scanner scanner = new Scanner(System.in);
        Prints prints = new Prints();
        prints.user();

        email = scanner.nextLine();

        System.out.println("Insira sua senha:");
        String tokens = scanner.nextLine();

        Conectar conectar = new Conectar();
        conectar.realizarCadastro(email, tokens, fkFuncionario);
    }
}
