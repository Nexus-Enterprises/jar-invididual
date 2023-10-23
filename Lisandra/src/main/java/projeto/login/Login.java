package projeto.login;

import projeto.conexao.Conectar;
import projeto.menu.Menu;
import projeto.print.Prints;

import java.util.Scanner;

public class Login {
    private String username;
    private String token;
    private Boolean logado = false;

    Menu menu = new Menu();
    Conectar conectar = new Conectar();
    Scanner scanner = new Scanner(System.in);
    Prints prints = new Prints();
    public Boolean login() {
        while (!logado) {
            prints.username();
            username = scanner.nextLine();
            prints.token();
            token = scanner.nextLine();

            logado = conectar.Logar(username, token);
        }
        return true;
    }
}
