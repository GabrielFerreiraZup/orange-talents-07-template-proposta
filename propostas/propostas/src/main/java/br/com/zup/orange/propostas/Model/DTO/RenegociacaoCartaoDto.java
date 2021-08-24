package br.com.zup.orange.propostas.Model.DTO;

import java.time.LocalDateTime;

public class RenegociacaoCartaoDto {

    private String id;
    private int quantidade;
    private Double valor;
    private LocalDateTime dataDeCriacao;

    public String getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }

    public RenegociacaoCartaoDto(String id, int quantidade, Double valor, LocalDateTime dataDeCriacao) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
        this.dataDeCriacao = dataDeCriacao;
    }

    @Override
    public String toString() {
        return "RenegociacaoCartaoDto{" +
                "id='" + id + '\'' +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                ", dataDeCriacao=" + dataDeCriacao +
                '}';
    }
}
