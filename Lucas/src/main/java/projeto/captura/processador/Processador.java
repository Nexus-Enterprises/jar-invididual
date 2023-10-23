package projeto.captura.processador;

import com.github.britooo.looca.api.core.Looca;
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

        // Cria instancia da API Looca
        Looca looca = new Looca();

        // Retira a Informacao de Genuine ou Authenthic dos processadores
        String brand = looca.getProcessador().getFabricante().replace("Genuine","").replace("Authentic","");

        // Verifica qual a fabricante do Processador
        if (brand.equals("AMD")){
            // Pega o nome do Processador e remove os Dados nao imporantes para o cadastro
            name = processador.getProcessorIdentifier().getName();
            name = name.replaceAll("Processor| 6-Core ", "");

            // Pega o nome do Processador por extenso e tira apenas o modelo
            model = looca.getProcessador().getNome();
            model = model.replaceAll("AMD | Processor","");

        } else if (brand.equals("Intel")){
            // Pega o nome do Processador e remove os Dados nao imporantes para o cadastro
            name = processador.getProcessorIdentifier().getName();
            name = name.replaceAll("R|CPU|TM|Gen|U9400|8265U|1.60GHz|-|@|1.40GHz", "").replace("(","").replace(")","");

            // Pega o nome do Processador por extenso e tira apenas o modelo
            model = looca.getProcessador().getNome();
            model = model.replaceAll("Intel|R|TM|CPU|@ |1.40GHz|1.60GHz|1.50GHz|1.80GHz","").replace("()","").replace("     ","");
        }
        Double usage = looca.getProcessador().getUso();
        String nameBD = """
                %s %s
                """.formatted(brand, model);
        conectar.inserirProcessador(nameBD);

        return """
              
                                           PROCESSADOR                     
              
                 Fabricante:                               %s
                 Nome:                                     %s
                 Modelo:                                   %s
                 Uso:                                      %.2f%%
                 Frequencia:                               %.2fGhz
                """.formatted(brand, name, model, usage, freqProcessor);

    }
}