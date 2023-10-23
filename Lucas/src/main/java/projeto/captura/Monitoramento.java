package projeto.captura;

import projeto.captura.disco.Discos;
import projeto.captura.memoria.Memoria;
import projeto.captura.processador.Processador;
import projeto.print.Prints;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Monitoramento {
    private Boolean sair = false;
    Discos disk = new Discos();
    Memoria memory = new Memoria();
    Processador processor = new Processador();

    public void monitor() {

        Prints prints = new Prints();


        Timer timer = new Timer();
        TimerTask main = new Execution();
        timer.schedule(main, 0, 15000);

        Scanner scanner = new Scanner(System.in);


        while (!sair) {
            prints.menuMonitorar();
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println(processor.processador());
                    break;
                case 2:
                    System.out.println(memory.memoria());
                    break;
                case 3:
                    System.out.println(disk.disco());
                    break;
                case 0:
                    prints.sair();
                    sair = true;
                    timer.cancel();
                    break;
                default:
                    break;
            }
        }
    }

    public static class Execution extends TimerTask {
        public void run() {
            Discos disk = new Discos();
            disk.disco();

            Memoria memory = new Memoria();
            memory.memoria();

            Processador processor = new Processador();
            processor.processador();
        }
    }
}

