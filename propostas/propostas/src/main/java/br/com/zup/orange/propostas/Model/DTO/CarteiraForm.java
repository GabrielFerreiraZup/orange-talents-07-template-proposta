package br.com.zup.orange.propostas.Model.DTO;

import br.com.zup.orange.propostas.enums.NomeCarteiraEnum;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CarteiraForm {

    @NotBlank
    @Email
    private String email;

    private NomeCarteiraEnum carteira;

    public String getEmail() {
        return email;
    }

    public NomeCarteiraEnum getCarteira() {
        return carteira;
    }

    public CarteiraForm(String email, NomeCarteiraEnum carteira) {
        this.email = email;
        this.carteira = carteira;
    }
}
