package br.com.zup.orange.propostas.Model.DTO;

public class ParcelaCartaoDto {

    private String id;
    private int quantidade;
    private Double valor;

    public String getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public ParcelaCartaoDto(String id, int quantidade, Double valor) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "ParcelaCartaoDto{" +
                "id='" + id + '\'' +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                '}';
    }
}
