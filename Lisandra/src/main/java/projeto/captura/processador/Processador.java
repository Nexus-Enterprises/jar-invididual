package projeto.captura.processador;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import projeto.conexao.Conectar;

public class Processador {
    public String processador() {
        // Cria uma instacia para puxar dados do processador
        CentralProcessor processador = new SystemInfo().getHardware().getProcessor();
        Conectar conectar = new Conectar();

        // Criacao das variaveis
        String name = "";
        String model = "";

        // Pega a Frequencia e faz calculo de GHz
        Double frequency = Double.valueOf(processador.getMaxFreq());
        Double freqProcessor = ((frequency / 1000)/ 1000)/ 1000;

        // Cria instancia da API processador

        // Retira a Informacao de Genuine ou Authenthic dos processadores
        String brand = processador.getProcessorIdentifier().getVendor().replace("Genuine","").replace("Authentic","");

        // Verifica qual a fabricante do Processador
        if (brand.equals("AMD")){
            // Pega o nome do Processador e remove os Dados nao imporantes para o cadastro
            name = processador.getProcessorIdentifier().getName();
            name = name.replaceAll("Processor| 6-Core ", "");

            // Pega o nome do Processador por extenso e tira apenas o modelo
            model = processador.getProcessorIdentifier().getName();
            model = model.replaceAll("AMD | Processor","");

        } else if (brand.equals("Intel")){
            // Pega o nome do Processador e remove os Dados nao imporantes para o cadastro
            name = processador.getProcessorIdentifier().getName();
            name = name.replaceAll("R|CPU|TM|Gen|U9400|8265U|1.60GHz|-|@|1.40GHz", "").replace("(","").replace(")","");

            // Pega o nome do Processador por extenso e tira apenas o modelo
            model = processador.getProcessorIdentifier().getName();
            model = model.replaceAll("Intel|R|TM|CPU|@ |1.40GHz|1.60GHz|1.50GHz|1.80GHz","").replace("()","").replace("     ","");
        }
        String nameBD = """
                %s %s
                """.formatted(brand, model);
        conectar.inserirProcessador(nameBD);

        return """
                *------------------------------------------------------------*
                |                           Processador                      |
                *------------------------------------------------------------*
                | Fabricante:                               %s
                | Nome:                                     %s
                | Modelo:                                   %s
                | Frequencia:                               %.2fGhz
                """.formatted(brand, name, model, freqProcessor);

    }
}