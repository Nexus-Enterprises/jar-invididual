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

        int numAle = ThreadLocalRandom.current().nextInt(1,10);
        int numAle1 = ThreadLocalRandom.current().nextInt(1, 1000001);
        int numAle2 = ThreadLocalRandom.current().nextInt(1, 1000001);

        String tokens = String.valueOf((numAle * numAle1 * numAle2) / numAle);

        tokens = ((((((((tokens.replace("1", "A").replace("3", "B").replace("5", "C").replace("7", "D").replace("9", "E").replace("-", "")))))))));

        this.token = tokens;

        System.out.printf("\n\n|    Seu Token foi Gerado: %s    |\n", tokens);

        Conectar conectar = new Conectar();
        conectar.realizarCadastro(email, tokens, fkFuncionario);
    }
}
