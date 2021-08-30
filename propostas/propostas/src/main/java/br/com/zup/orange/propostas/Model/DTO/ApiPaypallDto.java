package br.com.zup.orange.propostas.Model.DTO;

import br.com.zup.orange.propostas.enums.StatusCarteiraEnum;

public class ApiPaypallDto {

    private StatusCarteiraEnum resultado;

    private String id;

    public StatusCarteiraEnum getResultado() {
        return resultado;
    }

    public String getId() {
        return id;
    }

    public ApiPaypallDto(StatusCarteiraEnum resultado, String id) {
        this.resultado = resultado;
        this.id = id;
    }
}
