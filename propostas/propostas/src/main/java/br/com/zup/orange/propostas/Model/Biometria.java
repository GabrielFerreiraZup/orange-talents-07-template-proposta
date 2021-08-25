package br.com.zup.orange.propostas.Model;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Base64;

@Entity
public class Biometria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100000)
    @Column(columnDefinition = "TEXT")
    private String biometria;

    @ManyToOne
    private Cartao cartao;

    public Long getId() {
        return id;
    }

    public String getBiometria() {
        return biometria;
    }

    public Cartao getCartao() {
        return cartao;
    }
    @Deprecated
    public Biometria() {
    }

    public Biometria(String biometria, Cartao cartao) {
        this.biometria = biometria;
        this.cartao = cartao;
    }
}
