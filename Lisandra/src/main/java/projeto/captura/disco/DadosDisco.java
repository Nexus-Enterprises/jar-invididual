package projeto.captura.disco;

import projeto.conexao.Conectar;

public class DadosDisco {
    String nome;
    String modelo = "NULL";
    String montagem;
    Double espTotal;
    Double espLivre;
    Double espUsado;

    public DadosDisco(String nome, String modelo, String montagem, Double discTotal) {
        this.nome = nome;
        this.modelo = modelo;
        this.montagem = montagem;
        this.espTotal = discTotal;

        Conectar conectar = new Conectar();
        conectar.DadosDisco(modelo, nome, discTotal, montagem);
    }
}