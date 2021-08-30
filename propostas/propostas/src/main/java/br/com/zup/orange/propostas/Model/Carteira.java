package br.com.zup.orange.propostas.Model;


import br.com.zup.orange.propostas.enums.NomeCarteiraEnum;
import br.com.zup.orange.propostas.enums.StatusCarteiraEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String email;

    private NomeCarteiraEnum carteira;

    private StatusCarteiraEnum resultado;

    private String idPaypal;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public NomeCarteiraEnum getCarteira() {
        return carteira;
    }

    public StatusCarteiraEnum getResultado() {
        return resultado;
    }

    public String getIdPaypal() {
        return idPaypal;
    }
    @Deprecated
    public Carteira() {
    }

    public Carteira(String email, NomeCarteiraEnum carteira, StatusCarteiraEnum resultado, String idPaypal) {
        this.email = email;
        this.carteira = carteira;
        this.resultado = resultado;
        this.idPaypal = idPaypal;
    }
}

