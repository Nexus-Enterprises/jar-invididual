package projeto.captura.disco;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;

public class Discos {
    private Integer fkmaquina;
    private String nomeDisco;
    private String modeloDisco = "NULL";
    private String montagemDisco;
    private Double espTotalDisco;
    private Double espLivreDisco;
    private Double espUsadoDisco;

    public String disco() {
        // Instancia da funcao de Discos
        DiscoGrupo discoGrupo = new Looca().getGrupoDeDiscos();
        Looca looca = new Looca();

        // define o tamnho da lista do getDisco
        int size = discoGrupo.getDiscos().size();

        // Cria uma lista com o tamanho do getDisco definido acima
        DadosDisco[] disk = new DadosDisco[size];

        // um for que percorre todos os discos dentro do discoGrupo
        for (int i = 0; i < disk.length; i++) {
            // O nome do disco!!
            String vol = looca.getGrupoDeDiscos().getVolumes().get(i).getNome();
            String nome = discoGrupo.getDiscos().get(i).getNome();

            // O modelo do disco sera definido aqui
            String modelo = discoGrupo.getDiscos().get(i).getModelo();

            // Onde o volume esta sendo montado
            String montagem = discoGrupo.getVolumes().get(i).getPontoDeMontagem();

            // Tamamnho total do disco
            Double discTotal = Double.valueOf(discoGrupo.getDiscos().get(i).getTamanho());
            Double total = ((discTotal / 1024) / 1024) / 1024;

            // Total disponivel
            Double vl = Double.valueOf(discoGrupo.getVolumes().get(i).getDisponivel());
            Double livre = ((vl / 1024) / 1024) / 1024;

            // Quantidadde Usada
            Double usado = total - livre;

            // Envia todos os dados captados acima para o Arquivo que servira como objeto
            disk[i] = new DadosDisco(nome, vol, montagem, total);
        }

        // Imprime as mensgens juntamente com os dados dos objetos
        String mensagem = """
                *------------------------------------------------------------*
                |                            Discos                          |
                *------------------------------------------------------------*
                """;

        // percorre todo o arquivo e mostra todos os dados salvos
        for (DadosDisco dadosDisco : disk) {
            mensagem += """
                    | Modelo:                                     %s
                    | Montagem:                                   %s
                    | Espaco Total:                               %.2f Gb
                    *------------------------------------------------------------*
                    """.formatted(dadosDisco.nome, dadosDisco.montagem, dadosDisco.espTotal);
        }
        // retorna a String formatada para o MAIN
        return mensagem;
    }
}
