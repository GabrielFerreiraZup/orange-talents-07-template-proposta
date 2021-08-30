package br.com.zup.orange.propostas.Model.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CarteiraForm {

    @NotBlank
    @Email
    private String email;

    private String carteira;

    public String getEmail() {
        return email;
    }

    public String getCarteira() {
        return carteira;
    }

    public CarteiraForm(String email, String carteira) {
        this.email = email;
        this.carteira = carteira;
    }
}
