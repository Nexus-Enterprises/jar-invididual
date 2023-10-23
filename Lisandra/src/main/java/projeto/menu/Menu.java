package projeto.menu;

import projeto.cadastro.Cadastro;
import projeto.login.Login;
import projeto.print.Prints;

import java.util.Scanner;

public class Menu {
    private boolean sair = false;

    public void exibirMenu() {
        Login login = new Login();
        Cadastro cadastro = new Cadastro();
        Prints prints = new Prints();
        Scanner scanner = new Scanner(System.in);


        while (!sair) {
            prints.menu();
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    sair = login.login();
                    break;
                case 2:
                    cadastro.cadastrar();
                    break;
                case 0:
                    prints.sair();
                    sair = true;
                    break;
                default:
                    break;
            }
        }
    }
}
// Realizado Pela Nexus Enterprises :)