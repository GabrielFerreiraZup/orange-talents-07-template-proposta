package br.com.zup.orange.propostas.Model.DTO;

public class SolicitacaoDto {

    private String documento;
    private String nome;
    private String resultadoSolicitacao;
    private String idProposta;

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public String getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }

    public String getIdProposta() {
        return idProposta;
    }

    public SolicitacaoDto() {
    }

    public SolicitacaoDto(String documento, String nome, String resultadoSolicitacao, String idProposta) {
        this.documento = documento;
        this.nome = nome;
        this.resultadoSolicitacao = resultadoSolicitacao;
        this.idProposta = idProposta;
    }

    @Override
    public String toString() {
        return "SolicitacaoDto{" +
                "documento='" + documento + '\'' +
                ", nome='" + nome + '\'' +
                ", resultadoSolicitacao='" + resultadoSolicitacao + '\'' +
                ", idProposta='" + idProposta + '\'' +
                '}';
    }
}
