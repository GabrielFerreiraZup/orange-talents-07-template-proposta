package br.com.zup.orange.propostas.Model.DTO;

import javax.validation.constraints.NotBlank;

public class TesteBancoForm {
    @NotBlank
    private String teste;

    public String getTeste() {
        return teste;
    }

    public TesteBancoForm(String teste) {
        this.teste = teste;
    }
}
