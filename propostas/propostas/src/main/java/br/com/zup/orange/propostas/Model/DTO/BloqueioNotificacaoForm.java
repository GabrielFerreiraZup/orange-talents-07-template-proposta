package br.com.zup.orange.propostas.Model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BloqueioNotificacaoForm {

    private String sistemaResponsavel;

    public String getSistemaResponsavel() {
        return sistemaResponsavel;
    }

    public BloqueioNotificacaoForm(@JsonProperty("sistemaResponsavel") String sistemaResponsavel) {
        this.sistemaResponsavel = sistemaResponsavel;
    }
}
