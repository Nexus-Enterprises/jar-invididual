package projeto.captura.memoria;

import com.github.britooo.looca.api.core.Looca;
import projeto.conexao.Conectar;

public class Memoria {
    public String memoria() {
        // Cria a instacia da API Looca
        Looca looca = new Looca();

        // pega a quantidade de memoria em uso e faz o calculo para Gb
        Double memEmUso = Double.valueOf(looca.getMemoria().getEmUso());
        Double emUso = ((memEmUso / 1024) / 1024) / 1024;

        // pega a quantidade de memoria disponivel e faz o calculo para Gb
        Double memDisponivel = Double.valueOf(looca.getMemoria().getDisponivel());
        Double disponivel = ((memDisponivel / 1024) / 1024) / 1024;

        // pega a quantidade de memoria total e faz o calculo para Gb
        Double memTotal = Double.valueOf(looca.getMemoria().getTotal());
        Double total = ((memTotal / 1024) / 1024) / 1024;

        Conectar conectar = new Conectar();

        conectar.inserirMemoria(total);
        // retorna a mensgem para ser impressa na Main
        return """
                *------------------------------------------------------------*
                |                           Memoria                          |
                *------------------------------------------------------------*
                | Uso:                                       %.2f Gb
                | Disponivel:                                %.2f Gb
                | Total:                                     %.2f Gb
                """.formatted(emUso, disponivel, total);
    }
}