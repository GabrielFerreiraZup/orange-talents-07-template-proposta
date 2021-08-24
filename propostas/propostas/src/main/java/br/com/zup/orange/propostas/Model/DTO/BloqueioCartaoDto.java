package br.com.zup.orange.propostas.Model.DTO;

import java.time.LocalDateTime;

public class BloqueioCartaoDto {

    private String id;
    private LocalDateTime bloqueadoEm;
    private String sistemaResponsavel;
    private boolean ativo;

    public String getId() {
        return id;
    }

    public LocalDateTime getBloqueadoEm() {
        return bloqueadoEm;
    }

    public String getSistemaResponsavel() {
        return sistemaResponsavel;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public BloqueioCartaoDto(String id, LocalDateTime bloqueadoEm, String sistemaResponsavel, boolean ativo) {
        this.id = id;
        this.bloqueadoEm = bloqueadoEm;
        this.sistemaResponsavel = sistemaResponsavel;
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "BloqueioCartaoDto{" +
                "id='" + id + '\'' +
                ", bloqueadoEm=" + bloqueadoEm +
                ", sistemaResponsavel='" + sistemaResponsavel + '\'' +
                ", ativo=" + ativo +
                '}';
    }
}
