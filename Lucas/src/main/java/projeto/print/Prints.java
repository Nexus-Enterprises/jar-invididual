package projeto.print;

public class Prints {
    public void inicial(){
        System.out.println("Seja Bem-Vindo a Plataforma NEXUS!\n");
    }
    public void menu() {
        System.out.println("\nPor Favor realize o Login para poder acessar \ntodas as areas da plataforma! \n");
        System.out.println("Caso não possua um Login, realize o Cadastro\n");
        System.out.println("");
        System.out.println("| 1 - Login                                  |");
        System.out.println("| 2 - Cadastro                               |");
        System.out.println("| 0 - Sair                                   |");
        System.out.println("");
    }
    public void username() {
        System.out.println("\nDigite seu email: ");
    }
    public void password() {
        System.out.println("\nDigite seu token: ");
    }
    public void token() {
        System.out.println("\nDigite seu token:");
    }
    public void erroUser() {
        System.out.println("\nUsuario incorreto");
    }
    public void autenticado() {
        System.out.println("\nLogin Realizado!");
    }
    public void erroToken() {
        System.out.println("\nNão foi possivel autenticar o token!");
    }
    public void sair() {
        System.out.println("\nSessão Finalizada!");
    }

    public void user() {
        System.out.println("\nDigite seu email: ");
    }
    public void pass() {
        System.out.println("\nDigite seu token: ");
    }
    public void afterLogin(){
        System.out.println("");
    }
    public void menuMonitorar() {
        System.out.println("""
                Qual dos Monitoramentos deseja visualizar 
                
                
                1 - Processador                       
                2 - Memoria                           
                3 - Disco                             
                
                """);
    }
}

// Realizado Pela Nexus Enterprises :)