package br.com.zup.orange.propostas.Model.DTO;

import br.com.zup.orange.propostas.enums.CarteiraEnum;

public class ApiPaypallDto {

    private CarteiraEnum resultado;

    private String id;

    public CarteiraEnum getResultado() {
        return resultado;
    }

    public String getId() {
        return id;
    }

    public ApiPaypallDto(CarteiraEnum resultado, String id) {
        this.resultado = resultado;
        this.id = id;
    }
}
